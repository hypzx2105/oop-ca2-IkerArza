import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Q5 {

    public static void readFile ( String fileName ) throws FileNotFoundException {

        System.out.println ( "Question 5 ,, OOP CA2-COLLECTIONS\n" );


        Map<String , Integer> identiferCountMap = new HashMap<>();

        Map<String , List<String>> identiferLineMap = new HashMap<>();

        File file = new File( fileName );
        Scanner fileScanner = new Scanner( file );
        int lineNumber = 0;


        String identifierPattern = "[A-Za-z_][A-Za-z0-9_]*";

        while ( fileScanner.hasNextLine() ) {
            lineNumber++;
            String line = fileScanner.nextLine();


            String[] words = line.split( "[^A-Za-z0-9_]+" );
            for ( int i = 0; i < words.length; i++ ) {

                String word = words[i];
                if ( word.matches( identifierPattern ) ) {
                    String wordLower = word.toLowerCase();


                    if ( identiferCountMap.containsKey( wordLower ) ) {
                        identiferCountMap.put( wordLower , identiferCountMap.get( wordLower ) + 1 );
                    }
                    else {
                        identiferCountMap.put( wordLower , 1 );
                    }


                    if ( !identiferLineMap.containsKey( wordLower ) ) {
                        identiferLineMap.put( wordLower , new ArrayList<>() );
                    }

                    identiferLineMap.get( wordLower ).add( lineNumber + ". " + line.trim() );

                }

            }

        }
        fileScanner.close();

        // sorting identifier in ascn order
        List<String> sortedIdentiferCount = new ArrayList<>( identiferCountMap.keySet() );
        Collections.sort( sortedIdentiferCount );

        for ( int i = 0; i < sortedIdentiferCount.size(); i++ ) {
            String word = sortedIdentiferCount.get( i );
            int counter = identiferCountMap.get( word );
            List<String> wordList = identiferLineMap.get( word );
            System.out.println ( word + " " + counter + "\n " + wordList );
            System.out.println();
        }

        System.out.println ( "***** End of Question 5 ! " );

    }

    public static void main ( String[] args ) throws FileNotFoundException {

        readFile( "src/Question2.java" );

    }

}
