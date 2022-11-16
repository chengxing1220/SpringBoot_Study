package com.tellhow.review.spring_annotation.di.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DynastyDao {
    private String name="华山派";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
