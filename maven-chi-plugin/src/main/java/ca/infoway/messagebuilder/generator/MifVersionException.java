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

import java.io.File;

import ca.infoway.messagebuilder.GeneratorException;

/**
 * <p>An exception that gets thrown when trying to process more than one MIF that are
 * not all of the same version.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class MifVersionException extends GeneratorException {

	private static final long serialVersionUID = 7127767928650429991L;
	
	/**
	 * <p>Standard constructor.
	 * 
	 * @param file - the file containing the MIF
	 * @param version - the version number of the file.
	 * @param mifVersion - the version number of the other files processed so far.
	 */
	public MifVersionException(File file, String version, String mifVersion) {
		super("File " + file.getName() + " uses MIF version " + version + " although other files use version " + mifVersion);
	}
}
