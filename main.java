import java.util.*;
public class Program10 {
	public static String[] cars = {};
	public static int eSize = cars.length;
	public static void main(String[] args) {
		 Scanner stdIn = new Scanner(System.in);
		 System.out.println("Welcome to WordList!\r\n"
					+ "--------------------");
		 while(true) {
		 int choice =getMenuChoice(stdIn);
		 if (choice == 4) {
			 break;
		 }
		 else if (choice == 3) {
			 printWords(cars, eSize);
		 }
		 else if (choice == 2) {
			 removeWord(cars,eSize,stdIn);
		 }
		 else if (choice == 1) {
			 addWord(cars,eSize,stdIn);
		 }
		 }
		 
		
		
	}//end main
	
	private static int getMenuChoice(Scanner stdIn) {
		
		System.out.println("1. Add Word\r\n"
				+ "2. Remove Word\r\n"
				+ "3. Print Words\r\n"
				+ "4. Quit");
		int i= 0;
		do {
			System.out.print("Choose an option(1-4): ");
			if (stdIn.hasNextInt()) {
				i = stdIn.nextInt();
			}
			else {
				stdIn.next();
				continue;
			}
		}while(!(i<=4)||!(i>=1));
		return i;
	}
	//This method prints the menu options to the screen, reads in the user’s selection, 
	//and validates it. It returns the valid option selection.
	
	
	public static int findWord(String[] words, int numWords, String word) {
		int goal = -1;
		for (int i = 0; i<numWords; i++) {
			if (words[i].equals(word)) {
				goal = i;
				return goal;
			}
		}
		return goal;
	}
	//This method searches for the word parameter in the words array. If found, it returns
	//the index of the word; otherwise it returns -1.
	
	
	public static boolean addWord(String[] words, int numWords, Scanner stdIn) {
		System.out.println("Enter word: ");
		String input = stdIn.next();
		
		if(findWord(words,numWords, input)== -1) {
			List<String> arrlist = new ArrayList<String>(Arrays.asList(words));
			arrlist.add(input);
			words = arrlist.toArray(words);
			cars = words;
			eSize++;
			return true;
		}
		else {
			System.out.println("That has already been added");
			return false;
		}
	}
	
	//This method adds the word parameter to the words array only if words does not
	//already contain it. It returns true if word was added to words; false otherwise.
	
	
	public static boolean removeWord(String[] words, int numWords, Scanner stdIn) {
		System.out.println("Enter word: ");
		String input = stdIn.next();
		
		int index = findWord(words,numWords, input);
      if(index> -1) {
			String[] arr = new String[numWords];
         for(int j = 0; j < index; j++){
            arr[j] = words[j];
         }
			for(int i = index+1; i < numWords; i++) {
				arr[i-1]=words[i];
			}
         cars = Arrays.copyOf(arr,arr.length-1);
			eSize--;
	
			return true;
		}
		else {
			System.out.println("That is not present");
			return false;
		}
	}
	//This method removes the word parameter from the words array only if words contains it. 
	//It returns true if word was found and removed from words; false otherwise.
	
	
	public static void printWords(String[] words, int numWords) {
		int i;
		for( i = 0; i < numWords; i++) {
			System.out.println(words[i]);
		}
		System.out.println();
	}
	//This method prints all of the elements in the words array parameter to the screen - in some reasonable
	//format

}
