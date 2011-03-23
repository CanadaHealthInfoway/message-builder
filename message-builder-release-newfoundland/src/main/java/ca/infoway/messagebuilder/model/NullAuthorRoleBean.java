package ca.infoway.messagebuilder.model;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;

/**
 * <p>Null Author Role 
 * 
 * <p>This is a messaging artifact used by HL7 to allow the 
 * time, signiture and method to be captured when the author is 
 * not sent. This will happen in circumstances where the author 
 * information is sent as part of the authentication token. 
 */
@Hl7PartTypeMapping("MFMI_MT700751CA.AuthorRole")
public class NullAuthorRoleBean extends MessagePartBean implements AuthorPerson {

	private static final long serialVersionUID = 8387919540420282915L;

}
