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

package ca.infoway.messagebuilder.model.newfoundland.cerx.adversereaction;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryResponseMessageBean;
import ca.infoway.messagebuilder.model.newfoundland.ResponseMessageAttributesBean;

@Hl7PartTypeMapping("REPC_IN000002CA")
public class PatientAdverseReactionQueryResponseMessageBean extends NewQueryResponseMessageBean<PatientAdverseReactionQueryCriteriaBean, AdverseReactionBean> {

    private static final long serialVersionUID = 7165135264265155338L;

    public PatientAdverseReactionQueryResponseMessageBean(ResponseMessageAttributesBean attributes, PatientAdverseReactionQueryCriteriaBean criteria) {
        super(attributes, criteria);
    }

    public PatientAdverseReactionQueryResponseMessageBean(PatientAdverseReactionQueryCriteriaBean criteria) {
        super(criteria);
    }

    public PatientAdverseReactionQueryResponseMessageBean() {
        this(new PatientAdverseReactionQueryCriteriaBean());
    }
}
