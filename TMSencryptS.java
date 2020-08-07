
/*
 * Author: Arthur Gregoryo (gregoryo/arthurgregoryo)
 * Version: 0.1
 * Not recommended for commercial use.
 * 
 */

import java.util.Random;

public class TMSencryptS {
	public static boolean encrypt(String pathIn,String pathOut,long key) {
		int[] keys = new int[4];
		keys[0] = Integer.parseInt(String.valueOf(key).substring(0,3));
		keys[1] = Integer.parseInt(String.valueOf(key).substring(4,8));
		keys[2] = Integer.parseInt(String.valueOf(key).substring(8,12));
		keys[3] = Integer.parseInt(String.valueOf(key).substring(12,16));
		return encrypt(pathIn,pathOut,keys);
	} 
	public static boolean decrypt(String pathIn,String pathOut,long key) {
		int[] keys = new int[4];
		keys[0] = Integer.parseInt(String.valueOf(key).substring(0,3));
		keys[1] = Integer.parseInt(String.valueOf(key).substring(4,8));
		keys[2] = Integer.parseInt(String.valueOf(key).substring(8,12));
		keys[3] = Integer.parseInt(String.valueOf(key).substring(12,16));
		return decrypt(pathIn,pathOut,keys);
	} 
	
	public static boolean encrypt(String pathIn,String pathOut,int ...keys) {
		byte[] content = TMSArchiveS.read(pathIn);
		long[] convContent = encrypt(content, keys);
		String writableContent = "";
		for(int i = 0; i < convContent.length;i++) {
			writableContent += Long.toString(convContent[i]) + randomNewChar();
		}
		return TMSArchiveS.write(pathOut, writableContent, false);
	}
	
	public static boolean decrypt(String pathIn,String pathOut,int ...keys) {
		String content = new String(TMSArchiveS.read(pathIn));
		String[] convContent = content.split("[ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz]");
		long[] decryptedContent = new long[convContent.length];
		for(int i = 0;i<convContent.length-1;i++) {
			decryptedContent[i] = Long.parseLong(convContent[i]);
		}
		String writableContent = new String(decrypt(decryptedContent, keys));

		return TMSArchiveS.write(pathOut, writableContent, false);
	}
	
	public static long[] encrypt(byte[] content,int ... keys){
		long[] convContent = new long[content.length];
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < keys.length; j++) {
				convContent[i] = content[i] * keys[j];
			}
		}
		return convContent;
	}
	
	public static byte[] decrypt(long[] content, int... keys) {
		byte[] decryptedContent = new byte[content.length];
		long[] convContent = new long[content.length];
		for (int i = 0; i < content.length; i++) {
			for (int j = 0; j < keys.length; j++) {
				convContent[i] = content[i] / keys[j];
			}
		}
		for (int i = 0; i < convContent.length; i++) {
			decryptedContent[i] = (byte) convContent[i];
		}
		return decryptedContent;
	}
	
	public static char randomNewChar() {
		Random random = new Random();
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return abc.charAt(random.nextInt(abc.length()));
	}
}
