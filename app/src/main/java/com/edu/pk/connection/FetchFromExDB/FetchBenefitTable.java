package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Benefit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchBenefitTable extends BasicConnection {
    List<Benefit> benefitList;

    public FetchBenefitTable() {
        super();
        this.benefitList = new ArrayList<>();
    }
    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `benefit`";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Benefit fetchBenefit = fetchCourseFromDataBase(rs);
            benefitList.add(fetchBenefit);
        }
        stmt.close();
    }

    private Benefit fetchCourseFromDataBase(ResultSet rs) {
        try {
            int idBenefit = rs.getInt("idBenefit");
            int idStudent = rs.getInt("idStudent");
            String nameBenefit = rs.getString("nameBenefit");
            String sum = rs.getString("sum");
            String status = rs.getString("status");
            String fromTheDateOf = rs.getString("fromTheDateOf");
            String untilTheDate = rs.getString("untilTheDate");

            Benefit benefit = new Benefit(idStudent, nameBenefit, sum, status, fromTheDateOf, untilTheDate);
            benefit.setIdBenefit(idBenefit);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Benefit> getBenefitList(){
        return benefitList;
    }
}

