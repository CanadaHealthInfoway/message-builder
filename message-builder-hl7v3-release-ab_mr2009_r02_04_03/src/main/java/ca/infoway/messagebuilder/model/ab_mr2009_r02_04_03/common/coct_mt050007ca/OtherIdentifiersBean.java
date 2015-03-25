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
package ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.common.coct_mt050007ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ab_mr2009_r02_04_03.domainvalue.OtherIdentifiersRoleType;



/**
 * <p>Business Name: Other Identifiers</p>
 * 
 * <p>Used for patient identification.</p>
 * 
 * <p>This role object is used to store any other patient 
 * identification identifiers.</p>
 */
@Hl7PartTypeMapping({"COCT_MT050007CA.IdentifiedEntity"})
public class OtherIdentifiersBean extends MessagePartBean {

    private static final long serialVersionUID = 20150325L;
    private II id = new IIImpl();
    private CV code = new CVImpl();


    /**
     * <p>Business Name: K:Other Identifier</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other identification numbers associated with identifying 
     * a patient.</p>
     * 
     * <p>Alternate Identifiers for the Patient (e.g., Driver'''s 
     * License number, Health insurance number).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: K:Other Identifier</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Other identification numbers associated with identifying 
     * a patient.</p>
     * 
     * <p>Alternate Identifiers for the Patient (e.g., Driver'''s 
     * License number, Health insurance number).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: J:Other Identifier Type</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to set the type of identier</p>
     * 
     * <p>Describes the identification type (driver's license, 
     * etc.)</p>
     */
    @Hl7XmlMapping({"code"})
    public OtherIdentifiersRoleType getCode() {
        return (OtherIdentifiersRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: J:Other Identifier Type</p>
     * 
     * <p>Relationship: COCT_MT050007CA.IdentifiedEntity.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Used to set the type of identier</p>
     * 
     * <p>Describes the identification type (driver's license, 
     * etc.)</p>
     */
    public void setCode(OtherIdentifiersRoleType code) {
        this.code.setValue(code);
    }

}
