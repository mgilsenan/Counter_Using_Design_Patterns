import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class WordCount extends Counter {
    private int wordCount;

    public WordCount(){
        
    }


    @Override
    public int getCount() {
        return wordCount;
    }

    @Override
    public void setCount(int count) {
        wordCount += count;
    }

    public static void main(String[] args) {

        IBanner banner = new Banner(
                "WordCount Version 1.0",
                "Copyright (C) 2020, All Rights Reserved",
                "Written by Maryam Gilsenan"
        );

        IAdministrator admin = new Administrator(args);
            
        admin.administer();

        if (admin.helpIsEnabled()) {
            admin.usage();
            return;
        } else if (admin.bannerIsEnabled()) {
            banner.printBanner();
            return;
        }

        List<String>  arguments = admin.getSrcFilename();
        for (String srcFile : arguments) {
            countFile(srcFile);
            // if (options.verboseIsEnabled()) {
            //     System.out.println("*****");
            // }
        }

    }

    private static void countFile(String srcFile) {
        IFileCheck file = new FileCheck(srcFile, new File(srcFile));

        file.verifyFileExists();

        try{
            BufferedReader reader = file.getBufferedReader();
            String line;
            int wordCount = 0;

            while((line = reader.readLine()) != null) {
                if(!line.equals(""))
                {
                    String[] wordList = line.split("\\s+");

                    wordCount += wordList.length;
                }
            }

            file.close();

            System.out.println("wordcount counted successfully "+ wordCount);

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
}
