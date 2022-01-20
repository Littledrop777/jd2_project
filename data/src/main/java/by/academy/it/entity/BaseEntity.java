package by.academy.it.entity;

import java.io.Serializable;

public interface BaseEntity<K extends Serializable> {

    void setId(String id);

    String getId();
}
