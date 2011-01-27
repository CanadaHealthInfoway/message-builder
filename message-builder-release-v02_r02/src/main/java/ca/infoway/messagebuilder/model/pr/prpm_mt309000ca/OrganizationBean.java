/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Organization</p>
 * 
 * <p><p>The scoping organization for the specified role 
 * class</p></p>
 * 
 * <p><p>Supports the requirement to supply additional 
 * information regarding the assigning Organization of the 
 * specified RoleClass</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT309000CA.Organization"})
public class OrganizationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private TerritorialAuthorityBean territorialAuthority;


    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
