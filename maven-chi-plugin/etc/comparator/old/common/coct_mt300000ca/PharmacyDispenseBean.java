/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.domainvalue.ActPharmacySupplyType;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodIntentEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.coct_mt280001ca.A_BillableActChoiceBean;
import ca.infoway.messagebuilder.model.merged.DispenseShipToLocationBean;
import java.util.Date;



/**
 * <p>Pharmacy Dispense 
 * 
 * <p>Patient classes are not referenced in the billable acts, 
 * as they are noted in the parent model (e.g. Invoice message) 
 * as the CoveredPartyAsPatient 
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SupplyEvent"})
@Hl7RootType
public class PharmacyDispenseBean extends MessagePartBean implements A_BillableActChoiceBean {

    private CS<x_ActMoodIntentEvent> moodCode = new CSImpl<x_ActMoodIntentEvent>();
    private CV<ActPharmacySupplyType> typeOfDispense = new CVImpl<ActPharmacySupplyType>();
    private TS dispenseTime = new TSImpl();
    private PQ totalDispensed = new PQImpl();
    private IVL<TS, Interval<Date>> dispensedDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private ProductBean product;
    private ResponsibleProviderBean performer;
    private DispenseShipToLocationBean originServiceDeliveryLocation;
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private DispenseInstructionsBean pertinentInformation;
    private EncounterInformationBean componentOf;

    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodIntentEvent getMoodCode() {
        return this.moodCode.getValue();
    }
    public void setMoodCode(x_ActMoodIntentEvent moodCode) {
        this.moodCode.setValue(moodCode);
    }

    @Hl7XmlMapping({"code"})
    public ActPharmacySupplyType getTypeOfDispense() {
        return this.typeOfDispense.getValue();
    }
    public void setTypeOfDispense(ActPharmacySupplyType typeOfDispense) {
        this.typeOfDispense.setValue(typeOfDispense);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Date getDispenseTime() {
        return this.dispenseTime.getValue();
    }
    public void setDispenseTime(Date dispenseTime) {
        this.dispenseTime.setValue(dispenseTime);
    }

    @Hl7XmlMapping({"quantity"})
    public PhysicalQuantity getTotalDispensed() {
        return this.totalDispensed.getValue();
    }
    public void setTotalDispensed(PhysicalQuantity totalDispensed) {
        this.totalDispensed.setValue(totalDispensed);
    }

    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getDispensedDaysSupply() {
        return this.dispensedDaysSupply.getValue();
    }
    public void setDispensedDaysSupply(Interval<Date> dispensedDaysSupply) {
        this.dispensedDaysSupply.setValue(dispensedDaysSupply);
    }

    @Hl7XmlMapping({"product"})
    public ProductBean getProduct() {
        return this.product;
    }
    public void setProduct(ProductBean product) {
        this.product = product;
    }

    @Hl7XmlMapping({"performer"})
    public ResponsibleProviderBean getPerformer() {
        return this.performer;
    }
    public void setPerformer(ResponsibleProviderBean performer) {
        this.performer = performer;
    }

    @Hl7XmlMapping({"origin/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getOriginServiceDeliveryLocation() {
        return this.originServiceDeliveryLocation;
    }
    public void setOriginServiceDeliveryLocation(DispenseShipToLocationBean originServiceDeliveryLocation) {
        this.originServiceDeliveryLocation = originServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }

    @Hl7XmlMapping({"pertinentInformation"})
    public DispenseInstructionsBean getPertinentInformation() {
        return this.pertinentInformation;
    }
    public void setPertinentInformation(DispenseInstructionsBean pertinentInformation) {
        this.pertinentInformation = pertinentInformation;
    }

    @Hl7XmlMapping({"componentOf"})
    public EncounterInformationBean getComponentOf() {
        return this.componentOf;
    }
    public void setComponentOf(EncounterInformationBean componentOf) {
        this.componentOf = componentOf;
    }

}
