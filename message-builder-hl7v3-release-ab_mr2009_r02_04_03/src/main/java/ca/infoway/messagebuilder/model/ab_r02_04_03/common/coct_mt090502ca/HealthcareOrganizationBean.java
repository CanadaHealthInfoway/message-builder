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
package ca.infoway.messagebuilder.model.ab_r02_04_03.common.coct_mt090502ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_r02_04_03.common.merged.ResponsibleOrganizationBean;



/**
 * <p>Business Name: Healthcare Organization</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up.</p>
 * 
 * <p>The organization under whose authority the associated 
 * action (linked by a participation) was performed.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090502CA.AssignedEntity"})
@Hl7RootType
public class HealthcareOrganizationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ab_r02_04_03.common.merged.EntererChoice, ca.infoway.messagebuilder.model.ab_r02_04_03.common.coct_mt080100ca.PerformerChoice, ca.infoway.messagebuilder.model.ab_r02_04_03.common.merged.AuthorPerson_2, ca.infoway.messagebuilder.model.ab_r02_04_03.common.coct_mt911102ca.ActingPerson, ca.infoway.messagebuilder.model.ab_r02_04_03.common.coct_mt011001ca.Assignees {

    private static final long serialVersionUID = 20150302L;
    private ResponsibleOrganizationBean representedOrganization;


    /**
     * <p>Relationship: 
     * COCT_MT090502CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    /**
     * <p>Relationship: 
     * COCT_MT090502CA.AssignedEntity.representedOrganization</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
