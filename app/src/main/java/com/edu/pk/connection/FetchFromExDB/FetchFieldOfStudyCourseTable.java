package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.FieldOfStudyCourse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchFieldOfStudyCourseTable extends BasicConnection {
    List<FieldOfStudyCourse> fieldOfStudyCourseList;

    public FetchFieldOfStudyCourseTable() {
        super();
        fieldOfStudyCourseList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `fieldOfStudy_course`";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            FieldOfStudyCourse fetchField = fetchFieldOfStudyCourseList(rs);
            fieldOfStudyCourseList.add(fetchField);
        }
        stmt.close();
    }

    private FieldOfStudyCourse fetchFieldOfStudyCourseList(ResultSet rs) {
        try {
            int fieldOfStudyNo = rs.getInt("fieldOfStudyNo");
            int courseNo = rs.getInt("courseNo");

            return  new FieldOfStudyCourse(fieldOfStudyNo, courseNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<FieldOfStudyCourse> getFieldOfStudyCourseList() {
        return fieldOfStudyCourseList;
    }
}
