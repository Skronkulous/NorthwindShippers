package com.pluralsight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.pluralsight.ConnectionManager.conn;

public class DataManager {
    public static PreparedStatement prepState = null;
    public static ResultSet rSet = null;

    public static Long newShipper(String name, String phone){
        try{
            String query = "INSERT INTO shippers (CompanyName, Phone) VALUES (\"" + name + "\", \"" + phone + "\")";
            prepState = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepState.executeUpdate();
            ResultSet keys = prepState.getGeneratedKeys();
            keys.next();
            return keys.getLong(1);
        }
        catch(Exception searchError){
            System.out.println("SEARCH ERROR");
            searchError.printStackTrace();
            return 0L;
        }
    }

    public static void allShippers(){
        try{
            String query = "SELECT * FROM Shippers";
            prepState = conn.prepareStatement(query);
            rSet = prepState.executeQuery();
            System.out.println("All Shippers: ");
            while(rSet.next()){
                String shipperInfo = "ID: " + rSet.getInt("ShipperID") +
                        " | Name: " + rSet.getString("CompanyName") +
                        " | Phone: " + rSet.getString("Phone");
                System.out.println(shipperInfo);
            }
        }
        catch(Exception searchError){
            System.out.println("SEARCH ERROR");
            searchError.printStackTrace();
        }
    }

    public static void updateShipper(String id, String phone){
        try{
            String query = "UPDATE Shippers SET Phone = \"" + phone + "\" WHERE ShipperID = " + Integer.parseInt(id);
            prepState = conn.prepareStatement(query);
            prepState.executeUpdate();
        }
        catch(Exception searchError){
            System.out.println("SEARCH ERROR");
            searchError.printStackTrace();
        }
    }

    public static void deleteShipper(int key){
        try{
            String query = "DELETE FROM Shippers WHERE ShipperID = " + key;
            prepState = conn.prepareStatement(query);
            prepState.executeUpdate();
        }
        catch(Exception searchError){
            System.out.println("SEARCH ERROR");
            searchError.printStackTrace();
        }
    }
}
