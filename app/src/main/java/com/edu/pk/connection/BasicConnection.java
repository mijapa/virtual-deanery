package com.edu.pk.connection;

import android.os.AsyncTask;

import com.edu.pk.connection.FetchFromExDB.FetchFieldOfStudyTable;
import com.edu.pk.data.FieldOfStudy;

import java.sql.Connection;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public abstract class BasicConnection extends AsyncTask<String, String, String> {
    private ConnectionClass connectionClass;
    public Connection con;
    private boolean isSuccess = false;

    public BasicConnection() {
        this.connectionClass = new ConnectionClass();
        con = connectionClass.CONN();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            if (con == null) {
                throw new Exception("Internet ERROR");
            } else {
                queryFuction(con.createStatement());
                isSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            isSuccess = false;
        }
        return null;
    }

    public abstract void queryFuction(Statement stmt) throws Exception;
    public boolean isSuccess() {
        return isSuccess;
    }

    public static void updateTable(BasicConnection tableClass) throws Exception{
        BasicConnection table = tableClass;
        tableClass.execute().get(3000,TimeUnit.MILLISECONDS);
    }

}
