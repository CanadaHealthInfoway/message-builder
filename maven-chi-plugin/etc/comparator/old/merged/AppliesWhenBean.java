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
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.PQ;
import ca.infoway.messagebuilder.datatype.URG;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.PQImpl;
import ca.infoway.messagebuilder.datatype.impl.URGImpl;
import ca.infoway.messagebuilder.datatype.lang.PhysicalQuantity;
import ca.infoway.messagebuilder.datatype.lang.UncertainRange;
import ca.infoway.messagebuilder.domainvalue.ObservationDosageDefinitionPreconditionType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT260010CA.Component2","COCT_MT260020CA.Component2","COCT_MT260030CA.Component2"})
public class AppliesWhenBean extends MessagePartBean {

    private CV<ObservationDosageDefinitionPreconditionType> dosagePreconditionType = new CVImpl<ObservationDosageDefinitionPreconditionType>();
    private URG<PQ, PhysicalQuantity> dosagePreconditionValue = new URGImpl<PQ, PhysicalQuantity>();

    @Hl7XmlMapping({"observationEventCriterion/code"})
    public ObservationDosageDefinitionPreconditionType getDosagePreconditionType() {
        return this.dosagePreconditionType.getValue();
    }
    public void setDosagePreconditionType(ObservationDosageDefinitionPreconditionType dosagePreconditionType) {
        this.dosagePreconditionType.setValue(dosagePreconditionType);
    }

    @Hl7XmlMapping({"observationEventCriterion/value"})
    public UncertainRange<PhysicalQuantity> getDosagePreconditionValue() {
        return this.dosagePreconditionValue.getValue();
    }
    public void setDosagePreconditionValue(UncertainRange<PhysicalQuantity> dosagePreconditionValue) {
        this.dosagePreconditionValue.setValue(dosagePreconditionValue);
    }

}
