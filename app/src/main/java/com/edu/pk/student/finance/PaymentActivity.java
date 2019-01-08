package com.edu.pk.student.finance;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.edu.pk.BaseActivity;
import com.edu.pk.R;
import com.edu.pk.data.Payment;

import java.util.List;

public class PaymentActivity extends BaseActivity{

    private PaymentViewModel mPaymentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        mPaymentViewModel = ViewModelProviders.of(this).get(PaymentViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TableLayout tableLayout = (TableLayout) findViewById(R.id.tablelayout);
        TableRow rowHeader = new TableRow(this);
        rowHeader.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText = {"Tytuł", "Rok akademicki", "Nr. semestru", "Semestr", "Należność", "Odsetki naliczone", "Odsetki szacowane", "Termin płatności", "Wpłaty", "Odsetki zapłacone", "Do zapłaty", "Uwagi"};
        for (String c : headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(15);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        tableLayout.addView(rowHeader);
        List<Payment> payments = mPaymentViewModel.getPayments();

        for(int i = 0; i < payments.size(); i++){
            String description = payments.get(i).getDescription();
            String year = payments.get(i).getYear();
            String termNo = payments.get(i).getTermNo();
            String term = payments.get(i).getTerm();
            String charge = payments.get(i).getCharge();
            String accruedInterest = payments.get(i).getAccruedInterest();
            String estimatedInterest = payments.get(i).getEstimatedInterest();
            String paymentDeadline = payments.get(i).getPaymentDeadline();
            String payment = payments.get(i).getPayment();
            String interestPaid = payments.get(i).getInterestPaid();
            String toPay = payments.get(i).getToPay();
            String comments = payments.get(i).getComments();

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            String[] colText = {description, year, termNo, term, charge, accruedInterest, estimatedInterest, paymentDeadline, payment, interestPaid, toPay, comments};
            for (String text : colText) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(16);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(text);
                row.addView(tv);
            }
            tableLayout.addView(row);
        }
    }

}
