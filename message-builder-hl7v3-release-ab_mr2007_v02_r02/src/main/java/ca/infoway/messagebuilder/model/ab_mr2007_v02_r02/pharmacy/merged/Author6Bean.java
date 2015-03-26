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
package ca.infoway.messagebuilder.model.ab_mr2007_v02_r02.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.TS;
import ca.infoway.messagebuilder.datatype.impl.TSImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Date;



/**
 * <p>Business Name: ChangedBy</p>
 * 
 * <p>PORX_MT060040CA.Author1: *changed by</p>
 * 
 * <p>Identity of the health service provider or application 
 * responsible for the change in the prescription status.</p>
 * 
 * <p>In an EHR integrated health services environment, it is 
 * important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is mandatory because provider or application 
 * maintaining the prescription must be known.</p>
 * 
 * <p>In an EHR integrated health services environment, it is 
 * important that other providers are able to query who (or 
 * what application) is responsible for status changes. Also 
 * used by applications for auditing and sorting.</p><p>The 
 * attribute is mandatory because provider or application 
 * maintaining the prescription must be known.</p>
 * 
 * <p>PORX_MT060210CA.Author7: *changed by</p>
 * 
 * <p>Identity of the health service provider or the 
 * application responsible for the change in the other 
 * medication status.</p>
 * 
 * <p>In an EHR integrated health services environment, it is 
 * important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting. The attribute is marked as 
 * &quot;mandatory&quot; because provider or application 
 * maintaining the other medication must be known.</p>
 * 
 * <p>PORX_MT060090CA.Author6: *changed by</p>
 * 
 * <p>Identity of the health service provider or the 
 * application responsible for the change in the prescription 
 * dispense status.</p>
 * 
 * <p>In an EHR integrated health services environment, it is 
 * important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting. The attribute is mandatory because 
 * provider or application maintaining the prescription 
 * dispense must be known.</p>
 * 
 * <p>PORX_MT060010CA.Author6: *changed by</p>
 * 
 * <p>Identity of the health service provider or the 
 * application responsible for the change in the prescription 
 * dispense status.</p>
 * 
 * <p>In an EHR integrated health services environment, it is 
 * important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting.</p><p>The attribute is populated 
 * because provider or application maintaining the prescription 
 * dispense must be known else an appropriate 'null' flavor 
 * must be specified.</p>
 * 
 * <p>In an EHR integrated health services environment, it is 
 * important that other providers are able to query who is 
 * responsible for status changes. Also used by applications 
 * for auditing and sorting.</p><p>The attribute is populated 
 * because provider or application maintaining the prescription 
 * dispense must be known else an appropriate 'null' flavor 
 * must be specified.</p>
 */
@Hl7PartTypeMapping({"PORX_MT060010CA.Author6","PORX_MT060040CA.Author1","PORX_MT060090CA.Author6","PORX_MT060210CA.Author7"})
public class Author6Bean extends MessagePartBean {

    private static final long serialVersionUID = 20150326L;
    private TS time = new TSImpl();
    private ChangedBy changedBy;


    /**
     * <p>Business Name: ChangeTimestamp</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>This 
     * attribute is marked as &quot;mandatory&quot; as the time the 
     * comment was posted will always be known.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>This 
     * attribute is marked as &quot;mandatory&quot; as the time the 
     * comment was posted will always be known.</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Author7.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date and time at which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the other medication. 
     * Also used for sorting and audit purposes.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the time of change must 
     * be known.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the other medication. 
     * Also used for sorting and audit purposes.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the time of change must 
     * be known.</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author6.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date and time at which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit purposes.</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author6.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date and time at which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit 
     * purposes.</p><p>The attribute is mandatory as the time of 
     * change is known.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit 
     * purposes.</p><p>The attribute is mandatory as the time of 
     * change is known.</p>
     */
    @Hl7XmlMapping({"time"})
    public Date getTime() {
        return this.time.getValue();
    }

    /**
     * <p>Business Name: ChangeTimestamp</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author1.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date on which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>This 
     * attribute is marked as &quot;mandatory&quot; as the time the 
     * comment was posted will always be known.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription. 
     * Also used for sorting and audit purposes.</p><p>This 
     * attribute is marked as &quot;mandatory&quot; as the time the 
     * comment was posted will always be known.</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Author7.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date and time at which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the other medication. 
     * Also used for sorting and audit purposes.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the time of change must 
     * be known.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the other medication. 
     * Also used for sorting and audit purposes.</p><p>Attribute is 
     * marked as &quot;mandatory&quot; as the time of change must 
     * be known.</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author6.time</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>The date and time at which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit purposes.</p>
     * 
     * <p>Un-merged Business Name: ChangeTimestamp</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author6.time</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>The date and time at which the change was made.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit 
     * purposes.</p><p>The attribute is mandatory as the time of 
     * change is known.</p>
     * 
     * <p>Gives other providers the frame of reference in 
     * evaluating any post-change issues with the prescription 
     * dispense. Also used for sorting and audit 
     * purposes.</p><p>The attribute is mandatory as the time of 
     * change is known.</p>
     */
    public void setTime(Date time) {
        this.time.setValue(time);
    }


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author1.changedBy</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Author7.changedBy</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author6.changedBy</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author6.changedBy</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"changedBy"})
    public ChangedBy getChangedBy() {
        return this.changedBy;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060040CA.Author1.changedBy</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060210CA.Author7.changedBy</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060010CA.Author6.changedBy</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: PORX_MT060090CA.Author6.changedBy</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setChangedBy(ChangedBy changedBy) {
        this.changedBy = changedBy;
    }

}
