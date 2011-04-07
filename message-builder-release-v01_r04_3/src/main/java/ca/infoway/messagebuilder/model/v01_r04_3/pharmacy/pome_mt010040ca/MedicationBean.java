/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.pome_mt010040ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.AppearanceCharacteristicsBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.DrugCostBean;
import ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged.MonographsBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"POME_MT010040CA.Medication"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private DrugOrCompoundBean player;
    private List<MonographsBean> subjectOf1Document = new ArrayList<MonographsBean>();
    private DrugHalfLifeBean subjectOf2HalfLife;
    private List<AppearanceCharacteristicsBean> subjectOf3Characteristic = new ArrayList<AppearanceCharacteristicsBean>();
    private List<MonitoringProgramsBean> subjectOf4MonitoringProgram = new ArrayList<MonitoringProgramsBean>();
    private DrugCostBean subjectOf5PotentialCharge;
    private List<RecommendedAdministrationInstructionsBean> consumedInAdministrationGuideline = new ArrayList<RecommendedAdministrationInstructionsBean>();
    private DispenseInformationBean productOf1DispenseGuidelines;
    private List<FormulariesBean> productOf2PotentialSupply = new ArrayList<FormulariesBean>();


    @Hl7XmlMapping({"player"})
    public DrugOrCompoundBean getPlayer() {
        return this.player;
    }
    public void setPlayer(DrugOrCompoundBean player) {
        this.player = player;
    }


    @Hl7XmlMapping({"subjectOf1/document"})
    public List<MonographsBean> getSubjectOf1Document() {
        return this.subjectOf1Document;
    }


    @Hl7XmlMapping({"subjectOf2/halfLife"})
    public DrugHalfLifeBean getSubjectOf2HalfLife() {
        return this.subjectOf2HalfLife;
    }
    public void setSubjectOf2HalfLife(DrugHalfLifeBean subjectOf2HalfLife) {
        this.subjectOf2HalfLife = subjectOf2HalfLife;
    }


    @Hl7XmlMapping({"subjectOf3/characteristic"})
    public List<AppearanceCharacteristicsBean> getSubjectOf3Characteristic() {
        return this.subjectOf3Characteristic;
    }


    @Hl7XmlMapping({"subjectOf4/monitoringProgram"})
    public List<MonitoringProgramsBean> getSubjectOf4MonitoringProgram() {
        return this.subjectOf4MonitoringProgram;
    }


    @Hl7XmlMapping({"subjectOf5/potentialCharge"})
    public DrugCostBean getSubjectOf5PotentialCharge() {
        return this.subjectOf5PotentialCharge;
    }
    public void setSubjectOf5PotentialCharge(DrugCostBean subjectOf5PotentialCharge) {
        this.subjectOf5PotentialCharge = subjectOf5PotentialCharge;
    }


    @Hl7XmlMapping({"consumedIn/administrationGuideline"})
    public List<RecommendedAdministrationInstructionsBean> getConsumedInAdministrationGuideline() {
        return this.consumedInAdministrationGuideline;
    }


    @Hl7XmlMapping({"productOf1/dispenseGuidelines"})
    public DispenseInformationBean getProductOf1DispenseGuidelines() {
        return this.productOf1DispenseGuidelines;
    }
    public void setProductOf1DispenseGuidelines(DispenseInformationBean productOf1DispenseGuidelines) {
        this.productOf1DispenseGuidelines = productOf1DispenseGuidelines;
    }


    @Hl7XmlMapping({"productOf2/potentialSupply"})
    public List<FormulariesBean> getProductOf2PotentialSupply() {
        return this.productOf2PotentialSupply;
    }

}
