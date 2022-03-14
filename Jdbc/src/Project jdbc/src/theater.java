import java.sql.SQLException;
import java.util.Scanner;

public class theater 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
	Scanner s=new Scanner(System.in);	
int n;
do
{
	System.out.println("1.admin login");
	System.out.println("2.user login");
	System.out.println("3.exit");
	System.out.println("enter your choice");
	 n=s.nextInt();
	admin a=new admin();
	user u=new user();
	switch(n)
	{
	case 1:
		a.admin();
		break;
case 2:
		u.user();
		break;
case 3:
       return;
	}
}
while(n!=0);
	}
}
