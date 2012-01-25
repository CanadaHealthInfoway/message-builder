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

package ca.infoway.messagebuilder;

import org.apache.commons.lang.StringUtils;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum that lists the various supported hl7 versions.
 */
public class SpecificationVersion extends EnumPattern implements VersionNumber {

	static{ /*static init block for translation purposes. Please do not remove.*/ }

	private static final long serialVersionUID = 3269139690668726076L;

	/**
	 * <p>This designation is used for a stand-alone version of the IEHR messages.  It
	 * was released on 2007-05-08
	 */
	public static final SpecificationVersion V01R04_3 = new SpecificationVersion("V01R04_3", "V01R04.3");

	public static final SpecificationVersion V02R01 = new SpecificationVersion("V02R01", "V02R01");

	/**
	 * <p>This designation is used for the major release of CeRx, CR, PR and other 
	 * messages.  It appears to have been officially released on 2007-12-07.
	 */
	public static final SpecificationVersion V02R02 = new SpecificationVersion("V02R02", "V02R02");
	/**
	 * <p>R02.04.00 is the designation given to Maintenance Release 2009 (MR 2009), 
	 * officially released on 2009-03-16.
	 */
	public static final SpecificationVersion R02_04_02 = new SpecificationVersion("R02_04_02", "R02.04.02");
	
	public static final SpecificationVersion R02_04_03 = new SpecificationVersion("R02_04_03", "R02.04.03");

	/**
	 * Newfoundland and Labrador (mixed V01R04.3 / V02R02).
	 */
	public static final SpecificationVersion NEWFOUNDLAND = new SpecificationVersion("NEWFOUNDLAND", "Newfoundland and Labrador (mixed V01R04.3 / V02R02)");
	
	/**
	 * Saskatchewan (V01R04.3).
	 */
	public static final SpecificationVersion V01R04_3_SK = new SpecificationVersion("V01R04_3_SK", "Saskatchewan (V01R04.3)", SpecificationVersion.V01R04_3);
	
	/**
	 * Alberta (V02R02).
	 */
	public static final SpecificationVersion V02R02_AB = new SpecificationVersion("V02R02_AB", "Alberta (V02R02)", SpecificationVersion.V02R02);
	
	public static final SpecificationVersion NA = new SpecificationVersion("NA", "", null, true);
	
	private final String description;
	private final boolean unknown;
	private final VersionNumber baseVersion;
	
	private SpecificationVersion(String name, String description) {
		this(name, description, null);
	}
	private SpecificationVersion(String name, String description, VersionNumber baseVersion) {
		this(name, description, baseVersion, false);
	}
	private SpecificationVersion(String name, String description, VersionNumber baseVersion, boolean unknown) {
		super(name);
		this.description = description;
		this.baseVersion = baseVersion;
		this.unknown = unknown;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getVersionLiteral() {
		return name();
	}
	
	/**
	 * <p>Checks if is unknown.
	 *
	 * @return true, if is unknown
	 */
	public boolean isUnknown() {
		return this.unknown;
	}
	
	/**
	 * <p>Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * <p>Gets the base version, if applicable. Since all versions in this
	 * enum are base versions, this method just returns itself.
	 *
	 * @return the description
	 */
	public VersionNumber getBaseVersion() {
		return this.baseVersion == null ? this : this.baseVersion;
	}

	public static boolean isVersion(VersionNumber desiredVersion, VersionNumber versionToCheck) {
		String actualVersion = (versionToCheck == null ? null : versionToCheck.getVersionLiteral());
		String baseVersion = (versionToCheck == null ? null : (versionToCheck.getBaseVersion() == null ? null : versionToCheck.getBaseVersion().getVersionLiteral()));
		String desiredVersionLiteral = (desiredVersion == null ? null : desiredVersion.getVersionLiteral());
		
		return StringUtils.equals(actualVersion, desiredVersionLiteral) || StringUtils.equals(baseVersion, desiredVersionLiteral);
	}
	
}
