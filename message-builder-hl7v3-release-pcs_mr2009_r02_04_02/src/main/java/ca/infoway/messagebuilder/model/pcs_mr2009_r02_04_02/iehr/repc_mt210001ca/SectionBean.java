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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.repc_mt210001ca;

import java.util.ArrayList;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.DocumentSectionsBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReferenceBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.iehr.merged.ReferralBean;



@Hl7PartTypeMapping({"REPC_MT210001CA.Section"})
public class SectionBean extends MessagePartBean {

    private static final long serialVersionUID = 20130307L;
    private ED<EncapsulatedData> text = new EDImpl<EncapsulatedData>();
    private DocumentContent component1DocumentContent;
    private List<DocumentSectionsBean> component2SubSection = new ArrayList<DocumentSectionsBean>();
    private List<ReferenceBean> component3Reference = new ArrayList<ReferenceBean>();


    /**
     * <p>Business Name: M: Document Overview Content</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Section.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getText() {
        return this.text.getValue();
    }

    /**
     * <p>Business Name: M: Document Overview Content</p>
     * 
     * <p>Relationship: REPC_MT210001CA.Section.text</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setText(EncapsulatedData text) {
        this.text.setValue(text);
    }


    /**
     * <p>Relationship: REPC_MT210001CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"component1/documentContent"})
    public DocumentContent getComponent1DocumentContent() {
        return this.component1DocumentContent;
    }

    /**
     * <p>Relationship: REPC_MT210001CA.Component4.documentContent</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setComponent1DocumentContent(DocumentContent component1DocumentContent) {
        this.component1DocumentContent = component1DocumentContent;
    }

    public ReferralBean getComponent1DocumentContentAsPatientCareProvisionRequest() {
        return this.component1DocumentContent instanceof ReferralBean ? (ReferralBean) this.component1DocumentContent : null;
    }
    public boolean hasComponent1DocumentContentAsPatientCareProvisionRequest() {
        return (this.component1DocumentContent instanceof ReferralBean);
    }


    /**
     * <p>Relationship: REPC_MT210001CA.Component.subSection</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component2/subSection"})
    public List<DocumentSectionsBean> getComponent2SubSection() {
        return this.component2SubSection;
    }


    /**
     * <p>Relationship: REPC_MT210001CA.Component5.reference</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"component3/reference"})
    public List<ReferenceBean> getComponent3Reference() {
        return this.component3Reference;
    }

}
