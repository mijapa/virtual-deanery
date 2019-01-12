package com.edu.pk.connection.InsertIntoExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Grade;

import java.sql.Statement;

public class InsertGrade extends BasicConnection {
    Grade grade;

    public InsertGrade(Grade grade) {
        super();
        this.grade = grade;
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "INSERT INTO `grade` (`courseNo`, `NIU`, `grade`) VALUES ('" +
                + grade.getCourseNo() +"', '" +
                + grade.getNiu() +"', '" +
                + grade.getGrade()+"')";
        stmt.executeUpdate(query);
        stmt.close();
    }
}
