package Shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class Shop {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		int n=0;
	do
	{// TODO Auto-generated method stub
   System.out.println("1.Admin login");
   System.out.println("2.User login");
   System.out.println("3.Exit");
   System.out.println("Enter your choice");
   AdminLogin ad=new AdminLogin();
   UserLogin us=new UserLogin();
   Scanner s=new Scanner(System.in);
    n=s.nextInt();
   switch(n)
   {
   case 1:	
	  ad.Admin();
	   break;
   case 2:
	  us.User();
	  break;
   case 3:
	   return;
	   
   }
	
	}while(n!=0);
	}
	
}