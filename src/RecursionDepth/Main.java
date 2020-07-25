package RecursionDepth;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //заданый каталог, внутри которого будет "обход"
        File directory = new File("data");
        directory.mkdir();

        File directory1 = new File(directory.getPath(), "data1");
        directory1.mkdir();
        File data1File1 = new File(directory1.getPath(), "data1File1.txt");
        data1File1.createNewFile();
        File data1Directory11 = new File(directory1.getPath(), "data11");
        data1Directory11.mkdir();
        File data1Directory21 = new File(data1Directory11.getPath(), "data21");
        data1Directory21.mkdir();
        File data1File21 = new File(data1Directory21.getPath(), "data21File21.txt");
        data1File21.createNewFile();

        File data1File2 = new File(directory1.getPath(), "data1File2.txt");
        data1File2.createNewFile();

        File directory2 = new File(directory.getPath(), "data2");
        directory2.mkdir();
        File data2File1 = new File(directory2.getPath(), "data2File1.txt");
        data2File1.createNewFile();

        File directory3 = new File(directory.getPath(), "data3");
        directory3.mkdir();

        System.out.println("----------------список файлов------------------");
        listFile(directory);
        System.out.println("----------------глубина рекурсии------------------");
        recursiveDepth(directory, 1);
        System.out.println("--------------------удаление---------------------");
        deleteFiles(directory);

    }

    public static void listFile(File root) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFile(file);
                }
                System.out.printf("%s\n", file);
            }
        }
    }

    public static void recursiveDepth(File root, int depth) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    recursiveDepth(file, depth + 1);
                }
                System.out.printf("%s %s\n", file, depth);
            }
        }
    }

    public static void deleteFiles(File root) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteFiles(file);
                }
                file.delete();
            }
        }
        root.delete();
    }
}
