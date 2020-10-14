import java.util.List;

public interface IAdministrator {
    public void administer();

	public void usage();

	public boolean helpIsEnabled();

    public boolean bannerIsEnabled();
    
    public List<String> getSrcFilename();

	public boolean verboseIsEnabled();
}
