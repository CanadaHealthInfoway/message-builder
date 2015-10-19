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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.pr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



@Hl7PartTypeMapping({"PRPM_MT303011AB.HealthCareProvider","PRPM_MT303012AB.HealthCareProvider","PRPM_MT303013AB.HealthCareProvider"})
public class HealthCareProviderBean extends MessagePartBean {

    private static final long serialVersionUID = 20151019L;
    private SET<II, Identifier> id = new SETImpl<II, Identifier>(IIImpl.class);
    private CV code = new CVImpl();


    /**
     * <p>Business Name: HealthCareProviderRoleIdentification</p>
     * 
     * <p>Un-merged Business Name: 
     * HealthCareProviderRoleIdentification</p>
     * 
     * <p>Relationship: PRPM_MT303011AB.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     * 
     * <p>Un-merged Business Name: 
     * HealthCareProviderRoleIdentification</p>
     * 
     * <p>Relationship: PRPM_MT303012AB.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     * 
     * <p>Un-merged Business Name: 
     * HealthCareProviderRoleIdentification</p>
     * 
     * <p>Relationship: PRPM_MT303013AB.HealthCareProvider.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-10)</p>
     * 
     * <p>Allows lookup on college website, confirmation of 
     * identity, etc. Regulations occasionally require license 
     * numbers to be specified as part of clinical records.</p>
     * 
     * <p>If the identifier used in the root of the CMET is the 
     * same as the license number, the license number should be 
     * sent in both places.</p>
     * 
     * <p>The license number issued to the provider and relevant to 
     * the current action.</p>
     */
    @Hl7XmlMapping({"id"})
    public Set<Identifier> getId() {
        return this.id.rawSet();
    }


    /**
     * <p>Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Un-merged Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Relationship: PRPM_MT303011AB.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some circumstances, license number isn't unique.</p>
     * 
     * <p>Identifies the type of role being linked</p>
     * 
     * <p>Un-merged Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Relationship: PRPM_MT303012AB.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Relationship: PRPM_MT303013AB.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some circumstances, license number isn't unique.</p>
     * 
     * <p>Identifies the type of role being nullified</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Un-merged Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Relationship: PRPM_MT303011AB.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some circumstances, license number isn't unique.</p>
     * 
     * <p>Identifies the type of role being linked</p>
     * 
     * <p>Un-merged Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Relationship: PRPM_MT303012AB.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: HealthCareProviderRoleType</p>
     * 
     * <p>Relationship: PRPM_MT303013AB.HealthCareProvider.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>In some circumstances, license number isn't unique.</p>
     * 
     * <p>Identifies the type of role being nullified</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }

}
