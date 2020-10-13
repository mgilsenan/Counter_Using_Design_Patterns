public class Banner implements IBanner{
    private String version, copyright, author;

    public Banner(String version, String copyright, String author){
        this.version = version;
        this.copyright = copyright;
        this.author = author;
    }

    public void printBanner(){
        System.out.println(version);
        System.out.println(copyright);
        System.out.println(author);
    }
}
