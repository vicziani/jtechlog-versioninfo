package jtechlog.versioninfo;

import org.junit.Test;
import static org.junit.Assert.*;

public class VersionInfoTest 
{
    @Test
    public void testVersion()
    {
        VersionInfo v = new VersionInfo();
        System.out.printf("Version: %s, Build number: %s, Build info: %s, Timestamp: %s, Scm branch: %s\n",
                v.getVersion(), v.getBuildNumber(), v.getBuildInfo(), v.getTimestamp(), v.getScmBranch());
        assertEquals("1.0-SNAPSHOT", v.getVersion());
    }
}
