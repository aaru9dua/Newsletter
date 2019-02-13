import java.util.*;
class Newsletter{
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("1. Add Topic"+"\n"+"2. View All Topics"+"\n"+"3. Search Topics"+"\n"+"4. Display content");	
	System.out.println("Choose your Option");
	int num=scan.nextInt();
	if(num==1)
	{
		System.out.println("Add Topic");

	}
	else if(num==2)
	{
		System.out.println("View All Topics");

	}
	else if(num==3)
	{
		System.out.println("Search Topic");

	}
	else if(num==4)
	{
		System.out.println("Display Content");

	}
	else
	{
		System.out.println("Enter a valid option");
	}

    }

}