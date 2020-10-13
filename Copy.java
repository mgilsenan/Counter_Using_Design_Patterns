import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Copy {
    public static void main(String[] args) {
        IBanner testBanner = new Banner(
                "Copy Version 1.0",
                "Copyright (C) 2020, All Rights Reserved",
                "Written by Maryam Gilsenan"
        );

        IAdministrator admin = new Administrator(args);
            
        admin.administer();

        if (admin.helpIsEnabled()) {
            System.out.println("Usage: <class_name> <src> <dst>");
            return;
        } else if (admin.bannerIsEnabled()) {
            testBanner.printBanner();
            return;
        }

        List<String>  arguments = admin.getSrcFilename();
        String srcFile = arguments.get(0);         
        String dstFile = arguments.get(1);

        copyFile(srcFile, dstFile);
    }

    private static void copyFile(String srcFile, String dstFile) {
        try{

            FileInputStream srcStream = new FileInputStream(srcFile);
            FileOutputStream dstStream = new FileOutputStream(dstFile);

            byte[] buffer = new byte[1024];

            int length;

            while ((length = srcStream.read(buffer)) > 0){
                dstStream.write(buffer, 0, length);
            }

            //Closing the input/output file streams
            srcStream.close();
            dstStream.close();

            System.out.println("File has been copied successfully");

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
