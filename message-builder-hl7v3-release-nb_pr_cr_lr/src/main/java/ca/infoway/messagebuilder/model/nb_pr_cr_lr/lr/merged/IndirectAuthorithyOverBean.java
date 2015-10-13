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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRLO_MT000001CA.IndirectAuthorithyOver","PRLO_MT000002CA.IndirectAuthorithyOver","PRLO_MT202014CA.IndirectAuthorithyOver","PRLO_MT202015CA.IndirectAuthorithyOver"})
public class IndirectAuthorithyOverBean extends MessagePartBean {

    private static final long serialVersionUID = 20151013L;
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000001CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202014CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000002CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202015CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000001CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202014CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT000002CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRLO_MT202015CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
