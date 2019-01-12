package com.edu.pk.connection.UpdateExDB;

import android.os.AsyncTask;

import com.edu.pk.connection.ConnectionClass;
import com.edu.pk.data.TypeAcc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdatePassword extends AsyncTask<String, String, String> {
    int niu;
    String password;
    ConnectionClass connectionClass;
    private boolean isSuccess = false;
    public UpdatePassword(int niu, String password){
        this.connectionClass = new ConnectionClass();
        this.niu = niu;
        this.password = password;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
    @Override
    protected String doInBackground(String... params) {
        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
                throw new Exception("Internet ERROR");

            } else {
                switch (TypeAcc.getType(niu)) {
                    case STUDENT:
                        changeStudentPassword(con);
                        break;
                    case LECTURER:
                        changeLecturerPassword(con);
                        break;
                    case EMPLOYEE:
                        changeEmployeePassword(con);
                        break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            isSuccess = false;
        }
        return null;
    }

    private void changeStudentPassword(Connection con) throws SQLException {
        String query = "UPDATE student SET password = '" + password + "' WHERE student.NIU = "+ niu;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        isSuccess = true;
    }
    private void changeLecturerPassword(Connection con) throws SQLException {
        String query = "UPDATE lecturer SET password = '" + password + "' WHERE lecturer.NIU = "+ niu;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        isSuccess = true;
    }
    private void changeEmployeePassword(Connection con) throws SQLException {
        String query = "UPDATE employee SET password = '" + password + "' WHERE employee.NIU = "+ niu;
        Statement stmt = con.createStatement();
        stmt.executeUpdate(query);
        stmt.close();
        isSuccess = true;
    }
}
