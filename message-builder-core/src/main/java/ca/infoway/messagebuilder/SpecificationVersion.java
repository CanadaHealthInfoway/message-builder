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

import java.util.HashMap;
import java.util.Map;

import ca.infoway.messagebuilder.datatype.StandardDataType;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum that lists the various supported hl7 versions.
 */
public class SpecificationVersion extends EnumPattern implements VersionNumber {

	private static final long serialVersionUID = 3269139690668726076L;

	/**
	 * <p>This designation is used for a stand-alone version of the IEHR messages.  It
	 * was released on 2007-05-08
	 */
	public static final SpecificationVersion V01R04_3 = new SpecificationVersion("V01R04_3", "V01R04.3", Hl7BaseVersion.CERX);

	public static final SpecificationVersion V01R04_4 = new SpecificationVersion("V01R04_4", "V01R04.4", Hl7BaseVersion.CERX);

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
	
	public static final SpecificationVersion R02_04_03_IMM_AB = new SpecificationVersion("R02_04_03_IMM_AB", "Alberta (Immunization)", Hl7BaseVersion.MR2009);

	// ON Drug
	public static final SpecificationVersion V01R04_3_ON = new SpecificationVersion("V01R04_3_ON", "ON Drug", Hl7BaseVersion.CERX);

	// BC V02R04
	public static final SpecificationVersion V02R04_BC = new SpecificationVersion("V02R04_BC", "BC (V02R04)", Hl7BaseVersion.MR2007);

	static{ /*static init block for translation purposes. Please do not remove.*/ 
		V01R04_3.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_BUS);
		V01R04_3.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_VER);
		V01R04_3.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_BUS_AND_VER);
		
		V01R04_3_ON.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_BUS);
		V01R04_3_ON.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_VER);
		V01R04_3_ON.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_BUS_AND_VER);
		
		V01R04_2_SK.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_BUS);
		V01R04_2_SK.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_VER);
		V01R04_2_SK.registerHl7ReleaseByDatatype(Hl7BaseVersion.MR2009, StandardDataType.II_BUS_AND_VER);
	}

	
	
	private final String description;
	private final Hl7BaseVersion baseVersion;
	
	private final Map<String, Hl7BaseVersion> hl7ReleaseByDatatypeMap = new HashMap<String, Hl7BaseVersion>();
	
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
	 * Check registry to see if the provided datatype should be treated as specified by a specific HL7v3 release. If not, 
	 * use the defined base version.
	 * 
	 * The great majority of implementations should never need to register specific datatypes against HL7v3 releases.  
	 * 
	 * @param datatype An object representing a datatype. Usually, but not restricted to, an instance of StandardDataType. 
	 * @return the HL7 release that the given datatype conforms to 
	 */
	public Hl7BaseVersion getBaseVersion(Typed datatype) {
		if (datatype != null && this.hl7ReleaseByDatatypeMap.containsKey(datatype.getType())) {
			return this.hl7ReleaseByDatatypeMap.get(datatype.getType());
		}
		return getBaseVersion();
	}

	/**
	 * Clear the registry.
	 */
	public void clearHl7ReleaseByDatatypeRegistry() {
		this.hl7ReleaseByDatatypeMap.clear();
	}
	
	/**
	 * Register a specific datatype against a particular HL7v3 release (for validation and processing).
	 * 
	 * @param hl7BaseVersion
	 * @param datatype
	 */
	public void registerHl7ReleaseByDatatype(Hl7BaseVersion hl7BaseVersion, Typed datatype) {
		this.hl7ReleaseByDatatypeMap.put(datatype.getType(), hl7BaseVersion);
	}
	
	/**
	 * Checks if the supplied VersionNumber is based on a particular HL7v3 release.
	 * 
	 * This now takes in the specific datatype for which this check is being performed. If the datatype 
	 * registry contains this datatype then its registered version is returned, otherwise the base version
	 * is returned. 
	 * 
	 * @param version
	 * @param versionToCheck
	 * @return whether the version supplied is a match for the given HL7v3 release
	 */
	public static boolean isVersion(Typed datatype, VersionNumber version, Hl7BaseVersion versionToCheck) {
		if (versionToCheck == null || version == null) {
			return false;
		}
		
		return version.getBaseVersion(datatype) == versionToCheck;
	}

	/**
	 * Checks that a provided version is a match for a known version. Usually done for jurisdiction-specific datatype processing.
	 * 
	 * This check does _not_ compare the contents of the datatype registry.
	 * 
	 * @param version1
	 * @param version2
	 * @return whether the versions match
	 */
	public static boolean isExactVersion(VersionNumber version1, VersionNumber version2) {
		if (version1 == null || version1.getVersionLiteral() == null || version2 == null || version2.getVersionLiteral() == null) {
			return false;
		}
		return version1.getVersionLiteral().equals(version2.getVersionLiteral()) && version1.getBaseVersion() == version2.getBaseVersion();
	}

}
