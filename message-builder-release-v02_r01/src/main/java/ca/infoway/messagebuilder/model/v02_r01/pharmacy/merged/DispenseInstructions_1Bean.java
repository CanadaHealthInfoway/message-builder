/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActRelationshipType;
import ca.infoway.messagebuilder.domainvalue.ContextControl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.CreatedAtBean;
import ca.infoway.messagebuilder.model.v02_r01.merged.RelatedPersonBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt010120ca.DrugDispenseInstructionsBean;
import ca.infoway.messagebuilder.model.v02_r01.pharmacy.porx_mt010140ca.RemainingDispensesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"PORX_MT010110CA.SupplyRequest","PORX_MT010120CA.SupplyRequest","PORX_MT010140CA.SupplyRequest","PORX_MT060060CA.SupplyRequest"})
@Hl7RootType
public class DispenseInstructions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private IVL<TS, Interval<Date>> dispensingAllowedPeriod = new IVLImpl<TS, Interval<Date>>();
    private List<DrugDispenseInstructionsBean> componentSupplyRequestItem = new ArrayList<DrugDispenseInstructionsBean>();
    private List<RelatedPersonBean> receiverPersonalRelationship = new ArrayList<RelatedPersonBean>();
    private DispenseShipToLocationBean destinationServiceDeliveryLocation;
    private CreatedAtBean location;
    private INT totalPrescribedQuantity = new INTImpl();
    private SubstanceAdministrationRequestBean componentOfActRequest;
    private List<RemainingDispensesBean> fulfillmentSupplyEvent = new ArrayList<RemainingDispensesBean>();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private BL sourceOfContextConductionInd = new BLImpl();
    private CS sourceOfContextControlCode = new CSImpl();
    private CS sourceOfTypeCode = new CSImpl();
    private SupplementalFillInformationBean sourceOfSupplementalFillInformation;


    /**
     * <p>DispensingAllowedPeriod</p>
     * 
     * <p>A:Dispensing Allowed Period</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDispensingAllowedPeriod() {
        return this.dispensingAllowedPeriod.getValue();
    }
    public void setDispensingAllowedPeriod(Interval<Date> dispensingAllowedPeriod) {
        this.dispensingAllowedPeriod.setValue(dispensingAllowedPeriod);
    }


    @Hl7XmlMapping({"component/supplyRequestItem"})
    public List<DrugDispenseInstructionsBean> getComponentSupplyRequestItem() {
        return this.componentSupplyRequestItem;
    }


    @Hl7XmlMapping({"receiver/personalRelationship"})
    public List<RelatedPersonBean> getReceiverPersonalRelationship() {
        return this.receiverPersonalRelationship;
    }


    @Hl7XmlMapping({"destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getDestinationServiceDeliveryLocation() {
        return this.destinationServiceDeliveryLocation;
    }
    public void setDestinationServiceDeliveryLocation(DispenseShipToLocationBean destinationServiceDeliveryLocation) {
        this.destinationServiceDeliveryLocation = destinationServiceDeliveryLocation;
    }


    @Hl7XmlMapping({"location"})
    public CreatedAtBean getLocation() {
        return this.location;
    }
    public void setLocation(CreatedAtBean location) {
        this.location = location;
    }


    /**
     * <p>TotalPrescribedQuantity</p>
     * 
     * <p>B:Total Prescribed Quantity</p>
     */
    @Hl7XmlMapping({"quantity"})
    public Integer getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(Integer totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }


    @Hl7XmlMapping({"componentOf/actRequest"})
    public SubstanceAdministrationRequestBean getComponentOfActRequest() {
        return this.componentOfActRequest;
    }
    public void setComponentOfActRequest(SubstanceAdministrationRequestBean componentOfActRequest) {
        this.componentOfActRequest = componentOfActRequest;
    }


    @Hl7XmlMapping({"fulfillment/supplyEvent"})
    public List<RemainingDispensesBean> getFulfillmentSupplyEvent() {
        return this.fulfillmentSupplyEvent;
    }


    /**
     * <p>TotalDaysSupply</p>
     * 
     * <p>C:Total Days Supply</p>
     */
    @Hl7XmlMapping({"expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }


    @Hl7XmlMapping({"sourceOf/contextConductionInd"})
    public Boolean getSourceOfContextConductionInd() {
        return this.sourceOfContextConductionInd.getValue();
    }
    public void setSourceOfContextConductionInd(Boolean sourceOfContextConductionInd) {
        this.sourceOfContextConductionInd.setValue(sourceOfContextConductionInd);
    }


    @Hl7XmlMapping({"sourceOf/contextControlCode"})
    public ContextControl getSourceOfContextControlCode() {
        return (ContextControl) this.sourceOfContextControlCode.getValue();
    }
    public void setSourceOfContextControlCode(ContextControl sourceOfContextControlCode) {
        this.sourceOfContextControlCode.setValue(sourceOfContextControlCode);
    }


    @Hl7XmlMapping({"sourceOf/typeCode"})
    public ActRelationshipType getSourceOfTypeCode() {
        return (ActRelationshipType) this.sourceOfTypeCode.getValue();
    }
    public void setSourceOfTypeCode(ActRelationshipType sourceOfTypeCode) {
        this.sourceOfTypeCode.setValue(sourceOfTypeCode);
    }


    @Hl7XmlMapping({"sourceOf/supplementalFillInformation"})
    public SupplementalFillInformationBean getSourceOfSupplementalFillInformation() {
        return this.sourceOfSupplementalFillInformation;
    }
    public void setSourceOfSupplementalFillInformation(SupplementalFillInformationBean sourceOfSupplementalFillInformation) {
        this.sourceOfSupplementalFillInformation = sourceOfSupplementalFillInformation;
    }

}