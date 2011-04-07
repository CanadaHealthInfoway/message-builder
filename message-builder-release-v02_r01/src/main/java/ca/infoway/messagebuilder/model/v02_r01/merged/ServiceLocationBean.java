/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.ServiceDeliveryLocationRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.common.coct_mt960002ca.GeographicCoordinatesBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;



@Hl7PartTypeMapping({"COCT_MT240002CA.ServiceDeliveryLocation","COCT_MT240003CA.ServiceDeliveryLocation","COCT_MT240007CA.ServiceDeliveryLocation"})
@Hl7RootType
public class ServiceLocationBean extends MessagePartBean implements Recipient {

    private static final long serialVersionUID = 20110407L;
    private II serviceLocationIdentifier = new IIImpl();
    private CV serviceLocationType = new CVImpl();
    private AD serviceLocationAddress = new ADImpl();
    private SET<TEL, TelecommunicationAddress> serviceLocationPhonesAndEMails = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private ST serviceLocationName = new STImpl();
    private List<GeographicCoordinatesBean> subjectOfPosition = new ArrayList<GeographicCoordinatesBean>();


    /**
     * <p>ServiceLocationIdentifier</p>
     * 
     * <p>C:Service Location Identifier</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getServiceLocationIdentifier() {
        return this.serviceLocationIdentifier.getValue();
    }
    public void setServiceLocationIdentifier(Identifier serviceLocationIdentifier) {
        this.serviceLocationIdentifier.setValue(serviceLocationIdentifier);
    }


    /**
     * <p>ServiceLocationType</p>
     * 
     * <p>A: Service Location Type</p>
     */
    @Hl7XmlMapping({"code"})
    public ServiceDeliveryLocationRoleType getServiceLocationType() {
        return (ServiceDeliveryLocationRoleType) this.serviceLocationType.getValue();
    }
    public void setServiceLocationType(ServiceDeliveryLocationRoleType serviceLocationType) {
        this.serviceLocationType.setValue(serviceLocationType);
    }


    /**
     * <p>ServiceLocationAddress</p>
     * 
     * <p>D:Service Location Address</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getServiceLocationAddress() {
        return this.serviceLocationAddress.getValue();
    }
    public void setServiceLocationAddress(PostalAddress serviceLocationAddress) {
        this.serviceLocationAddress.setValue(serviceLocationAddress);
    }


    /**
     * <p>ServiceLocationPhonesAndEMails</p>
     * 
     * <p>E:Service Location Phones and E-mails</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getServiceLocationPhonesAndEMails() {
        return this.serviceLocationPhonesAndEMails.rawSet();
    }


    /**
     * <p>ServiceLocationName</p>
     * 
     * <p>B:Service Location Name</p>
     */
    @Hl7XmlMapping({"location/name"})
    public String getServiceLocationName() {
        return this.serviceLocationName.getValue();
    }
    public void setServiceLocationName(String serviceLocationName) {
        this.serviceLocationName.setValue(serviceLocationName);
    }


    @Hl7XmlMapping({"subjectOf/position"})
    public List<GeographicCoordinatesBean> getSubjectOfPosition() {
        return this.subjectOfPosition;
    }

}
