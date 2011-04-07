/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.common.coct_mt680000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT680000CA.AdjudicatedInvoiceAuthor"})
public class AdjudicatedInvoiceAuthorBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ED<String> eOBSignature = new EDImpl<String>();
    private ST adjudicatorDeviceSoftwareName = new STImpl();


    /**
     * <p>EOB signature</p>
     * 
     * <p><p>EOB signature</p></p>
     */
    @Hl7XmlMapping({"signatureText"})
    public String getEOBSignature() {
        return this.eOBSignature.getValue();
    }
    public void setEOBSignature(String eOBSignature) {
        this.eOBSignature.setValue(eOBSignature);
    }


    /**
     * <p>Adjudicator Device Software Name</p>
     * 
     * <p><p>(COB Source. Which s/w rules were used to create the 
     * COB CMET such as CPhA, NeCST. Use modifier for Invoice or 
     * PreDet</p></p>
     */
    @Hl7XmlMapping({"adjudicatorRole/playingAdjudicatorDevice/softwareName"})
    public String getAdjudicatorDeviceSoftwareName() {
        return this.adjudicatorDeviceSoftwareName.getValue();
    }
    public void setAdjudicatorDeviceSoftwareName(String adjudicatorDeviceSoftwareName) {
        this.adjudicatorDeviceSoftwareName.setValue(adjudicatorDeviceSoftwareName);
    }

}
