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

package ca.infoway.messagebuilder.generator;

import static java.util.Arrays.asList;
import static org.apache.commons.io.FilenameUtils.getExtension;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

public class MifFileUtil {
	
	private static final String[] FILE_EXTENSIONS = new String[]{"mif", "dmif", "coremif"};

	/**
	 * <p>Scans the given directory for 'mif' and 'dmif' files
	 * 
	 * @param mifDirectory
	 * @return a list of mif files or null if not found
	 */
	@SuppressWarnings("unchecked")
	public static Collection<File> getMifFiles(File mifDirectory) {
		if (mifDirectory.isDirectory()) {
			return FileUtils.listFiles(mifDirectory, FILE_EXTENSIONS, true);
		} else if (mifDirectory.isFile() && asList(FILE_EXTENSIONS).contains(getExtension(mifDirectory.getName()))) {
			return Arrays.asList(mifDirectory);
		} else {
			return null;
		}
	}

}
