/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.domainvalue.ActDetectedIssueManagementCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090107ca.ProviderBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT980010CA.DetectedIssueManagement","PORX_MT980020CA.DetectedIssueManagement","PORX_MT980030CA.DetectedIssueManagement"})
public class IssueManagementsBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CV managementType = new CVImpl();
    private ProviderBean authorAssignedPerson;
    private TS managementDate = new TSImpl();
    private ST managementDescription = new STImpl();


    /**
     * <p>ManagementType</p>
     * 
     * <p>A:Management Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ActDetectedIssueManagementCode getManagementType() {
        return (ActDetectedIssueManagementCode) this.managementType.getValue();
    }
    public void setManagementType(ActDetectedIssueManagementCode managementType) {
        this.managementType.setValue(managementType);
    }


    @Hl7XmlMapping({"author/assignedPerson"})
    public ProviderBean getAuthorAssignedPerson() {
        return this.authorAssignedPerson;
    }
    public void setAuthorAssignedPerson(ProviderBean authorAssignedPerson) {
        this.authorAssignedPerson = authorAssignedPerson;
    }


    /**
     * <p>ManagementDate</p>
     * 
     * <p>B:Management Date</p>
     */
    @Hl7XmlMapping({"author/time"})
    public Date getManagementDate() {
        return this.managementDate.getValue();
    }
    public void setManagementDate(Date managementDate) {
        this.managementDate.setValue(managementDate);
    }


    /**
     * <p>ManagementDescription</p>
     * 
     * <p>C:Management Description</p>
     */
    @Hl7XmlMapping({"text"})
    public String getManagementDescription() {
        return this.managementDescription.getValue();
    }
    public void setManagementDescription(String managementDescription) {
        this.managementDescription.setValue(managementDescription);
    }

}
