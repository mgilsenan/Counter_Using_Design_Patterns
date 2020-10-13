public class Option implements IOption{
    private String shortVersion;
    private String longVersion;
    private String meaning;

    public Option(String shortVersion, String longVersion, String meaning) {
        this.shortVersion = shortVersion;
        this.longVersion = longVersion;
        this.meaning = meaning;
    }

    public String getShortVersion() {
        return shortVersion;
    }
    public String getLongVersion(){
        return longVersion;
    }

    public String getMeaning() {
        return meaning;
    }
}
