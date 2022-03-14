import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class admin 
{

	
	public void admin()throws SQLException,ClassNotFoundException
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
		ResultSet rr=((java.sql.Statement) smt).executeQuery("select * from admin");
		while(rr.next())
		{
		if(username.equals(rr.getString(2))&&password.equals(rr.getString(1)))
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
			System.out.println("1.add movie");
			System.out.println("2.display");
			System.out.println("3.remove");
			System.out.println("4.update");
			System.out.println("5.logout");
			System.out.println("enter your choice");
			m=s.nextInt();
		
switch(m)
{
case 1:
	System.out.println("enter movie id");
	int mid=s.nextInt();
	System.out.println("enter movie name");
	String mname=s.next();
	System.out.println("enter language");
	String lang=s.next();
	System.out.println("enter movie category");
	String mcat=s.next();
	System.out.println("Enter rate");
	Double rate=s.nextDouble();
	PreparedStatement pp=con.prepareStatement("insert into movie(no,movie,language,category,rate)values(?,?,?,?,?)");
	pp.setInt(1, mid);
	pp.setString(2,mname);
	pp.setString(3,lang);
	pp.setString(4, mcat);
	pp.setDouble(5, rate);
	pp.executeUpdate();
	System.out.println("movie added");
	break;
case 2:
	Statement smt1=(Statement)con.createStatement();
	ResultSet rs=smt1.executeQuery("select * from movie");
	System.out.println("************************");
	while(rs.next())
	{
		System.out.println("no-->"+rs.getInt(1)+"\n"+"movie-->"+rs.getString(2)+"\n"+"language-->"+rs.getString(3)+"\n"+"category-->"+rs.getString(4)+"\n"+"rate-->"+rs.getDouble(5));
		}
	System.out.println("*************************");
	break;
case 3:
	Statement smt2=(Statement)con.createStatement();
	ResultSet rs1=smt2.executeQuery("select * from movie");
	System.out.println("***********************");
	while(rs1.next())
	{
		System.out.println("no-->"+rs1.getInt(1)+"/n"+"movie-->"+rs1.getString(2));
		
		
	}
	System.out.println("************************");
	System.out.println("enter movie no");
	int no=s.nextInt();
	PreparedStatement ps=con.prepareStatement("delete from movie where no=?");
	ps.setInt(1, no);
	ps.executeUpdate();
	System.out.println("succesfully removed");
	break;
case 4:
	System.out.println("************************");
	System.out.println("enter movie no");
	int no1=s.nextInt();
	System.out.println("enter category");
	String cat=s.next();
	PreparedStatement ps1=con.prepareStatement("update movie set category=? where no=?");
	ps1.setString(1,cat);
	ps1.setInt(2, no1);
	ps1.executeUpdate();
	System.out.println("updated succesfully");
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
		}}}
		
	