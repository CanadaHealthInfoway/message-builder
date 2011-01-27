/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>COCT_MT090310CA.AssignedDevice: EHR Repository</p>
 * 
 * <p><p>Identification of the EHR infostructure responsible 
 * for the storage and management of the record.</p></p>
 * 
 * <p><p>Provides context about the record and its 
 * management.</p></p>
 * 
 * <p>COCT_MT090302CA.AssignedDevice: Application</p>
 * 
 * <p><p>A reference to a system/application related to 
 * healthcare information.</p></p>
 * 
 * <p><p>Allows an application to be uniquely identified.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice","COCT_MT090310CA.AssignedDevice"})
@Hl7RootType
public class EHRRepositoryBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20110127L;
    private ST repositoryJurisdictionName = new STImpl();
    private ST repositoryName = new STImpl();
    private II id = new IIImpl();
    private ST applicationName = new STImpl();


    /**
     * <p>RepositoryJurisdictionName</p>
     * 
     * <p>Repository Jurisdiction Name</p>
     * 
     * <p><p>The name of the jurisdiction that is responsible for 
     * the EHR infostructure that contains and manages the 
     * record.</p></p>
     * 
     * <p><p>Establishes business context for determining 
     * custodianship, and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"representedRepositoryJurisdiction/name"})
    public String getRepositoryJurisdictionName() {
        return this.repositoryJurisdictionName.getValue();
    }
    public void setRepositoryJurisdictionName(String repositoryJurisdictionName) {
        this.repositoryJurisdictionName.setValue(repositoryJurisdictionName);
    }


    /**
     * <p>RepositoryName</p>
     * 
     * <p>Repository Name</p>
     * 
     * <p><p>The name of the repository which is responsible for 
     * maintaining the record. E.g. &quot;Ontario Health 
     * Respository #3&quot;</p></p>
     * 
     * <p><p>Provides a human-readable name for the repository and 
     * is therefore mandatory</p></p>
     */
    @Hl7XmlMapping({"assignedRepository/name"})
    public String getRepositoryName() {
        return this.repositoryName.getValue();
    }
    public void setRepositoryName(String repositoryName) {
        this.repositoryName.setValue(repositoryName);
    }


    /**
     * <p>C:Application Id</p>
     * 
     * <p><p>Unique identifier of an application or a system.</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>PVD.020-01 (extension)</p><p>PVD.020-02 
     * (root)</p><p>Dispensing Pharmacy number</p><p>Pharmacy 
     * Identifier</p><p>Facility.facilityKey</p><p>DispensedItem.facilityKey</p></p>
     * 
     * <p><p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p></p>
     * 
     * <p><p>To uniquely identify an 
     * application/system.</p><p>Attribute is mandatory to allow 
     * for distinguishing different applications/systems.</p></p>
     * 
     * <p>Repository Identifier</p>
     * 
     * <p><p>A unique identifier for the EHR repository.</p></p>
     * 
     * <p><p>Allows repositories to be uniquely identified for 
     * linking or grouping purposes and is therefore mandatory.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>ApplicationName</p>
     * 
     * <p>B: Application Name</p>
     * 
     * <p><p>The name assigned to the application/system.</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>PVD.070</p><p>Dispensing Pharmacy 
     * Name</p><p>Facility.name</p></p>
     * 
     * <p><p>Used for human communication. The name of the 
     * application must be known and is therefore marked as 
     * 'mandatory'.</p></p>
     */
    @Hl7XmlMapping({"assignedDevice/manufacturerModelName"})
    public String getApplicationName() {
        return this.applicationName.getValue();
    }
    public void setApplicationName(String applicationName) {
        this.applicationName.setValue(applicationName);
    }

}
