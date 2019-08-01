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
package ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.common.coct_mt120600on;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.domainvalue.HumanLanguage;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.on_cerx_v01_r04_3.merged.RefusedByBean;



/**
 * <p>Business Name: Notes</p>
 * 
 * <p>Public Health requires all clinical notes to be 
 * 'verified' by a responsible party if not created by 
 * physician in charge. This model conveys the correct 
 * semantics, but is inconsistent with other uses of 
 * &quot;author&quot; participation in POIZ models. Any changes 
 * here will have to be reconciled with other projects using 
 * this same cmet.</p>
 * 
 * <p>Allows various Providers to attach comments to an 
 * existing record, and thus improving cross-provider 
 * communications.</p>
 * 
 * <p>This is a list of comments made about the record by 
 * providers. Information captured here includes the provider 
 * making the comments; and excludes information that would 
 * render the record invalid. This information will only be 
 * seen when another provider reviews the record. Urgent or 
 * targeted messages should be sent using a different mechanism 
 * (e.g. phone).</p>
 */
@Hl7PartTypeMapping({"COCT_MT120600ON.Annotation"})
@Hl7RootType
public class NotesBean extends MessagePartBean {

    private static final long serialVersionUID = 20190731L;
    private ST text = new STImpl();
    private CV languageCode = new CVImpl();
    private RefusedByBean author;


    /**
     * <p>Business Name: Note Text</p>
     * 
     * <p>Relationship: COCT_MT120600ON.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free text comments. Additional textual iinformation 
     * entered about an object.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Note Text</p>
     * 
     * <p>Relationship: COCT_MT120600ON.Annotation.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Allows a provider to attach comments to objects for 
     * communication. This attribute is mandatory because there's 
     * no point in having a note class unless there's actually 
     * content in the note.</p>
     * 
     * <p>Free text comments. Additional textual iinformation 
     * entered about an object.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }


    /**
     * <p>Business Name: Written in</p>
     * 
     * <p>Relationship: COCT_MT120600ON.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows providers to write notes in the language of their 
     * choice.</p><p>This attribute is marked as 'populated' 
     * because the language of the note must always be 
     * known/available or a null flavor must be specified.</p>
     * 
     * <p>A coded value denoting the language in which the note is 
     * written.</p>
     */
    @Hl7XmlMapping({"languageCode"})
    public HumanLanguage getLanguageCode() {
        return (HumanLanguage) this.languageCode.getValue();
    }

    /**
     * <p>Business Name: Written in</p>
     * 
     * <p>Relationship: COCT_MT120600ON.Annotation.languageCode</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Allows providers to write notes in the language of their 
     * choice.</p><p>This attribute is marked as 'populated' 
     * because the language of the note must always be 
     * known/available or a null flavor must be specified.</p>
     * 
     * <p>A coded value denoting the language in which the note is 
     * written.</p>
     */
    public void setLanguageCode(HumanLanguage languageCode) {
        this.languageCode.setValue(languageCode);
    }


    /**
     * <p>Relationship: COCT_MT120600ON.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"author"})
    public RefusedByBean getAuthor() {
        return this.author;
    }

    /**
     * <p>Relationship: COCT_MT120600ON.Annotation.author</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setAuthor(RefusedByBean author) {
        this.author = author;
    }

}
