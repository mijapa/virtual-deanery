package com.edu.pk.connection.InsertIntoExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.StudentFieldOfStudy;

import java.sql.Statement;

public class InsertStudentFieldOfStudy extends BasicConnection {
    StudentFieldOfStudy studentFieldOfStudy;

    public InsertStudentFieldOfStudy(StudentFieldOfStudy studentFieldOfStudy) {
        super();
        this.studentFieldOfStudy = studentFieldOfStudy;
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "INSERT INTO `student_fieldOfStudy` (`fieldOfStudyNo`, `NIU`) " +
                "VALUES " +
                "('"+ studentFieldOfStudy.getFieldOfStudyNo()+ "', '" +
                ""+ studentFieldOfStudy.getNiu() +"')";
        stmt.executeUpdate(query);
        stmt.close();
    }

}
