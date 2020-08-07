
/*
 * Author: Arthur Gregoryo (gregoryo/arthurgregoryo)
 * Version: 0.1
 * Not recommended for commercial use.
 * 
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TMSArchiveS {
	public static byte[] read(String path) {
		try {
			return Files.readAllBytes(Paths.get(path));
		}catch (Exception error) {
			System.out.println("File not found!");
		}
		return null;
		
	}
		

	public static boolean write(String path, String content, boolean append) {
		try {
			FileWriter archive = new FileWriter(path, append);
			PrintWriter writeArchive = new PrintWriter(archive);
			writeArchive.println(content);
			writeArchive.close();
			return true;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
