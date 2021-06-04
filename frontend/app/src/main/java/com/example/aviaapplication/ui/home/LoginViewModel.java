package com.example.aviaapplication.ui.home;

import android.app.Application;
import android.app.usage.UsageEvents;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.aviaapplication.api.models.User;
import com.example.aviaapplication.utils.ActivityNavigation;
import com.example.aviaapplication.utils.LiveMessageEvent;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import lombok.val;

//Не вижу смысла делать в репозитории, ибо в качестве модели - синглтон GoogleSignIn (место репозитория)
public class LoginViewModel extends AndroidViewModel {

    private GoogleSignInClient googleSignInClient;

    private final String TAG = "loginViewModel";
    private final int GOOGLE_SIGN_IN = 9001;

    LiveMessageEvent<ActivityNavigation> startActivityForResultEvent;
    MutableLiveData<User> userLiveData;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        startActivityForResultEvent = new LiveMessageEvent<>();

        userLiveData = new MutableLiveData<>(null);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getApplication().getApplicationContext());

        if (account != null){
            User user = new User(account.getDisplayName(),
                    account.getEmail(),
                    account.getPhotoUrl());
            userLiveData.setValue(user);
        }
}

    public LiveData<User> getMutableData(){
        return userLiveData;
    }

    public void login(){
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResultEvent.sendEvent(activityNavigation ->
                activityNavigation.startActivityForResult(signInIntent, GOOGLE_SIGN_IN));
    }

    void setGoogleSignInClient(GoogleSignInClient client){
        googleSignInClient = client;

    }

    void onResultFromActivity(int requestCode, int resultCode, Intent data) {
        if (requestCode == GOOGLE_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data);
                googleSignInComplete(task);
        }
    }

    private void googleSignInComplete(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            User user = new User();
            user.setEmail(account.getEmail());
            user.setImageUri(account.getPhotoUrl());
            user.setName(account.getDisplayName());
            userLiveData.setValue(user);

            // TODO(developer): send ID Token to server and validate
            } catch (ApiException e) {
            Log.w(TAG, "handleSignInResult:error", e);
        }
    }

    public void logout(){
        googleSignInClient.signOut();
        userLiveData.setValue(null);
    }

    public boolean isAuthorised(){
        return userLiveData.getValue() != null;
    }


}