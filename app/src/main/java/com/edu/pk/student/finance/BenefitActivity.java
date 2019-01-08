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
import com.edu.pk.data.Benefit;

import java.util.List;

public class BenefitActivity extends BaseActivity {

    private BenefitViewModel mBenefitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit);

        mBenefitViewModel = ViewModelProviders.of(this).get(BenefitViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TableLayout tableLayout = (TableLayout) findViewById(R.id.tablelayout);
        TableRow rowHeader = new TableRow(this);
        rowHeader.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText = {"Nazwa świadczenia", "Kwota świadczenia", "Status", "Świadczenie przyznane od dnia", "Świadczenie przyznane do dnia"};
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
        List<Benefit> benefits = mBenefitViewModel.getBenefits();

        for(int i = 0; i < benefits.size(); i++){
            String nameBenefit = benefits.get(i).getNameBenefit();
            String sum = benefits.get(i).getSum();
            String status = benefits.get(i).getStatus();
            String fromTheDateOf = benefits.get(i).getFromTheDateOf();
            String untilTheDate = benefits.get(i).getUntilTheDate();

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            String[] colText = {nameBenefit, sum, status, fromTheDateOf, untilTheDate};
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
