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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r01.pharmacy.porx_mt060110ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.IssueFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



@Hl7PartTypeMapping({"PORX_MT060110CA.ParameterList"})
@Hl7RootType
public class ParameterListBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private CV issueFilterCodeValue = new CVImpl();
    private BL mostRecentByDrugIndicatorValue = new BLImpl();
    private BL mostRecentDispenseForEachRxIndicatorValue = new BLImpl();


    /**
     * <p>D:Administration Effective Period</p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>Issue Filter Code</p>
     */
    @Hl7XmlMapping({"issueFilterCode/value"})
    public IssueFilterCode getIssueFilterCodeValue() {
        return (IssueFilterCode) this.issueFilterCodeValue.getValue();
    }
    public void setIssueFilterCodeValue(IssueFilterCode issueFilterCodeValue) {
        this.issueFilterCodeValue.setValue(issueFilterCodeValue);
    }


    /**
     * <p>Most Recent By Drug Indicator</p>
     */
    @Hl7XmlMapping({"mostRecentByDrugIndicator/value"})
    public Boolean getMostRecentByDrugIndicatorValue() {
        return this.mostRecentByDrugIndicatorValue.getValue();
    }
    public void setMostRecentByDrugIndicatorValue(Boolean mostRecentByDrugIndicatorValue) {
        this.mostRecentByDrugIndicatorValue.setValue(mostRecentByDrugIndicatorValue);
    }


    /**
     * <p>Most Recent Dispense for each Rx Indicator</p>
     */
    @Hl7XmlMapping({"mostRecentDispenseForEachRxIndicator/value"})
    public Boolean getMostRecentDispenseForEachRxIndicatorValue() {
        return this.mostRecentDispenseForEachRxIndicatorValue.getValue();
    }
    public void setMostRecentDispenseForEachRxIndicatorValue(Boolean mostRecentDispenseForEachRxIndicatorValue) {
        this.mostRecentDispenseForEachRxIndicatorValue.setValue(mostRecentDispenseForEachRxIndicatorValue);
    }

}
