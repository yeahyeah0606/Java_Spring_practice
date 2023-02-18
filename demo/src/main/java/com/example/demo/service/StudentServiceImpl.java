package com.example.demo.service;

import com.example.demo.Student4;
import com.example.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements  StudentService{
    @Autowired
    private StudentDao stdDao;
    @Override
    public Student4 getById(Integer stdID) {
        return  stdDao.getById(stdID);
    }
}
