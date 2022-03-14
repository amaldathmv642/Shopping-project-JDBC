package Shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLogin 
{
public void Admin()throws SQLException,ClassNotFoundException
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
	ResultSet rr=((java.sql.Statement) smt).executeQuery("select * from admin");
	while(rr.next())
	{
	if(username.equals(rr.getString(1))&&password.equals(rr.getString(2)))
		{
			f=1;
		}
	
	if(f==1)
		
		
	{
		System.out.println("Sucessfully verified");
	}
	else
	{
		System.out.println("Invalid user name or password");
	}
	if(f==1)
	{
	do
	{
		System.out.println("1.add product");
		System.out.println("2.display");
		System.out.println("3.remove");
		System.out.println("4.update");
		System.out.println("5.logout");
		System.out.println("enter your choice");
		m=s.nextInt();
	
	switch(m)
	{
	case 1:
		System.out.println("Enter your productid");
		int pid=s.nextInt();
		System.out.println("Enter your product name");
		String pname=s.next();
		System.out.println("Enter your minsellquantity");
		int min=s.nextInt();
		System.out.println("enter your price:");
		double price =s.nextDouble();
		PreparedStatement ps=con.prepareStatement("insert into product(product_id,product_name,prize,product_Quantity)values (?,?,?,?)");
		ps.setInt(1,pid);
		ps.setString(2,pname);
		ps.setInt(4, min);
		ps.setDouble(3, price);
		ps.executeUpdate();
		System.out.println("product added succesfully");
		break;
	case 2:
		Statement smt1=(Statement) con.createStatement();
		ResultSet rs=((java.sql.Statement) smt1).executeQuery("select * from product");
		System.out.println("###########***********############");
		while(rs.next())
		{
			System.out.println("product_name ->"+rs.getString(1)+"\n"+"product_id->"+rs.getInt(2)+"\n"+"product_Quantity->"+rs.getInt(3)+"\n"+"prize->"+rs.getDouble(4));
		}
		System.out.println("##########************#############");
		break;
	case 3:
		Statement smt2=(Statement) con.createStatement();
		ResultSet rs2=((java.sql.Statement) smt2).executeQuery("select * from product");
		System.out.println("#########************##############");
		while(rs2.next())
		{
			System.out.println("product id->"+rs2.getInt(2)+"\n"+"product name->"+rs2.getString(1));
		}
		System.out.println("########************#############");
		System.out.println("Enter product id:");
		int id=s.nextInt();
		PreparedStatement pp=con.prepareStatement("delete from product where product_id=?;");
		pp.setInt(1, id);
		pp.executeUpdate();
		System.out.println("Successfulyy removed ");
		break;
	case 4:
		System.out.println("######**************########");
		System.out.println("Enter product id");
		int id1=s.nextInt();
		System.out.println("enter new quantity");
		int q=s.nextInt();
		PreparedStatement pp1=con.prepareStatement("update product set product_Quantity=? where product_id=?");
		pp1.setInt(2,id1);
		pp1.setInt(1,q);
		pp1.executeUpdate();
		System.out.println("successfully updated");
		break;
	case 5:
		return;
	}
	}
	while(m!=0);
	}
	
	{
		System.out.println("incorrect id");
	}
	}
}}

