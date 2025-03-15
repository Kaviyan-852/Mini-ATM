
package BACKEND;

import java.sql.Connection;
import java.sql.DriverManager;

public class CONNECTIONS {
    
    public Connection connects(){
    
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
         Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm", "root", "root");
            
         return con;
        }
    catch(Exception e){
    e.printStackTrace();
    }
        return null;
    }
    
    
}
