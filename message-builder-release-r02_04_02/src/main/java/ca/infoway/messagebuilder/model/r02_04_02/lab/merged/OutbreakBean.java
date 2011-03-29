/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Outbreak</p>
 * 
 * <p>POLB_MT004100CA.OutbreakEvent: Outbreak</p>
 * 
 * <p><p>Identifies an outbreak which the reporting lab 
 * suspects this result might be a part of.</p></p>
 * 
 * <p><p>Used as an indicator to public health that this lab 
 * result may indicate the subject is a part of an outbreak. 
 * This does not confirm that lab result is an outbreak 
 * subject, only that the potential exists and public health 
 * should disposition.</p></p>
 * 
 * <p>POLB_MT004200CA.OutbreakEvent: Outbreak</p>
 * 
 * <p><p>Identifies an outbreak which the reporting lab 
 * suspects this result might be a part of.</p></p>
 * 
 * <p><p>Used as an indicator to public health that this lab 
 * result may indicate the subject is a part of an outbreak. 
 * This does not confirm that lab result is an outbreak 
 * subject, only that the potential exists and public health 
 * should disposition.</p></p>
 * 
 * <p>POLB_MT004000CA.OutbreakEvent: Outbreak</p>
 * 
 * <p><p>Identifies an outbreak which the reporting lab 
 * suspects this result might be a part of.</p></p>
 * 
 * <p><p>Used as an indicator to public health that this lab 
 * result may indicate the subject is a part of an outbreak. 
 * This does not confirm that lab result is an outbreak 
 * subject, only that the potential exists and public health 
 * should disposition.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.OutbreakEvent","POLB_MT001010CA.OutbreakEvent","POLB_MT001999CA.OutbreakEvent","POLB_MT002000CA.OutbreakEvent","POLB_MT004000CA.OutbreakEvent","POLB_MT004100CA.OutbreakEvent","POLB_MT004200CA.OutbreakEvent"})
public class OutbreakBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private II outbreakIdentifier = new IIImpl();


    /**
     * <p>OutbreakIdentifier</p>
     * 
     * <p>Outbreak Identifier</p>
     * 
     * <p><p>Allows public health to identify an outbreak for which 
     * this test is being conducted.</p></p>
     * 
     * <p>Outbreak Identifier</p>
     * 
     * <p><p>Identifies an outbreak which the reporting lab 
     * suspects this result might be a part of.</p></p>
     * 
     * <p><p>Used as an indicator to public health that this lab 
     * result may indicate the subject is a part of an outbreak. 
     * This does not confirm that lab result is an outbreak 
     * subject, only that the potential exists and public health 
     * should disposition.</p></p>
     * 
     * <p>Outbreak Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getOutbreakIdentifier() {
        return this.outbreakIdentifier.getValue();
    }
    public void setOutbreakIdentifier(Identifier outbreakIdentifier) {
        this.outbreakIdentifier.setValue(outbreakIdentifier);
    }

}