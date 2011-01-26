/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.ClinicalDrug;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Antigens</p>
 * 
 * <p>POIZ_MT030060CA.Antigens: Antigens</p>
 * 
 * <p><p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p></p>
 * 
 * <p><p>Important for expressing antigen validity and 
 * counts.</p></p>
 * 
 * <p>POIZ_MT030050CA.Antigens: Antigens</p>
 * 
 * <p><p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p></p>
 * 
 * <p><p>Important for expressing antigen validity and 
 * counts.</p></p>
 * 
 * <p>POIZ_MT060150CA.Antigens: Antigens</p>
 * 
 * <p><p>A list of antigens that may or be present in a vaccine 
 * administered to a patient.</p></p>
 * 
 * <p><p>Important for expressing antigen validity and 
 * counts.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Antigens","POIZ_MT030060CA.Antigens","POIZ_MT060150CA.Antigens"})
public class AntigensBean extends MessagePartBean {

    private static final long serialVersionUID = 20110126L;
    private HealthChartBean asHealthChart;
    private CV antigenCode = new CVImpl();
    private ST antigenName = new STImpl();


    @Hl7XmlMapping({"asHealthChart"})
    public HealthChartBean getAsHealthChart() {
        return this.asHealthChart;
    }
    public void setAsHealthChart(HealthChartBean asHealthChart) {
        this.asHealthChart = asHealthChart;
    }


    /**
     * <p>AntigenCode</p>
     * 
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
     * <p>AntigenName</p>
     * 
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
