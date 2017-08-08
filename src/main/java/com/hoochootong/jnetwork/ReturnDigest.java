package com.hoochootong.jnetwork;

import java.io.*;
import java.security.*;

public class ReturnDigest extends Thread{
	private String fileName;
	private byte[] digest;
	public ReturnDigest(String fileName) {
		this.fileName = fileName;
	}
	
	public void run() {
		try {
			FileInputStream in = new FileInputStream(fileName);
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			DigestInputStream din = new DigestInputStream(in, sha);
			while(din.read() != -1);
			din.close();
			digest = sha.digest();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public byte[] getDigest() {
		return digest;
	}
}
