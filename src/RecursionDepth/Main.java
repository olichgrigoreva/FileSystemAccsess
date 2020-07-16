package RecursionDepth;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("veryLongFileName.txt");
        file.createNewFile();
        if (file.exists()) {
            System.out.printf("File '%s' exists in the %s path!\n", file.getName(), file.toPath());
        } else {
            System.out.printf("File '%s' is created in the %s path!\n", file.getName(), file.toPath());
        }

        String fileName = file.getName();
        char[] charArray = fileName.toCharArray();
        int charArrayLength = charArray.length;
        final String EXTENTION = ".txt";

        File newFile = new File("-" + fileName.substring(1, charArrayLength - 5) + EXTENTION);
        System.out.println(newFile.getName());

        File newFile2 = new File("--" + fileName.substring(2, charArrayLength - 6) + EXTENTION);
        System.out.println(newFile2.getName());

        File newFile3 = new File("---" + fileName.substring(3, charArrayLength - 7) + EXTENTION);
        System.out.println(newFile3.getName());

        fileNameOffset(file);
    }

    public static void fileNameOffset(File file) {
        String fileName = file.getName();
        char[] charArray = fileName.toCharArray();
        int charArrayLength = charArray.length;
        final String EXTENTION = ".txt";

        for (int i = 0; i < charArrayLength - 4; i++) {
            charArray[i] = '-';
            File newFile = new File(charArray[i] + fileName.substring(1, charArrayLength - 4 + i) + EXTENTION);
            file.renameTo(newFile);
            //fileNameOffset(newFile);
        }
    }

    /*public static void recursiveDelete(File root, String depth) {
        File[] files = root.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    recursiveDelete(file, depth + 1);
                }
                file.renameTo(file.getName());
            }
        }
    }*/
}
