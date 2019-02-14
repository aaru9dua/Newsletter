import java.util.Scanner;
class Newsletter{
	public static void main(String[] args){
		Scanner s=new Scanner(System.in);
		System.out.println(" available choices: ");
		System.out.println(" \t 1) add a new Topic : ");
		System.out.println(" \t 2) view available Topics");
		System.out.println(" \t 3) Search and display for a file ");
		
		int c=s.nextInt();	
		switch(c){
			case 1: {//choice1();
					System.out.println("1: Add Topic");
					break;
					}
			case 2: {//choice2();
					System.out.println("2: View All Topics");
					break;
					}
			case 3: {
					//choice3();
					System.out.println("3: Search And Display Topic");
					break;
					}
			
			default:System.out.println("Enter Proper choice");
		}
	} 

}