package com.academy.it.validation;

import com.academy.it.entity.BaseEntity;

import java.util.List;

public interface EntityValidation <T extends BaseEntity<String>> {

    List<String> validate(T entity);

}
