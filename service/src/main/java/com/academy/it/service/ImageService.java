package com.academy.it.service;

import com.academy.it.entity.Image;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface ImageService {
    String save(String userId, String imgPath);

    Image findById(String id);

    List<Image> findByUserId(String userId);

    void upload(String imagePath, InputStream imageContent) throws IOException;

    byte[] getImageBytes(String imageId) throws IOException;
}
