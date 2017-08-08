package com.hoochootong.jnetwork;

import javax.xml.bind.*;

public class ReturnDigestUserInterface {
	public static void main(String[] args) {
		ReturnDigest[] returnDigest = new ReturnDigest[args.length];
		for(int i = 0; i < args.length; i++) {
			String fileName = args[i];
			returnDigest[i] = new ReturnDigest(fileName);
			returnDigest[i].start();
		}
		
		for(int i = 0; i < args.length; i++) {
			String fileName = args[i];
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(fileName);
			byte[] digest = returnDigest[i].getDigest();
//			stringBuilder.append(DatatypeConverter.printHexBinary(digest));
			System.out.println(stringBuilder);
		}
	}
}
