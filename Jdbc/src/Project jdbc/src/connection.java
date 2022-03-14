


import java.sql.DriverManager;
import java.sql.SQLException;

public class connection 
{
public connection getConnection() throws SQLException,ClassNotFoundException
{

	Class.forName("com.mysql.cj.jdbc.Driver");
	java.sql.Connection con=null;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","mysql","amal123@#VIRAT");
	if(con!=null)
	{
		return (connection) con;
		
	}
	else
		{
		return null;
		
		}
}
}
