package ca.infoway.messagebuilder.model.cerx.consent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.InformationAccessTypeBean;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.Recipient;

@Hl7PartTypeMapping({ "RCMR_MT010001CA.PermissionToInform" })
public class InformationAccessBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -377645382168732286L;

    private List<InformationAccessTypeBean> informationAccessTypes = new ArrayList<InformationAccessTypeBean>();

    private Recipient recipient;

    @Hl7XmlMapping("subject")
    public List<InformationAccessTypeBean> getInformationAccessTypes() {
        return informationAccessTypes;
    }

    public void setInformationAccessTypes(List<InformationAccessTypeBean> informationAccessTypes) {
        this.informationAccessTypes = informationAccessTypes;
    }

    @Hl7XmlMapping("receiver/recipient")
    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
}
