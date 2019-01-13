package com.edu.pk.connection;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.edu.pk.LoginActivity;
import com.edu.pk.data.Student;
import com.edu.pk.employee.EmployeeMenuActivity;
import com.edu.pk.lecturer.LecturerMenuActivity;
import com.edu.pk.student.MenuActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionClass {
    String classs = "com.mysql.jdbc.Driver";

    String url = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7272802";
    String un = "sql7272802";
    String password = "fkS9GvXWws";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;

        try {
            Class.forName(classs);
            conn = DriverManager.getConnection(url, un, password);

        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}
