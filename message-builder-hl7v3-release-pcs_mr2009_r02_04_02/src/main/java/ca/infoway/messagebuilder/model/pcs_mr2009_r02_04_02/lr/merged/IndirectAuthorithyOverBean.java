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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT202301CA.IndirectAuthorithyOver","PRPA_MT202302CA.IndirectAuthorithyOver","PRPA_MT202303CA.IndirectAuthorithyOver","PRPA_MT202317CA.IndirectAuthorithyOver"})
public class IndirectAuthorithyOverBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202302CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202301CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202317CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202302CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202301CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202303CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * PRPA_MT202317CA.IndirectAuthorithyOver.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}
