/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pr.prpm_mt301010ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.PlaceEntityType;
import ca.infoway.messagebuilder.domainvalue.RoleCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Territorial Authority</p>
 * 
 * <p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists</p>
 * 
 * <p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT301010CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20100614L;
    private CV territorialAuthorityType = new CVImpl();
    private TerritorialAuthorityBean partTerritorialAuthority;
    private CV jurisdictionType = new CVImpl();

    @Hl7XmlMapping({"code"})
    public RoleCode getTerritorialAuthorityType() {
        return (RoleCode) this.territorialAuthorityType.getValue();
    }
    public void setTerritorialAuthorityType(RoleCode territorialAuthorityType) {
        this.territorialAuthorityType.setValue(territorialAuthorityType);
    }

    @Hl7XmlMapping({"part/territorialAuthority"})
    public TerritorialAuthorityBean getPartTerritorialAuthority() {
        return this.partTerritorialAuthority;
    }
    public void setPartTerritorialAuthority(TerritorialAuthorityBean partTerritorialAuthority) {
        this.partTerritorialAuthority = partTerritorialAuthority;
    }

    @Hl7XmlMapping({"territory/code"})
    public PlaceEntityType getJurisdictionType() {
        return (PlaceEntityType) this.jurisdictionType.getValue();
    }
    public void setJurisdictionType(PlaceEntityType jurisdictionType) {
        this.jurisdictionType.setValue(jurisdictionType);
    }

}
