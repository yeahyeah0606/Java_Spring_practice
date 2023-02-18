package com.example.demo.dao;

import com.example.demo.Student4;
import com.example.demo.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDaoImpl implements  StudentDao{
    @Autowired
    private NamedParameterJdbcTemplate npjt;
    @Override
    public Student4 getById(Integer stdID) {
        String sql = "select id, name from student where id = :stdID";
        Map<String, Object> map = new HashMap<>();
        map.put("stdID", stdID);
        List<Student4> list = npjt.query(sql, map, new StudentRowMapper());
        if(list.size()>0){
            return  list.get(0);
        }else{
            return  null;
        }
    }
}
