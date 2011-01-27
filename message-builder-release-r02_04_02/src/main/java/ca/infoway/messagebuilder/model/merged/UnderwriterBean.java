/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.Underwriter","PORX_MT010120CA.Underwriter","PORX_MT060040CA.Underwriter"})
public class UnderwriterBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private II payorIdentifier = new IIImpl();
    private ST payorName = new STImpl();


    /**
     * <p>PayorIdentifier</p>
     * 
     * <p>Payor Identifier</p>
     * 
     * <p><p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p></p>
     * 
     * <p><p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p></p>
     * 
     * <p>B:Payor Identifier</p>
     * 
     * <p><p>A unique identifier for the payor organization 
     * responsible for the coverage extension.</p></p>
     * 
     * <p><p>Gives context to the coverage extension identifier and 
     * therefore mandatory. Allows the dispensing service delivery 
     * location to know where to send a claim.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getPayorIdentifier() {
        return this.payorIdentifier.getValue();
    }
    public void setPayorIdentifier(Identifier payorIdentifier) {
        this.payorIdentifier.setValue(payorIdentifier);
    }


    /**
     * <p>PayorName</p>
     * 
     * <p>C:Payor Name</p>
     * 
     * <p><p>The name of the organization responsible for issuing 
     * the coverage extension</p></p>
     * 
     * <p><p>Mandatory for display purposes.</p></p>
     * 
     * <p>Payor Name</p>
     * 
     * <p><p>The name of the organization responsible for issuing 
     * the coverage extension.</p></p>
     * 
     * <p><p>Mandatory for display purposes.</p></p>
     */
    @Hl7XmlMapping({"underwritingOrganization/name"})
    public String getPayorName() {
        return this.payorName.getValue();
    }
    public void setPayorName(String payorName) {
        this.payorName.setValue(payorName);
    }

}
