package basicprogrammingmodel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * assume two parameters: one is string, the other is file
 * <p>
 * E.g:  java basicprogrammingmodel.SystemInput "aa" ~/temp/1 < ~/temp/2
 * E.g:  java basicprogrammingmodel.SystemInput "aa" ~/temp/1 <<< "abc"
 */


public class SystemInput {

    public static void main(String[] args) throws IOException {
        String input = args[0];
        File file = new File(args[1]);

        System.out.println("first parameter is : " + input);
        System.out.println("second parameter is : " + file.getName());

        Files.lines(Paths.get(file.getPath())).forEach(str -> System.out.print(str));


        Scanner scanner = new Scanner(System.in);
        String stdIn = scanner.next();
        int i;
        while ((i = System.in.read()) != -1) {
            System.out.println("standard input is : " + (char) i);
        }
    }
}
