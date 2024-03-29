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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.BecauseOfBean;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT220001CA.DocumentContent","REPC_MT220002CA.DocumentContent","REPC_MT220003CA.DocumentContent"})
public interface DocumentContent_2 {


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220001CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220002CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: REPC_MT220003CA.DocumentContent.reason</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     */
    public List<BecauseOfBean> getReason();

}
