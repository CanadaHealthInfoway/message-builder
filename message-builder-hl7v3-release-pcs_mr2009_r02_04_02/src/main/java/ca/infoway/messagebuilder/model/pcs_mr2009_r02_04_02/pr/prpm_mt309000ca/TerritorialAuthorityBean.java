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

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.pr.prpm_mt309000ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Territorial Authority</p>
 * 
 * <p><p>RoleClass necessary to support the Jurisdiction within 
 * which the scoping organization exists</p></p>
 * 
 * <p><p>Supports business requirement to provide additional 
 * information regarding the jurisdication within the scoping 
 * organization exists.</p></p>
 */
@Hl7PartTypeMapping({"PRPM_MT309000CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private CV territorialAuthorityType = new CVImpl();
    private CV jurisdictionType = new CVImpl();
    private TerritorialAuthorityBean partTerritorialAuthority;


    /**
     * <p>Territorial Authority Type</p>
     * 
     * <p><p>The code identifying the specific Territorial 
     * Authority</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     */
    @Hl7XmlMapping({"code"})
    public Code getTerritorialAuthorityType() {
        return (Code) this.territorialAuthorityType.getValue();
    }
    public void setTerritorialAuthorityType(Code territorialAuthorityType) {
        this.territorialAuthorityType.setValue(territorialAuthorityType);
    }


    /**
     * <p>Jurisdiction Type</p>
     * 
     * <p><p>A character value that represents the Canadian 
     * provincial or territorial geographical area within which the 
     * Provider is operating.</p></p>
     * 
     * <p><p>Populated attribute supports the validation and 
     * identification of the healthcare provider</p></p>
     * 
     * <p><p>If Jurisdiction is included in the message, then 
     * Territorial Authority Type is Expected to Exist.</p></p>
     */
    @Hl7XmlMapping({"territory/code"})
    public Code getJurisdictionType() {
        return (Code) this.jurisdictionType.getValue();
    }
    public void setJurisdictionType(Code jurisdictionType) {
        this.jurisdictionType.setValue(jurisdictionType);
    }


    @Hl7XmlMapping({"part/territorialAuthority"})
    public TerritorialAuthorityBean getPartTerritorialAuthority() {
        return this.partTerritorialAuthority;
    }
    public void setPartTerritorialAuthority(TerritorialAuthorityBean partTerritorialAuthority) {
        this.partTerritorialAuthority = partTerritorialAuthority;
    }

}
