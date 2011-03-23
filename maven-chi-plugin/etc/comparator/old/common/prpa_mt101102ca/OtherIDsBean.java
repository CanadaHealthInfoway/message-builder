/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.prpa_mt101102ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.OtherIDsRoleCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;



@Hl7PartTypeMapping({"PRPA_MT101102CA.OtherIDs"})
public class OtherIDsBean extends MessagePartBean {

    private SET<II, Identifier> nonHealthcareIdentification = new SETImpl<II, Identifier>(IIImpl.class);
    private CV<OtherIDsRoleCode> nonHealthcareIdentificationCode = new CVImpl<OtherIDsRoleCode>();
    private II nonHealthcareOrganizationIdentifier = new IIImpl();
    private ST nonHealthcareOrganizationName = new STImpl();

    @Hl7XmlMapping({"id"})
    public Set<Identifier> getNonHealthcareIdentification() {
        return this.nonHealthcareIdentification.rawSet();
    }

    @Hl7XmlMapping({"code"})
    public OtherIDsRoleCode getNonHealthcareIdentificationCode() {
        return this.nonHealthcareIdentificationCode.getValue();
    }
    public void setNonHealthcareIdentificationCode(OtherIDsRoleCode nonHealthcareIdentificationCode) {
        this.nonHealthcareIdentificationCode.setValue(nonHealthcareIdentificationCode);
    }

    @Hl7XmlMapping({"scopingIdOrganization/id"})
    public Identifier getNonHealthcareOrganizationIdentifier() {
        return this.nonHealthcareOrganizationIdentifier.getValue();
    }
    public void setNonHealthcareOrganizationIdentifier(Identifier nonHealthcareOrganizationIdentifier) {
        this.nonHealthcareOrganizationIdentifier.setValue(nonHealthcareOrganizationIdentifier);
    }

    @Hl7XmlMapping({"scopingIdOrganization/name"})
    public java.lang.String getNonHealthcareOrganizationName() {
        return this.nonHealthcareOrganizationName.getValue();
    }
    public void setNonHealthcareOrganizationName(java.lang.String nonHealthcareOrganizationName) {
        this.nonHealthcareOrganizationName.setValue(nonHealthcareOrganizationName);
    }

}
