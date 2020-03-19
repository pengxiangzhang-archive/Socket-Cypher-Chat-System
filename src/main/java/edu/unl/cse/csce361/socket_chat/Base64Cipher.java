package edu.unl.cse.csce361.socket_chat;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Cipher implements Cipher {
	public String encipher(String plaintext, String key) {
		String ciphertext = null;
		try {
			ciphertext = Base64.getEncoder().encodeToString(plaintext.getBytes("UTF-16"));
		} catch (UnsupportedEncodingException e) {
			return "Error.WrongCipherSet Error84$"; // User will never type this.
		}

		return ciphertext;
	}

	public String decipher(String ciphertext, String key) {
		String plaintext = null;
		if (ciphertext.getBytes().length < 2 == false) {
			try {
				plaintext = new String(Base64.getDecoder().decode(ciphertext.getBytes()), "UTF-16");
			} catch (UnsupportedEncodingException e) {
				return "Error.WrongCipherSet Error84$";
			}
			return plaintext;
		} else
			return "Error.WrongCipherSet Error84$";

	}
}