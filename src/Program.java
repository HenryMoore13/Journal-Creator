import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) throws IOException{
        String name = getName();
        String title = getSubjectTitle();
        String message = getMessage();
        newFile(title, name, message);

    }

    private static String getName() {
        System.out.println("What is Your Name? ");
        String name = stdin.nextLine();
        return name;
    }
    private static String getSubjectTitle(){
        System.out.println("Title Of Your Journal: ");
        String title = stdin
                .nextLine()
                .toLowerCase()
                .replaceAll("\\s+", "_");
        return title;
    }
    private static String getMessage() {
        System.out.println("What Would You Like To Say? ");
        String line;
        ArrayList<String> messages = new ArrayList<>();

        while (true){
            line = stdin.nextLine();
            messages.add(line);
            if (line.toLowerCase().equals("end")){
                messages.remove(messages.size() -1);
                return String.join("\n", messages);
            }

        }


    }


    private static void newFile(String title, String name, String message) throws IOException {
        var lines = new ArrayList<String>();
        lines.add("Title: " + title);
        lines.add("Author: " + name);
        lines.add("Message:\n" + message);
        Files.write(Paths.get(title + ".txt"), lines);

    }


}
