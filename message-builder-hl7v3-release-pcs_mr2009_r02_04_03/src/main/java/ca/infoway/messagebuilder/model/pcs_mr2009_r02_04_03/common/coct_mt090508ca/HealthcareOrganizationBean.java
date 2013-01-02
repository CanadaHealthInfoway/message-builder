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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt090508ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.ResponsibleOrganizationBean;



/**
 * <p>Business Name: Healthcare Organization</p>
 * 
 * <p>Critical to tracking responsibility and performing 
 * follow-up.</p>
 * 
 * <p>All attributes other than the various identifiers are 
 * expected to be retrieved from the provider registry.</p>
 * 
 * <p>The organization under whose authority the associated 
 * (linked by a participation) action is performed</p>
 */
@Hl7PartTypeMapping({"COCT_MT090508CA.AssignedEntity"})
@Hl7RootType
public class HealthcareOrganizationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged.RecipientChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged.RoleChoice, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt911108ca.ActingPerson {

    private static final long serialVersionUID = 20121204L;
    private ResponsibleOrganizationBean representedOrganization;


    @Hl7XmlMapping({"representedOrganization"})
    public ResponsibleOrganizationBean getRepresentedOrganization() {
        return this.representedOrganization;
    }

    public void setRepresentedOrganization(ResponsibleOrganizationBean representedOrganization) {
        this.representedOrganization = representedOrganization;
    }

}
