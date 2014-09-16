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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.generator.lang;

import java.io.File;

import ca.infoway.messagebuilder.generator.NamingPolicy;

public class IntermediateToModelConfiguration {

	protected final File sourceFolder;
	protected final String basePackageName;
	private final File reportDirectory;
	private final NamingPolicy namingPolicy;
	private boolean isR2;
	
	public IntermediateToModelConfiguration(File sourceFolder,
			String basePackageName, File reportDirectory, NamingPolicy namingPolicy, boolean isR2) {
		this.sourceFolder = sourceFolder;
		this.basePackageName = basePackageName;
		this.reportDirectory = reportDirectory;
		this.namingPolicy = namingPolicy == null ? NamingPolicy.getDefaultPolicy() : namingPolicy;
		this.isR2 = isR2;
	}
	public File getSourceFolder() {
		return sourceFolder;
	}
	public String getBasePackageName() {
		return basePackageName;
	}
	public File getReportDirectory() {
		return reportDirectory;
	}
	public NamingPolicy getNamingPolicy() {
		return namingPolicy;
	}
	public boolean isR2() {
		return this.isR2;
	}
}
