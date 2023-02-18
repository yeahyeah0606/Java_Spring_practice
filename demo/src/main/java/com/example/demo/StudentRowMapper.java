package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student4> {
    @Override
    public Student4 mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student4 std = new Student4();
        std.setId(rs.getInt("id"));
        std.setName(rs.getString("name"));
        return std;
    }
}
