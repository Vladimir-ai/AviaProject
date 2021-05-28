package com.example.aviaapplication.ui.searchFlights;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aviaapplication.R;
import com.example.aviaapplication.additions.recyclerView.RecentFlightsViewAdapter;
import com.example.aviaapplication.api.models.City;
import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.ui.cities.FragmentCitiesSearch;
import com.example.aviaapplication.ui.foundFlights.FoundFlights;
import com.example.aviaapplication.utils.CommonUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;


public class SearchFlightsFragment extends Fragment {
    private static TextView countTV, dateTV, cityFromTV, cityToTV;
    private ImageView minusIV, plusIV, swapCities, deleteSecondCity;
    private LinearLayout chooseDateFlights;
    private static Calendar startDate, lastDate;
    public Integer containerId = 0;
    private static City fromCity, toCity;
    private ProgressBar progressBar;

    private Button searchFlightBtn;
    private static Integer countOfPersons;
    private DialogChooseDateFlight dialogChooseDateFlight;
    private RecentFlightsViewAdapter recentFlightsViewAdapter;
    private RecyclerView recyclerView;
    private SearchFlightViewModel searchFlightViewModel;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_flights, container, false);
        containerId = container.getId();
        initViews(view);
        setListeners();
        setLastData();
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void setLastData() {
        if (startDate != null) {
            setNewDate(startDate, lastDate);
        }
        if (fromCity != null) {
            setCityFrom(fromCity);
        }
        if (toCity != null) {
            setCityTo(toCity);
        }
        if (countOfPersons != null) {
            countTV.setText(Integer.toString(countOfPersons));
        }
    }

    private void initViews(View rootView) {
        searchFlightViewModel = ViewModelProviders.of(this).get(SearchFlightViewModel.class);

        progressBar = rootView.findViewById(R.id.search_flights_pb);
        swapCities = rootView.findViewById(R.id.fragment_search_flights_swap_iv);
        deleteSecondCity = rootView.findViewById(R.id.fragment_search_flights_remove_sec_city_iv);
        chooseDateFlights = rootView.findViewById(R.id.choose_data);
        minusIV = rootView.findViewById(R.id.search_flights_count_of_people_minus_iv);
        plusIV = rootView.findViewById(R.id.search_flights_count_of_people_plus_iv);
        countTV = rootView.findViewById(R.id.search_flights_count_of_people_count_tv);
        dateTV = rootView.findViewById(R.id.search_flights_date_tv);
        cityFromTV = rootView.findViewById(R.id.fragment_search_flights_city_from_tv);
        cityToTV = rootView.findViewById(R.id.fragment_search_flights_city_to_tv);
        searchFlightBtn = rootView.findViewById(R.id.search_flights_btn);
        dialogChooseDateFlight = new DialogChooseDateFlight();
        dialogChooseDateFlight.setStyle(DialogFragment.STYLE_NO_FRAME, 0);
        recyclerView = rootView.findViewById(R.id.search_flights_rv);
        recentFlightsViewAdapter = new RecentFlightsViewAdapter(this);
        recyclerView.setAdapter(recentFlightsViewAdapter);
        //getRecentFlights();
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    private void setListeners() {
        minusIV.setOnClickListener(v -> {
            int currState = Integer.parseInt(countTV.getText().toString());
            if (currState > 1) {
                countOfPersons = currState - 1;
                countTV.setText(Integer.toString(currState - 1));
            }
        });
        plusIV.setOnClickListener(v -> {
            int currState = Integer.parseInt(countTV.getText().toString());
            if (currState < 10) {
                countOfPersons = currState + 1;
                countTV.setText(Integer.toString(currState + 1));
            }
        });

        cityFromTV.setOnClickListener(v -> {
            Fragment f = new FragmentCitiesSearch();
            f.setTargetFragment(this, 1);
            getParentFragmentManager().beginTransaction()
                    .replace(containerId, f, "from")
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(SearchFlightsFragment.class.toString())
                    .commit();
        });
        cityToTV.setOnClickListener(v -> {
            Fragment f = new FragmentCitiesSearch();
            f.setTargetFragment(this, 1);
            getParentFragmentManager().beginTransaction()
                    .replace(containerId, f, "to")
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .addToBackStack(SearchFlightsFragment.class.toString())
                    .commit();
        });
        chooseDateFlights.setOnClickListener(v -> {
            if (!dialogChooseDateFlight.isVisible()) {
                dialogChooseDateFlight.show(getChildFragmentManager(), "");
            }
        });
        searchFlightBtn.setOnClickListener(v -> {

            if (startDate == null || lastDate == null) {
                CommonUtils.makeErrorToast(getContext(), "Укажите дату полета");
                return;
            }
            if (fromCity == null) {
                CommonUtils.makeErrorToast(getContext(), "Укажите пункт отправления");
                return;
            }
            if (toCity == null) {
                CommonUtils.makeErrorToast(getContext(), "Укажите пункт назначения");
                return;
            }
//            Date startDate = SearchFlightsFragment.startDate.getTime();
//            Date lastDate = new Date(SearchFlightsFragment.lastDate.getTime().getTime() + TimeUnit.DAYS.toMillis(1));

            //  findFlights();


        });
        deleteSecondCity.setOnClickListener(v -> {
            setCityTo(null);
        });
        swapCities.setOnClickListener(v -> {
            City fromCityCopy = fromCity;
            setCityFrom(toCity);
            setCityTo(fromCityCopy);
        });


        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.navigation_main_search);
            }
        });
    }


    public void setCityFrom(City cityFrom) {
        fromCity = cityFrom;
        if (cityFrom != null) {
            cityFromTV.setText(cityFrom.getCityName());
        } else {
            cityFromTV.setText("Откуда");
        }
    }

    public void setCityTo(City cityTo) {
        toCity = cityTo;
        if (cityTo != null) {
            cityToTV.setText(cityTo.getCityName());
        } else {
            cityToTV.setText("Куда");
        }
    }

    @SuppressLint("SetTextI18n")
    public void setNewDate(Calendar startDate, Calendar lastDate) {

        SimpleDateFormat format = new SimpleDateFormat("d MMMM ");
        if (startDate != null && lastDate != null) {
            this.startDate = initDate(startDate);
            this.lastDate = initDate(lastDate);
            if (startDate.equals(lastDate)) {
                dateTV.setText(format.format(startDate.getTime()));
            } else {
                dateTV.setText(format.format(startDate.getTime()) + "  \n" + format.format(lastDate.getTime()));
            }
        }
    }

    private Calendar initDate(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }

    void getRecentFlights() {

        searchFlightViewModel.getRecentFlights()
                .observe(getViewLifecycleOwner(), model -> {
                    if (model == null) {
                        Toast.makeText(getContext(), "Ошибка получения данных", Toast.LENGTH_SHORT).show();
                    } else {
                        recentFlightsViewAdapter.submitList(model);
                    }
                });
    }

    void findFlights() {
        searchFlightViewModel.getIsLoading().observe(this, isLoading -> {
            if (isLoading) progressBar.setVisibility(View.VISIBLE);
            else progressBar.setVisibility(View.GONE);
        });
        searchFlightViewModel.findFlights()
                .observe(this, model -> {
                    searchFlightViewModel.getIsLoading().postValue(false);
                    if (model == null) {
                        Toast.makeText(getContext(), "Ошибка получения данных", Toast.LENGTH_SHORT).show();
                    } else {
                        Fragment f = FoundFlights.getInstance(model);
                        getParentFragmentManager().beginTransaction()
                                .replace(containerId, f)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                .addToBackStack(SearchFlightsFragment.class.toString())
                                .commit();
                    }
                });
    }
}
