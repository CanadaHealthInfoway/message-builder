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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: OrderSortKey</p>
 * 
 * <p>POLB_MT001001CA.RequestSortKey: Order Sort Key</p>
 * 
 * <p>OLIS needs an alphanumeric sort key string to a test 
 * request to allow a laboratory to provide sorting information 
 * for test requests within an order.</p>
 * 
 * <p>String used for sorting of orders.</p>
 * 
 * <p>POLB_MT001000CA.RequestSortKey: Order Sort Key</p>
 * 
 * <p>OLIS needs an alphanumeric sort key string to a test 
 * request to allow a laboratory to provide sorting information 
 * for test requests within an order.</p>
 * 
 * <p>String used for sorting of orders.</p>
 * 
 * <p>POLB_MT001999CA.RequestSortKey: Order Sort Key</p>
 * 
 * <p>OLIS needs an alphanumeric sort key string to a test 
 * request to allow a laboratory to provide sorting information 
 * for test requests within an order.</p>
 * 
 * <p>String used for sorting of orders.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.RequestSortKey","POLB_MT001001CA.RequestSortKey","POLB_MT001999CA.RequestSortKey"})
public class OrderSortKeyBean extends MessagePartBean {

    private static final long serialVersionUID = 20150904L;
    private ST text = new STImpl();


    /**
     * <p>Business Name: SortKeyText</p>
     * 
     * <p>Un-merged Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT001001CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     * 
     * <p>Un-merged Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT001000CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     * 
     * <p>Un-merged Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT001999CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: SortKeyText</p>
     * 
     * <p>Un-merged Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT001001CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     * 
     * <p>Un-merged Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT001000CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     * 
     * <p>Un-merged Business Name: SortKeyText</p>
     * 
     * <p>Relationship: POLB_MT001999CA.RequestSortKey.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Attribute for communicating the actual sort key 
     * value.</p>
     * 
     * <p>Value used for sorting orders.</p>
     */
    public void setText(String text) {
        this.text.setValue(text);
    }

}
