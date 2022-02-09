package com.academy.it.dao;

import com.academy.it.entity.Image;

import java.util.List;

public interface ImageDao extends Dao<Image, String>{

    List<Image> findByUserId(String id);
}
