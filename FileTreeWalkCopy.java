package practice;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

// MyFileVisitor that implements Copy
class MyFileCopyVisitor extends SimpleFileVisitor<Path> {
	private Path source, destination;
	
	public MyFileCopyVisitor(Path source, Path destination) {
		this.source = source;
		this.destination = destination;
	}
	
	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
		Path newd = destination.resolve(source.relativize(path));
		try {
			Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return FileVisitResult.CONTINUE;
	}
	
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
		Path newd = destination.resolve(source.relativize(path));
		try {
			Files.copy(path, newd, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return FileVisitResult.CONTINUE;
	}
}

public class FileTreeWalkCopy {

	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage: FileTreeWalkCopy <source-path> <destination-path>");
			System.exit(1);
		}
		
		Path pathSource = Paths.get(args[0]);
		Path destinationSource = Paths.get(args[1]);
		try {
			Files.walkFileTree(pathSource, 
					new MyFileCopyVisitor(pathSource, destinationSource));
			System.out.println("Directory " + pathSource.getFileName() + " copied!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}