package com.academy.it.controller;

import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.entity.Friend;
import com.academy.it.entity.Status;
import com.academy.it.service.FriendService;
import com.academy.it.service.SearchService;
import com.academy.it.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class SearchController {

    private final SearchService searchService;
    private final FriendService friendService;

    @Autowired
    public SearchController(SearchService searchService, FriendService friendService) {
        this.searchService = searchService;
        this.friendService = friendService;
    }

    @GetMapping("/{page}/search.html")
    public ModelAndView search(@RequestParam("pattern") String str,
                               @PathVariable("page") int pageId,
                               HttpSession session) {
        int max = 5;
        int first = (pageId - 1) * max;
        List<SearchUserResultDto> results = searchService.search(str, first, max);
        String userId = (String) session.getAttribute("userId");
        if (userId != null) {
            results.forEach(result -> friendService.findByUserIdAndFriendId(userId, result.getUuid())
                    .ifPresent(friend -> result.setStatus(friend.getStatus())));
        }
        ModelAndView modelAndView = new ModelAndView("search-result");
        modelAndView.addObject("results", results);
        modelAndView.addObject("page", pageId);
        modelAndView.addObject("pattern", str);
        return modelAndView;
    }
}
