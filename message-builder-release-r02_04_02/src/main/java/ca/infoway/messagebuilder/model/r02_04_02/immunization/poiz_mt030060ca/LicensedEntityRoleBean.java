/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.immunization.poiz_mt030060ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p><p>Identifies the source of the immunization information 
 * as someone who is a provider.</p></p>
 * 
 * <p><p>Needed for categorizing sources of immunization 
 * information. As a result, this attribute is required.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030060CA.LicensedEntityRole"})
public class LicensedEntityRoleBean extends MessagePartBean implements ca.infoway.messagebuilder.model.r02_04_02.immunization.merged.InformationSourceChoice {

    private static final long serialVersionUID = 20110407L;
    private CV licensedEntityType = new CVImpl();


    /**
     * <p>Licensed Entity Type</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getLicensedEntityType() {
        return (HealthcareProviderRoleType) this.licensedEntityType.getValue();
    }
    public void setLicensedEntityType(HealthcareProviderRoleType licensedEntityType) {
        this.licensedEntityType.setValue(licensedEntityType);
    }

}
