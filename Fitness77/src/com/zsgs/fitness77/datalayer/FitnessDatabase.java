package com.zsgs.fitness77.datalayer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class FitnessDatabase 
{
    static Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/fitness";
    private static final String username ="root";
    private static final String password ="gowsi@9894";
    static 
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
            System.out.println("MySQL JDBC Driver not found.");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection Failed! Check output console");
        }
    }
    private FitnessDatabase() throws ClassNotFoundException
    {
    }
    public static boolean  insertRecord(String query) 
    {
        boolean insertRow = false;
        try (PreparedStatement pst=con.prepareStatement(query))
        {
            pst.execute(); 
            insertRow = true;
        } 
        catch(SQLException e)
        {
            e.printStackTrace();
        } 
        return insertRow;
    }
    public static ResultSet executerQueryData(String query)
    {
        ResultSet rs =null;
        try
        {
           PreparedStatement pr = con.prepareStatement(query);
           rs = pr.executeQuery();
        } 
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public static void connectionClose() 
    {
        try
        {
            if(con.isClosed()==false)
            {
              con.close();
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace(); 
        } 
    } 
}
