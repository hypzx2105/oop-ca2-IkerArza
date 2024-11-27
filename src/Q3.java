import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// https://www.w3schools.com/java/ref_string_startswith.asp?utm
// https://www.benchresources.net/java-how-to-remove-first-and-last-character-from-a-string/
//https://www.baeldung.com/java-io-file

public class Q3 {
    public static void main(String[] args) {
        ArrayList<String> stack = new ArrayList<>();

        try {
            File file = new File("tags.txt");
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                String tagsLine = scanner.nextLine();

                System.out.println("Tags being processed: " + tagsLine);

                Scanner tagScanner = new Scanner(tagsLine);
                while (tagScanner.hasNext()) {
                    String tag = tagScanner.next();

                    if (!tag.equals("<br>")) {
                        if (tag.startsWith("<") && !tag.startsWith("</")) {

                            stack.add(tag);
                        } else if (tag.startsWith("</")) {

                            if (stack.isEmpty()) {
                                System.out.println("Error: Closing tag " + tag + " has no matching opening tag.");
                                return;
                            }


                            String lastOpened = stack.remove(stack.size() - 1);
                            String expectedClosing = "</" + lastOpened.substring(1);
                            if (!tag.equals(expectedClosing)) {
                                System.out.println("Error: Tag " + tag + " does not match the last opened tag " + lastOpened);
                                return;
                            }
                        }
                    }
                }
                tagScanner.close();
            }

            scanner.close();


            if (!stack.isEmpty()) {
                System.out.println("Error: Some opening tags are not closed: " + stack);
            } else {
                System.out.println("The HTML tags are properly nested.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File 'tags.txt' not found.");
        }
    }
}

///mismatching tags: <p> <ul> <li> </ul> </li> </p>
///correct tags: <p> <ul> <li> </li> </ul> <br> </p>
///missing tags: <p> <ul> <li> </li> </p>





