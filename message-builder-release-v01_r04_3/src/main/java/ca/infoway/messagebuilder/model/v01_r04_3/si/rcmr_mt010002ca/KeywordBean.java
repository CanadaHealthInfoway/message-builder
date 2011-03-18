/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.si.rcmr_mt010002ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ActInformationAccessTypeCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.common.coct_mt040205ca.ResponsiblePersonBean;
import ca.infoway.messagebuilder.model.v01_r04_3.merged.Consenter;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"RCMR_MT010002CA.KeywordEvent"})
@Hl7RootType
public class KeywordBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<CV> consentInformationTypes = new ArrayList<CV>();
    private ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean subject1Patient;
    private ST keyword = new STImpl();
    private Consenter authorConsenter;


    /**
     * <p>B:Consent Information Types</p>
     */
    @Hl7XmlMapping({"subject2/recordType/code"})
    public List<ActInformationAccessTypeCode> getConsentInformationTypes() {
        return new RawListWrapper<CV, ActInformationAccessTypeCode>(consentInformationTypes, CVImpl.class);
    }


    @Hl7XmlMapping({"subject1/patient"})
    public ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean getSubject1Patient() {
        return this.subject1Patient;
    }
    public void setSubject1Patient(ca.infoway.messagebuilder.model.v01_r04_3.common.merged.PatientBean subject1Patient) {
        this.subject1Patient = subject1Patient;
    }


    /**
     * <p>Keyword</p>
     */
    @Hl7XmlMapping({"author/signatureText"})
    public String getKeyword() {
        return this.keyword.getValue();
    }
    public void setKeyword(String keyword) {
        this.keyword.setValue(keyword);
    }


    @Hl7XmlMapping({"author/consenter"})
    public Consenter getAuthorConsenter() {
        return this.authorConsenter;
    }
    public void setAuthorConsenter(Consenter authorConsenter) {
        this.authorConsenter = authorConsenter;
    }

    public PatientBean getAuthorConsenterAsPatient() {
        return this.authorConsenter instanceof PatientBean ? (PatientBean) this.authorConsenter : null;
    }
    public boolean hasAuthorConsenterAsPatient() {
        return (this.authorConsenter instanceof PatientBean);
    }

    public ResponsiblePersonBean getAuthorConsenterAsResponsibleParty() {
        return this.authorConsenter instanceof ResponsiblePersonBean ? (ResponsiblePersonBean) this.authorConsenter : null;
    }
    public boolean hasAuthorConsenterAsResponsibleParty() {
        return (this.authorConsenter instanceof ResponsiblePersonBean);
    }

}
