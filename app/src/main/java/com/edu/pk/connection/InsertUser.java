package com.edu.pk.connection;

import android.os.AsyncTask;

import com.edu.pk.data.Lecturer;
import com.edu.pk.data.Student;
import com.edu.pk.data.TypeAcc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUser extends AsyncTask<String, String, String> {

    ConnectionClass connectionClass = new ConnectionClass();
    private boolean isSuccess = false;
    Student student = null;
    Lecturer lecturer = null;

    public InsertUser(Student student) {
        this.student = student;
    }

    public InsertUser(Lecturer lecturer) {
        this.lecturer = lecturer;
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
                if(student != null){
                    insertStudent(student, con);
                }
                else if(lecturer != null){
                    insertLecturer(lecturer, con);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            isSuccess = false;
        }
        return null;
    }

    private void insertLecturer(Lecturer lecturer, Connection con) {
        String query = "INSERT INTO `lecturer` (" +
                "`NIU`, " +
                "`password`, " +
                "`typeAcc`, " +
                "`firstName`, " +
                "`lastName`, " +
                "`address`, " +
                "`cityOrVillage`, " +
                "`voivodeship`, " +
                "`country`, " +
                "`tel`) " +
                "VALUES (" +
                "'"+ lecturer.getNiu() +"', " +
                "'"+ lecturer.getPassword() +"', " +
                "'1', " +
                "'"+ lecturer.getFirstName() +"', " +
                "'"+ lecturer.getLastName() +"', " +
                "'"+ lecturer.getAddress() +"', " +
                "'   ', " +
                "'   ', " +
                "'   ', " +
                ""+ lecturer.getPhoneNumber() +")";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        isSuccess = true;
    }

    private void insertStudent(Student student, Connection con) {
        String query = "INSERT INTO `student` (" +
                "`NIU`, " +
                "`albumNo`, " +
                "`password`, `" +
                "typeAcc`, " +
                "`pesel`, " +
                "`firstName`, " +
                "`lastName`, " +
                "`familyName`, " +
                "`sex`, " +
                "`address`, " +
                "`cityOrVillage`, " +
                "`voivodeship`, " +
                "`country`, " +
                "`distanceFromTheCheck_InPlace`, " +
                "`dateOfBirth`, " +
                "`placeOfBirth`, " +
                "`fatherName`, " +
                "`motherName`, " +
                "`motherFamilyName`, " +
                "`maritalStatus`, " +
                "`foreigner`, " +
                "`phoneint`, " +
                "`otherint`, " +
                "`bankAccount`, " +
                "`email`, " +
                "`dateOfStudyStart`, " +
                "`term`) " +
                "VALUES (" +
                "'"+ student.getNiu() +"', " +
                "'"+ student.getAlbumNo() +"', " +
                "'"+ student.getPassword() +"', " +
                "'2', " +
                "'"+ student.getPesel() +"', " +
                "'"+ student.getFirstName() +"', " +
                "'"+ student.getLastName() +"', " +
                "'"+ student.getFamilyName() +"', " +
                "'"+ student.getSex() +"', " +
                "'"+ student.getAddress() +"', " +
                "'"+ student.getCityOrVillage() +"', " +
                "'"+ student.getVoivodeship() +"', " +
                "'"+ student.getCountry() +"', " +
                "'"+ student.getDistanceFromTheCheck_InPlace() +"', " +
                "'"+ student.getDateOfBirth() +"', " +
                "'"+ student.getPlaceOfBirth() +"', " +
                "'"+ student.getFatherName() +"', " +
                "'"+ student.getMotherName() +"', " +
                "'"+ student.getMotherFamilyName() +"', " +
                "'"+ student.getMaritalStatus() +"', " +
                "'"+ student.getForeigner() +"', " +
                "'"+ student.getPhoneNumber() +"', " +
                "'"+ student.getOtherNumber() +"', " +
                "'"+ student.getBankAccount() +"', " +
                "'"+ student.getEmail() +"', " +
                "'"+ student.getDateOfStudyStart()+"', " +
                "'"+ student.getTerm()+"')";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        isSuccess = true;
    }
}
