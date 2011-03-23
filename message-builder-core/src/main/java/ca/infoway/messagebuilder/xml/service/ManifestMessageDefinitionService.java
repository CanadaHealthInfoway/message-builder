package ca.infoway.messagebuilder.xml.service;

import static java.util.Arrays.asList;
import static org.apache.commons.lang.StringUtils.split;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.j5goodies.EnumeratedIterable;

/**
 * @sharpen.ignore - xml.service - translated manually
 */
class ManifestMessageDefinitionService extends BaseMessageDefinitionService {

	@Override
	protected List<String> getNames() {
		return getResourceNamesFromManifests();
	}

	private List<String> getResourceNamesFromManifests() {
		List<String> manifests = new ArrayList<String>();
		try {
			Enumeration<URL> resources = getClass().getClassLoader().getResources("META-INF/MANIFEST.MF");
			for (URL url : EnumeratedIterable.iterable(resources)) {
				InputStream input = url.openStream();
				try {
					Manifest manifest = new Manifest(input);
					Attributes attributes = manifest.getMainAttributes();
					String messageSets = attributes.getValue("MBT-Message-Set");
					if (StringUtils.isNotBlank(messageSets)) {
						manifests.addAll(asList(split(messageSets)));
					}
				} finally {
					IOUtils.closeQuietly(input);
				}
			}
		} catch (IOException e) {
			// quietly swallow the error
		}
		return manifests;
	}
}
