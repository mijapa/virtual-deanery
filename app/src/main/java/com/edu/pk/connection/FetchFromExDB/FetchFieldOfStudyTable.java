package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.FieldOfStudy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchFieldOfStudyTable extends BasicConnection {
    List<FieldOfStudy> fieldOfStudyList;


    public FetchFieldOfStudyTable(){
        fieldOfStudyList = new ArrayList<>();
    }


    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `fieldOfStudy`";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            FieldOfStudy fetchField = fetchFieldOfStudyList(rs);
            fieldOfStudyList.add(fetchField);
        }
        stmt.close();
    }

    private FieldOfStudy fetchFieldOfStudyList(ResultSet rs) {
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

    public List<FieldOfStudy> getFieldOfStudyList() {
        return fieldOfStudyList;
    }
}
