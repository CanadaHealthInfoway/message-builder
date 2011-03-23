/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.iehr.comt_mt111111ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.ED;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.EDImpl;
import ca.infoway.messagebuilder.datatype.lang.EncapsulatedData;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Rendered Record</p>
 * 
 * <p>Conveys a portion of the patient's record as rendered 
 * content.</p>
 * 
 * <p>Allows simple applications which do not yet support all 
 * of the discrete messaging specifications to still access 
 * data within the EHR.</p>
 */
@Hl7PartTypeMapping({"COMT_MT111111CA.RenderedContent"})
public class RenderedRecordBean extends MessagePartBean implements SummaryBean {

    private static final long serialVersionUID = 20100603L;
    private CV renderedContentType = new CVImpl();
    private ED<EncapsulatedData> renderedContent = new EDImpl<EncapsulatedData>();

    @Hl7XmlMapping({"code"})
    public Code getRenderedContentType() {
        return (Code) this.renderedContentType.getValue();
    }
    public void setRenderedContentType(Code renderedContentType) {
        this.renderedContentType.setValue(renderedContentType);
    }

    @Hl7XmlMapping({"text"})
    public EncapsulatedData getRenderedContent() {
        return this.renderedContent.getValue();
    }
    public void setRenderedContent(EncapsulatedData renderedContent) {
        this.renderedContent.setValue(renderedContent);
    }

}
