package practice;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo1 {

	public static void main(String[] args) {
		// create a Path object by calling static method get() in Paths class
		Path testFilePath = Paths.get("/home/d_sakho/android-sdk-linux/extras/google/google_play_services/" +
								"samples/maps/src/com/example/mapdemo/RawMapViewDemoActivity.java");
		
		// retrive basic info about the file
		System.out.println("Printing file information: ");
		System.out.println("\t File Name: " + testFilePath.getFileName());
		System.out.println("\t Root of the path: " + testFilePath.getRoot());
		System.out.println("\t Parent of the target: " + testFilePath.getParent());
		System.out.println("\t File System: " + testFilePath.getFileSystem());
		
		// print the elements
		System.out.println("\nNumber of elements in Path: " + testFilePath.getNameCount());
		System.out.println("Printing elements of the path: ");
		for (Path path : testFilePath) {
			System.out.println("\t Path element: " + path);
		}
	}
}