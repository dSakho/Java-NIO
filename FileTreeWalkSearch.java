package practice;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileSearchVisitor extends SimpleFileVisitor<Path> {
	private PathMatcher matcher;
	
	public MyFileSearchVisitor(String pattern) {
		try {
			matcher = FileSystems.getDefault().getPathMatcher(pattern);
		} catch (IllegalArgumentException iae) {
			System.err.println("Invalid pattern; did you forget the prefix \"glob:\"?+" +
						"(as in glob:*.java)");
			System.exit(1);
		}
	}
	
	private void find(Path path) {
		// want matcher to only match the name not the entire path!
		Path name = path.getFileName();
		if(matcher.matches(name)) {
			System.out.println("Matching file:" + path.getFileName());
		}
	}
	
	@Override
	public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
		find(path);
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes fileAttributes) {
		find(path);
		return FileVisitResult.CONTINUE;
	}
}

public class FileTreeWalkSearch {
	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Usage: FileTreeWalkSearch <start-path> <pattern to search>");
			System.exit(1);
		}
		
		Path startPath = Paths.get(args[0]);
		String pattern = args[1];
		
		try {
			Files.walkFileTree(startPath, new MyFileSearchVisitor(pattern));
			System.out.println("File search completed!");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
