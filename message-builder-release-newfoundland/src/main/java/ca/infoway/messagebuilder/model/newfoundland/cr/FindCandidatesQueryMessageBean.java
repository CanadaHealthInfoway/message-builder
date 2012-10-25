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

package ca.infoway.messagebuilder.model.newfoundland.cr;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.newfoundland.NewQueryMessageBean;

/**
 * <p>Find Candidates Query</p>
 * 
 * <p>This interaction sends a query to a Person Registry requesting a list of 
 * candidates that match a particular set of person demographics.</p>
 * 
 * @author administrator
 */
@Hl7PartTypeMapping("PRPA_IN101103CA")
public class FindCandidatesQueryMessageBean extends NewQueryMessageBean<FindCandidatesCriteria> {

    private static final long serialVersionUID = 8365557396616384144L;

    public FindCandidatesQueryMessageBean() {
        super(new FindCandidatesCriteria());
    }

    public FindCandidatesQueryMessageBean(FindCandidatesCriteria criteria) {
        super(criteria);
    }
}
