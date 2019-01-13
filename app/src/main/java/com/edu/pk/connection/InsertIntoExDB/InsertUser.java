package com.edu.pk.connection.InsertIntoExDB;
import com.edu.pk.connection.BasicConnection;

import com.edu.pk.data.Lecturer;
import com.edu.pk.data.Student;

import java.sql.SQLException;
import java.sql.Statement;

public class InsertUser extends BasicConnection {

    Student student = null;
    Lecturer lecturer = null;

    public InsertUser(Student student) {
        super();
        this.student = student;
    }

    public InsertUser(Lecturer lecturer) {
        super();
        this.lecturer = lecturer;
    }


    @Override
    public void queryFuction(Statement stmt) throws Exception {
        if(student != null){
            insertStudent(stmt);
        }
        else if(lecturer != null){
            insertLecturer(stmt);
        }
    }

    private void insertLecturer(Statement stmt) {
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
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertStudent(Statement stmt) {
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
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
