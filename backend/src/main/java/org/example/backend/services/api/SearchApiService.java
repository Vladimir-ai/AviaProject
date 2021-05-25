package org.example.backend.services.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.example.backend.configurations.RapidApiConfiguration;
import org.example.backend.model.api.SearchApiRS;
import org.example.backend.model.dto.SearchApiRQDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
public class SearchApiService {
    private final RapidApiConfiguration configuration;
    private final ObjectMapper objectMapper;

    @Autowired
    public SearchApiService(RapidApiConfiguration configuration, ObjectMapper objectMapper) {
        this.configuration = configuration;
        this.objectMapper = objectMapper;
    }

    public SearchApiRS find(SearchApiRQDto searchRQ) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format("https://%s/apiservices/browsequotes/v1.0/RU/RUB/ru-RU/%s/%s/%s", configuration.url, searchRQ.getFromCode(), searchRQ.getToCode(), searchRQ.getDepartureDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))))
                .get()
                .addHeader("x-rapidapi-key", configuration.token)
                .addHeader("x-rapidapi-host", configuration.url)
                .build();
        SearchApiRS searchApiRS = null;
        try {
            Response response = client.newCall(request).execute();
            searchApiRS = objectMapper.readValue(response.body().string(), SearchApiRS.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchApiRS;
    }

}
