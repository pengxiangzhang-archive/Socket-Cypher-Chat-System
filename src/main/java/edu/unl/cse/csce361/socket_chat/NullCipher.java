package edu.unl.cse.csce361.socket_chat;

public class NullCipher implements Cipher {

	public String encipher(String plaintext, String key) {

		return plaintext;
	}

	public String decipher(String ciphertext, String key) {

		return ciphertext;
	}

}
