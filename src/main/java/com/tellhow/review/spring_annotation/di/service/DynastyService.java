package com.tellhow.review.spring_annotation.di.service;

import com.tellhow.review.spring_annotation.di.dao.DynastyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("dynastyService1")
public class DynastyService {

    private DynastyDao dynastyDao;

    String name="华英";

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DynastyDao getDynastyDao() {
        return dynastyDao;
    }

    public void setDynastyDao(DynastyDao dynastyDao) {
        this.dynastyDao = dynastyDao;
    }


}
