import java.io.*;
import java.util.List;
// import Administrator.*;
// import Composite.*;
// import Factory.*;
// import Banner.*;
// import FileCheck.*;
// import TemplateStrategy.*;

public class wcOO {
    private static boolean verboseEnabled;
    private static List<CounterTemplate> compositeCounters;
    private static CounterTemplate counter;
    private static CounterTemplate totalCounter;
    private static List<CounterTemplate> compositeTotalCounters;
    private static CounterTemplate totalLineCounter;
    private static CounterTemplate totoalCharCounter;
    private static CounterTemplate totalWordCounter;
    
    public static void clientSetCount(ICounterStrategy counterType, int count) {
        counterType.Count(count);
    }

    public static void main(String args[]) throws IOException {
        IBanner testBanner = new Banner(
                "WCOO Version 1.0",
                "Copyright (C) 2020, All Rights Reserved",
                "Written by Team A3"
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
        CounterFactory totalCounterFactory = new CounterFactory(); 
        totalCounter = totalCounterFactory.createCounter();

        // Using the Composite Design Pattern to get a Counter that is composed of Char, Line, Word Counters.
        compositeTotalCounters = ((TotalCounterTemplate)totalCounter).getCounterTemplates();

        totalLineCounter = compositeTotalCounters.get(2);
        totoalCharCounter = compositeTotalCounters.get(1);
        totalWordCounter = compositeTotalCounters.get(0);
        
        List<String>  arguments = admin.getSrcFilename();
        for (String srcFile : arguments) {
            countFile(srcFile);
        }  

        //printing total count of all src files
        System.out.print("\n"+"Total lines " +  totalLineCounter.getCount() + ", Total words " + totalWordCounter.getCount() + ", Total chars " + totoalCharCounter.getCount()+"\n");
        
    }
    
    private static void countFile(String srcFile) {
        CounterFactory factory = new CounterFactory(); 

        counter = factory.createCounter();

        compositeCounters = ((TotalCounterTemplate)counter).getCounterTemplates();

        IFileCheck file = new FileCheck(srcFile, new File(srcFile));

        file.verifyFileExists();

        try {
            BufferedReader reader = file.getBufferedReader();
         
            String line;
            CounterTemplate lineCounter = compositeCounters.get(2);
            CounterTemplate charCounter = compositeCounters.get(1);
            CounterTemplate wordCounter = compositeCounters.get(0);

         
            while((line = reader.readLine()) != null) {
                    
                        clientSetCount(lineCounter, 1);
                        clientSetCount(totalLineCounter, 1);
                        if(verboseEnabled){ printVerbose('l', 1);}

                        if(!line.equals(""))
                        {
                            String[] wordList = line.split("\\s+");

                            clientSetCount(charCounter, line.length());
                            clientSetCount(totoalCharCounter, line.length());
 
                            clientSetCount(wordCounter, wordList.length);
                            clientSetCount(totalWordCounter, wordList.length);

                            if(verboseEnabled){
                                for (String word : wordList) {
                                    printVerbose('w', 1);
                                    printVerbose('c', word.length());
                                } 
                            }
                        }

            }
            file.close();

            System.out.print("\n"+"lines " +  lineCounter.getCount() + ", words " + wordCounter.getCount() + ", chars " + charCounter.getCount()+"\n");

             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printVerbose(char character, int count) {
        for(int i = 0; i < count; i++){
            System.out.print(character);
        }
    }
  
}

