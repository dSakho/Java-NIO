package practice;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo2 {

	public static void main(String[] args) {
		// get a path object with relative path
		Path testFilePath = Paths.get("src");
		System.out.println("The file name is: " + testFilePath.getFileName());
		System.out.println("The absolute path name is: " + testFilePath.toAbsolutePath());
		System.out.println("It's normalized path name is: " + testFilePath.normalize());
		
		// get another path object with normalized relative path
		Path testPathNormalized = Paths.get(testFilePath.normalize().toString());
		System.out.println("It's normalized absolute path is: " + 
					testPathNormalized.toAbsolutePath());
		try {
			System.out.println("It's normalized real path is: " + 
						testFilePath.toRealPath(LinkOption.NOFOLLOW_LINKS));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
