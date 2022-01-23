package com.academy.it.controller;

import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{page}/search.html")
    public ModelAndView search(@RequestParam("pattern") String str,
                               @PathVariable("page") int pageId) {
        int max = 5;
        int first = (pageId - 1) * max;
        List<SearchUserResultDto> results = searchService.search(str, first, max);
        ModelAndView modelAndView = new ModelAndView("search-result");
        modelAndView.addObject("results", results);
        modelAndView.addObject("page", pageId);
        modelAndView.addObject("pattern", str);
        return modelAndView;
    }
}
