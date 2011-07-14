/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt090302ca;

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
 * <p>Application</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">An 
 * identification of a system/application that can initiate an 
 * event to change the status of an object.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows an 
 * application to be uniquely identified.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice"})
@Hl7RootType
public class ApplicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged.ChangedBy {

    private static final long serialVersionUID = 20110714L;
    private II applicationId = new IIImpl();
    private ST applicationName = new STImpl();


    /**
     * <p>C:Application Id</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Unique 
     * identifier of an application or a system.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-01 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-02 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy number</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Pharmacy 
     * Identifier</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.facilityKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.facilityKey</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-01 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-02 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy number</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Pharmacy 
     * Identifier</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.facilityKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.facilityKey</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-01 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-02 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy number</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Pharmacy 
     * Identifier</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.facilityKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.facilityKey</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-01 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-02 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy number</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Pharmacy 
     * Identifier</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.facilityKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.facilityKey</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-01 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-02 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy number</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Pharmacy 
     * Identifier</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.facilityKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.facilityKey</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-01 
     * (extension)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.020-02 
     * (root)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy number</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Pharmacy 
     * Identifier</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.facilityKey</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">DispensedItem.facilityKey</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">To uniquely 
     * identify an application/system.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Attribute is 
     * mandatory to allow for distinguishing different 
     * applications/systems.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">To uniquely 
     * identify an application/system.</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Attribute is 
     * mandatory to allow for distinguishing different 
     * applications/systems.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getApplicationId() {
        return this.applicationId.getValue();
    }
    public void setApplicationId(Identifier applicationId) {
        this.applicationId.setValue(applicationId);
    }


    /**
     * <p>B:Application Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The name 
     * assigned to the application/system.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.070</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy Name</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.name</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.070</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy Name</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.name</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">PVD.070</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Dispensing 
     * Pharmacy Name</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Facility.name</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Used for 
     * human communication. The name of the application must be 
     * known and is therefore marked as 'mandatory'.</p></p>
     */
    @Hl7XmlMapping({"assignedDevice/name"})
    public String getApplicationName() {
        return this.applicationName.getValue();
    }
    public void setApplicationName(String applicationName) {
        this.applicationName.setValue(applicationName);
    }

}
