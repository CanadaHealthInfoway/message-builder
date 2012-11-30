/**
 * Copyright 2012 Canada Health Infoway, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.IssuesBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.x_ActPriorityPharmacy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Expected Start Time</p>
 * 
 * <p>Expected start time. For methadone, this indicated when 
 * the drug is expected to be taken.</p>
 * 
 * <p>ID cannot be mandatory as it may not be present on a 
 * pre-determination</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SubstanceAdministrationIntent"})
public class ExpectedStartTimeBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private II id = new IIImpl();
    private IVL<TS, Interval<Date>> effectiveTime = new IVLImpl<TS, Interval<Date>>();
    private CV priorityCode = new CVImpl();
    private OriginalPrescriptionOrderBean inFulfillmentOfSubstanceAdministrationOrder;
    private DispenseSubstitutionBean componentSubstitution;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Dispense ID</p>
     * 
     * <p>filler transaction number for dispense</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Dispense ID</p>
     * 
     * <p>filler transaction number for dispense</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Substance Administration Time</p>
     * 
     * <p>Used effectiveTime for methadone only</p>
     * 
     * <p>Substance Administration Time</p>
     * 
     * <p>(For methadone, this indicates when the drug is expected 
     * to be taken</p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getEffectiveTime() {
        return this.effectiveTime.getValue();
    }

    /**
     * <p>Substance Administration Time</p>
     * 
     * <p>Used effectiveTime for methadone only</p>
     * 
     * <p>Substance Administration Time</p>
     * 
     * <p>(For methadone, this indicates when the drug is expected 
     * to be taken</p>
     */
    public void setEffectiveTime(Interval<Date> effectiveTime) {
        this.effectiveTime.setValue(effectiveTime);
    }


    /**
     * <p>In lieu of days supply.</p>
     * 
     * <p>In lieu of days supply, specify PRN, UD or use NullFlavor 
     * of UNK (unknown), else not specified.</p>
     * 
     * <p>In lieu of days supply, specify PRN, UD or use NullFlavor 
     * of UNK (unknown), else not specified.</p>
     * 
     * <p>for PRN, UD or unknown (use NullFlavor</p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public x_ActPriorityPharmacy getPriorityCode() {
        return (x_ActPriorityPharmacy) this.priorityCode.getValue();
    }

    /**
     * <p>In lieu of days supply.</p>
     * 
     * <p>In lieu of days supply, specify PRN, UD or use NullFlavor 
     * of UNK (unknown), else not specified.</p>
     * 
     * <p>In lieu of days supply, specify PRN, UD or use NullFlavor 
     * of UNK (unknown), else not specified.</p>
     * 
     * <p>for PRN, UD or unknown (use NullFlavor</p>
     */
    public void setPriorityCode(x_ActPriorityPharmacy priorityCode) {
        this.priorityCode.setValue(priorityCode);
    }


    @Hl7XmlMapping({"inFulfillmentOf/substanceAdministrationOrder"})
    public OriginalPrescriptionOrderBean getInFulfillmentOfSubstanceAdministrationOrder() {
        return this.inFulfillmentOfSubstanceAdministrationOrder;
    }

    public void setInFulfillmentOfSubstanceAdministrationOrder(OriginalPrescriptionOrderBean inFulfillmentOfSubstanceAdministrationOrder) {
        this.inFulfillmentOfSubstanceAdministrationOrder = inFulfillmentOfSubstanceAdministrationOrder;
    }


    @Hl7XmlMapping({"component/substitution"})
    public DispenseSubstitutionBean getComponentSubstitution() {
        return this.componentSubstitution;
    }

    public void setComponentSubstitution(DispenseSubstitutionBean componentSubstitution) {
        this.componentSubstitution = componentSubstitution;
    }


    @Hl7XmlMapping({"subjectOf/detectedIssueEvent"})
    public List<IssuesBean> getSubjectOfDetectedIssueEvent() {
        return this.subjectOfDetectedIssueEvent;
    }

}
