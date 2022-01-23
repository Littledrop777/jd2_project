package com.academy.it.controller;

import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController {

    private final SearchServiceImpl searchService;

    @Autowired
    public SearchController(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search.html")
    public ModelAndView search(@RequestParam("pattern") String str) {
        List<SearchUserResultDto> results = searchService.search(str);
        ModelAndView modelAndView = new ModelAndView("search-result");
        modelAndView.addObject("results", results);
        return modelAndView;
    }
}
