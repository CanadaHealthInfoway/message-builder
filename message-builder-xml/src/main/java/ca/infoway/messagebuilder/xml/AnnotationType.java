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
	
	private static final long serialVersionUID = 3066114109382422542L;
	
	public static final AnnotationType CONSTRAINT = new AnnotationType("CONSTRAINT", "constraint");//id in mif2 
	public static final AnnotationType DESCRIPTION = new AnnotationType("DESCRIPTION", "description"); //for interactions 
	public static final AnnotationType DEFINITION = new AnnotationType("DEFINITION", "definition"); //for message parts (className, attributes, associations) 
	public static final AnnotationType DESIGN_COMMENTS = new AnnotationType("DESIGN_COMMENTS", "designComments"); 
	public static final AnnotationType MAPPING = new AnnotationType("MAPPING", "mapping"); //sourceName
	public static final AnnotationType OPEN_ISSUE = new AnnotationType("OPEN_ISSUE", "openIssues", "openIssue"); 
//	public static final AnnotationType OTHER_NOTES = new AnnotationType("OTHER_NOTES", "", ""); //has something in the constraint tool
	public static final AnnotationType RATIONALE = new AnnotationType("RATIONALE", "rationale"); 
	public static final AnnotationType USAGE_NOTES = new AnnotationType("USAGE_NOTES", "usageNotes"); 
	
	private final String[] mifElementNames;


	private AnnotationType(String name, String ... mif) {
		super(name);
		this.mifElementNames = mif;
	}


	public String[] getMifElementNames() {
		return mifElementNames;
	}
	
}