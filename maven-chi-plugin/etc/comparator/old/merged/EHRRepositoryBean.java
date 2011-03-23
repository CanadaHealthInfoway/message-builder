/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice","COCT_MT090310CA.AssignedDevice"})
@Hl7RootType
public class EHRRepositoryBean extends MessagePartBean implements ChangedByBean {

    private II repositoryIdentifier = new IIImpl();
    private ST repositoryName = new STImpl();
    private ST repositoryJurisdictionName = new STImpl();
    private II sendingApplicationIdentifier = new IIImpl();
    private ST sendingApplicationName = new STImpl();
    private ST sendingApplicationConfigurationInformation = new STImpl();
    private IVL<TS, Interval<Date>> sendingApplicationVersionDate = new IVLImpl<TS, Interval<Date>>();
    private ST sendingSoftwareVersionNumber = new STImpl();
    private ST sendingApplicationSoftwareName = new STImpl();

    @Hl7XmlMapping({"id"})
    public Identifier getRepositoryIdentifier() {
        return this.repositoryIdentifier.getValue();
    }
    public void setRepositoryIdentifier(Identifier repositoryIdentifier) {
        this.repositoryIdentifier.setValue(repositoryIdentifier);
    }

    @Hl7XmlMapping({"assignedRepository/name"})
    public java.lang.String getRepositoryName() {
        return this.repositoryName.getValue();
    }
    public void setRepositoryName(java.lang.String repositoryName) {
        this.repositoryName.setValue(repositoryName);
    }

    @Hl7XmlMapping({"representedRepositoryJurisdiction/name"})
    public java.lang.String getRepositoryJurisdictionName() {
        return this.repositoryJurisdictionName.getValue();
    }
    public void setRepositoryJurisdictionName(java.lang.String repositoryJurisdictionName) {
        this.repositoryJurisdictionName.setValue(repositoryJurisdictionName);
    }

    @Hl7XmlMapping({"assignedDevice/id"})
    public Identifier getSendingApplicationIdentifier() {
        return this.sendingApplicationIdentifier.getValue();
    }
    public void setSendingApplicationIdentifier(Identifier sendingApplicationIdentifier) {
        this.sendingApplicationIdentifier.setValue(sendingApplicationIdentifier);
    }

    @Hl7XmlMapping({"assignedDevice/name"})
    public java.lang.String getSendingApplicationName() {
        return this.sendingApplicationName.getValue();
    }
    public void setSendingApplicationName(java.lang.String sendingApplicationName) {
        this.sendingApplicationName.setValue(sendingApplicationName);
    }

    @Hl7XmlMapping({"assignedDevice/desc"})
    public java.lang.String getSendingApplicationConfigurationInformation() {
        return this.sendingApplicationConfigurationInformation.getValue();
    }
    public void setSendingApplicationConfigurationInformation(java.lang.String sendingApplicationConfigurationInformation) {
        this.sendingApplicationConfigurationInformation.setValue(sendingApplicationConfigurationInformation);
    }

    @Hl7XmlMapping({"assignedDevice/existenceTime"})
    public Interval<Date> getSendingApplicationVersionDate() {
        return this.sendingApplicationVersionDate.getValue();
    }
    public void setSendingApplicationVersionDate(Interval<Date> sendingApplicationVersionDate) {
        this.sendingApplicationVersionDate.setValue(sendingApplicationVersionDate);
    }

    @Hl7XmlMapping({"assignedDevice/manufacturerModelName"})
    public java.lang.String getSendingSoftwareVersionNumber() {
        return this.sendingSoftwareVersionNumber.getValue();
    }
    public void setSendingSoftwareVersionNumber(java.lang.String sendingSoftwareVersionNumber) {
        this.sendingSoftwareVersionNumber.setValue(sendingSoftwareVersionNumber);
    }

    @Hl7XmlMapping({"assignedDevice/softwareName"})
    public java.lang.String getSendingApplicationSoftwareName() {
        return this.sendingApplicationSoftwareName.getValue();
    }
    public void setSendingApplicationSoftwareName(java.lang.String sendingApplicationSoftwareName) {
        this.sendingApplicationSoftwareName.setValue(sendingApplicationSoftwareName);
    }

}
