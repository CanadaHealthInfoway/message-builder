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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.si.comt_mt301001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Comment</p>
 * 
 * <p>Allows comments to be attached to a Patient record. A 
 * Patient record can pertain to demographic or clinical (Drug, 
 * Condition, Lab, DI, etc) information.</p>
 * 
 * <p>Identifies the comments to be recorded against a 
 * Patient's record.</p>
 */
@Hl7PartTypeMapping({"COMT_MT301001CA.Annotation"})
@Hl7RootType
public class CommentBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private ST text = new STImpl();
    private CV languageCode = new CVImpl();
    private SET<II, Identifier> subjectAnnotatedActId = new SETImpl<II, Identifier>(IIImpl.class);


    /**
     * <p>Business Name: C:Annotation Text</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach arbitrary comments to 
     * clinical records (prescription, dispenses, lab results, 
     * allergies, etc) for communication. This attribute is 
     * mandatory because there's no point in having an annotation 
     * unless there's actually content in the note.</p>
     * 
     * <p>Free text comment to be attached to a record.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: C:Annotation Text</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach arbitrary comments to 
     * clinical records (prescription, dispenses, lab results, 
     * allergies, etc) for communication. This attribute is 
     * mandatory because there's no point in having an annotation 
     * unless there's actually content in the note.</p>
     * 
     * <p>Free text comment to be attached to a record.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: D:Written in</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: D:Written in</p>
     * 
     * <p>Relationship: COMT_MT301001CA.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Business Name: A:Record Id</p>
     * 
     * <p>Relationship: COMT_MT301001CA.AnnotatedAct.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1-2)</p>
     * 
     * <p>Allows the record to be uniquely referenced and is 
     * therefore mandatory.</p>
     * 
     * <p>The identifier assigned by the central system (EHR) to 
     * the record item being annotated.</p>
     */
    @Hl7XmlMapping({"subject/annotatedAct/id"})
    public Set<Identifier> getSubjectAnnotatedActId() {
        return this.subjectAnnotatedActId.rawSet();
    }

}
