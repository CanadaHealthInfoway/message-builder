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

package ca.infoway.messagebuilder.model.newfoundland.cerx.unfilledprescription;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.deviceprescription.BasePrescriptionBean;

@Hl7PartTypeMapping("PORX_IN060500CA")
public class UnfilledPrescriptionQueryResponseMessageBean extends NewQueryResponseMessageBean<UnfilledPrescriptionQueryCriteriaBean, BasePrescriptionBean> {

    private static final long serialVersionUID = 3611260208598786095L;

    public UnfilledPrescriptionQueryResponseMessageBean(ResponseMessageAttributesBean attributes, UnfilledPrescriptionQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public UnfilledPrescriptionQueryResponseMessageBean(UnfilledPrescriptionQueryCriteriaBean criteria) {
        super(criteria);
    }

    public UnfilledPrescriptionQueryResponseMessageBean() {
        this(new UnfilledPrescriptionQueryCriteriaBean());
    }
}
