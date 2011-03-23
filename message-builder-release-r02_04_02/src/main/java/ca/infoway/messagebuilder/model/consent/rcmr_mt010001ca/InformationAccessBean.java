/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.consent.rcmr_mt010001ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.ConsentGivenToBean;
import java.util.ArrayList;
import java.util.List;



/**
 * <p>Information Access</p>
 * 
 * <p>Describes the type of information access being consented 
 * to.</p>
 * 
 * <p>Allows fine-grained control over the types of information 
 * access is granted to and who is granted access.</p>
 */
@Hl7PartTypeMapping({"RCMR_MT010001CA.PermissionToInform"})
public class InformationAccessBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private ConsentGivenToBean receiver;
    private List<CV> consentInformationTypes = new ArrayList<CV>();

    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }

    @Hl7XmlMapping({"subject/recordType/code"})
    public List<Code> getConsentInformationTypes() {
        return new RawListWrapper<CV, Code>(consentInformationTypes, CVImpl.class);
    }

}
