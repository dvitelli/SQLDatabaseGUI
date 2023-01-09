package src;
import java.io.File;
import java.sql.*;

import javax.swing.RootPaneContainer;

class Main{
    public static void main(String[] args){
        
    
        try (
        
            Connection connect = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/employees?", "root", "Secret"); //set up connection to database
            
            Statement stmt = connect.createStatement(); //statement required for talking to SQL
            
            ) {
                
                String seeAll = "SELECT * from employeedata";
                System.out.print("SQL Test:" + seeAll + "\n");
                ResultSet rs = stmt.executeQuery(seeAll);
                
                
                while (rs.next()){
                    int employeeId = rs.getInt("employeeID");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String jobTitle = rs.getString("jobTitle");
                    System.out.format("%s, %s, %s, %s\n", employeeId, firstName, lastName, jobTitle);
                } //print all info in database
                
               
                
            } catch(SQLException exc){
                exc.printStackTrace();
            }
        
        
    }
}