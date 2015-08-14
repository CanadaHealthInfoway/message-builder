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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt300000ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Playing Prescribe Person</p>
 * 
 * <p>ID cannot be mandatory as it may not be present on a 
 * pre-determination</p>
 */
@Hl7PartTypeMapping({"COCT_MT300000CA.PresriberRole"})
public class PlayingPrescribePersonBean extends MessagePartBean {

    private static final long serialVersionUID = 20150814L;
    private II id = new IIImpl();
    private PersonPrescribingBean playingPrescriberPerson;


    /**
     * <p>Business Name: Prescriber ID</p>
     * 
     * <p>Relationship: COCT_MT300000CA.PresriberRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>This is mandatory for Invoices and required with 
     * nullFlavor for Pre-Determinations.</p>
     * 
     * <p>Prescriber ID</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: Prescriber ID</p>
     * 
     * <p>Relationship: COCT_MT300000CA.PresriberRole.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>This is mandatory for Invoices and required with 
     * nullFlavor for Pre-Determinations.</p>
     * 
     * <p>Prescriber ID</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: 
     * COCT_MT300000CA.PresriberRole.playingPrescriberPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"playingPrescriberPerson"})
    public PersonPrescribingBean getPlayingPrescriberPerson() {
        return this.playingPrescriberPerson;
    }

    /**
     * <p>Relationship: 
     * COCT_MT300000CA.PresriberRole.playingPrescriberPerson</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setPlayingPrescriberPerson(PersonPrescribingBean playingPrescriberPerson) {
        this.playingPrescriberPerson = playingPrescriberPerson;
    }

}
