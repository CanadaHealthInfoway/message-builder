/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.merged;

import java.util.Date;

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
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"MCCI_MT000100CA.Sender","MCCI_MT000200CA.Sender","MCCI_MT000300CA.Sender","MCCI_MT102001CA.Sender"})
public class SenderBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private TEL sendingNetworkAddress = new TELImpl();
    private II sendingApplicationIdentifier = new IIImpl();
    private ST sendingApplicationName = new STImpl();
    private ST sendingApplicationConfigurationInformation = new STImpl();
    private IVL<TS, Interval<Date>> sendingApplicationVersionDate = new IVLImpl<TS, Interval<Date>>();
    private ST sendingSoftwareVersionNumber = new STImpl();
    private ST sendingApplicationSoftwareName = new STImpl();
    private II sendingOrganizationIdentifier = new IIImpl();
    private II sendingFacilityIdentifier = new IIImpl();


    /**
     * <p>SendingNetworkAddress</p>
     * 
     * <p>IB:Sending Network Address</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The network 
     * address of the application which sent the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be 
     * important for sender validation. Usually also the address to 
     * which responses are sent. This is optional because not all 
     * environments require network addresses.</p></p>
     */
    @Hl7XmlMapping({"telecom"})
    public TelecommunicationAddress getSendingNetworkAddress() {
        return this.sendingNetworkAddress.getValue();
    }
    public void setSendingNetworkAddress(TelecommunicationAddress sendingNetworkAddress) {
        this.sendingNetworkAddress.setValue(sendingNetworkAddress);
    }


    /**
     * <p>SendingApplicationIdentifier</p>
     * 
     * <p>IA:Sending Application Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the application or system from where the 
     * message is being sent.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Because this 
     * is the key identifier of where the message is coming from, 
     * this attribute is mandatory.</p></p>
     * 
     * <p>IA:Sending Application Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the application or system to whom the message 
     * is being routed.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Because this 
     * is the key identifier of where the message is intended to 
     * go, this attribute is mandatory.</p></p>
     */
    @Hl7XmlMapping({"device/id"})
    public Identifier getSendingApplicationIdentifier() {
        return this.sendingApplicationIdentifier.getValue();
    }
    public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
        this.sendingApplicationIdentifier.setValue(sendingApplicationIdentifier);
    }


    /**
     * <p>SendingApplicationName</p>
     * 
     * <p>IE:Sending Application Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is the 
     * name associated with the system or application sending the 
     * message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * useful information when debugging.</p></p>
     */
    @Hl7XmlMapping({"device/name"})
    public String getSendingApplicationName() {
        return this.sendingApplicationName.getValue();
    }
    public void setSendingApplicationName(String sendingApplicationName) {
        this.sendingApplicationName.setValue(sendingApplicationName);
    }


    /**
     * <p>SendingApplicationConfigurationInformation</p>
     * 
     * <p>II:Sending Application Configuration Information</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * additional information about the configuration of the 
     * sending application. Useful when debugging.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides 
     * additional information that may assist in debugging 
     * interactions.</p></p>
     */
    @Hl7XmlMapping({"device/desc"})
    public String getSendingApplicationConfigurationInformation() {
        return this.sendingApplicationConfigurationInformation.getValue();
    }
    public void setSendingApplicationConfigurationInformation(String sendingApplicationConfigurationInformation) {
        this.sendingApplicationConfigurationInformation.setValue(sendingApplicationConfigurationInformation);
    }


    /**
     * <p>SendingApplicationVersionDate</p>
     * 
     * <p>IH:Sending Application Version Date</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the last time the sending application was modified or 
     * reconfigured.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Can help to 
     * isolate the source of a problem when debugging.</p></p>
     */
    @Hl7XmlMapping({"device/existenceTime"})
    public Interval<Date> getSendingApplicationVersionDate() {
        return this.sendingApplicationVersionDate.getValue();
    }
    public void setSendingApplicationVersionDate(Interval<Date> sendingApplicationVersionDate) {
        this.sendingApplicationVersionDate.setValue(sendingApplicationVersionDate);
    }


    /**
     * <p>SendingSoftwareVersionNumber</p>
     * 
     * <p>IG:Sending Software Version Number</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the version number of the piece of software used to 
     * construct the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be used 
     * to filter messages based on the compliance testing of the 
     * sending software.</p></p>
     */
    @Hl7XmlMapping({"device/manufacturerModelName"})
    public String getSendingSoftwareVersionNumber() {
        return this.sendingSoftwareVersionNumber.getValue();
    }
    public void setSendingSoftwareVersionNumber(String sendingSoftwareVersionNumber) {
        this.sendingSoftwareVersionNumber.setValue(sendingSoftwareVersionNumber);
    }


    /**
     * <p>SendingApplicationSoftwareName</p>
     * 
     * <p>IF:Sending Application Software Name</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the name of the software used to construct the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be used 
     * to filter messages based on sending application compliance 
     * testing.</p></p>
     */
    @Hl7XmlMapping({"device/softwareName"})
    public String getSendingApplicationSoftwareName() {
        return this.sendingApplicationSoftwareName.getValue();
    }
    public void setSendingApplicationSoftwareName(String sendingApplicationSoftwareName) {
        this.sendingApplicationSoftwareName.setValue(sendingApplicationSoftwareName);
    }


    /**
     * <p>SendingOrganizationIdentifier</p>
     * 
     * <p>IC:Sending Organization Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Uniquely 
     * identifies the legal entity responsible for the content of 
     * the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be used 
     * for routing/filtering purposes. Also allows tracking of the 
     * original responsible party for messages which may undergo 
     * multiple routing or translation steps. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p></p>
     */
    @Hl7XmlMapping({"device/asAgent/representedOrganization/id"})
    public Identifier getSendingOrganizationIdentifier() {
        return this.sendingOrganizationIdentifier.getValue();
    }
    public void setSendingOrganizationIdentifier(Identifier sendingOrganizationIdentifier) {
        this.sendingOrganizationIdentifier.setValue(sendingOrganizationIdentifier);
    }


    /**
     * <p>SendingFacilityIdentifier</p>
     * 
     * <p>ICA:Sending Facility Identifier</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">The unique 
     * identifier of the hospital, clinic or other facility which 
     * constructed the message.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">May be used 
     * for routing, or for configuration control. This attribute is 
     * optional because not all environments require communicating 
     * this information.</p></p>
     */
    @Hl7XmlMapping({"device/asLocatedEntity/location/id"})
    public Identifier getSendingFacilityIdentifier() {
        return this.sendingFacilityIdentifier.getValue();
    }
    public void setSendingFacilityIdentifier(Identifier sendingFacilityIdentifier) {
        this.sendingFacilityIdentifier.setValue(sendingFacilityIdentifier);
    }

}
