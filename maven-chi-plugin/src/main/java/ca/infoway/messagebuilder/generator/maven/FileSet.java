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

package ca.infoway.messagebuilder.generator.maven;

import java.io.File;

/**
 * <p>Provide information that categorizes a set of MIF files.
 * 
 * @author Intelliware Development
 */
public class FileSet {
	
	/**
	 * <p>Default constructor.
	 */
	public FileSet() {
	}
	/**
	 * <p>Constructor to populate all of the file set data.
	 * @param name - the name of the set of files.
	 * @param directory - the directory where the files are located
	 */
	public FileSet(String name, File directory) {
		super();
		this.name = name;
		this.directory = directory;
	}
	private String name;
	private File directory;
	
	/**
	 * <p>A name of the set of files that can be used for categorization.
	 * Names might include, for example, 'cr' for files that belong to 
	 * "Volume 4 - Client Registry" MIFs.
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * <p>Set the name.
	 * @param name - the name to assign to the set of MIF files.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * <p>The directory in which MIF files reside.
	 * 
	 * @return the directory
	 */
	public File getDirectory() {
		return this.directory;
	}
	/**
	 * <p>Set the directory.
	 * @param directory - the directory in which MIFs reside.
	 */
	public void setDirectory(File directory) {
		this.directory = directory;
	}
}
