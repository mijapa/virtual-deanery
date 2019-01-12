package com.edu.pk.connection.FetchFromExDB;
import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Lecturer;
import com.edu.pk.data.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchLecturerTable extends BasicConnection {

    List<Lecturer> lecturerList;

    public FetchLecturerTable(){
        super();
        lecturerList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `lecturer`";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Lecturer fetchLecturer = fetchLecturerFromDataBase(rs);
            lecturerList.add(fetchLecturer);
        }
        stmt.close();
    }

    private Lecturer fetchLecturerFromDataBase(ResultSet rs) {
        try {
            int niu = rs.getInt("NIU");
            String password = rs.getString("password");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String address = rs.getString("address");
            int phoneNumber = rs.getInt("tel");

            return new Lecturer(niu, password, firstName, lastName, address, phoneNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Lecturer> getLecturerList(){
        return lecturerList;
    }
}
