/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt470000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.ConsentGivenToBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT470000CA.InformDefinition"})
public class AccessTypeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ConsentGivenToBean receiver;
    private List<CV> consentInformationTypes = new ArrayList<CV>();


    @Hl7XmlMapping({"receiver"})
    public ConsentGivenToBean getReceiver() {
        return this.receiver;
    }
    public void setReceiver(ConsentGivenToBean receiver) {
        this.receiver = receiver;
    }


    /**
     * <p>B:Consent Information Types</p>
     */
    @Hl7XmlMapping({"subject/actDefinition/code"})
    public List<ActInformationAccessTypeCode> getConsentInformationTypes() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(consentInformationTypes, CVImpl.class);
    }

}
