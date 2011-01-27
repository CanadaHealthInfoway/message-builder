/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.lab.polb_mt004200ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ANY;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.ANYImpl;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_BasicConfidentialityKind;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;
import java.util.Set;



/**
 * <p>Report Section Observation</p>
 * 
 * <p><p>Any report sections reported at the header or report 
 * level (not specific to a specimen or diagnosis).</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004200CA.ReportLevelObservationEvent"})
public class ReportSectionObservationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private ANY<Object> reportSectionObservationValue = new ANYImpl<Object>();
    private CD reportSectionObservationType = new CDImpl();
    private ST noteType = new STImpl();
    private II sectionIdentifier = new IIImpl();
    private SET<CV, Code> resultMaskingIndicator = new SETImpl<CV, Code>(CVImpl.class);
    private TS reportSectionObservationDateTime = new TSImpl();


    /**
     * <p>Report Section Observation Value</p>
     * 
     * <p><p>The report section values - usually this is 
     * text-based. If a coded value applies, values must be 
     * selected from the SectionHeadingObservationValue Concept 
     * Domain.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Object getReportSectionObservationValue() {
        return this.reportSectionObservationValue.getValue();
    }
    public void setReportSectionObservationValue(Object reportSectionObservationValue) {
        this.reportSectionObservationValue.setValue(reportSectionObservationValue);
    }


    /**
     * <p>Report Section Observation Type</p>
     * 
     * <p><p>Specifies the type of report section.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getReportSectionObservationType() {
        return (Code) this.reportSectionObservationType.getValue();
    }
    public void setReportSectionObservationType(Code reportSectionObservationType) {
        this.reportSectionObservationType.setValue(reportSectionObservationType);
    }


    /**
     * <p>Note Type</p>
     * 
     * <p><p>Type of comment or note.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getNoteType() {
        return this.noteType.getValue();
    }
    public void setNoteType(String noteType) {
        this.noteType.setValue(noteType);
    }


    /**
     * <p>Section Identifier</p>
     * 
     * <p><p>Unique identifier for a section of the report at the 
     * ObservationReport level.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getSectionIdentifier() {
        return this.sectionIdentifier.getValue();
    }
    public void setSectionIdentifier(Identifier sectionIdentifier) {
        this.sectionIdentifier.setValue(sectionIdentifier);
    }


    /**
     * <p>Result Masking Indicator</p>
     */
    @Hl7XmlMapping({"confidentialityCode"})
    public Set<x_BasicConfidentialityKind> getResultMaskingIndicator() {
        return this.resultMaskingIndicator.rawSet(x_BasicConfidentialityKind.class);
    }


    /**
     * <p>Report Section Observation Date/Time</p>
     * 
     * <p><p>The date/time this report section was 
     * &quot;reported&quot;.</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Date getReportSectionObservationDateTime() {
        return this.reportSectionObservationDateTime.getValue();
    }
    public void setReportSectionObservationDateTime(Date reportSectionObservationDateTime) {
        this.reportSectionObservationDateTime.setValue(reportSectionObservationDateTime);
    }

}
