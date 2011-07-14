/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pcs_cerx_v01_r04_3.merged;

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



/**
 * <p>RecommendedDosage</p>
 * 
 * <p>PORX_MT980030CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the outer dosage boundaries that were exceeded and triggered 
 * the issue. Included in this information are the 
 * drug-specific recommended dosage ranges for various age 
 * groups and weight classes.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
 * reference for calculating optimum dose of medication for 
 * patients.</p></p>
 * 
 * <p>PORX_MT980020CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the outer dosage boundaries that were exceeded and triggered 
 * the issue. Included in this information are the 
 * drug-specific recommended dosage ranges for various age 
 * groups, weight classes, etc.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
 * reference for calculating optimum dose of medication for 
 * patients.</p></p>
 * 
 * <p>PORX_MT980010CA.SubstanceAdministrationEventCriterion: 
 * Recommended Dosage</p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Identifies 
 * the outer dosage boundaries that were exceeded and triggered 
 * the issue. Included in this information are the 
 * drug-specific recommended dosage ranges for various age 
 * groups and weight classes.</p></p>
 * 
 * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Provides a 
 * reference for calculating optimum dose of medication for 
 * patients.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980010CA.SubstanceAdministrationEventCriterion","PORX_MT980020CA.SubstanceAdministrationEventCriterion","PORX_MT980030CA.SubstanceAdministrationEventCriterion"})
public class RecommendedDosageBean extends MessagePartBean {

    private static final long serialVersionUID = 20110714L;
    private IVL<TS, Interval<Date>> doseDuration = new IVLImpl<TS, Interval<Date>>();
    private URG<PQ, PhysicalQuantity> dosageRange = new URGImpl<PQ, PhysicalQuantity>();
    private List<DosagePreconditionsBean> componentObservationEventCriterion = new ArrayList<DosagePreconditionsBean>();


    /**
     * <p>DoseDuration</p>
     * 
     * <p>A:Dose Duration</p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Indicates 
     * the recommended duration for drug therapy that was exceeded 
     * or not met.</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Recommended 
     * Duration (width)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * calculation of amount under or over.</p></p>
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
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">This is a 
     * specification of the range of quantity of medication 
     * (Min/Max figures) that is recommended for the drug to avoid 
     * triggering of dosage issues.</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ContraIndication.recommendedRange</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Maximum Dosage 
     * Level (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Minimum Dosage 
     * Level (low)</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ContraIndication.recommendedRange</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Maximum Dosage 
     * Level (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Minimum Dosage 
     * Level (low)</p></p>
     * 
     * <p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">ContraIndication.recommendedRange</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Maximum Dosage 
     * Level (high)</p><p 
     * xmlns:html="http://www.w3.org/1999/xhtml">Minimum Dosage 
     * Level (low)</p></p>
     * 
     * <p><p xmlns:html="http://www.w3.org/1999/xhtml">Allows 
     * calculation of amount over/under.</p></p>
     */
    @Hl7XmlMapping({"doseQuantity"})
    public UncertainRange<PhysicalQuantity> getDosageRange() {
        return this.dosageRange.getValue();
    }
    public void setDosageRange(UncertainRange<PhysicalQuantity> dosageRange) {
        this.dosageRange.setValue(dosageRange);
    }


    @Hl7XmlMapping({"component/observationEventCriterion"})
    public List<DosagePreconditionsBean> getComponentObservationEventCriterion() {
        return this.componentObservationEventCriterion;
    }

}
