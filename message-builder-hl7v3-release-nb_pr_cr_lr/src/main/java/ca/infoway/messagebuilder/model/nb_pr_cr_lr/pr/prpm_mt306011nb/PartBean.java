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
package ca.infoway.messagebuilder.model.nb_pr_cr_lr.pr.prpm_mt306011nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.domainvalue.RoleLinkType;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPM_MT306011NB.Part"})
public class PartBean extends MessagePartBean {

    private static final long serialVersionUID = 20150902L;
    private CS typeCode = new CSImpl();
    private TerritorialAuthorityBean territorialAuthority;


    /**
     * <p>Relationship: PRPM_MT306011NB.Part.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"typeCode"})
    public RoleLinkType getTypeCode() {
        return (RoleLinkType) this.typeCode.getValue();
    }

    /**
     * <p>Relationship: PRPM_MT306011NB.Part.typeCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setTypeCode(RoleLinkType typeCode) {
        this.typeCode.setValue(typeCode);
    }


    /**
     * <p>Relationship: PRPM_MT306011NB.Part.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"territorialAuthority"})
    public TerritorialAuthorityBean getTerritorialAuthority() {
        return this.territorialAuthority;
    }

    /**
     * <p>Relationship: PRPM_MT306011NB.Part.territorialAuthority</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setTerritorialAuthority(TerritorialAuthorityBean territorialAuthority) {
        this.territorialAuthority = territorialAuthority;
    }

}