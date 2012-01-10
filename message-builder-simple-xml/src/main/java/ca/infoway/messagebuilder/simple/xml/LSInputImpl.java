/**
 * Copyright 2012 Canada Health Infoway, Inc.
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

package ca.infoway.messagebuilder.simple.xml;

import java.io.InputStream;
import java.io.Reader;

import org.w3c.dom.ls.LSInput;

class LSInputImpl implements LSInput {
	
	private final InputStream input;
	private final String systemId;

	public LSInputImpl(String systemId) {
		this.systemId = systemId;
		this.input = getClass().getResourceAsStream(systemId);
	}
	
	public LSInputImpl(String systemId, String resourceName) {
		this.systemId = systemId;
		this.input = getClass().getResourceAsStream(resourceName);
	}

	public String getBaseURI() {
		return null;
	}

	public InputStream getByteStream() {
		return this.input;
	}

	public boolean getCertifiedText() {
		return false;
	}

	public Reader getCharacterStream() {
		return null;
	}

	public String getEncoding() {
		return null;
	}

	public String getPublicId() {
		return null;
	}

	public String getStringData() {
		return null;
	}

	public String getSystemId() {
		return this.systemId;
	}

	public void setBaseURI(String baseURI) {
	}

	public void setByteStream(InputStream byteStream) {
	}

	public void setCertifiedText(boolean certifiedText) {
	}

	public void setCharacterStream(Reader characterStream) {
	}

	public void setEncoding(String encoding) {
	}

	public void setPublicId(String publicId) {
	}

	public void setStringData(String stringData) {
	}

	public void setSystemId(String systemId) {
	}
}