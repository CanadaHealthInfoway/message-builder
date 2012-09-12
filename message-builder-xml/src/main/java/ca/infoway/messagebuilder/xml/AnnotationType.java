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

package ca.infoway.messagebuilder.xml;

import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>Annotation Type.
 * 
 * <p>This enum models the various annotation types in the HL7 standards materials.
 * VB: The following constraints are taken from section 6.2.4.1 "Constrained Item Properties", page 39 of the
 * SMCT User Guide.
 * https://www.i-proving.ca/download/Projects/e-Health/CHI/SMCT/SMCT+User+Guide+v0.3+%28MASTER%29.pdf
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 */
public class AnnotationType extends EnumPattern {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
	private static final long serialVersionUID = 3066114109382422542L;
	
	public static final AnnotationType CONSTRAINT = new AnnotationType("CONSTRAINT", "CONSTRAINT", "constraint", "formalConstraint"); 
//	public static final AnnotationType DESCRIPTION = new AnnotationType("DESCRIPTION", "DESCRIPTION / DEFINITION", "description", "definition");
	public static final AnnotationType DESIGN_COMMENTS = new AnnotationType("DESIGN_COMMENTS", "DESIGN COMMENTS", "designComments"); 
	public static final AnnotationType MAPPING = new AnnotationType("MAPPING", "MAPPING", "mapping");
	public static final AnnotationType OPEN_ISSUE = new AnnotationType("OPEN_ISSUE", "OPEN ISSUE", "openIssues", "openIssue"); 
	public static final AnnotationType OTHER_NOTES = new AnnotationType("OTHER_NOTES", "OTHER NOTES", "otherAnnotation");
	public static final AnnotationType RATIONALE = new AnnotationType("RATIONALE", "RATIONALE", "rationale"); 
	public static final AnnotationType USAGE_NOTES = new AnnotationType("USAGE_NOTES", "USAGE NOTES", "usageNotes");
	
	//TODO: GN: need to figure out if these have corresponding mappings on mif1s
	public static final AnnotationType DESCRIPTION = new AnnotationType("DESCRIPTION", "DESCRIPTION", "description");
	public static final AnnotationType DEFINITION = new AnnotationType("DEFINITION", "DEFINITION", "definition");
	public static final AnnotationType USAGE_CONSTRAINT = new AnnotationType("USAGE_CONSTRAINT", "USAGE CONSTRAINT", "usageConstraint");
	public static final AnnotationType REQUIREMENTS = new AnnotationType("REQUIREMENTS", "REQUIREMENTS", "requirements");
	public static final AnnotationType STABILITY_REMARKS = new AnnotationType("STABILITY_REMARKS", "STABILITY REMARKS", "stabilityRemarks");
	public static final AnnotationType WALKTHROUGH = new AnnotationType("WALKTHROUGH", "WALKTHROUGH", "walkthrough");
	public static final AnnotationType APPENDIX = new AnnotationType("APPENDIX", "APPENDIX", "appendix");
	
	public static final AnnotationType BALLOT_COMMENT = new AnnotationType("BALLOT_COMMENT", "BALLOT COMMENT", "ballotComment");
	public static final AnnotationType CHANGE_REQUEST = new AnnotationType("CHANGE_REQUEST", "CHANGE REQUEST", "changeRequest");
	public static final AnnotationType STATIC_EXAMPLE = new AnnotationType("STATIC_EXAMPLE", "STATIC EXAMPLE", "staticExample");
	public static final AnnotationType DEPRECATION_INFO = new AnnotationType("DEPRECATION_INFO", "DEPRECATION INFO", "deprecationInfo");
	
	private final String[] mifElementNames;
	private String displayName;


	private AnnotationType(String name, String displayName, String ... mif) {
		super(name);
		this.displayName = displayName;
		this.mifElementNames = mif;
	}


	public String[] getMifElementNames() {
		return mifElementNames;
	}


	public String getDisplayName() {
		return displayName;
	}


	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}