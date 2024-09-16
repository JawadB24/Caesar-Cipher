
// Jawad Butt
// 2023-04-03
// This class takes a message input from the user, encrypts it using the shift value input, and returns an encoded message  
public class Cipher {

	// Declares the instance variables
	private int shift; // Shift value for cipher
	private String message; // Message to be encrypted

	// Constructor method that takes in shift and message parameters
	public Cipher(int shifter, String messages) {
		shift = shifter; // Initializes shift variable
		message = messages.toUpperCase(); // Initializes message variable and converts to UpperCase
	}

	// Getter method for shift variable
	public int getShift() {
		return shift;
	}

	// Getter method for message variable
	public String getMessage() {
		return message;
	}

	// Setter method for shift variable
	public void setShift(int newShift) {
		shift = newShift;
	}

	// Setter method for message variable, converting it to UpperCase
	public void setMessage(String newMessage) {
		message = newMessage.toUpperCase();
	}

	// Encode method returning the encrypted message, shifting each letter of the
	// original message
	public String encode() {
		String encryption = ""; // Initializes encryption variable, used to add the letters from the message
								// after being shifted
		for (int i = 0; i < message.length(); i++) { // Loops through each character in the message
			char letter = message.charAt(i); // The letter variable stores the character at the index "i"
			if (letter >= 65 && letter <= 90) { // ensures the characters shifted are UpperCase
				if (shift >= 0) { // If the shift value is positive or equal to zero
					shift %= 26; // This modulus operation guarantees the shift value stays between 0 and 26
					char newLetter = (char) (letter + shift); // Applies shift value to the letter and casts it back to
																// a
																// character
					if (newLetter > 90) { // If the shifted character is past 'Z',
						newLetter = (char) (newLetter - 26); // the new letter will wrap back around to 'A'
					}
					encryption += newLetter; // Adds encrypted character to encrypted message
				} else if (shift < 0) { // If the shift value is negative,
					int shift1 = (Math.abs(shift)) % 26; // calculates the absolute value of shift value, and keeps it
															// between 0 and 26
					char newLetter = (char) (letter - shift1); // Applies negative shift value to the letter and casts
																// it back to a character
					if (newLetter < 65) { // If the shifted character is before 'A',
						newLetter = (char) (newLetter + 26); // the new letter will wrap back around to 'Z'
					}
					encryption += newLetter; // Adds encrypted character to encrypted message
				}
			}
		}
		return format(encryption); // Calls "helper" method to return encrypted message in proper format
	}

	// Method to format the encrypted message for output
	public String format(String encrypter) {
		String formatMessage = ""; // Initializes formatMessage variable, used to format the letters in the
									// encrypted message
		for (int i = 0; i < encrypter.length(); i++) { // Loops through each character in the encrypted message
			char letter = encrypter.charAt(i); // The letter variable stores the character at the index "i"
			if (i % 5 == 0 && i % 50 != 0 && i > 0) { // After every 5 characters except for the last (50th) character
														// in the final (10th) block,

				formatMessage += " "; // a space is added to the String formatMessage variable
			}
			formatMessage += letter; // Adds a character from the encrypted message to the formatted message

			if ((i + 1) % 50 == 0) { // Instead of a space, after every 50 characters
				formatMessage += "\n"; // a newline is added to the formatted message
			}
		}
		return formatMessage; // returns formatted message
	}

}
