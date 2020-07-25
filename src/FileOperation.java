import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileOperation {
    public static void main(String[] args) throws IOException {

        Scanner pause = new Scanner(System.in);

        //создание файла
        File createFile = new File("testfile.txt");
        if (!createFile.exists()) {
            createFile.createNewFile();
            System.out.printf("%s is created in %s \n", createFile.getName(), createFile.getAbsolutePath());
            System.out.println("Check file then press Enter");
            pause.nextLine();
        } else {
            System.out.printf("File '%s' already exists\n", createFile.getName());
        }

        //переименование
        File renameFile = new File("testfile_rename.txt");
        if (!renameFile.exists()) {
            createFile.renameTo(renameFile);
            System.out.printf("Created file '%s' is renamed to '%s' in %s\n", createFile, renameFile, renameFile.getAbsolutePath());
        } else {
            System.out.printf("File '%s' already exists\n", renameFile.getName());
        }

        //копирование
        File directory = new File("data");
        directory.mkdir(); //создание директории
        System.out.printf("Directory '%s' is created in %s \n", directory.getName(), directory.getAbsolutePath());
        File copyFile = new File(directory.getPath(), renameFile.getPath()); //файл для копирования
        copyFile.createNewFile();
        Files.copy(renameFile.toPath(), copyFile.toPath(), StandardCopyOption.REPLACE_EXISTING); // копирование файла
        System.out.printf("Content from '%s' is copied to %s file\n", renameFile.getName(), copyFile.getAbsolutePath());

        //удаление
        System.out.println("Check files and directory then press Enter");
        pause.nextLine();
        renameFile.delete();
        copyFile.delete();
        directory.deleteOnExit();
    }
}
