package com.academy.it.service.impl;

import com.academy.it.dto.SearchUserResultDto;

import java.util.List;

public interface SearchService {
    List<SearchUserResultDto> search(String criteria);
}
