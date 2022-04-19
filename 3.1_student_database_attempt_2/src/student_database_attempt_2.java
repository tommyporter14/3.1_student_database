import java.util.InputMismatchException;
import java.util.Scanner;

public class student_database_attempt_2 {

	public static void main(String[] args) {
		Scanner	scnr = new Scanner(System.in);
		String[] studentsFirst = {"Patrick","James","Caelin","Nick","Dakota", "Justin", "Brandon", "Eva", "Sasha", "Cindy"};
		String[] studentsLast = {"Smith","Johnshon","Wallace","Jones","Mann", "Lincoln", "Presley","Parks", "Armstrong", "Lennon"};
		String[] hometown = {"Royal Oak","Berkley","Detroit","Oak Park","Southfield", "Birminham", "Hamtramck", "Highland Park", "Taylor", "Warren"};
		String[] favFood = {"Pizza","Burgers","Spaghetti","Salad","Chinese","Sushi","Thai","Ice Cream","Popcorn","BBQ"};

		System.out.println("Welcome to our Java class. Which student would you like to learn more about? (enter a number 1-10):");
		boolean studentRepeat = true;
		
		while (studentRepeat)
		{
			try 
			{
				int userNumber = scnr.nextInt();
				
				boolean infoRepeat = true;
				
				while (infoRepeat)
				{
					printInfo(userNumber, studentsFirst, studentsLast);
					String choiceOne = scnr.next();
					
					if (choiceOne.equalsIgnoreCase("favfood"))
					{
						printFood(userNumber, studentsFirst, favFood);
						if (!yesNoChoice(scnr)) 
						{
								infoRepeat = false;
						}
					}
					else if (choiceOne.equalsIgnoreCase("hometown"))
					{
						printHome(userNumber, studentsFirst, hometown);
						if (!yesNoChoice(scnr)) 
						{
								infoRepeat = false;
						}
					}
					else
					{
						System.out.println("Invalid input. (enter 'hometown' or 'favfood'):");
					}
				}
				System.out.println("Would you like to learn about another student? (enter 'yes' or 'no'):");
				if (!yesNoChoice(scnr)) 
				{
					studentRepeat = false;
				} 
				else 
				{
					System.out.print("Which student would you like to learn more about? (enter a number 1-10): ");
				}
				
			}
			catch (InputMismatchException e) 
			{
				scnr.next();
				System.out.println("That isn't a number. Please try again. (enter a number 1-10): ");
			} 
			catch (IndexOutOfBoundsException e) 
			{
				System.out.println("That student does not exist. Please try again. (enter a number 1-10): ");
			}
		}
		System.out.println("Goodbye.");
		scnr.close();
	}
	
	public static void printInfo(int n, String first[], String last[])
	{
		System.out.println("Student " + n + " is " + first[n - 1] + " " + last[n-1] + ". What would you like to know about " + first[n-1] + "? (enter 'hometown' or 'favfood'): ");
	}
	public static void printFood(int n, String first[], String food[]) 
	{
		System.out.print(first[n-1] + "'s favorite food is " + food[n-1] + ". Would you like to know more? (enter 'yes' or 'no'):");
	}
	public static void printHome(int n, String first[], String town[]) 
	{
		System.out.print(first[n-1] + " is from " + town[n-1] + ". Would you like to know more? (enter 'yes' or 'no'):");
	}
	public static boolean yesNoChoice(Scanner scnr) 
	{
		try 
		{
			String choice = scnr.next();
			
				if (!choice.equalsIgnoreCase("yes") && !choice.equalsIgnoreCase("no")) {
					throw new InputMismatchException("Input must be 'yes' or 'no'");
				}
				
				if (choice.equalsIgnoreCase("yes")) {
					return true;
				} else {
					return false;
				}
		} 
		catch (InputMismatchException e) 
		{
			System.out.print("I'm not sure what you want. Please enter 'yes' or 'no': ");
			return (yesNoChoice(scnr));
		}
	}
}
