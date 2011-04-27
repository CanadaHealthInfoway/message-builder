/**
 * Copyright 2011 Canada Health Infoway, Inc.
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

import java.io.File;

import org.apache.commons.lang.StringUtils;

public class FileDirectoryUtil {
	
	public static void createDirectoriesIfNeeded(File outputFile) {
		String directoryPath = StringUtils.substringBeforeLast(outputFile.getAbsolutePath(), File.separator);
		if (!StringUtils.equals(directoryPath, outputFile.getAbsolutePath())) {
			File directoryFile = new File(directoryPath);
			if (!directoryFile.exists() && !directoryFile.mkdirs()) {
				throw new IllegalStateException("Could not create directories necessary to write file: " + outputFile.getAbsolutePath());
			}
		}
	}
}
