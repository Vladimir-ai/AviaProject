package org.example.backend.services;

import org.example.backend.model.api.SearchApiRS;
import org.example.backend.model.dto.SearchApiRQDto;
import org.example.backend.model.dto.SearchRQ;
import org.example.backend.model.dto.SearchResultDto;
import org.example.backend.repositories.UserRepo;
import org.example.backend.services.api.SearchApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private final SearchApiService searchApiService;
    private final UserRepo userRepo;

    @Autowired
    public SearchService(SearchApiService searchApiService, UserRepo userRepo) {
        this.searchApiService = searchApiService;
        this.userRepo = userRepo;
    }

    public List<SearchResultDto> find(SearchRQ rq){
        SearchApiRS rs = searchApiService.find(new SearchApiRQDto(rq.getFrom(),rq.getTo(),rq.getDepartureDate()));
        List<SearchResultDto> result = new ArrayList<>();

        rs.getQuotes().forEach(quote -> {
            result.add(new SearchResultDto(quote.getId(),rs.getPlaceById(quote.getOutboundLeg().getOriginId()).getCityName(),rs.getPlaceById(quote.getOutboundLeg().getOriginId()).getIataCode(),rs.getPlaceById(quote.getOutboundLeg().getDestinationId()).getName(),rs.getPlaceById(quote.getOutboundLeg().getDestinationId()).getIataCode(),quote.getPrice(),(int)(quote.getPrice()*1.5),quote.getOutboundLeg().getDepartureDate().withHour(quote.getQuoteDateTime().getHour()).withMinute(quote.getQuoteDateTime().getMinute()),quote.getOutboundLeg().getDepartureDate().withHour(quote.getQuoteDateTime().getHour()).withMinute(quote.getQuoteDateTime().getMinute())));
        });
        return result;
    }

}
