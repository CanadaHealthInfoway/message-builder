package ca.infoway.messagebuilder.j5goodies;

import static org.apache.commons.lang.StringUtils.substringBefore;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.jar.Manifest;

import org.apache.commons.io.IOUtils;

/**
 * <p>A class that can find the Manifest that corresponds to the jar that contains
 * a particular class.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class ManifestReader {

	/**
	 * <p>Get the manifest that's contained in the jar that contains the given class.
	 * @param mainClass - the class
	 * @return - the Manifest
	 * @throws IOException - if the manifest cannot be read.
	 */
    public static Manifest read(Class<?> mainClass) throws IOException {
        String path = mainClass.getResource(toResourceName(mainClass)).toString();
        String manifestPath = extractRoot(path, mainClass) + "/META-INF/MANIFEST.MF";
        InputStream stream = new URL(manifestPath).openStream();
        try {
            return new Manifest(stream);
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    static String extractRoot(String path, Class<?> mainClass) {
        if (path.contains("!")) {
            return path.substring(0, path.lastIndexOf("!") + 1);
        } else if (path.contains("/WEB-INF")) {
            return substringBefore(path, "/WEB-INF");
        } else {
            return substringBefore(path, mainClass.getName().replace('.', '/'));
        }
    }

    private static String toResourceName(Class<?> mainClass) {
        return "/" + mainClass.getName().replace('.', '/') + ".class";
    }
}