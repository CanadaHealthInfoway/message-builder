/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
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
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT010110CA.Component6","PORX_MT060040CA.Component6"})
public class Component6_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20100615L;
    private INT totalPrescribedQuantity = new INTImpl();
    private IVL<TS, Interval<Date>> totalDaysSupply = new IVLImpl<TS, Interval<Date>>();
    private TargetedToPharmacyBean supplyRequestLocation;
    private CS supplyRequestSourceOfTypeCode = new CSImpl();
    private CS supplyRequestSourceOfContextControlCode = new CSImpl();
    private BL supplyRequestSourceOfContextConductionInd = new BLImpl();
    private SupplementalFillInformationBean supplyRequestSourceOfSupplementalFillInformation;
    private DispenseShipToLocationBean supplyRequestDestinationServiceDeliveryLocation;

    @Hl7XmlMapping({"supplyRequest/quantity"})
    public Integer getTotalPrescribedQuantity() {
        return this.totalPrescribedQuantity.getValue();
    }
    public void setTotalPrescribedQuantity(Integer totalPrescribedQuantity) {
        this.totalPrescribedQuantity.setValue(totalPrescribedQuantity);
    }

    @Hl7XmlMapping({"supplyRequest/expectedUseTime"})
    public Interval<Date> getTotalDaysSupply() {
        return this.totalDaysSupply.getValue();
    }
    public void setTotalDaysSupply(Interval<Date> totalDaysSupply) {
        this.totalDaysSupply.setValue(totalDaysSupply);
    }

    @Hl7XmlMapping({"supplyRequest/location"})
    public TargetedToPharmacyBean getSupplyRequestLocation() {
        return this.supplyRequestLocation;
    }
    public void setSupplyRequestLocation(TargetedToPharmacyBean supplyRequestLocation) {
        this.supplyRequestLocation = supplyRequestLocation;
    }

    @Hl7XmlMapping({"supplyRequest/sourceOf/typeCode"})
    public ActRelationshipType getSupplyRequestSourceOfTypeCode() {
        return (ActRelationshipType) this.supplyRequestSourceOfTypeCode.getValue();
    }
    public void setSupplyRequestSourceOfTypeCode(ActRelationshipType supplyRequestSourceOfTypeCode) {
        this.supplyRequestSourceOfTypeCode.setValue(supplyRequestSourceOfTypeCode);
    }

    @Hl7XmlMapping({"supplyRequest/sourceOf/contextControlCode"})
    public ContextControl getSupplyRequestSourceOfContextControlCode() {
        return (ContextControl) this.supplyRequestSourceOfContextControlCode.getValue();
    }
    public void setSupplyRequestSourceOfContextControlCode(ContextControl supplyRequestSourceOfContextControlCode) {
        this.supplyRequestSourceOfContextControlCode.setValue(supplyRequestSourceOfContextControlCode);
    }

    @Hl7XmlMapping({"supplyRequest/sourceOf/contextConductionInd"})
    public Boolean getSupplyRequestSourceOfContextConductionInd() {
        return this.supplyRequestSourceOfContextConductionInd.getValue();
    }
    public void setSupplyRequestSourceOfContextConductionInd(Boolean supplyRequestSourceOfContextConductionInd) {
        this.supplyRequestSourceOfContextConductionInd.setValue(supplyRequestSourceOfContextConductionInd);
    }

    @Hl7XmlMapping({"supplyRequest/sourceOf/supplementalFillInformation"})
    public SupplementalFillInformationBean getSupplyRequestSourceOfSupplementalFillInformation() {
        return this.supplyRequestSourceOfSupplementalFillInformation;
    }
    public void setSupplyRequestSourceOfSupplementalFillInformation(SupplementalFillInformationBean supplyRequestSourceOfSupplementalFillInformation) {
        this.supplyRequestSourceOfSupplementalFillInformation = supplyRequestSourceOfSupplementalFillInformation;
    }

    @Hl7XmlMapping({"supplyRequest/destination/serviceDeliveryLocation"})
    public DispenseShipToLocationBean getSupplyRequestDestinationServiceDeliveryLocation() {
        return this.supplyRequestDestinationServiceDeliveryLocation;
    }
    public void setSupplyRequestDestinationServiceDeliveryLocation(DispenseShipToLocationBean supplyRequestDestinationServiceDeliveryLocation) {
        this.supplyRequestDestinationServiceDeliveryLocation = supplyRequestDestinationServiceDeliveryLocation;
    }

}
