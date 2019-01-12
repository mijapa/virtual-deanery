package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchCourseTable extends BasicConnection {
    List<Course> coursesList;

    public FetchCourseTable() {
        this.coursesList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `course`";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Course fetchCourse = fetchCourseFromDataBase(rs);
            coursesList.add(fetchCourse);
        }
        stmt.close();
    }

    private Course fetchCourseFromDataBase(ResultSet rs) {
        try {
            int courseNo = rs.getInt("courseNo");
            String name = rs.getString("name");
            String ects = rs.getString("ects");
            String department = rs.getString("department");
            String fieldOfStudy = rs.getString("fieldOfStudy");
            String hourAmount = rs.getString("hourAmount");
            int term = rs.getInt("term");

            return new Course(courseNo, name, ects, term, department, fieldOfStudy, hourAmount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Course> getCoursesList() {
        return coursesList;
    }
}
