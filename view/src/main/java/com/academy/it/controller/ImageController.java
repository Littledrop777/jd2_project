package com.academy.it.controller;

import com.academy.it.entity.UserInfo;
import com.academy.it.service.UserInfoService;
import com.academy.it.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@SessionAttributes("imageName")
public class ImageController {

    private final ImageService imageService;
    private final UserInfoService infoService;

    @Autowired
    public ImageController(ImageService imageService, UserInfoService infoService) {
        this.imageService = imageService;
        this.infoService = infoService;
    }


    @PostMapping("/save-image.do")
    public ModelAndView uploadImage(@RequestParam("image") MultipartFile file,
                                    HttpSession session) throws IOException {
        String userId = String.valueOf(session.getAttribute("userId"));
        String imagePath = userId + "/" + file.getOriginalFilename();
        imageService.upload(imagePath, file.getInputStream());
        UserInfo userInfo = infoService.findByUserId(userId);
        userInfo.setImage(imagePath);
        infoService.update(userInfo);
        return new ModelAndView("redirect:" + userId + "/profile.html")
                .addObject("imageName", file.getOriginalFilename());
    }


}
