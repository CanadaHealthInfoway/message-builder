/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.porx_mt060080ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Generic Query Parameters 
 * 
 * <p>Defines the set of parameters that may be used to filter 
 * the query response. 
 * 
 * <p>Root class for query definition 
 */
@Hl7PartTypeMapping({"PORX_MT060080CA.ParameterList"})
@Hl7RootType
public class GenericQueryParametersBean extends MessagePartBean {

    private CV<IssueFilterCode> issueFilterCode = new CVImpl<IssueFilterCode>();
    private II prescriptionOrderNumber = new IIImpl();

    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCode() {
        return this.issueFilterCode.getValue();
    }
    public void setIssueFilterCode(IssueFilterCode issueFilterCode) {
        this.issueFilterCode.setValue(issueFilterCode);
    }

    @Hl7XmlMapping({"prescriptionOrderNumber/value"})
    public Identifier getPrescriptionOrderNumber() {
        return this.prescriptionOrderNumber.getValue();
    }
    public void setPrescriptionOrderNumber(Identifier prescriptionOrderNumber) {
        this.prescriptionOrderNumber.setValue(prescriptionOrderNumber);
    }

}
