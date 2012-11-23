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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt210003ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.DocumentContent_1;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.DocumentSectionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReferralBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT210003CA.Section"})
public class SectionBean extends MessagePartBean {

    private static final long serialVersionUID = 20121122L;
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private DocumentContent_1 component1DocumentContent;
    private List<DocumentSectionsBean> component2SubSection = new ArrayList<DocumentSectionsBean>();
    private List<ReferenceBean> component3Reference = new ArrayList<ReferenceBean>();


    /**
     * <p>M: Document Overview Content</p>
     * 
     * <p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p>
     * 
     * <p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p>
     * 
     * <p>Represents the principle content of the document and 
     * therefore is mandatory.</p>
     * 
     * <p>There is no guidance provided within the standard on how 
     * report content should be organized or formatted. Guidance 
     * may be provided by professional colleges, specialty groups 
     * or others.</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>M: Document Overview Content</p>
     * 
     * <p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p>
     * 
     * <p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p>
     * 
     * <p>Represents the principle content of the document and 
     * therefore is mandatory.</p>
     * 
     * <p>There is no guidance provided within the standard on how 
     * report content should be organized or formatted. Guidance 
     * may be provided by professional colleges, specialty groups 
     * or others.</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    @Hl7XmlMapping({"component1/documentContent"})
    public DocumentContent_1 getComponent1DocumentContent() {
        return this.component1DocumentContent;
    }

    public void setComponent1DocumentContent(DocumentContent_1 component1DocumentContent) {
        this.component1DocumentContent = component1DocumentContent;
    }

    public ReferralBean getComponent1DocumentContentAsPatientCareProvisionRequest() {
        return this.component1DocumentContent instanceof ReferralBean ? (ReferralBean) this.component1DocumentContent : null;
    }
    public boolean hasComponent1DocumentContentAsPatientCareProvisionRequest() {
        return (this.component1DocumentContent instanceof ReferralBean);
    }


    @Hl7XmlMapping({"component2/subSection"})
    public List<DocumentSectionsBean> getComponent2SubSection() {
        return this.component2SubSection;
    }


    @Hl7XmlMapping({"component3/reference"})
    public List<ReferenceBean> getComponent3Reference() {
        return this.component3Reference;
    }

}
