/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"MCCI_MT002100CA.Sender","MCCI_MT002200CA.Sender","MCCI_MT002300CA.Sender","MCCI_MT102001CA.Sender"})
public class SenderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private ST sendingSoftwareVersionNumber = new STImpl();
    private ST sendingApplicationConfigurationInformation = new STImpl();
    private II sendingApplicationIdentifier = new IIImpl();
    private ST sendingApplicationSoftwareName = new STImpl();
    private ST sendingApplicationName = new STImpl();
    private IVL<TS, Interval<Date>> sendingApplicationVersionDate = new IVLImpl<TS, Interval<Date>>();
    private TEL sendingNetworkAddress = new TELImpl();


    /**
     * <p>SendingSoftwareVersionNumber</p>
     * 
     * <p>IG:Sending Software Version Number</p>
     */
    @Hl7XmlMapping({"device/manufacturerModelName"})
    public String getSendingSoftwareVersionNumber() {
        return this.sendingSoftwareVersionNumber.getValue();
    }
    public void setSendingSoftwareVersionNumber(String sendingSoftwareVersionNumber) {
        this.sendingSoftwareVersionNumber.setValue(sendingSoftwareVersionNumber);
    }


    /**
     * <p>SendingApplicationConfigurationInformation</p>
     * 
     * <p>II:Sending Application Configuration Information</p>
     */
    @Hl7XmlMapping({"device/desc"})
    public String getSendingApplicationConfigurationInformation() {
        return this.sendingApplicationConfigurationInformation.getValue();
    }
    public void setSendingApplicationConfigurationInformation(String sendingApplicationConfigurationInformation) {
        this.sendingApplicationConfigurationInformation.setValue(sendingApplicationConfigurationInformation);
    }


    /**
     * <p>SendingApplicationIdentifier</p>
     * 
     * <p>IA:Sending Application Identifier</p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getSendingApplicationIdentifier() {
        return this.sendingApplicationIdentifier.getValue();
    }
    public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
        this.sendingApplicationIdentifier.setValue(sendingApplicationIdentifier);
    }


    /**
     * <p>SendingApplicationSoftwareName</p>
     * 
     * <p>IF:Sending Application Software Name</p>
     */
    @Hl7XmlMapping({"device/softwareName"})
    public String getSendingApplicationSoftwareName() {
        return this.sendingApplicationSoftwareName.getValue();
    }
    public void setSendingApplicationSoftwareName(String sendingApplicationSoftwareName) {
        this.sendingApplicationSoftwareName.setValue(sendingApplicationSoftwareName);
    }


    /**
     * <p>SendingApplicationName</p>
     * 
     * <p>IE:Sending Application Name</p>
     */
    @Hl7XmlMapping({"device/name"})
    public String getSendingApplicationName() {
        return this.sendingApplicationName.getValue();
    }
    public void setSendingApplicationName(String sendingApplicationName) {
        this.sendingApplicationName.setValue(sendingApplicationName);
    }


    /**
     * <p>SendingApplicationVersionDate</p>
     * 
     * <p>IH:Sending Application Version Date</p>
     */
    @Hl7XmlMapping({"device/existenceTime"})
    public Interval<Date> getSendingApplicationVersionDate() {
        return this.sendingApplicationVersionDate.getValue();
    }
    public void setSendingApplicationVersionDate(Interval<Date> sendingApplicationVersionDate) {
        this.sendingApplicationVersionDate.setValue(sendingApplicationVersionDate);
    }


    /**
     * <p>SendingNetworkAddress</p>
     * 
     * <p>IB:Sending Network Address</p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getSendingNetworkAddress() {
        return this.sendingNetworkAddress.getValue();
    }
    public void setSendingNetworkAddress(TelecommunicationAddress sendingNetworkAddress) {
        this.sendingNetworkAddress.setValue(sendingNetworkAddress);
    }

}