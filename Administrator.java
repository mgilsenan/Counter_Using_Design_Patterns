import java.util.ArrayList;
import java.util.List;

public class Administrator implements IAdministrator {
    private String args[];
    private static final Option help = new Option("-h", "-help", "List a summary of all options and their arguments.");
    private static final Option verbose = new Option("-v", "-verbose", "Enable verbose output.");
    private static final Option banner = new Option("-b" , "-banner", "Print the application's banner.");
    private boolean isHelpEnabled;
    private boolean isBannerEnabled;
    private List<String> srcFilename = new ArrayList<String>();
    private boolean isVerboseEnabled;;

    public Administrator(String args[]){
        this.args = args;
    }

    public void administer(){
        
        if ( args.length < 1 ) {
            unsuccessfulAttempt();
        }

        for (int n = 0; n < args.length; ++n) {
            if (args[n] != null) {
                if(optionsEnabled(args[n])){
                    setOptions(args[n]);
                } else if(argsIsFile(args[n])){
                    srcFilename.add(args[n]);
                } else{
                    unsuccessfulAttempt();
                }
            }
        }
    }

    private boolean argsIsFile(String string) {
        if(string.contains(".txt")){
            return true;
        }
        return false;
    }

    private boolean optionsEnabled(String string) {
        if(string.contains("-")){
            return true;
        }
        return false;
    }

    public void unsuccessfulAttempt() {
        System.out.println("Unsuccessful attempt, use the following options in the command line..." );
        System.out.println("HelpOption = \"-h\" | \"-help\"\n" +
                "VerboseOption = \"-v\" | \"-verbose\"\n" +
                "BannerOption = \"-b\" | \"-banner\"\n" );
        System.exit(0);
    }
    
    public void setOptions(String args){
        if(args.equals(help.getLongVersion())||args.equals(help.getShortVersion())){

            isHelpEnabled = true;
        }
    
        if(args.equals(banner.getLongVersion())||args.equals(banner.getShortVersion())){
           
            isBannerEnabled = true;
        }

        if(args.equals(verbose.getLongVersion())||args.equals(verbose.getShortVersion())){
           
            isVerboseEnabled = true;
        }
    }

    @Override
    public void usage() {
        System.out.println("Usage: <class_name> <src> {...<src>}");

    }

    @Override
    public boolean helpIsEnabled() {
        if(isHelpEnabled){
            return true;
        }
        return false;
    }

    @Override
    public boolean bannerIsEnabled() {
        if(isBannerEnabled){
            return true;
        }
        return false;
    }

    public List<String> getSrcFilename() {
        return (srcFilename);
    }

    @Override
    public boolean verboseIsEnabled() {
        if(isVerboseEnabled){
            return true;
        }
        return false;
    }
}
