/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.claims.qucr_mt810201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Arrangement</p>
 * 
 * <p><p>Business arrangement for payment purposes.</p></p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsFinancialContract"})
public class BusinessArrangementBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private II businessArrangementID = new IIImpl();


    /**
     * <p>Business Arrangement ID</p>
     * 
     * <p><p>Business arrangement identifier</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getBusinessArrangementID() {
        return this.businessArrangementID.getValue();
    }
    public void setBusinessArrangementID(Identifier businessArrangementID) {
        this.businessArrangementID.setValue(businessArrangementID);
    }

}
