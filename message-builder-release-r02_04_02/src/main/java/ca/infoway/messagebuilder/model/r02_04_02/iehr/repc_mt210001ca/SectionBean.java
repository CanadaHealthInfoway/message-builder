/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.repc_mt210001ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.DocumentSectionsBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ReferenceBean;
import ca.infoway.messagebuilder.model.r02_04_02.iehr.merged.ReferralBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT210001CA.Section"})
public class SectionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private List<DocumentSectionsBean> component2SubSection = new ArrayList<DocumentSectionsBean>();
    private DocumentContent component1DocumentContent;
    private ED<EncapsulatedData> documentOverviewContent = new EDImpl<EncapsulatedData>();
    private List<ReferenceBean> component3Reference = new ArrayList<ReferenceBean>();


    @Hl7XmlMapping({"component2/subSection"})
    public List<DocumentSectionsBean> getComponent2SubSection() {
        return this.component2SubSection;
    }


    @Hl7XmlMapping({"component1/documentContent"})
    public DocumentContent getComponent1DocumentContent() {
        return this.component1DocumentContent;
    }
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
     * <p>M: Document Overview Content</p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getDocumentOverviewContent() {
        return this.documentOverviewContent.getValue();
    }
    public void setDocumentOverviewContent(EncapsulatedData documentOverviewContent) {
        this.documentOverviewContent.setValue(documentOverviewContent);
    }


    @Hl7XmlMapping({"component3/reference"})
    public List<ReferenceBean> getComponent3Reference() {
        return this.component3Reference;
    }

}