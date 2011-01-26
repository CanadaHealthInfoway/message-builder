/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.poiz_mt070020ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.immunization.merged.AdministeredToBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POIZ_MT070020CA.ImmunizationProfile"})
@Hl7RootType
public class ImmunizationProfileBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private AttachmentBean pertinentInformationAttachment;
    private List<ImmunizationForecastBean> subject2ImmunizationForecast = new ArrayList<ImmunizationForecastBean>();
    private AdministeredToBean subject1;


    @Hl7XmlMapping({"pertinentInformation/attachment"})
    public AttachmentBean getPertinentInformationAttachment() {
        return this.pertinentInformationAttachment;
    }
    public void setPertinentInformationAttachment(AttachmentBean pertinentInformationAttachment) {
        this.pertinentInformationAttachment = pertinentInformationAttachment;
    }


    @Hl7XmlMapping({"subject2/immunizationForecast"})
    public List<ImmunizationForecastBean> getSubject2ImmunizationForecast() {
        return this.subject2ImmunizationForecast;
    }


    @Hl7XmlMapping({"subject1"})
    public AdministeredToBean getSubject1() {
        return this.subject1;
    }
    public void setSubject1(AdministeredToBean subject1) {
        this.subject1 = subject1;
    }

}
