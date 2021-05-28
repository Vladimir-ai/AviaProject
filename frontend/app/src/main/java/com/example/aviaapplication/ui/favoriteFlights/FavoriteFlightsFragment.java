package com.example.aviaapplication.ui.favoriteFlights;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aviaapplication.R;
import com.example.aviaapplication.additions.recyclerView.FlightsRecycleViewAdapter;
import com.example.aviaapplication.api.models.Flight;
import com.yandex.metrica.YandexMetrica;

import java.util.List;

public class FavoriteFlightsFragment extends Fragment {
    private FavoriteFlightsViewModel favoriteFlightsViewModel;
    private RecyclerView recyclerView;
    public ProgressBar progressBar;
    private Integer idUser;
    private FlightsRecycleViewAdapter mAdapter;
    private LinearLayout emptyFavoriteListLL;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        favoriteFlightsViewModel = new ViewModelProvider(this).get(FavoriteFlightsViewModel.class);
        YandexMetrica.reportEvent(getString(R.string.event_user_went_to_favorites));
        View view = inflater.inflate(R.layout.fragment_favorite_flights, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        emptyFavoriteListLL = view.findViewById(R.id.favorite_flights_ll);
        progressBar = view.findViewById(R.id.favorite_flights_pb);
        mAdapter = new FlightsRecycleViewAdapter(this);
        recyclerView = view.findViewById(R.id.favorite_flights_rv);
        recyclerView.setAdapter(mAdapter);
        updateList(favoriteFlightsViewModel.getFavoriteFlights());

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.navigation_main_search);
            }
        });
    }

    public void getExhibits() {
        //метод из ViewModel
    }

    public void updateList(List<Flight> list) {
        if (list.isEmpty()) {
            emptyFavoriteListLL.setVisibility(View.VISIBLE);
        } else {
            emptyFavoriteListLL.setVisibility(View.GONE);
            mAdapter.submitList(list);
        }
    }
}
