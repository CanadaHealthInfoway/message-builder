/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.x_VeryBasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PRPM_MT301010CA.Privilege","PRPM_MT303010CA.Privilege","PRPM_MT306011CA.Privilege"})
public class PrivilegeBean extends MessagePartBean {

    private static final long serialVersionUID = 20100603L;
    private II restrictionsToPracticeIdentifier = new IIImpl();
    private CV restrictionsToPracticeType = new CVImpl();
    private BL restrictionsToPracticeNegationIndicator = new BLImpl();
    private ST restrictionsToPracticeText = new STImpl();
    private IVL<TS, Interval<Date>> restrictionsToPracticeEffectiveDate = new IVLImpl<TS, Interval<Date>>();
    private CV restrictionsToPracticeConfidentialityCode = new CVImpl();
    private List<PrivilegeCategorizationBean> subjectOfPrivilegeCategorization = new ArrayList<PrivilegeCategorizationBean>();

    @Hl7XmlMapping({"id"})
    public Identifier getRestrictionsToPracticeIdentifier() {
        return this.restrictionsToPracticeIdentifier.getValue();
    }
    public void setRestrictionsToPracticeIdentifier(Identifier restrictionsToPracticeIdentifier) {
        this.restrictionsToPracticeIdentifier.setValue(restrictionsToPracticeIdentifier);
    }

    @Hl7XmlMapping({"code"})
    public Code getRestrictionsToPracticeType() {
        return (Code) this.restrictionsToPracticeType.getValue();
    }
    public void setRestrictionsToPracticeType(Code restrictionsToPracticeType) {
        this.restrictionsToPracticeType.setValue(restrictionsToPracticeType);
    }

    @Hl7XmlMapping({"negationInd"})
    public Boolean getRestrictionsToPracticeNegationIndicator() {
        return this.restrictionsToPracticeNegationIndicator.getValue();
    }
    public void setRestrictionsToPracticeNegationIndicator(Boolean restrictionsToPracticeNegationIndicator) {
        this.restrictionsToPracticeNegationIndicator.setValue(restrictionsToPracticeNegationIndicator);
    }

    @Hl7XmlMapping({"text"})
    public String getRestrictionsToPracticeText() {
        return this.restrictionsToPracticeText.getValue();
    }
    public void setRestrictionsToPracticeText(String restrictionsToPracticeText) {
        this.restrictionsToPracticeText.setValue(restrictionsToPracticeText);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getRestrictionsToPracticeEffectiveDate() {
        return this.restrictionsToPracticeEffectiveDate.getValue();
    }
    public void setRestrictionsToPracticeEffectiveDate(Interval<Date> restrictionsToPracticeEffectiveDate) {
        this.restrictionsToPracticeEffectiveDate.setValue(restrictionsToPracticeEffectiveDate);
    }

    @Hl7XmlMapping({"confidentialityCode"})
    public x_VeryBasicConfidentialityKind getRestrictionsToPracticeConfidentialityCode() {
        return (x_VeryBasicConfidentialityKind) this.restrictionsToPracticeConfidentialityCode.getValue();
    }
    public void setRestrictionsToPracticeConfidentialityCode(x_VeryBasicConfidentialityKind restrictionsToPracticeConfidentialityCode) {
        this.restrictionsToPracticeConfidentialityCode.setValue(restrictionsToPracticeConfidentialityCode);
    }

    @Hl7XmlMapping({"subjectOf/privilegeCategorization"})
    public List<PrivilegeCategorizationBean> getSubjectOfPrivilegeCategorization() {
        return this.subjectOfPrivilegeCategorization;
    }

}
