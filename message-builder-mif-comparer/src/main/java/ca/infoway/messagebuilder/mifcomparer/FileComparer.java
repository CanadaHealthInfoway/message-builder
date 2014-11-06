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

public abstract class FileComparer {

	
	protected XmlDocument left;
	protected XmlDocument right;
	protected MessageList messages;
	protected GlobalConfiguration globalConfig;
	
	public FileComparer(MifFile l, MifFile r, MessageList m) {
		left = new XmlDocument(l);
		right = new XmlDocument(r);		
		this.messages = m;
	}

	public FileComparer(File l, File r, MessageList m) {
		left = new XmlDocument(l);
		right = new XmlDocument(r);		
		this.messages = m;
	}

	/**
	 * Construct a {@link FileComparer} that will compare the two given
	 * {@link String}s. These are <i>not</i> pathnames, but rather the actual
	 * content to be compared. Any resulting {@link Message}s will contain
	 * hardcoded {@link File}s <tt>left-file</tt> and <tt>right-file</tt>.
	 */
	public FileComparer(String l, String r, MessageList m) {
		left = new XmlDocument("left-file", l);
		right = new XmlDocument("right-file", r);		
		this.messages = m;
	}
	
	/**
	 * Compare two files, adding details of any differences to msgs.
	 * 
	 * @return	the number of differences between the files
	 */
	public abstract int compare();

	public GlobalConfiguration getGlobalConfig() {
		return globalConfig;
	}

	public void setGlobalConfig(GlobalConfiguration globalConfig) {
		this.globalConfig = globalConfig;
	}
}
