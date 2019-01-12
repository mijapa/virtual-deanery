package com.edu.pk.connection.FetchFromExDB;

import android.os.AsyncTask;

import com.edu.pk.BaseActivity;
import com.edu.pk.connection.BasicConnection;
import com.edu.pk.connection.ConnectionClass;
import com.edu.pk.data.Course;
import com.edu.pk.data.FieldOfStudy;
import com.edu.pk.data.LecturerCourse;
import com.edu.pk.data.Student;
import com.edu.pk.data.StudentFieldOfStudy;
import com.edu.pk.data.TypeAcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchLecturerCourseTable extends BasicConnection {
    List<LecturerCourse> lecturerCourseList;

    public FetchLecturerCourseTable(){
        super();
        lecturerCourseList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM lecturer_course";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            LecturerCourse fetchCourse = fetchUserCourse(rs);
            lecturerCourseList.add(fetchCourse);
        }
        stmt.close();
    }
    private LecturerCourse fetchUserCourse(ResultSet rs) {
        try {
            int courseNo = rs.getInt("courseNo");
            int niu = rs.getInt("niu");
            return new LecturerCourse(courseNo, niu);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<LecturerCourse> getLecturerCourseList(){
        return lecturerCourseList;
    }
}
