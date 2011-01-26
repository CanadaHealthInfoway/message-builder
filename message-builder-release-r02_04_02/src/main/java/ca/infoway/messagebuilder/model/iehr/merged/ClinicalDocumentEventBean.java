/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"REPC_MT610001CA.ClinicalDocumentEvent","REPC_MT610002CA.ClinicalDocumentEvent"})
public class ClinicalDocumentEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private II serviceReportReferenceId = new IIImpl();


    /**
     * <p>ServiceReportReferenceId</p>
     * 
     * <p>K:Service Report Reference Id</p>
     * 
     * <p><p>An identifier for a report associated with the 
     * procedure.</p></p>
     * 
     * <p><p>Allows for a direct link to a report that has been 
     * written on the procedure. Often surgical, and even 
     * psychological procedures can result in numerous 
     * observations, and other information generally captured in 
     * narrative form. When filled in, this attribute allows the 
     * user to drill down to the Clinical Observation Document 
     * record used to capture this additional information.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceReportReferenceId() {
        return this.serviceReportReferenceId.getValue();
    }
    public void setServiceReportReferenceId(Identifier serviceReportReferenceId) {
        this.serviceReportReferenceId.setValue(serviceReportReferenceId);
    }

}
