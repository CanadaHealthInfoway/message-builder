/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: ResultSortKey</p>
 * 
 * <p>POLB_MT004000CA.ResultSortKey: Result Sort Key</p>
 * 
 * <p>OLIS needs an alphanumeric sort key string to a test 
 * result to allow a laboratory to provide sorting information 
 * for test results.</p>
 * 
 * <p>String used for sorting of results.</p>
 * 
 * <p>POLB_MT004200CA.ResultSortKey: Result Sort Key</p>
 * 
 * <p>This must not be linked at ObservationReport level.</p>
 * 
 * <p>OLIS needs an alphanumeric sort key string to a test 
 * result to allow a laboratory to provide sorting information 
 * for test results.</p>
 * 
 * <p>String used for sorting of results.</p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ResultSortKey","POLB_MT004100CA.ResultSortKey","POLB_MT004200CA.ResultSortKey"})
public class ResultSortKeyBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private ST text = new STImpl();


    /**
     * <p>Business Name: SortKeyText</p>
     * 
     * <p>Other Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     * 
     * <p>Other Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT004200CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     * 
     * <p>Other Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT004100CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: SortKeyText</p>
     * 
     * <p>Other Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT004000CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     * 
     * <p>Other Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT004200CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting results.</p>
     * 
     * <p>Other Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT004100CA.ResultSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
