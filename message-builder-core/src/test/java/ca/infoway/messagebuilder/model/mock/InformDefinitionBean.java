package ca.infoway.messagebuilder.model.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "COCT_MT470000CA.InformDefinition" })
public class InformDefinitionBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -377645382168732286L;

    private List<InformationAccessTypeBean> actDefinitions = new ArrayList<InformationAccessTypeBean>();

    private Recipient recipient;

    @Hl7XmlMapping("subject")
    public List<InformationAccessTypeBean> getActDefinitions() {
        return actDefinitions;
    }

    public void setActDefinitions(List<InformationAccessTypeBean> actDefinitions) {
        this.actDefinitions = actDefinitions;
    }

    @Hl7XmlMapping("receiver/recipient")
    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }
}
