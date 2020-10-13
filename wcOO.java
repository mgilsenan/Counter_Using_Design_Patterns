import java.io.*;
import java.util.List;

public class wcOO {
    public static void clientSetCount( ICounter counterType, int count ) { counterType.Count(count);}

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

        List<String>  arguments = admin.getSrcFilename();
        for (String srcFile : arguments) {
            countFile(srcFile);
            // if (admin.verboseIsEnabled()) {
            //     System.out.println("*****");
            // }
        }

        
        
    }

    private static void countFile(String srcFile) {
        IFileCheck file = new FileCheck(srcFile, new File(srcFile));

        file.verifyFileExists();

        try {
            BufferedReader reader = file.getBufferedReader();
            String line;

            WordCount wordCount = new WordCount();
            CharCount charCount = new CharCount();
            LineCount lineCount = new LineCount();
           
            while((line = reader.readLine()) != null) {
                        
                        //lineCount.setCount(1);
                        clientSetCount(lineCount, 1);

                        if(!line.equals(""))
                        {
                        
                            //charCount.setCount(line.length());
                            clientSetCount(charCount, line.length());
                          
                            String[] wordList = line.split("\\s+");
 
                            //wordCount.setCount(wordList.length);
                            clientSetCount(wordCount, wordList.length);
                        }

            }
            file.close();
            System.out.println("lines " +  lineCount.getCount() + ", words " + wordCount.getCount() + ", chars " + charCount.getCount());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

