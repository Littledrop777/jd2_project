package com.academy.it.service.impl;

import com.academy.it.dao.AppUserDao;
import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {

    private final AppUserDao appUserDao;

    @Autowired
    public SearchServiceImpl(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @Override
    public List<SearchUserResultDto> search(String criteria, int first, int max) {
        String[] names = criteria.trim().split(" ");
        List<SearchUserResultDto> results = new ArrayList<>();
        for (String name : names) {
            results.addAll(appUserDao.findAllByCriteria(name, first, max));
        }
        return results;
    }
}
