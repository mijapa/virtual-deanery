package com.edu.pk.connection.FetchFromExDB;

import com.edu.pk.connection.BasicConnection;
import com.edu.pk.data.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FetchPaymentTable extends BasicConnection {

    List<Payment> paymentList;

    public FetchPaymentTable() {
        super();
        this.paymentList = new ArrayList<>();
    }

    @Override
    public void queryFuction(Statement stmt) throws Exception {
        String query = "SELECT * FROM `payment`";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            Payment fetchPayment = fetchPaymentFromDataBase(rs);
            paymentList.add(fetchPayment);
        }
        stmt.close();
    }

    private Payment fetchPaymentFromDataBase(ResultSet rs) {
        try {
            int idPayment = rs.getInt("idPayment");
            int idStudent = rs.getInt("idStudent");
            String description = rs.getString("description");
            String year = rs.getString("year");
            String termNo = rs.getString("termNo");
            String term = rs.getString("term");
            String charge = rs.getString("charge");
            String accruedInterest = rs.getString("accruedInterest");
            String estimatedInterest = rs.getString("estimatedInterest");
            String paymentDeadline = rs.getString("paymentDeadline");
            String payment = rs.getString("payment");
            String interestPaid = rs.getString("interestPaid");
            String toPay = rs.getString("toPay");
            String comments = rs.getString("comments");

            Payment r_payment = new Payment(idStudent, description, year, termNo, term, charge, accruedInterest, estimatedInterest, paymentDeadline, payment, interestPaid, toPay, comments);
            r_payment.setIdPayment(idPayment);

            return r_payment;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Payment> getPaymentList(){
        return paymentList;
    }
}
