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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PRPA_MT202301CA.TerritorialAuthority","PRPA_MT202302CA.TerritorialAuthority","PRPA_MT202303CA.TerritorialAuthority","PRPA_MT202317CA.TerritorialAuthority"})
public class TerritorialAuthorityBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private II id = new IIImpl();


    /**
     * <p>LocationRegionId</p>
     * 
     * <p>H: Location Region Id</p>
     * 
     * <p><p>Identifies the health region associated with the 
     * service delivery location (if any).</p></p>
     * 
     * <p><p>In Canada, many service delivery locations are 
     * organized into regions for administrative, coordination 
     * and/or funding reasons. Regions may influence where a 
     * patient may go for services. They may also be used for 
     * searching.</p><p>Because not all service delivery locations 
     * are associated with a region, this element is only 
     * 'populated' to allow null flavors such as 'NA'.</p></p>
     * 
     * <p><p>In Canada, many service delivery locations are 
     * organized into regions for administrative, coordination 
     * and/or funding reasons. Regions may influence where a 
     * patient may go for services. They may also be used for 
     * searching.</p><p>Because not all service delivery locations 
     * are associated with a region, this element is only 
     * 'populated' to allow null flavors such as 'NA'.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
