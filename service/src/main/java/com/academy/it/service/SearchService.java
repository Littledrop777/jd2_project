package com.academy.it.service;

import com.academy.it.dto.SearchUserResultDto;

import java.util.List;

public interface SearchService {

    List<SearchUserResultDto> search(String criteria, int first, int max);
}
