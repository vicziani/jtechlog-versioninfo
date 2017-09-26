package jtechlog.versioninfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class VersionInfo {
    
    private String version;

    private String build;
    
    public static void main(String[] args) {
        VersionInfo versionInfo = new VersionInfo();
        System.out.println("Version: " + versionInfo.version);
        System.out.println("Build: " + versionInfo.build);
    }
    
    public VersionInfo() {
        try (InputStream is = VersionInfo.class.getResourceAsStream("/META-INF/MANIFEST.MF")) {
            Manifest manifest = new Manifest(is);
            Attributes attributes = manifest.getMainAttributes();

            version = attributes.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            build = attributes.getValue("Implementation-Build");
        }
        catch (IOException e) {
            throw new RuntimeException("Error loading META-INF/MANIFEST.MF file from classpath", e);
        }
    }
}
