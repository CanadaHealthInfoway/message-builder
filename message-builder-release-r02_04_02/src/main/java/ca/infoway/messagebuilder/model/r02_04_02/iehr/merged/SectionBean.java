/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.r02_04_02.iehr.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.ArrayList;
import java.util.List;



@Hl7PartTypeMapping({"REPC_MT220001CA.Section","REPC_MT220003CA.Section"})
public class SectionBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ED<EncapsulatedData> documentOverviewContent = new EDImpl<EncapsulatedData>();
    private DocumentContent_2 component1DocumentContent;
    private List<DocumentSectionsBean> component2SubSection = new ArrayList<DocumentSectionsBean>();
    private List<ReferenceBean> component3Reference = new ArrayList<ReferenceBean>();


    /**
     * <p>DocumentOverviewContent</p>
     * 
     * <p>M: Document Overview Content</p>
     * 
     * <p><p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p></p>
     * 
     * <p><p>Provides the primary rendered textual content of the 
     * document.</p><p>E.g. The cover letter for a referral, the 
     * overview portion of a report, etc.</p></p>
     * 
     * <p><p>Represents the principle content of the document and 
     * therefore is mandatory.</p></p>
     * 
     * <p><p>There is no guidance provided within the standard on 
     * how report content should be organized or formatted. 
     * Guidance may be provided by professional colleges, specialty 
     * groups or others.</p></p>
     */
    @Hl7XmlMapping({"text"})
    public EncapsulatedData getDocumentOverviewContent() {
        return this.documentOverviewContent.getValue();
    }
    public void setDocumentOverviewContent(EncapsulatedData documentOverviewContent) {
        this.documentOverviewContent.setValue(documentOverviewContent);
    }


    @Hl7XmlMapping({"component1/documentContent"})
    public DocumentContent_2 getComponent1DocumentContent() {
        return this.component1DocumentContent;
    }
    public void setComponent1DocumentContent(DocumentContent_2 component1DocumentContent) {
        this.component1DocumentContent = component1DocumentContent;
    }

    public DischargeCareSummaryReportBean getComponent1DocumentContentAsPatientCareProvisionEvent() {
        return this.component1DocumentContent instanceof DischargeCareSummaryReportBean ? (DischargeCareSummaryReportBean) this.component1DocumentContent : null;
    }
    public boolean hasComponent1DocumentContentAsPatientCareProvisionEvent() {
        return (this.component1DocumentContent instanceof DischargeCareSummaryReportBean);
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
