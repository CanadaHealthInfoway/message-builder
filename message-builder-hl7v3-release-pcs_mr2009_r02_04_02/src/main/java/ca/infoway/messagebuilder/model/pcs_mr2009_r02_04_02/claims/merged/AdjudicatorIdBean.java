/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.ficr_mt510201ca.AdjudicatorPersonBean;



/**
 * <p>FICR_MT510201CA.AdjudicatorRole: (no business name)</p>
 * 
 * <p><p>NECST only: To note a contact person (adjudicator) for 
 * the Provider to contact in case of questions on the EOB, use 
 * Adjudication Information codes</p></p>
 */
@Hl7PartTypeMapping({"FICR_MT510201CA.AdjudicatorRole","QUCR_MT830201CA.AdjudicatorRole"})
public class AdjudicatorIdBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II id = new IIImpl();
    private AdjudicatorPersonBean playingAdjudicatorPerson;
    private II adjudicatorInsuranceCarrierID = new IIImpl();


    /**
     * <p>Adjudicator ID</p>
     * 
     * <p><p>Set of identifiers that uniquely identify the 
     * adjudicator of the invoice.</p></p>
     * 
     * <p>Adjudicator Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    @Hl7XmlMapping({"playingAdjudicatorPerson"})
    public AdjudicatorPersonBean getPlayingAdjudicatorPerson() {
        return this.playingAdjudicatorPerson;
    }
    public void setPlayingAdjudicatorPerson(AdjudicatorPersonBean playingAdjudicatorPerson) {
        this.playingAdjudicatorPerson = playingAdjudicatorPerson;
    }


    /**
     * <p>AdjudicatorInsuranceCarrierID</p>
     * 
     * <p>Adjudicator Insurance Carrier ID</p>
     */
    @Hl7XmlMapping({"directAuthority/insuranceCarrierRole/id"})
    public Identifier getAdjudicatorInsuranceCarrierID() {
        return this.adjudicatorInsuranceCarrierID.getValue();
    }
    public void setAdjudicatorInsuranceCarrierID(Identifier adjudicatorInsuranceCarrierID) {
        this.adjudicatorInsuranceCarrierID.setValue(adjudicatorInsuranceCarrierID);
    }

}
