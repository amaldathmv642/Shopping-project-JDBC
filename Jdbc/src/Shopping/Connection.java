package Shopping;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection 
{
public Connection getConnection() throws SQLException,ClassNotFoundException
{

	Class.forName("com.mysql.cj.jdbc.Driver");
	java.sql.Connection con=null;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","mysql","amal123@#VIRAT");
	if(con!=null)
	{
		return (Connection) con;
		
	}
	else
		{
		return null;
		
		}
}
}
