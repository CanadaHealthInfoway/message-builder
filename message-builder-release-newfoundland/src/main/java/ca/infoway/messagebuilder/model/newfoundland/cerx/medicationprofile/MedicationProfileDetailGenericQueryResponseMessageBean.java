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

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("PORX_IN060360CA")
public class MedicationProfileDetailGenericQueryResponseMessageBean extends NewQueryResponseMessageBean<MedicationProfileDetailGenericQueryCriteriaBean, MedicationRecordBean> {

    private static final long serialVersionUID = -4581248172585519902L;

    public MedicationProfileDetailGenericQueryResponseMessageBean(ResponseMessageAttributesBean attributes, MedicationProfileDetailGenericQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public MedicationProfileDetailGenericQueryResponseMessageBean(MedicationProfileDetailGenericQueryCriteriaBean criteria) {
        super(criteria);
    }

    public MedicationProfileDetailGenericQueryResponseMessageBean() {
        this(new MedicationProfileDetailGenericQueryCriteriaBean());
    }
}
