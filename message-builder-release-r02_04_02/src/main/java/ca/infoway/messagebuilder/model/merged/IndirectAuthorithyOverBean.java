/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT202301CA.IndirectAuthorithyOver","PRPA_MT202302CA.IndirectAuthorithyOver","PRPA_MT202303CA.IndirectAuthorithyOver","PRPA_MT202317CA.IndirectAuthorithyOver"})
public class IndirectAuthorithyOverBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private TerritorialAuthorityBean territorialAuthority;

    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
