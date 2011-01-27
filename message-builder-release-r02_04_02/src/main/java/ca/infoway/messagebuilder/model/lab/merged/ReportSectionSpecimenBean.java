/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.SpecimenRoleBean;



/**
 * <p>POLB_MT004100CA.Specimen1: Culture Specimen</p>
 * 
 * <p><p>Associates the specimens as received with the culture 
 * observation (before processing). Specimen processing and 
 * subsequent reporting is communicated using the Isolate 
 * Specimen participation.</p></p>
 * 
 * <p>POLB_MT004200CA.Specimen: Report Section Specimen</p>
 * 
 * <p><p>At least 1 specimen must be specified on a Result.</p></p>
 * 
 * <p><p>Associates the specimens as received with a diagnosis 
 * report section. This includes specimens subsequent to 
 * processing. Specimens originally received (and not 
 * processed) are communicated using the Report Specimen 
 * participation.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT002000CA.Specimen","POLB_MT004000CA.Specimen","POLB_MT004100CA.Specimen1","POLB_MT004200CA.Specimen"})
public class ReportSectionSpecimenBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private SpecimenRoleBean specimen;
    private INT specimenSequenceNumber = new INTImpl();


    @Hl7XmlMapping({"specimen"})
    public SpecimenRoleBean getSpecimen() {
        return this.specimen;
    }
    public void setSpecimen(SpecimenRoleBean specimen) {
        this.specimen = specimen;
    }


    /**
     * <p>SpecimenSequenceNumber</p>
     * 
     * <p>Specimen Sequence Number</p>
     * 
     * <p><p>Order in which the specimen is to appear in the 
     * message.</p></p>
     * 
     * <p>Specimen Sequence Number</p>
     * 
     * <p><p>Specifies the order in which the specimen is to appear 
     * in the message.</p></p>
     */
    @Hl7XmlMapping({"sequenceNumber"})
    public Integer getSpecimenSequenceNumber() {
        return this.specimenSequenceNumber.getValue();
    }
    public void setSpecimenSequenceNumber(Integer specimenSequenceNumber) {
        this.specimenSequenceNumber.setValue(specimenSequenceNumber);
    }

}
