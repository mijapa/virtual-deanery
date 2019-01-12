package com.edu.pk.connection.FetchFromExDB;
import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchStudentTable extends BasicConnection {

    List<Student> studentList;

    public FetchStudentTable(){
        super();
        studentList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `student`";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Student fetchStudent = fetchStudentFromDataBase(rs);
            studentList.add(fetchStudent);
        }
        stmt.close();
    }

    private Student fetchStudentFromDataBase(ResultSet rs) {
        try {
            int niu = rs.getInt("NIU");
            int albumNo = rs.getInt("albumNo");
            String password = rs.getString("password");
            String pesel = rs.getString("pesel");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String familyName = rs.getString("familyName");
            int sex = rs.getInt("sex");
            String address = rs.getString("address");
            String cityOrVillage = rs.getString("cityOrVillage");
            String voivodeship = rs.getString("voivodeship");
            String country = rs.getString("country");
            int distanceFromTheCheck_InPlace = rs.getInt("distanceFromTheCheck_InPlace");
            String dateOfBirth = rs.getString("dateOfBirth");
            String placeOfBirth = rs.getString("placeOfBirth");
            String fatherName = rs.getString("fatherName");
            String motherName = rs.getString("motherName");
            String motherFamilyName = rs.getString("motherFamilyName");
            int maritalStatus = rs.getInt("maritalStatus");
            int foreigner = rs.getInt("foreigner");
            int phoneNumber = rs.getInt("phoneint");
            int otherNumber = rs.getInt("otherint");
            String bankAccount = rs.getString("bankAccount");
            String email = rs.getString("email");
            String dateOfStudyStart = rs.getString("dateOfStudyStart");
            int term = rs.getInt("term");
            return new Student(niu, albumNo, password, pesel, firstName, lastName, familyName, sex, address, cityOrVillage, voivodeship, country, distanceFromTheCheck_InPlace, dateOfBirth,
                    placeOfBirth, fatherName, motherName, motherFamilyName, maritalStatus, foreigner, phoneNumber, otherNumber, bankAccount, email, dateOfStudyStart, term);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Student> getStudentList() {
        return studentList;
    }
}
