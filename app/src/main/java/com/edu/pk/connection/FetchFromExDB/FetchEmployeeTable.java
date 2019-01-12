package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Employee;
import com.edu.pk.data.Lecturer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchEmployeeTable extends BasicConnection {

    List<Employee> employeeList;

    public FetchEmployeeTable(){
        super();
        employeeList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `employee`";
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Employee fetchEmployee = fetchEmployeeFromDataBase(rs);
            employeeList.add(fetchEmployee);
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

    public List<Employee> getEmployeeList(){
        return  employeeList;
    }
}
