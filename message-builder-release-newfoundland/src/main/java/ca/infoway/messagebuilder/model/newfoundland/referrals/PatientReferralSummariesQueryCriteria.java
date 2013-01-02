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

package ca.infoway.messagebuilder.model.newfoundland.referrals;

import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.BL;
import ca.infoway.messagebuilder.datatype.impl.BLImpl;
import ca.infoway.messagebuilder.model.newfoundland.QueryCriteria;

public class PatientReferralSummariesQueryCriteria extends QueryCriteria {

    private static final long serialVersionUID = 8347085172294469697L;

    private final BL mostRecentByTypeIndicator = new BLImpl(false);

    @Hl7XmlMapping("mostRecentByTypeIndicator/value")
    public boolean isMostRecentByTypeIndicator() {
        return this.mostRecentByTypeIndicator.getValue();
    }

    public void setMostRecentByTypeIndicator(boolean mostRecentByTypeIndicator) {
        this.mostRecentByTypeIndicator.setValue(mostRecentByTypeIndicator);
    }
}
