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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.claims.qucr_mt810201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Provider ID</p>
 * 
 * <p>Provider is the health care practitioner or goods 
 * provider that is providing the service or good that is being 
 * invoiced (e.g. Pharmacist and not Ordering Physician).</p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsProviderRole"})
public class ProviderIDBean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private II id = new IIImpl();


    /**
     * <p>Business Name: Summary Breakdown Provider ID</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsProviderRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of provider for summary breakdowns.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Summary Breakdown Provider ID</p>
     * 
     * <p>Relationship: QUCR_MT810201CA.AdjudResultsProviderRole.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identity of provider for summary breakdowns.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
