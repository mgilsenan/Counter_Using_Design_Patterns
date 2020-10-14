import java.io.*;
import java.util.List;

public class wcOO {
    private static boolean verboseEnabled;

    public static void clientSetCount(ICounterStrategy counterType, int count) {
        counterType.Count(count);
    }

    public static void main(String args[]) throws IOException {
        IBanner testBanner = new Banner(
                "WCOO Version 1.0",
                "Copyright (C) 2020, All Rights Reserved",
                "Written by Maryam Gilsenan"
        );

        IAdministrator admin = new Administrator(args);
            
        admin.administer();

        if (admin.helpIsEnabled()) {
            admin.usage();
            return;
        } else if (admin.bannerIsEnabled()) {
            testBanner.printBanner();
            return;
        }

        if(admin.verboseIsEnabled()){
            verboseEnabled = true;
        }

        List<String>  arguments = admin.getSrcFilename();
        for (String srcFile : arguments) {
            countFile(srcFile);
        }  
        
    }

    private static void countFile(String srcFile) {
        IFileCheck file = new FileCheck(srcFile, new File(srcFile));

        file.verifyFileExists();

        try {
            BufferedReader reader = file.getBufferedReader();
            String line;

            WordCounterTemplate wordCount = new WordCounterTemplate();
            CharCounterTemplate charCount = new CharCounterTemplate();
            LineCounterTemplate lineCount = new LineCounterTemplate();
           
            while((line = reader.readLine()) != null) {
                    
                        clientSetCount(lineCount, 1);
                        if(verboseEnabled){ printVerbose('l', 1);}

                        if(!line.equals(""))
                        {
                            clientSetCount(charCount, line.length());
                            if(verboseEnabled){ printVerbose('c', line.length());}
                          
                            String[] wordList = line.split("\\s+");
 
                            clientSetCount(wordCount, wordList.length);
                            if(verboseEnabled){ printVerbose('w', wordList.length);}
                        }

            }
            file.close();

            printCounts(wordCount, charCount, lineCount);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printVerbose(char character, int count) {
        for(int i = 0; i < count; i++){
            System.out.print(character);
        }
        System.out.println();
    }

    private static void printCounts(WordCounterTemplate wordCount, CharCounterTemplate charCount, LineCounterTemplate lineCount) {
        System.out.println("lines " +  lineCount.getCount() + ", words " + wordCount.getCount() + ", chars " + charCount.getCount());
    }
}

