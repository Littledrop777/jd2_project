package com.academy.it.controller;

import com.academy.it.entity.UserInfo;
import com.academy.it.service.UserInfoService;
import com.academy.it.service.impl.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class ImageController {

    private final ImageService imageService;
    private final UserInfoService infoService;

    @Autowired
    public ImageController(ImageService imageService, UserInfoService infoService) {
        this.imageService = imageService;
        this.infoService = infoService;
    }

    @GetMapping(value = "/images.html", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody
    ResponseEntity<byte[]> showImage(@RequestParam("imgId") String avatarId) throws IOException {
        byte[] image = imageService.get(avatarId);
        return new ResponseEntity<>(image, HttpStatus.CREATED);
    }

    @PostMapping("/save-image.do")
    public ModelAndView saveImage(@RequestParam("image") MultipartFile file,
                                  HttpSession session) throws IOException {
        String userId = String.valueOf(session.getAttribute("userId"));
        String imgName = file.getOriginalFilename();
        String imagePath = userId + "/" + imgName;
        imageService.upload(imagePath, file.getInputStream());
        String avatarId = imageService.save(userId, imagePath);
        UserInfo userInfo = infoService.findByUserId(userId);
        userInfo.setAvatarId(avatarId);
        infoService.update(userInfo);
        return new ModelAndView("redirect:" + userId + "/profile.html");
    }
}
