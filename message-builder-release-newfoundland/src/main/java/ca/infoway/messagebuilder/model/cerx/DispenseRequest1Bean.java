package ca.infoway.messagebuilder.model.cerx;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;

@Hl7PartTypeMapping({ "PORX_MT020070CA.MedicationDispense" })
public class DispenseRequest1Bean extends BaseDispenseRequestBean implements Serializable {

    private static final long serialVersionUID = -2095634015394561160L;

    private SupplyEventBean supplyEvent;

    private final List<DosageInstructionBean> dosageInstructions = Collections.synchronizedList(new ArrayList<DosageInstructionBean>());

    private SubstitutionMadeBean substitutionMade;

    private SubstanceAdministrationRequestBean substanceAdministrationRequest;

    @Hl7XmlMapping("component1/substitutionMade")
    public SubstitutionMadeBean getSubstitutionMade() {
        return substitutionMade;
    }
    public void setSubstitutionMade(SubstitutionMadeBean substitutionMade) {
        this.substitutionMade = substitutionMade;
    }

    @Hl7XmlMapping({ "component2/dosageInstruction" })
    public List<DosageInstructionBean> getDosageInstructions() {
        return dosageInstructions;
    }

    @Hl7XmlMapping({ "component3/supplyEvent" })
    public SupplyEventBean getSupplyEvent() {
        return supplyEvent;
    }

    public void setSupplyEvent(SupplyEventBean supplyEvent) {
        this.supplyEvent = supplyEvent;
    }

    @Hl7XmlMapping({ "inFulfillmentOf/substanceAdministrationRequest" })
    public SubstanceAdministrationRequestBean getSubstanceAdministrationRequest() {
        return substanceAdministrationRequest;
    }

    public void setSubstanceAdministrationRequest(SubstanceAdministrationRequestBean substanceAdministrationRequest) {
        this.substanceAdministrationRequest = substanceAdministrationRequest;
    }

}
