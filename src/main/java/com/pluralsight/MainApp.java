package com.pluralsight;

import java.sql.SQLException;

import static com.pluralsight.ConnectionManager.*;
import static com.pluralsight.DataManager.*;
import static com.pluralsight.MenuManager.*;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        try {
            if (args.length != 2) {
                login();
            } else {
                username = args[0];
                ds.setUsername(username);
                password = args[1];
                ds.setPassword(password);
            }
            startConnection();
            menuOrder();
        }
        catch(Exception connError){
            System.out.println("CONNECTION ERROR");
            connError.printStackTrace();
        }
        finally{
            conn.close();
            rSet.close();
            prepState.close();
            scan.close();
        }
    }
}
