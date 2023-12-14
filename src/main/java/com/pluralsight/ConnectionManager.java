package com.pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

import static com.pluralsight.MenuManager.scan;
public class ConnectionManager {
    public static String username, password;
    public static BasicDataSource ds = new BasicDataSource();
    public static Connection conn = null;
        public static void login(){
            System.out.print("Username: ");
            username = scan.nextLine();
            ds.setUsername(username);
            System.out.print("Password: ");
            password = scan.nextLine();
            ds.setPassword(password);
        }

        public static void startConnection(){
            try{
                ds.setUrl("jdbc:mysql://localhost:3306/northwind");
                conn = ds.getConnection();
            }
            catch(Exception connectionError){
                System.out.println("CONNECTION ERROR");
                connectionError.printStackTrace();
            }
        }
}
