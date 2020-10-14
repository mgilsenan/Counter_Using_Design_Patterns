import java.io.*;
import java.util.List;

public class wcOO {
    private static boolean verboseEnabled;
    private static List<CounterTemplate> compositeCounters;
	private static CounterTemplate wordCount;
    
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

        // Using Factory Design Pattern to create an instance of a Counter Template:
        CounterFactory factory = new CounterFactory(); 
        CounterTemplate counter = factory.createCounter();
        
        
        // Using the Composite Design Pattern to get a Counter that is composed of Char, Line, Word Counters.
        compositeCounters = ((TotalCounterTemplate)counter).getCounterTemplates();
        
        
        
        
        
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
//            WordCounterTemplate wordCount = new WordCounterTemplate();
//            CharCounterTemplate charCount = new CharCounterTemplate();
//            LineCounterTemplate lineCount = new LineCounterTemplate();
            		
            
            
            
            while((line = reader.readLine()) != null) {
                    
                        clientSetCount(compositeCounters.get(2), 1);
                        if(verboseEnabled){ printVerbose('l', 1);}

                        if(!line.equals(""))
                        {
                            clientSetCount(compositeCounters.get(1), line.length());
                            if(verboseEnabled){ printVerbose('c', line.length());}
                          
                            String[] wordList = line.split("\\s+");
 
                            clientSetCount(compositeCounters.get(0), wordList.length);
                            if(verboseEnabled){ printVerbose('w', wordList.length);}
                        }

            }
            file.close();

//            printCounts(compositeCounters.get(0), compositeCounters.get(1), compositeCounters.get(2));
            printCounts();
            
            
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

//    private static void printCounts(WordCounterTemplate wordCount, CharCounterTemplate charCount, LineCounterTemplate lineCount) {
//        System.out.println("lines " +  lineCount.getCount() + ", words " + wordCount.getCount() + ", chars " + charCount.getCount());
//    }
    
    
    private static void printCounts() {
    	System.out.println("lines " +  compositeCounters.get(2).getCount() + ", words " + compositeCounters.get(0).getCount() + ", chars " + compositeCounters.get(1).getCount());
    }
}

