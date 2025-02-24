package MovieProject;
import java.util.Scanner;

public class MovieDriver {
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		
		Movie movie = new Movie();
		boolean continueLoop = true;
		while(continueLoop) {
		
		System.out.println("Enter the movie title: ");
		String title = keyboard.nextLine();
		movie.setTitle(title);
		
		System.out.println("Enter the rating of the movie: ");
		String rating = keyboard.nextLine();
		movie.setRating(rating);
		
		System.out.println("Enter the number of tickets sold for this movie: ");
		int tickets = keyboard.nextInt();
		movie.setSoldTickets(tickets);
		
		System.out.println(movie.toString());
		
	    keyboard.nextLine();
	    
	    System.out.println("Do you want to enter another? (y or n) ");
	    String response = keyboard.nextLine();
	    if(response.equalsIgnoreCase("n")) {
	    	continueLoop = false;
	    }
		}
	}

}
