package ca.infoway.messagebuilder.model.cerx.medicationprofile;

import java.io.Serializable;
import java.util.Date;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.model.MessagePartBean;

@Hl7PartTypeMapping({ "PORX_MT060060CA.SupplyEventLastSummary", "PORX_MT060060CA.SupplyEventFirstSummary", "PORX_MT030040CA.SupplyEventFirstSummary", "PORX_MT030040CA.SupplyEventLastSummary", "PORX_MT060040CA.SupplyEventLastSummary", "PORX_MT060040CA.SupplyEventFirstSummary", "PORX_MT060190CA.SupplyEventFirstSummary", "PORX_MT060190CA.SupplyEventLastSummary" })
public class SupplySummaryBean extends MessagePartBean implements Serializable {

    private static final long serialVersionUID = -4201997691703158920L;

    private PQ quantity = new PQImpl();

    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();

    @Hl7XmlMapping("quantity")
    public PhysicalQuantity getQuantity() {
        return this.quantity.getValue();
    }

    public void setQuantity(PhysicalQuantity quantity) {
        this.quantity.setValue(quantity);
    }

    @Hl7XmlMapping("effectiveTime")
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }
}
