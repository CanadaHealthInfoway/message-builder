/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.si.rcmr_mt010001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
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

    private static final long serialVersionUID = 20100614L;
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
    public List<ActInformationAccessTypeCode> getConsentInformationTypes() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(consentInformationTypes, CVImpl.class);
    }

}
