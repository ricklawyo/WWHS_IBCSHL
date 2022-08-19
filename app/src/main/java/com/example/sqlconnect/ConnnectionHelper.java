package com.example.sqlconnect;
import android.os.StrictMode;
import android.service.autofill.TextValueSanitizer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

import javax.xml.transform.Result;

class ConnectionHelper {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    View view;
    ResultSet resultSet;
    String connectionUrl;

    public ConnectionHelper(View v) {
        connectionUrl =
                "jdbc:sqlserver://143.95.251.39:1433;"
                        + "database=beermeproto;"
                        + "user=sa;"
                        + "password=J()d31253!!;"
                        + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;";


        resultSet = null;
        view = v;

    }

    public void open() {
        StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(p);

        Connection connection = null;


        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try{

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT * from dbo.Beer";
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(selectSql);
            TextView tv = (TextView) view.findViewById(R.id.textView);

            // Print results fom select statement
            while (resultSet.next()) {
                tv.setText(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException ex)
        {
            Log.e("SQL Error ", ex.getMessage());
        }


    }
}