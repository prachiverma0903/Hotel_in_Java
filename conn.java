
package hotel;




import java.sql.*;


public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///hotelmanagementsystem","root","prachi"); 
            
            s =c.createStatement();  
          //  System.out.println("connected.");
           
        }catch(Exception e){ 
            System.out.println(e);
          //  System.out.println("not");
        }  
    }
	public ResultSet getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}  
}  

