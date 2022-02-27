package com.academy.it.service.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dao.ImageDao;
import com.academy.it.entity.Image;
import com.academy.it.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.List;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

@Service
@PropertySource("classpath:/service.properties")
@Transactional
public class ImageServiceImpl implements ImageService {

    @Value("${image.base.url}")
    private String basePath;
    private final ImageDao imageDao;
    private final AppUserDao userDao;

    @Autowired
    public ImageServiceImpl(ImageDao imageDao, AppUserDao userDao) {
        this.imageDao = imageDao;
        this.userDao = userDao;
    }

    @Override
    public String save(String userId, String imgPath) {
        Image image = new Image();
        image.setAppUser(userDao.findById(userId));
        image.setImagePath(imgPath);
        image.setCreateDate(Instant.now());
        return imageDao.save(image).getId();
    }

    @Override
    public Image findById(String id) {
        return imageDao.findById(id);
    }

    @Override
    public List<Image> findByUserId(String userId) {
        return imageDao.findByUserId(userId);
    }

    @Override
    public void upload(String imagePath, InputStream imageContent) throws IOException {
        Path imageFullPath = Path.of(basePath, imagePath);
        try (imageContent) {
            Files.createDirectories(imageFullPath.getParent());
            Files.write(imageFullPath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING);
        }
    }

    @Override
    public byte[] getImageBytes(String imageId) throws IOException {
        byte [] image;
        if (imageId.isEmpty()) {
            image = Files.readAllBytes(
                    Path.of(ResourceUtils.getFile("classpath:avatardefault.png")
                            .getAbsolutePath()));
        } else {
            Image byId = this.findById(imageId);
            image = Files.readAllBytes(
                    Path.of(basePath, byId.getImagePath()));
        }
        return image;
    }
}
