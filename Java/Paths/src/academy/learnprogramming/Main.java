package academy.learnprogramming;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        try {
            // copy file
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
////            Files.copy(sourceFile, copyFile); // only work when copyFile does not exist yet
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING); // change the file when destination copy file exists

            // copy directory
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            // the method below won't copy the files under sourceFile
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

            // move file
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

            // rename file
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.move(fileToMove,destination);

            // delete file
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
////            Files.delete(fileToDelete); // throw an exception when file does not exist
//            Files.deleteIfExists(fileToDelete);

            // create file. The file is empty, use stream or channel if writing content to the file
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file3.txt");
//            Files.createFile(fileToCreate);

            // create dir
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir5");
//            Files.createDirectory(dirToCreate); // throw exception if the dirToCreate exists

            // create dirs
////            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples/Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(dirToCreate); // create dir tree if not exist yet

            // File attributes
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = "+size);
            System.out.println("Last modified = "+Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified = "+attrs.lastModifiedTime());
            System.out.println("Created = "+attrs.creationTime());
            System.out.println("Is directory = "+attrs.isDirectory());
            System.out.println("Is regular file = "+attrs.isRegularFile());

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

    }

//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
////        Path filePath = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt");
//        Path filePath = Paths.get(".", "files", "SubdirectoryFile.txt");
//        printFile(filePath);
//
//        filePath = Paths.get("/Users/yonzhn/Documents/Learning/Java/OutThere.txt");
////        filePath = Paths.get("/Users/yonzhn/Documents/Learning/", "Java/", "OutThere.txt");
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2);
//
//        Path path3 = FileSystems.getDefault().getPath("thisFileDoesNotExist.txt");
//        System.out.println(path3.toAbsolutePath()); // file does not exist, but can still be a path
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = "+Files.exists(filePath));
//        System.out.println("Exists = "+Files.exists(path3));
//
//    }
//
//    private static void printFile(Path path) {
//        try(BufferedReader fileReader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = fileReader.readLine())!=null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }

}
