package edu.unl.cse.csce361.socket_chat;

public class CipherFactory {
	public static Cipher createCipher(String name, String keys) {
		if (name.equals("Base64"))
			return new Base64Cipher();
		else if (name.equals("DES"))
			return new DESCipher();
		else
			return new NullCipher();
	}

	public static Cipher createCipher() {
		return new NullCipher();
	}

}
