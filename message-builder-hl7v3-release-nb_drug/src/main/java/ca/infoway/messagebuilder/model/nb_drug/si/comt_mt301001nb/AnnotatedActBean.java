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
package ca.infoway.messagebuilder.model.nb_drug.si.comt_mt301001nb;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.nb_drug.common.coct_mt050202nb.PatientBean;



@Hl7PartTypeMapping({"COMT_MT301001NB.AnnotatedAct"})
public class AnnotatedActBean extends MessagePartBean {

    private static final long serialVersionUID = 20150901L;
    private II id = new IIImpl();
    private PatientBean subjectPatient;


    /**
     * <p>Business Name: A:Record Id</p>
     * 
     * <p>Relationship: COMT_MT301001NB.AnnotatedAct.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the record item being annotated.</p>
     * 
     * <p>An existing record identifier must be specified against 
     * which the note will be recorded. The record identifier must 
     * be a valid DIS record identifier and specified in the 
     * &ldquo;id&rdquo; element in the message path &ldquo;/subject 
     * /annotation /subject /annotatedAct&rdquo;.</p> <p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Record Id</p>
     * 
     * <p>Relationship: COMT_MT301001NB.AnnotatedAct.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows the record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the record item being annotated.</p>
     * 
     * <p>An existing record identifier must be specified against 
     * which the note will be recorded. The record identifier must 
     * be a valid DIS record identifier and specified in the 
     * &ldquo;id&rdquo; element in the message path &ldquo;/subject 
     * /annotation /subject /annotatedAct&rdquo;.</p> <p></p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Relationship: COMT_MT301001NB.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"subject/patient"})
    public PatientBean getSubjectPatient() {
        return this.subjectPatient;
    }

    /**
     * <p>Relationship: COMT_MT301001NB.Subject2.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setSubjectPatient(PatientBean subjectPatient) {
        this.subjectPatient = subjectPatient;
    }

}