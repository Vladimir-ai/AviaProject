package org.example.backend.controllers.restApi;

import org.example.backend.model.FlightTicket;

import org.example.backend.model.dto.SearchRQ;
import org.example.backend.model.dto.SearchResultDto;
import org.example.backend.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/find")
    public List<SearchResultDto> findTickets(@RequestBody SearchRQ body) {
        return searchService.find(body);
    }


}
