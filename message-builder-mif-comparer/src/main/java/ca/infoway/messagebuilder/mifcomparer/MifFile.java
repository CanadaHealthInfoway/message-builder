/**
 * Copyright 2013 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

package ca.infoway.messagebuilder.mifcomparer;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class MifFile {
	private static Pattern parser = Pattern
			.compile("^([A-Z]{2})([A-Z]{2})_([A-Z]{2})([0-9]{6})([A-Z][A-Z])( - (.*))?\\.mif$");

	private File file;
	private String subSection, domain, artifact, id, realm;		// Components of the "key"
	private String description;

	public MifFile(File f) {
		this.file = f;

		String basename = f.getName();

		if (!basename.toString().endsWith(".mif")) {
			throw new IllegalArgumentException(f
					+ ": Doesn't have a \".mif\" extension");
		}

		Matcher m = parser.matcher(basename);

		if (!m.matches()) {
			throw new IllegalArgumentException(f
					+ ": Filename doesn't begin with a valid key");
		}

		this.subSection = m.group(1);
		this.domain = m.group(2);
		this.artifact = m.group(3);
		this.id = m.group(4);
		this.realm = m.group(5);
		this.description = m.group(7) != null ? m.group(7) : "";
	}

	public File getFile() {
		return this.file;
	}

	public String getSubSection() {
		return subSection;
	}

	public String getDomain() {
		return domain;
	}

	public String getArtifact() {
		return artifact;
	}

	public String getId() {
		return id;
	}
	
	public String getRealm() {
		return realm;
	}

	public String getDescription() {
		return description;
	}

	public String getDirname() {
		return this.getFile().getParent();
	}
	
	public String getBasename() {
		return this.getFile().getName();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MifFile other = (MifFile) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.file.toString();
	}
}
