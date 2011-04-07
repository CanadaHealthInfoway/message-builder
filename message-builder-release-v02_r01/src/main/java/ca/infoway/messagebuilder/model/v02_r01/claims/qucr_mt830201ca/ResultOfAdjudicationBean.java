/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.claims.qucr_mt830201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"QUCR_MT830201CA.AdjudicationResult"})
public class ResultOfAdjudicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II adjudicationID = new IIImpl();
    private List<AdjudicationResultReferenceBean> reference = new ArrayList<AdjudicationResultReferenceBean>();


    /**
     * <p>Adjudication ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getAdjudicationID() {
        return this.adjudicationID.getValue();
    }
    public void setAdjudicationID(Identifier adjudicationID) {
        this.adjudicationID.setValue(adjudicationID);
    }


    @Hl7XmlMapping({"reference"})
    public List<AdjudicationResultReferenceBean> getReference() {
        return this.reference;
    }

}
