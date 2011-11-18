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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ResultSortKey</p>
 * 
 * <p>POLB_MT004000CA.ResultSortKey: Result Sort Key</p>
 * 
 * <p><p>String used for sorting of results.</p></p>
 * 
 * <p><p>OLIS needs an alphanumeric sort key string to a test 
 * result to allow a laboratory to provide sorting information 
 * for test results.</p></p>
 * 
 * <p>POLB_MT004200CA.ResultSortKey: Result Sort Key</p>
 * 
 * <p><p>This must not be linked at ObservationReport 
 * level.</p></p>
 * 
 * <p><p>String used for sorting of results.</p></p>
 * 
 * <p><p>OLIS needs an alphanumeric sort key string to a test 
 * result to allow a laboratory to provide sorting information 
 * for test results.</p></p>
 */
@Hl7PartTypeMapping({"POLB_MT004000CA.ResultSortKey","POLB_MT004100CA.ResultSortKey","POLB_MT004200CA.ResultSortKey"})
public class ResultSortKeyBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private ST text = new STImpl();


    /**
     * <p>SortKeyText</p>
     * 
     * <p>Sort Key Text</p>
     * 
     * <p>Sort Key Text</p>
     * 
     * <p><p>Value used for sorting results.</p></p>
     * 
     * <p><p>Attribute for communicating the actual sort key 
     * value.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public String getText() {
        return this.text.getValue();
    }
    public void setText(String text) {
        this.text.setValue(text);
    }

}
