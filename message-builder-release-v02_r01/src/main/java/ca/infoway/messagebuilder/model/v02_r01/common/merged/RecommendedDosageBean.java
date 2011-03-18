/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v02_r01.common.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Hl7PartTypeMapping({"COCT_MT260010CA.SubstanceAdministrationEventCriterion","COCT_MT260020CA.SubstanceAdministrationEventCriterion","COCT_MT260030CA.SubstanceAdministrationEventCriterion"})
public class RecommendedDosageBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<DosagePreconditionsBean> componentObservationEventCriterion = new ArrayList<DosagePreconditionsBean>();
    private IVL<TS, Interval<Date>> doseDuration = new IVLImpl<TS, Interval<Date>>();
    private URG<PQ, PhysicalQuantity> dosageRange = new URGImpl<PQ, PhysicalQuantity>();


    @Hl7XmlMapping({"component/observationEventCriterion"})
    public List<DosagePreconditionsBean> getComponentObservationEventCriterion() {
        return this.componentObservationEventCriterion;
    }


    /**
     * <p>DoseDuration</p>
     * 
     * <p>A:Dose Duration</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getDoseDuration() {
        return this.doseDuration.getValue();
    }
    public void setDoseDuration(Interval<Date> doseDuration) {
        this.doseDuration.setValue(doseDuration);
    }


    /**
     * <p>DosageRange</p>
     * 
     * <p>B:Dosage Range</p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRange() {
        return this.dosageRange.getValue();
    }
    public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
        this.dosageRange.setValue(dosageRange);
    }

}
