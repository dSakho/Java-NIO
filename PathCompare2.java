package practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathCompare2 {

	public static void main(String[] args) {
		Path path1 = Paths.get("src");
		Path path2 = Paths.get("/home/d_sakho/workspace/JavaPractice/src");
		
		try {
			System.out.println("Files.isSameFile(path1, path2) is: " +
							Files.isSameFile(path1, path2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
