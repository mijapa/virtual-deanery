package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.StudentFieldOfStudy;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchStudentFieldOfStudyTable extends BasicConnection {

    List<StudentFieldOfStudy> studentFieldOfStudyList;
    public FetchStudentFieldOfStudyTable() {
        studentFieldOfStudyList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `student_fieldOfStudy`";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            StudentFieldOfStudy studentFieldOfStudy = fetchStudentFieldOfStudy(rs);
            studentFieldOfStudyList.add(studentFieldOfStudy);
        }
        stmt.close();
    }

    private StudentFieldOfStudy fetchStudentFieldOfStudy(ResultSet rs) {
        try {
            int fieldOfStudyNo = rs.getInt("fieldOfStudyNo");
            int niu = rs.getInt("niu");

            return new StudentFieldOfStudy(fieldOfStudyNo, niu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<StudentFieldOfStudy> getStudentFieldOfStudyList(){
        return studentFieldOfStudyList;
    }
}
