package practice;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
		System.out.println("File name: " + path.getFileName());
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult preVisitDirectory(Path path, 
				BasicFileAttributes fileAttributes) {
		System.out.println("----------Directory Name:" + path + "----------");
		return FileVisitResult.CONTINUE;
	}
}

public class FileTreeWalk {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("Usage: FileWalkTree <source-path>");
			System.exit(1);
		}
		
		Path pathSource = Paths.get(args[0]);
		try {
			Files.walkFileTree(pathSource, new MyFileVisitor());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
