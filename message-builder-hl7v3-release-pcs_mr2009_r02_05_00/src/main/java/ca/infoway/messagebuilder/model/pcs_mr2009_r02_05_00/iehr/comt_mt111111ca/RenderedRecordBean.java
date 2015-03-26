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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.iehr.comt_mt111111ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_05_00.domainvalue.ActEventCategoryWorkingListCode;



/**
 * <p>Business Name: Rendered Record</p>
 * 
 * <p>Allows simple applications which do not yet support all 
 * of the discrete messaging specifications to still access 
 * data within the EHR.</p>
 * 
 * <p>Conveys a portion of the patient's record as rendered 
 * content.</p>
 */
@Hl7PartTypeMapping({"COMT_MT111111CA.RenderedContent"})
public class RenderedRecordBean extends MessagePartBean implements Summary {

    private static final long serialVersionUID = 20150326L;
    private CV code = new CVImpl();
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();


    /**
     * <p>Business Name: Rendered Content Type</p>
     * 
     * <p>Relationship: COMT_MT111111CA.RenderedContent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what type of data has been returned. This 
     * attribute is mandatory because type of data returned must be 
     * known for presentation and consumption.</p>
     * 
     * <p>Identifies the type of content contained within the 
     * rendered document portion of this class.</p>
     */
    @Hl7XmlMapping({"code"})
    public ActEventCategoryWorkingListCode getCode() {
        return (ActEventCategoryWorkingListCode) this.code.getValue();
    }

    /**
     * <p>Business Name: Rendered Content Type</p>
     * 
     * <p>Relationship: COMT_MT111111CA.RenderedContent.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Identifies what type of data has been returned. This 
     * attribute is mandatory because type of data returned must be 
     * known for presentation and consumption.</p>
     * 
     * <p>Identifies the type of content contained within the 
     * rendered document portion of this class.</p>
     */
    public void setCode(ActEventCategoryWorkingListCode code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: Rendered Content</p>
     * 
     * <p>Relationship: COMT_MT111111CA.RenderedContent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of a portion of a 
     * patient's record when the PoS application may not be capable 
     * of handling the discrete data. This attribute is mandatory 
     * because the rendered content must be known.</p>
     * 
     * <p>Contains a rendered view of a particular portion of the 
     * patients records. E.g. Allergy List, Problem List, Drug 
     * List, etc.</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: Rendered Content</p>
     * 
     * <p>Relationship: COMT_MT111111CA.RenderedContent.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Provides a human-readable view of a portion of a 
     * patient's record when the PoS application may not be capable 
     * of handling the discrete data. This attribute is mandatory 
     * because the rendered content must be known.</p>
     * 
     * <p>Contains a rendered view of a particular portion of the 
     * patients records. E.g. Allergy List, Problem List, Drug 
     * List, etc.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }

}
