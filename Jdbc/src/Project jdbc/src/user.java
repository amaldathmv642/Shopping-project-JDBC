import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class user 
{
	public void user()throws SQLException,ClassNotFoundException
	{
		java.sql.Connection con=null;
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","mysql","amal123@#VIRAT");
		Scanner s=new Scanner(System.in);
		int m;
		System.out.println("Enter your User name");
		String username=s.next();
		System.out.println("Enter your password");
		String password=s.next();
		Statement smt=(Statement) con.createStatement();
		ResultSet rr=((java.sql.Statement) smt).executeQuery("select * from user");
		while(rr.next())
		{
			if(username.equals(rr.getString(2))&&password.equals(rr.getString(1)))
			{
				f=1;
			}
		}
		if(f==1)
		{
			System.out.println("Sucessfully verified");
		}
		else
		{
		System.out.println("incorrect password");
		}
		do
		{
			System.out.println("1.book movie ticket");
			System.out.println("2.view");
		System.out.println("3.logout");
		System.out.println("Enter your choice");
		m=s.nextInt();
		switch(m)
		{
		case 1:
		    System.out.println("Enter movie number");
		    int pid=s.nextInt();
		    System.out.println("Enter number of tickets");
		    int q=s.nextInt();
		    double price=0;
		    int flag=0;
		    Statement smt2=(Statement) con.createStatement();
		    ResultSet rr2=((java.sql.Statement) smt2).executeQuery("select * from movie");
		    while(rr2.next())
		    {
		    	if(pid==rr2.getInt(1))
		    	{
		    		price=rr2.getDouble(5);
		    		
		    		
		    		
		    			double sum=price*q;
		    			System.out.println("Cost is"+sum);
		    			flag=1;
		    		}
		    		
		    		
		    	
		    		
		    		
		    	}
		  break;  
	
		case 2:
			Statement smt1=(Statement)con.createStatement();
			ResultSet rs=smt1.executeQuery("select * from movie");
			System.out.println("list of movies");
			System.out.println("+++++++++++++++++++++++");
			while(rs.next())
			{
				System.out.println("no"+rs.getInt(1)+"\n"+"movie  "+rs.getString(2)+"\n"+"category  "+rs.getString(4));
			}
			System.out.println("++++++++++++++++++++++++");
			break;
		case 3:
			return;
		}}while(m!=0);
		}
}
		
		