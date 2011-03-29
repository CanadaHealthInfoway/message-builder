/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt090302ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice"})
@Hl7RootType
public class ApplicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20110318L;
    private II applicationId = new IIImpl();
    private ST applicationName = new STImpl();


    /**
     * <p>C:Application Id</p>
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
     */
    @Hl7XmlMapping({"assignedDevice/name"})
    public String getApplicationName() {
        return this.applicationName.getValue();
    }
    public void setApplicationName(String applicationName) {
        this.applicationName.setValue(applicationName);
    }

}