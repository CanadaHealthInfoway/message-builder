/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>HealthDocument</p>
 * 
 * <p>POIZ_MT030060CA.HealthDocument: Health Document</p>
 * 
 * <p><p>The health document that supports the historical 
 * immunization information.</p></p>
 * 
 * <p><p>Useful for identifying the Health Document that is the 
 * basis of historical immunization information.</p></p>
 * 
 * <p>POIZ_MT030050CA.HealthDocument: Health Document</p>
 * 
 * <p><p>The health document that supports the historical 
 * immunization information.</p></p>
 * 
 * <p><p>Useful for identifying the Health Document that is the 
 * basis of historical immunization information.</p></p>
 * 
 * <p>POIZ_MT060150CA.HealthDocument: Health Document</p>
 * 
 * <p><p>The health document that supports the historical 
 * immunization information.</p></p>
 * 
 * <p><p>Useful for identifying the Health Document that is the 
 * basis of historical immunization information.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.HealthDocument","POIZ_MT030060CA.HealthDocument","POIZ_MT060150CA.HealthDocument"})
public class HealthDocumentBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private II healthDocumentID = new IIImpl();
    private ST healthDocumentTitle = new STImpl();
    private ED<EncapsulatedData> healthDocumentText = new EDImpl<EncapsulatedData>();


    /**
     * <p>HealthDocumentID</p>
     * 
     * <p>Health Document ID</p>
     * 
     * <p><p>Identifies the health document that supports the 
     * historical immunization information.</p></p>
     * 
     * <p><p>Used to reference identified health documents. As not 
     * all implementations will support this concept, this 
     * attribute is optional.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getHealthDocumentID() {
        return this.healthDocumentID.getValue();
    }
    public void setHealthDocumentID(Identifier healthDocumentID) {
        this.healthDocumentID.setValue(healthDocumentID);
    }


    /**
     * <p>HealthDocumentTitle</p>
     * 
     * <p>Health Document Title</p>
     * 
     * <p><p>The title of the Health Document</p></p>
     * 
     * <p><p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p></p>
     */
    @Hl7XmlMapping({"title"})
    public String getHealthDocumentTitle() {
        return this.healthDocumentTitle.getValue();
    }
    public void setHealthDocumentTitle(String healthDocumentTitle) {
        this.healthDocumentTitle.setValue(healthDocumentTitle);
    }


    /**
     * <p>HealthDocumentText</p>
     * 
     * <p>Health Document Text</p>
     * 
     * <p><p>Contains the body of the health document that is the 
     * basis of the immunization information.</p></p>
     * 
     * <p><p>Useful for identifying the Health Document that is the 
     * basis of historical immunization information. Not all 
     * implementations will support this concept so this attribute 
     * is optional.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getHealthDocumentText() {
        return this.healthDocumentText.getValue();
    }
    public void setHealthDocumentText(EncapsulatedData healthDocumentText) {
        this.healthDocumentText.setValue(healthDocumentText);
    }

}
