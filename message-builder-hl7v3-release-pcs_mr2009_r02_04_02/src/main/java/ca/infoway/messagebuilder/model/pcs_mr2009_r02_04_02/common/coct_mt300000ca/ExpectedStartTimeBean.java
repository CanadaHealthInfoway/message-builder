/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt300000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.IssuesBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>Expected Start Time</p>
 * 
 * <p><p>Expected start time. For methadone, this indicated 
 * when the drug is expected to be taken.</p></p>
 * 
 * <p><p>ID cannot be mandatory as it may not be present on a 
 * pre-determination</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.SubstanceAdministrationIntent"})
public class ExpectedStartTimeBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II dispenseID = new IIImpl();
    private IVL<TS, Interval<Date>> substanceAdministrationTime = new IVLImpl<TS, Interval<Date>>();
    private CV inLieuOfDaysSupply = new CVImpl();
    private OriginalPrescriptionOrderBean inFulfillmentOfSubstanceAdministrationOrder;
    private DispenseSubstitutionBean componentSubstitution;
    private List<IssuesBean> subjectOfDetectedIssueEvent = new ArrayList<IssuesBean>();


    /**
     * <p>Dispense ID</p>
     * 
     * <p><p>filler transaction number for dispense</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getDispenseID() {
        return this.dispenseID.getValue();
    }
    public void setDispenseID(Identifier dispenseID) {
        this.dispenseID.setValue(dispenseID);
    }


    /**
     * <p>Substance Administration Time</p>
     * 
     * <p><p>Used effectiveTime for methadone only</p></p>
     * 
     * <p><p>Substance Administration Time</p></p>
     * 
     * <p><p>(For methadone, this indicates when the drug is 
     * expected to be taken</p></p>
     */
    @Hl7XmlMapping({"effectiveTime"})
    public Interval<Date> getSubstanceAdministrationTime() {
        return this.substanceAdministrationTime.getValue();
    }
    public void setSubstanceAdministrationTime(Interval<Date> substanceAdministrationTime) {
        this.substanceAdministrationTime.setValue(substanceAdministrationTime);
    }


    /**
     * <p>In lieu of days supply.</p>
     * 
     * <p><p>In lieu of days supply, specify PRN, UD or use 
     * NullFlavor of UNK (unknown), else not specified.</p></p>
     * 
     * <p><p>In lieu of days supply, specify PRN, UD or use 
     * NullFlavor of UNK (unknown), else not specified.</p></p>
     * 
     * <p><p>for PRN, UD or unknown (use NullFlavor</p></p>
     */
    @Hl7XmlMapping({"priorityCode"})
    public Code getInLieuOfDaysSupply() {
        return (Code) this.inLieuOfDaysSupply.getValue();
    }
    public void setInLieuOfDaysSupply(Code inLieuOfDaysSupply) {
        this.inLieuOfDaysSupply.setValue(inLieuOfDaysSupply);
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
