package com.example.demo.controller;

import com.example.demo.Student4;
import com.example.demo.StudentRowMapper;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private NamedParameterJdbcTemplate npjt;
    @Autowired
    private StudentService stdService;
    @PostMapping("/students")
    public String insert(@RequestBody Student4 std){
       //String sql = "INSERT INTO student(id, name) value( :stdID , :stdName)";
        String sql = "INSERT INTO student(name) value( :stdName)";
        Map<String, Object> map = new HashMap<>();
        //map.put("stdID", std.getId());
        map.put("stdName", std.getName());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        //npjt.update( sql, map);
        npjt.update( sql, new MapSqlParameterSource(map), keyHolder);
        int id = keyHolder.getKey().intValue();
        System.out.println("mysql自動生成的id 為: "+ id );
        return "執行 insert sql";
    }
    @PostMapping("/students/many")
    public  String insertList(@RequestBody List<Student4> student4List){
        String sql = "INSERT INTO student(name) VALUE (:studentName)";
        MapSqlParameterSource[] parameterSources =
                new MapSqlParameterSource[student4List.size()];
        for(int i = 0; i<student4List.size(); i++){
            Student4 std = student4List.get(i);
            parameterSources[i] = new MapSqlParameterSource();
            parameterSources[i].addValue("studentName", std.getName());
        }
        npjt.batchUpdate(sql, parameterSources);

        return "執行一批 insert sql";
    }

    @DeleteMapping("/students/{stdID}")
    public  String delete(@PathVariable Integer stdID){
        String sql = "Delete from student where id = :stdID";
        Map<String, Object> map = new HashMap<>();
        map.put("stdID",stdID);
        npjt.update(sql, map);
        return "執行 delete sql";
    }
    @GetMapping("/studentsAll")
        public  List<Student4> select(  ) {
            String sql = "select id, name from student";
            Map<String, Object> map = new HashMap<>();
            List<Student4>  list = npjt.query(sql, map, new StudentRowMapper());
            return  list;
        }

    @GetMapping("/studentsAll/{stdID}")
    public  Student4 select(@PathVariable Integer stdID  ) {
        return stdService.getById(stdID);
    }
}
