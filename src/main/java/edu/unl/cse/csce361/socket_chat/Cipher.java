package edu.unl.cse.csce361.socket_chat;

public interface Cipher {
	String encipher(String plaintext, String key);

	String decipher(String ciphertext, String key);
}