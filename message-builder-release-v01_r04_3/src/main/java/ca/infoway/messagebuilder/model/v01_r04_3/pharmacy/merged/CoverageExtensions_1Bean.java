/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.v01_r04_3.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"PORX_MT010110CA.Coverage","PORX_MT010120CA.Coverage","PORX_MT060040CA.Coverage"})
public class CoverageExtensions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110318L;
    private CS extensionGrantedIndicator = new CSImpl();
    private II coverageExtensionId = new IIImpl();
    private UnderwriterBean authorUnderwriter;


    /**
     * <p>ExtensionGrantedIndicator</p>
     * 
     * <p>Extension Granted Indicator</p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getExtensionGrantedIndicator() {
        return (x_ActMoodOrderEvent) this.extensionGrantedIndicator.getValue();
    }
    public void setExtensionGrantedIndicator(x_ActMoodOrderEvent extensionGrantedIndicator) {
        this.extensionGrantedIndicator.setValue(extensionGrantedIndicator);
    }


    /**
     * <p>CoverageExtensionId</p>
     * 
     * <p>A:Coverage Extension Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCoverageExtensionId() {
        return this.coverageExtensionId.getValue();
    }
    public void setCoverageExtensionId(Identifier coverageExtensionId) {
        this.coverageExtensionId.setValue(coverageExtensionId);
    }


    @Hl7XmlMapping({"author/underwriter"})
    public UnderwriterBean getAuthorUnderwriter() {
        return this.authorUnderwriter;
    }
    public void setAuthorUnderwriter(UnderwriterBean authorUnderwriter) {
        this.authorUnderwriter = authorUnderwriter;
    }

}
