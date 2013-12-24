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

package ca.infoway.messagebuilder;

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
	public static final SpecificationVersion V01R04_3 = new SpecificationVersion("V01R04_3", "V01R04.3", Hl7BaseVersion.CERX);

	/**
	 * <p>This designation is used for the major release of CeRx, CR, PR and other 
	 * messages.  It appears to have been officially released on 2007-12-07.
	 */
	public static final SpecificationVersion V02R02 = new SpecificationVersion("V02R02", "V02R02", Hl7BaseVersion.MR2007);
	/**
	 * <p>R02.04.00 is the designation given to Maintenance Release 2009 (MR 2009), 
	 * officially released on 2009-03-16.
	 */
	public static final SpecificationVersion R02_04_02 = new SpecificationVersion("R02_04_02", "R02.04.02", Hl7BaseVersion.MR2009);
	
	public static final SpecificationVersion R02_04_03 = new SpecificationVersion("R02_04_03", "R02.04.03", Hl7BaseVersion.MR2009);

	public static final SpecificationVersion R02_05 = new SpecificationVersion("R02_05", "R02.05", Hl7BaseVersion.MR2009);
	
	/**
	 * Saskatchewan (V01R04.2)
	 * 
	 * Base version should technically be V01R04_2 (which isn't a MB HL7v3 release), but the value 
	 * is really only used to determine the main release (CeRx, in this case) so we should be ok to use V01R04_3.
	 * 
	 */
	public static final SpecificationVersion V01R04_2_SK = new SpecificationVersion("V01R04_2_SK", "Saskatchewan (V01R04.2)", Hl7BaseVersion.CERX);
	
	/**
	 * Alberta
	 */
	public static final SpecificationVersion V02R02_AB = new SpecificationVersion("V02R02_AB", "Alberta (V02R02)", Hl7BaseVersion.MR2007);

	// currently unused
	public static final SpecificationVersion R02_04_03_AB = new SpecificationVersion("R02_04_03_AB", "Alberta (R02_04_03)", Hl7BaseVersion.MR2009);

	// TBD if this is still considered as based on MR2009
	public static final SpecificationVersion R02_05_00_PA_AB = new SpecificationVersion("R02_05_00_PA_AB", "Alberta (R02_05_00 Pre-Adopted)", Hl7BaseVersion.MR2009);

	// ON Drug
	public static final SpecificationVersion V01R04_3_ON = new SpecificationVersion("V01R04_3_ON", "ON Drug", Hl7BaseVersion.CERX);

	// BC V02R04
	public static final SpecificationVersion V02R04_BC = new SpecificationVersion("V02R04_BC", "BC (V02R04)", Hl7BaseVersion.CERX);
	
	private final String description;
	private final Hl7BaseVersion baseVersion;
	
	private SpecificationVersion(String name, String description, Hl7BaseVersion baseVersion) {
		super(name);
		this.description = description;
		this.baseVersion = baseVersion;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getVersionLiteral() {
		return name();
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
	 * <p>Gets the base version of HL7v3 applicable to this version.
	 *
	 * @return the base version
	 */
	public Hl7BaseVersion getBaseVersion() {
		return this.baseVersion;
	}

	/**
	 * Checks if the supplied VersionNumber is based on a particular HL7v3 release
	 * 
	 * @param version
	 * @param versionToCheck
	 * @return
	 */
	public static boolean isVersion(VersionNumber version, Hl7BaseVersion versionToCheck) {
		if (versionToCheck == null || version == null) {
			return false;
		}
		return version.getBaseVersion() == versionToCheck;
	}
	
	public static boolean isExactVersion(VersionNumber version1, VersionNumber version2) {
		if (version1 == null || version1.getVersionLiteral() == null || version2 == null || version2.getVersionLiteral() == null) {
			return false;
		}
		return version1.getVersionLiteral().equals(version2.getVersionLiteral()) && version1.getBaseVersion() == version2.getBaseVersion();
	}
	
}
