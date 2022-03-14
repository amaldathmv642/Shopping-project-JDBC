package Shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class UserLogin 
{
	public void User()throws SQLException,ClassNotFoundException
	{
		java.sql.Connection con=null;
		int f=0;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","mysql","amal123@#VIRAT");
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
			if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
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
			System.out.println("1.BUYSELL");
			System.out.println("2.view");
		System.out.println("3.logout");
		System.out.println("Enter your choice");
		m=s.nextInt();
		switch(m)
		{
		case 1:
		    System.out.println("Enter product ID");
		    int pid=s.nextInt();
		    System.out.println("Enter  quantity");
		    int q=s.nextInt();
		    double price=0;
		    int flag=0;
		    Statement smt2=(Statement) con.createStatement();
		    ResultSet rr2=((java.sql.Statement) smt2).executeQuery("select * from product");
		    while(rr2.next())
		    {
		    	if(pid==rr2.getInt(2))
		    	{
		    		price=rr2.getDouble(3);
		    		int quantity=rr2.getInt(4);
		    		if(q<=quantity)
		    		{
		    			double sum=price*q;
		    			System.out.println("Cost is"+sum);
		    			flag=1;
		    		}
		    		else
		    		{
		    			System.out.println("Stack Overflow");
		    			flag=0;
		    		}
		    	}
		    }
		    if(flag==1)
		    {
		    Statement smt4=(Statement) con.createStatement();
		    ResultSet rs4=((java.sql.Statement) smt4).executeQuery("select * from product");
		    int qua=0;
		    while(rs4.next())
		    {
		    	int idd=rs4.getInt(2);
		    	if(idd==pid)
		    	{
		    		int q1=rs4.getInt(4);
		    		qua=q1-q;
		    	}
		    }
		    PreparedStatement pss=con.prepareStatement("update product set product_Quantity=? where product_id=?");	
		    pss.setInt(1, qua);
		    pss.setInt(2,pid);
		    pss.executeUpdate();
		    
		     }
		 break;
		case 2:
			Statement smt1=(Statement) con.createStatement();
			ResultSet rs=( (java.sql.Statement) smt1).executeQuery("select * from product");
			System.out.println("_________List of PRODUCT_____");
			System.out.println("******************************");
			while(rs.next())
			{
				System.out.println("product_id"+rs.getInt(2)+"\n"+"product_name"+rs.getString(1)+"\n"+"product_quantity"+rs.getInt(4));
				
				
			}
		    System.out.println("############################");
		    break;
		case 3:
			return;
		}
		}while(m!=0);
		}
	}
		
		

