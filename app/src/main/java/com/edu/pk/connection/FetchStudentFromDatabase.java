package com.edu.pk.connection;
import android.os.AsyncTask;
import com.edu.pk.data.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudentFromDatabase extends AsyncTask<String, String, String> {
    int niu;
    String password;

    int niuFromDataBase;
    String passwordFromDataBase;

    ConnectionClass connectionClass;

    String z = "";

    private boolean isSuccess = false;
    private Student student = null;

    public Student getStudent(){
        return student;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public FetchStudentFromDatabase(int niu, String password) {
        this.connectionClass = new ConnectionClass();
        this.niu = niu;
        this.password = password;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
           Connection con = connectionClass.CONN();
            if (con == null) {
                throw new Exception("Internet ERROR");

            } else {
                String query = "select * from student where niu='" + niu + "' and password = '" + password + "'";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    niuFromDataBase = rs.getInt("NIU");
                    passwordFromDataBase = rs.getString("password");

                    if (password.equals(passwordFromDataBase) && niu == niuFromDataBase) {
                        student = fetchFromDataBase(rs);
                        isSuccess = true;
                    } else {
                        isSuccess = false;
                    }
                }
                stmt.close();
            }
        } catch (Exception ex) {
            isSuccess = false;
            ex.printStackTrace();
        }
        return z;
    }

    private Student fetchFromDataBase(ResultSet rs) {
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
            int term = 0;
            return new Student(niu, albumNo, password, pesel, firstName, lastName, familyName, sex, address, cityOrVillage, voivodeship, country, distanceFromTheCheck_InPlace, dateOfBirth,
                    placeOfBirth, fatherName, motherName, motherFamilyName, maritalStatus, foreigner, phoneNumber, otherNumber, bankAccount, email, dateOfStudyStart, term);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
