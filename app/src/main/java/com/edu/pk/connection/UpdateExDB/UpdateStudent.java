package com.edu.pk.connection.UpdateExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateStudent extends BasicConnection {
    Student student;
    public UpdateStudent(Student student) {
        super();
        this.student = student;
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "UPDATE student SET " +
                "address = '" + student.getAddress() + "', " +
                "cityOrVillage = '" + student.getCityOrVillage() + "', " +
                "voivodeship = '" + student.getVoivodeship() + "', " +
                "otherint = '" + student.getOtherNumber() + "', " +
                "email = '" + student.getEmail() + "' " +
                "WHERE student.NIU = " + student.getNiu();
        stmt.executeUpdate(query);
        stmt.close();
    }

}
