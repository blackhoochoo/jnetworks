package com.hoochootong.jnetwork;

import javax.xml.bind.DatatypeConverter;

public class PollingDigest {
	public static void main(String[] args) {
		System.out.println(args.length);
		ReturnDigest[] returnDigest = new ReturnDigest[args.length];
		for (int i = 0; i < args.length; i++) {
			String fileName = args[i];
			returnDigest[i] = new ReturnDigest(fileName);
			returnDigest[i].start();
		}

		for (int i = 0; i < args.length; i++) {
			while (true) {
				byte[] digest = returnDigest[i].getDigest();
				if (digest != null) {
						
					String fileName = args[i];
					StringBuilder stringBuilder = new StringBuilder(fileName);
					stringBuilder.append(": ");

					stringBuilder.append(DatatypeConverter.printHexBinary(digest));
					System.out.println("thread_" + i + ":" + stringBuilder);
					break;
				}
			}

		}
	}

}
