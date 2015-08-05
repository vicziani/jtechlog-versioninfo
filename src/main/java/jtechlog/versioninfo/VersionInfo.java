package jtechlog.versioninfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class VersionInfo {
    
    private String version;

    private String buildNumber;
    
    private String buildInfo;
    
    private String timestamp;
    
    private String scmBranch;
    
    public VersionInfo() {
        Properties p = new Properties();
        InputStream is = null;
        try {
            is = VersionInfo.class.getResourceAsStream("/version.properties");
            p.load(is);
            version = p.getProperty("version");
            buildNumber = p.getProperty("buildNumber");
            buildInfo = p.getProperty("buildInfo");
            timestamp = p.getProperty("timestamp");
            scmBranch = p.getProperty("scmBranch");
        }
        catch (IOException e) {
            throw new AssertionError(e);
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    // InputSream lezárásakor hiba
                }
            }
        }
    }

    public String getVersion() {
        return version;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public String getBuildInfo() {
        return buildInfo;
    }

    public String getTimestamp() {
        return timestamp;
    }
    
    public String getScmBranch() {
        return scmBranch;
    }
}
