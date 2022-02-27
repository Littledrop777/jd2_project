package com.academy.it.controller;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.UserFriendDto;
import com.academy.it.entity.Status;
import com.academy.it.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FriendController {

    private final FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/{page}/friends.html")
    public ModelAndView showFriends(@PathVariable("page") int pageId,
                                    HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        int max = 5;
        int first = (pageId - 1) * max;
        double resultAmount = friendService.countFriendsResult(userId);
        int pageAmount = (int) Math.ceil(resultAmount / max);
        List<UserFriendDto> friends = friendService.findAllFriendsByUserId(userId, first, max);
        ModelAndView modelAndView = new ModelAndView("friends");
        modelAndView.addObject("friends", friends);
        modelAndView.addObject("pageAmount", pageAmount);
        return modelAndView;
    }

    @PostMapping("/add-friend.do")
    public ModelAndView addNewFriend(@RequestParam("id") String friendId,
                                     HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        Status status = friendService.addFriend(userId, friendId);
        String referer = request.getHeader("referer");
        return new ModelAndView("redirect:" + referer)
                .addObject("status", status);
    }

    @PostMapping("/delete-friend.do")
    public ModelAndView deleteFriend(@RequestParam("id") String friendId,
                                     HttpServletRequest request) {
        String userId = (String) request.getSession().getAttribute("userId");
        friendService.deleteFriend(userId, friendId);
        String referer = request.getHeader("referer");
        return new ModelAndView("redirect:" + referer);
    }

    @GetMapping("/{page}/friend-requests.html")
    public ModelAndView showRequests(@PathVariable("page") int pageId,
                                     HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        int max = 5;
        int first = (pageId - 1) * max;
        double resultAmount = friendService.countRequestsResult(userId);
        int pageAmount = (int) Math.ceil(resultAmount / max);
        List<UserFriendDto> friends = friendService.findRequestsByUserId(userId, first, max);
        ModelAndView modelAndView = new ModelAndView("friend-requests");
        modelAndView.addObject("friends", friends);
        modelAndView.addObject("pageAmount", pageAmount);
        return modelAndView;
    }

    @GetMapping("/{page}/requests-from-users.html")
    public ModelAndView showRequestsFromUsers(@PathVariable("page") int pageId,
                                              HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        int max = 5;
        int first = (pageId - 1) * max;
        double resultAmount = friendService.countRequestsFromResult(userId);
        int pageAmount = (int) Math.ceil(resultAmount / max);
        List<UserFriendDto> friends = friendService.findRequestsFromByUserId(userId, first, max);
        ModelAndView modelAndView = new ModelAndView("requests-from-users");
        modelAndView.addObject("friends", friends);
        modelAndView.addObject("pageAmount", pageAmount);
        return modelAndView;
    }
}
