
// Jawad Butt
// 2023-04-03
// The Main.java file takes a message input from the user and encodes it. It also takes an encrypted message by the user and prints all the possible decoded messages

// Importing the Scanner class to read input from the user
import java.util.Scanner;

public class MainCaesar {
	public static void main(String[] args) {

		// Creating a Scanner object to read input from the user
		Scanner input = new Scanner(System.in);

		// Prompts the user to enter a message to encode
		System.out.println("Please enter a message to encode: ");
		String message = input.nextLine();

		// Prompts the user to enter an amount to shift the message by
		System.out.println("Please enter an amount to shift by: ");
		int shift = input.nextInt();
		input.nextLine(); // Allows for the output to read the user's next input rather than the newline

		// Creates a new Cipher object with the user specified shift value and message
		Cipher encrypt = new Cipher(shift, message);

		// Calls the Encode method and prints the encrypted message
		System.out.println(encrypt.encode());

		// Prompts the user to enter an encrypted message to decipher
		System.out.println("Please enter an encrypted message to decipher: ");
		String encrypted = input.nextLine();

		// Create a new Cipher object with the encrypted message entered and a shift of
		// 0 as this object is simply created to hold the encoded message
		Cipher decipher = new Cipher(0, encrypted);

		// Creates an instance of the Decode object
		Decode decodes = new Decode();
		decodes.decoder(decipher); // Calls the decoder method and prints the possible deciphered messages
		System.out.println("Which of these messages was yours?");
	}
}