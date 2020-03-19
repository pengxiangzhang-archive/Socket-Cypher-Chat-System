package edu.unl.cse.csce361.socket_chat;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DESCipher implements Cipher {

	public static byte[] convertToByte(String userInput) throws Exception {
		byte[] inputToByte = userInput.getBytes();
		int byteLength = inputToByte.length;
		byte[] byteOut = new byte[byteLength / 2];
		for (int i = 0; i < byteLength; i = i + 2) {
			byteOut[i / 2] = (byte) Integer.parseInt(new String(inputToByte, i, 2), 16);
		}
		return byteOut;
	}

	public static String convertToString(byte[] userInput) throws Exception {
		int byteLength = userInput.length;
		StringBuffer sb = new StringBuffer(byteLength * 2);
		for (int i = 0; i < byteLength; i++) {
			int byteToString = userInput[i];
			while (byteToString < 0) {
				byteToString = byteToString + 256;
			}
			if (byteToString < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(byteToString, 16));
		}
		return sb.toString();
	}

	@Override
	public String encipher(String plaintext, String key) {
		try {
			javax.crypto.Cipher dESCipher = javax.crypto.Cipher.getInstance("DES");
			Key secretKey = new javax.crypto.spec.SecretKeySpec(key.getBytes(), "DES");
			dESCipher.init(javax.crypto.Cipher.ENCRYPT_MODE, secretKey);
			return convertToString(dESCipher.doFinal(plaintext.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (NoSuchPaddingException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (InvalidKeyException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (IllegalBlockSizeException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (BadPaddingException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (Exception e) {
			return "Error.WrongCipherSet Error84$";
		}

	}

	@Override
	public String decipher(String ciphertext, String key) {
		try {
			javax.crypto.Cipher mDecryptCipher = javax.crypto.Cipher.getInstance("DES");
			Key newKey = new javax.crypto.spec.SecretKeySpec(key.getBytes(), "DES");
			mDecryptCipher.init(javax.crypto.Cipher.DECRYPT_MODE, newKey);
			return new String(mDecryptCipher.doFinal(convertToByte(ciphertext)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (InvalidKeyException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (IllegalBlockSizeException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (BadPaddingException e) {
			return "Error.WrongCipherSet Error84$";
		} catch (Exception e) {
			return "Error.WrongCipherSet Error84$";
		}
	}
}