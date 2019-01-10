package com.edu.pk.connection;
import android.os.AsyncTask;

import com.edu.pk.data.Employee;
import com.edu.pk.data.Lecturer;
import com.edu.pk.data.Student;
import com.edu.pk.data.TypeAcc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchUserDataFromDatabase extends AsyncTask<String, String, String> {
    int niu;
    ConnectionClass connectionClass;

    private boolean isSuccess = false;
    private Student student = null;
    private Employee employee = null;
    private Lecturer lecturer = null;

    public Student getStudent(){
        return student;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public FetchUserDataFromDatabase(int niu) {
        this.connectionClass = new ConnectionClass();
        this.niu = niu;
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
                        getStudent(con);
                        break;
                    case LECTURER:
                        getLecturer(con);
                        break;
                    case EMPLOYEE:
                        getEmployee(con);
                        break;
                }
            }
        } catch (Exception ex) {
            isSuccess = false;
            ex.printStackTrace();
        }
        return null;
    }

    private void getStudent(Connection con) throws SQLException {
        String query = "select * from student where niu='" + niu + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            student = fetchStudentFromDataBase(rs);
        }
        isSuccess = true;
        stmt.close();
    }

    private void getLecturer(Connection con) throws SQLException {
        String query = "select * from lecturer where niu='" + niu + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            lecturer = fetchLecturerFromDataBase(rs);
            isSuccess = true;
        }
        stmt.close();
    }

    private void getEmployee(Connection con) throws SQLException {
        String query = "select * from employee where niu='" + niu + "'";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            employee = fetchEmployeeFromDataBase(rs);
            isSuccess = true;
        }
        stmt.close();
    }

    private Employee fetchEmployeeFromDataBase(ResultSet rs) {
        try {
            int niu = rs.getInt("NIU");
            String password = rs.getString("password");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String address = rs.getString("address");
            String cityOrVillage = rs.getString("cityOrVillage");
            String pesel = rs.getString("pesel");
            String email = rs.getString("email");

            return new Employee(niu, password, firstName, lastName, address, cityOrVillage, email, pesel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
}
