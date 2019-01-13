package com.edu.pk.connection.FetchFromExDB;

import android.os.AsyncTask;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.connection.ConnectionClass;
import com.edu.pk.data.Grade;
import com.edu.pk.data.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchGradeTable extends BasicConnection {
    List<Grade> gradeList;
    Integer niu;
    public FetchGradeTable(Integer niu){
        super();
        this.niu = niu;
        gradeList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `grade` WHERE niu = "+ niu;
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Grade fetchGrade = fetchStudentFromDataBase(rs);
            gradeList.add(fetchGrade);
        }
        stmt.close();
    }

    private Grade fetchStudentFromDataBase(ResultSet rs) {
        try {
            int courseNo = rs.getInt("courseNo");
            int grade = rs.getInt("grade");
            int niu = rs.getInt("NIU");

            return new Grade(niu, courseNo, grade);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Grade> getGradeList() {
        return gradeList;
    }
}
