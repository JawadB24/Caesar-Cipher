// Jawad Butt
// 2023-04-03
// This decode class takes the encrypted message entered by the user and deciphers it using brute force
public class Decode {

	// No-argument constructor
	public Decode() {

	}

	public void decoder(Cipher decoding) {
		for (int i = 1; i < 26; i++) { // Loops through the possible shift values
			Cipher decrypter = new Cipher(i, decoding.getMessage()); // Creates a new cipher object with the shift value
																		// ranging from 1 - 25 and the encrypted message
			String decodedMessage = decrypter.encode(); // Calls the encode method to shift through all the possible
														// values, using brute force to decipher the message
			System.out.println(i + ". " + decodedMessage); // Prints the possible original messages
		}
	}

}