package com.academy.it.service.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.SearchUserResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    private final AppUserDao appUserDao;

    @Autowired
    public SearchServiceImpl(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @Override
    public List<SearchUserResultDto> search(String criteria) {
        String[] names = criteria.trim().split(" ");
        List<SearchUserResultDto> results = new ArrayList<>();
        for (String name : names) {
            results.addAll(appUserDao.findAllByCriteria(name));
        }
        return results;
    }
}