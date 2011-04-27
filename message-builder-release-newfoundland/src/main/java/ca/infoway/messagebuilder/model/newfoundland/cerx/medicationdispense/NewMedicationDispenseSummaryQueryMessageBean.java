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

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationdispense;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

@Hl7PartTypeMapping("PORX_IN060230CA")
public class NewMedicationDispenseSummaryQueryMessageBean extends NewQueryMessageBean<MedicationDispenseSummaryQueryCriteriaBean> {

    private static final long serialVersionUID = -1529723287636359486L;

    public NewMedicationDispenseSummaryQueryMessageBean() {
        this(new MedicationDispenseSummaryQueryCriteriaBean());
    }

    public NewMedicationDispenseSummaryQueryMessageBean(MedicationDispenseSummaryQueryCriteriaBean criteria) {
        super(criteria);
    }
}
