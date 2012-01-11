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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.IVL;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.IVLImpl;
import ca.infoway.messagebuilder.datatype.impl.RawListWrapper;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.Interval;
import ca.infoway.messagebuilder.domainvalue.ActStatus;
import ca.infoway.messagebuilder.domainvalue.PrescriptionDispenseFilterCode;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * <p>UnfilledPrescriptionQueryParameters</p>
 * 
 * <p>PORX_MT060270CA.ParameterList: (no business name)</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 * 
 * <p>PORX_MT060240CA.ParameterList: Unfilled Prescription 
 * Query Parameters</p>
 * 
 * <p><p>Defines the set of parameters that may be used to 
 * filter the query response.</p></p>
 * 
 * <p><p>Root class for query definition</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT060240CA.ParameterList","PORX_MT060270CA.ParameterList"})
@Hl7RootType
public class UnfilledPrescriptionQueryParametersBean extends MessagePartBean {

    private static final long serialVersionUID = 20111208L;
    private IVL<TS, Interval<Date>> administrationEffectivePeriodValue = new IVLImpl<TS, Interval<Date>>();
    private II prescriberProviderIDValue = new IIImpl();
    private List<CV> prescriptionStatusValue = new ArrayList<CV>();
    private CV rxDispenseIndicatorValue = new CVImpl();


    /**
     * <p>AdministrationEffectivePeriod</p>
     * 
     * <p>E:Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     * 
     * <p>D:Administration Effective Period</p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Indicates the administration period for which the 
     * request/query applies.</p><p>Filter the result set to 
     * include only those medication records (prescription order, 
     * prescription dispense and other active medication) for which 
     * the patient was deemed to be taking the drug within the 
     * specified period.</p></p>
     * 
     * <p><p>Allows the requester to specify the administration 
     * period of interest for the retrieval. Useful for 
     * constraining run-away queries.</p></p>
     */
    @Hl7XmlMapping({"administrationEffectivePeriod/value"})
    public Interval<Date> getAdministrationEffectivePeriodValue() {
        return this.administrationEffectivePeriodValue.getValue();
    }
    public void setAdministrationEffectivePeriodValue(Interval<Date> administrationEffectivePeriodValue) {
        this.administrationEffectivePeriodValue.setValue(administrationEffectivePeriodValue);
    }


    /**
     * <p>PrescriberProviderID</p>
     * 
     * <p>D:Prescriber Provider ID</p>
     * 
     * <p><p>Identifier of the prescriber who created and/or 
     * supervised the prescriptions being retrieved.</p><p>The 
     * result set will be filtered to only include records which 
     * were either directly created by this provider, or were 
     * created 'under the supervision' of this provider.</p></p>
     * 
     * <p><p>Identifier of the prescriber who created and/or 
     * supervised the prescriptions being retrieved.</p><p>The 
     * result set will be filtered to only include records which 
     * were either directly created by this provider, or were 
     * created 'under the supervision' of this provider.</p></p>
     * 
     * <p><p>Allows for the retrieval of prescriptions based on a 
     * specific prescriber.</p></p>
     */
    @Hl7XmlMapping({"prescriberProviderID/value"})
    public Identifier getPrescriberProviderIDValue() {
        return this.prescriberProviderIDValue.getValue();
    }
    public void setPrescriberProviderIDValue(Identifier prescriberProviderIDValue) {
        this.prescriberProviderIDValue.setValue(prescriberProviderIDValue);
    }


    /**
     * <p>PrescriptionStatuses</p>
     * 
     * <p>E:Prescription Statuses</p>
     * 
     * <p><p>Indicates that prescriptions of a specific statuses 
     * are to be included in the result set. Allowable prescription 
     * status codes are: 'ABORTED, ACTIVE', 'COMPLETED', and 
     * 'SUSPENDED'.</p></p>
     * 
     * <p><p>Allows for the retrieval of patient prescriptions and 
     * dispenses based on the lifecycle state of the 
     * prescription.</p></p>
     */
    @Hl7XmlMapping({"prescriptionStatus/value"})
    public List<ActStatus> getPrescriptionStatusValue() {
        return new RawListWrapper<CV, ActStatus>(prescriptionStatusValue, CVImpl.class);
    }


    /**
     * <p>RxDispenseIndicator</p>
     * 
     * <p>Rx Dispense Indicator</p>
     * 
     * <p><p>A coded value indicating the dispensing (fill) status 
     * of the prescription to be included in the result set. The 
     * only allowable Rx Dispense Indicators is ND (Never 
     * Dispensed).</p></p>
     * 
     * <p><p>Allows for finer sub-set of prescriptions to be 
     * retrieved based on the fill status of the prescription.</p></p>
     */
    @Hl7XmlMapping({"rxDispenseIndicator/value"})
    public PrescriptionDispenseFilterCode getRxDispenseIndicatorValue() {
        return (PrescriptionDispenseFilterCode) this.rxDispenseIndicatorValue.getValue();
    }
    public void setRxDispenseIndicatorValue(PrescriptionDispenseFilterCode rxDispenseIndicatorValue) {
        this.rxDispenseIndicatorValue.setValue(rxDispenseIndicatorValue);
    }

}
