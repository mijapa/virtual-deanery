package com.edu.pk.connection;

import android.os.AsyncTask;

import com.edu.pk.data.Employee;
import com.edu.pk.data.FieldOfStudy;
import com.edu.pk.data.TypeAcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UpdateFieldOfStudy extends AsyncTask<String, String, String> {
    ConnectionClass connectionClass;
    private boolean isSuccess = false;
    List<FieldOfStudy> fieldOfStudyList;

    public UpdateFieldOfStudy(){
        this.connectionClass = new ConnectionClass();
        fieldOfStudyList = new ArrayList<>();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            Connection con = connectionClass.CONN();
            if (con == null) {
                throw new Exception("Internet ERROR");
            } else {
                getList(con);
                isSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            isSuccess = false;
        }
        return null;
    }

    private void getList(Connection con) throws Exception{
        String query = "SELECT * FROM `fieldOfStudy`";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            FieldOfStudy fetchField = fetchFieldFromDatabase(rs);
            fieldOfStudyList.add(fetchField);
        }
        stmt.close();
    }

    private FieldOfStudy fetchFieldFromDatabase(ResultSet rs) {
        try {
            int fieldOfStudyNo = rs.getInt("fieldOfStudyNo");
            String fieldOfStudyName = rs.getString("fieldOfStudyName");
            String department = rs.getString("department");
            FieldOfStudy returnField = new FieldOfStudy(fieldOfStudyName, department);
            returnField.setFieldOfStudyNo(fieldOfStudyNo);
            return returnField;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
    public List<FieldOfStudy> getFieldOfStudyList() {
        return fieldOfStudyList;
    }

}
