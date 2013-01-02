/**
 * Copyright 2013 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.AllergyTestValue;
import ca.infoway.messagebuilder.domainvalue.ObservationAllergyTestType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.common.repc_mt000009ca.RecordsBean;
import java.util.Date;



@Hl7PartTypeMapping({"REPC_MT000001CA.AllergyTestEvent","REPC_MT000005CA.AllergyTestEvent","REPC_MT000009CA.AllergyTestEvent","REPC_MT000013CA.AllergyTestEvent"})
public class AllergyTestsBean extends MessagePartBean implements RecordsBean, ca.infoway.messagebuilder.model.merged.RecordsBean, ca.infoway.messagebuilder.model.common.repc_mt000005ca.RecordsBean {

    private II allergyTestRecordId = new IIImpl();
    private CD<ObservationAllergyTestType> allergyTestType = new CDImpl<ObservationAllergyTestType>();
    private TS allergyTestDate = new TSImpl();
    private CV<AllergyTestValue> allergyTestResult = new CVImpl<AllergyTestValue>();

    @Hl7XmlMapping({"id"})
    public Identifier getAllergyTestRecordId() {
        return this.allergyTestRecordId.getValue();
    }
    public void setAllergyTestRecordId(Identifier allergyTestRecordId) {
        this.allergyTestRecordId.setValue(allergyTestRecordId);
    }

    @Hl7XmlMapping({"code"})
    public ObservationAllergyTestType getAllergyTestType() {
        return this.allergyTestType.getValue();
    }
    public void setAllergyTestType(ObservationAllergyTestType allergyTestType) {
        this.allergyTestType.setValue(allergyTestType);
    }

    @Hl7XmlMapping({"effectiveTime"})
    public Date getAllergyTestDate() {
        return this.allergyTestDate.getValue();
    }
    public void setAllergyTestDate(Date allergyTestDate) {
        this.allergyTestDate.setValue(allergyTestDate);
    }

    @Hl7XmlMapping({"value"})
    public AllergyTestValue getAllergyTestResult() {
        return this.allergyTestResult.getValue();
    }
    public void setAllergyTestResult(AllergyTestValue allergyTestResult) {
        this.allergyTestResult.setValue(allergyTestResult);
    }

}
