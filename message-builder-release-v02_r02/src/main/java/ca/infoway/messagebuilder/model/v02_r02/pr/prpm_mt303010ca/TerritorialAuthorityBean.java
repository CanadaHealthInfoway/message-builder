/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r02.pr.prpm_mt303010ca;

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
 * <p><p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists</p></p>
 * 
 * <p><p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists.</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT303010CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV territorialAuthorityType = new CVImpl();
    private TerritorialAuthorityBean partTerritorialAuthority;
    private CV jurisdictionType = new CVImpl();


    /**
     * <p>Territorial Authority Type</p>
     * 
     * <p><p>The code identifying the specific Territorial 
     * Authority</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     */
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


    /**
     * <p>Jurisdiction Type</p>
     * 
     * <p><p>A character value that represents the Canadian 
     * provincial or territorial geographical area within which the 
     * Provider is operating.</p></p>
     * 
     * <p><p>Mandatory attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     * 
     * <p><p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"territory/code"})
    public PlaceEntityType getJurisdictionType() {
        return (PlaceEntityType) this.jurisdictionType.getValue();
    }
    public void setJurisdictionType(PlaceEntityType jurisdictionType) {
        this.jurisdictionType.setValue(jurisdictionType);
    }

}
