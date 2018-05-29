// weishu tan
// 2018-05-29

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Util {

	public static String getPathOf(String title) {
		return "story/" + title.replaceAll(" ", ".") + ".txt";
	}

	public static ArrayList<String> readFile(String filepath) {
		ArrayList<String> lines = new ArrayList< >();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filepath));
			String line = "";
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
			reader.close();
			return lines;
		} catch (FileNotFoundException errnf) {
			System.out.println("Error : File " + filepath + " Not Found!");
		} catch (IOException errio) {
			System.out.println("Error : Cannot Read File " + filepath + "!");
		}
		return null;
	}

	public static String writeFile(String filepath, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
			bw.write(content);
			bw.close();
			return null;
		} catch (Exception err) {
			err.printStackTrace();
		}
		return "error";
	}
}
