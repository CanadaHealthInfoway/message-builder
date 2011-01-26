/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.poiz_mt061150ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.immunization.merged.AntigenValidityBean;



/**
 * <p>Antigen</p>
 * 
 * <p><p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p></p>
 * 
 * <p><p>Important for expressing antigen validity and 
 * counts.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT061150CA.Antigen"})
public class AntigenBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private INT antigenCountValue = new INTImpl();
    private AntigenValidityBean asHealthChartSubjectOf1AntigenValidity;
    private CV antigenCode = new CVImpl();
    private ST antigenName = new STImpl();


    /**
     * <p>Antigen Count Value</p>
     * 
     * <p><p>Represents the asserted antigen count.</p></p>
     * 
     * <p><p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p></p>
     */
    @Hl7XmlMapping({"asHealthChart/subjectOf2/antigenCount/value"})
    public Integer getAntigenCountValue() {
        return this.antigenCountValue.getValue();
    }
    public void setAntigenCountValue(Integer antigenCountValue) {
        this.antigenCountValue.setValue(antigenCountValue);
    }


    @Hl7XmlMapping({"asHealthChart/subjectOf1/antigenValidity"})
    public AntigenValidityBean getAsHealthChartSubjectOf1AntigenValidity() {
        return this.asHealthChartSubjectOf1AntigenValidity;
    }
    public void setAsHealthChartSubjectOf1AntigenValidity(AntigenValidityBean asHealthChartSubjectOf1AntigenValidity) {
        this.asHealthChartSubjectOf1AntigenValidity = asHealthChartSubjectOf1AntigenValidity;
    }


    /**
     * <p>Antigen Code</p>
     * 
     * <p><p>The unique code used to identify the antigen.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p></p>
     * 
     * <p><p>Allows un-ambiguous identification of the ingredients 
     * of a drug for performing various alert checking.</p><p>Also 
     * allows for the identification of antigens as specific class 
     * of ingredients in vaccines.</p></p>
     */
    @Hl7XmlMapping({"code"})
    public ClinicalDrug getAntigenCode() {
        return (ClinicalDrug) this.antigenCode.getValue();
    }
    public void setAntigenCode(ClinicalDrug antigenCode) {
        this.antigenCode.setValue(antigenCode);
    }


    /**
     * <p>Antigen Name</p>
     * 
     * <p><p>The name of the antigen contained within a 
     * vaccine.</p></p>
     * 
     * <p><p>Used for communication between and display to 
     * providers.</p></p>
     */
    @Hl7XmlMapping({"name"})
    public String getAntigenName() {
        return this.antigenName.getValue();
    }
    public void setAntigenName(String antigenName) {
        this.antigenName.setValue(antigenName);
    }

}
