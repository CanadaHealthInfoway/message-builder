/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.ficr_mt610201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"FICR_MT610201CA.InsuranceCarrierRole"})
public class InsuranceCarrierRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II adjudicatorInsuranceCarrierID = new IIImpl();


    /**
     * <p>Adjudicator Insurance Carrier ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicatorInsuranceCarrierID() {
        return this.adjudicatorInsuranceCarrierID.getValue();
    }
    public void setAdjudicatorInsuranceCarrierID(Identifier adjudicatorInsuranceCarrierID) {
        this.adjudicatorInsuranceCarrierID.setValue(adjudicatorInsuranceCarrierID);
    }

}