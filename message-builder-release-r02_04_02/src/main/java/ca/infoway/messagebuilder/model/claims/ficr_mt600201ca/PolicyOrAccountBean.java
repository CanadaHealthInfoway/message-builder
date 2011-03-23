/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.claims.ficr_mt600201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.CarrierRole_1Bean;



/**
 * <p>id: = Coverage Identifier, extension = 
 * Policy.Plan.Group.Contract. Division.Section.Version (or 
 * similar). Carrier noted in author participation, and may not 
 * be same namespace as OID of id</p>
 */
@Hl7PartTypeMapping({"FICR_MT600201CA.PolicyOrAccount"})
public class PolicyOrAccountBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II policyID = new IIImpl();
    private CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient;
    private CarrierRole_1Bean authorCarrierRole;

    @Hl7XmlMapping({"id"})
    public Identifier getPolicyID() {
        return this.policyID.getValue();
    }
    public void setPolicyID(Identifier policyID) {
        this.policyID.setValue(policyID);
    }

    @Hl7XmlMapping({"beneficiary/coveredPartyAsPatient"})
    public CoveredPartyAsPatientBean getBeneficiaryCoveredPartyAsPatient() {
        return this.beneficiaryCoveredPartyAsPatient;
    }
    public void setBeneficiaryCoveredPartyAsPatient(CoveredPartyAsPatientBean beneficiaryCoveredPartyAsPatient) {
        this.beneficiaryCoveredPartyAsPatient = beneficiaryCoveredPartyAsPatient;
    }

    @Hl7XmlMapping({"author/carrierRole"})
    public CarrierRole_1Bean getAuthorCarrierRole() {
        return this.authorCarrierRole;
    }
    public void setAuthorCarrierRole(CarrierRole_1Bean authorCarrierRole) {
        this.authorCarrierRole = authorCarrierRole;
    }

}
