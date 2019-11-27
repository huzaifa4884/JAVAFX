package sample;

import java.sql.*;

public class ConnectionConfiguration
{
    private static Connection cn = null;
    ConnectionConfiguration() {
        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            System.out.println("Connection successfull");
        } catch (Exception e) {
            System.out.println("Connection Unsuccesfull");
            e.printStackTrace();
        }
    }
    public ResultSet PopulateTable() throws SQLException {

        String Roll_No,Name,FName,Gender,Email,Address;
        String Query = "Select * from Student_record";
        Statement St;
        ResultSet rs;

        St = cn.createStatement();
        St.executeQuery(Query);
        rs = St.getResultSet();
        System.out.println("Good till now");
        return rs;



    }
}