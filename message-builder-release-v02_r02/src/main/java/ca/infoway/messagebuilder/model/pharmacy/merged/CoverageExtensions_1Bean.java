/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pharmacy.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CS;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CSImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_ActMoodOrderEvent;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>CoverageExtensions</p>
 * 
 * <p>PORX_MT010120CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a drug not 
 * previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 * 
 * <p>PORX_MT060040CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a device 
 * not previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 * 
 * <p>PORX_MT010110CA.Coverage: Coverage Extensions</p>
 * 
 * <p><p>An authorization issued by a payor to cover a device 
 * not previously covered by a patient's drug plan.</p></p>
 * 
 * <p><p>Allows conveying special coverage information between 
 * providers.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT010110CA.Coverage","PORX_MT010120CA.Coverage","PORX_MT060040CA.Coverage"})
public class CoverageExtensions_1Bean extends MessagePartBean {

    private static final long serialVersionUID = 20110127L;
    private UnderwriterBean authorUnderwriter;
    private II coverageExtensionId = new IIImpl();
    private CS extensionGrantedIndicator = new CSImpl();


    @Hl7XmlMapping({"author/underwriter"})
    public UnderwriterBean getAuthorUnderwriter() {
        return this.authorUnderwriter;
    }
    public void setAuthorUnderwriter(UnderwriterBean authorUnderwriter) {
        this.authorUnderwriter = authorUnderwriter;
    }


    /**
     * <p>CoverageExtensionId</p>
     * 
     * <p>A:Coverage Extension Id</p>
     * 
     * <p><p>Unique identification for a specific coverage 
     * extension.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times when the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p>A:Coverage Extension Id</p>
     * 
     * <p><p>Unique identification for a specific coverage 
     * extension.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     * 
     * <p><p>Allows for referencing of a specific coverage 
     * extension.</p><p>This identifier may be needed on claims 
     * against the coverage.</p><p>At times the ID will not be 
     * available (such as when the request has just been 
     * submitted), the attribute is 'populated'.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getCoverageExtensionId() {
        return this.coverageExtensionId.getValue();
    }
    public void setCoverageExtensionId(Identifier coverageExtensionId) {
        this.coverageExtensionId.setValue(coverageExtensionId);
    }


    /**
     * <p>ExtensionGrantedIndicator</p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p></p>
     * 
     * <p><p>Indicates to the pharmacy whether they need to check 
     * the status of coverage prior to dispensing. Mandatory due to 
     * HL7 rules.</p></p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p></p>
     * 
     * <p><p>Indicates to the pharmacy whether they need to check 
     * the status of coverage prior to dispensing. The attribute is 
     * mandatory due to HL7 rules.</p></p>
     * 
     * <p>Extension Granted Indicator</p>
     * 
     * <p><p>If set to 'EVN', then coverage has been granted. 
     * Otherwise it has merely been requested.</p></p>
     * 
     * <p><p>Indicates to the pharmacy whether they need to check 
     * the status of coverage prior to dispensing</p></p>
     */
    @Hl7XmlMapping({"moodCode"})
    public x_ActMoodOrderEvent getExtensionGrantedIndicator() {
        return (x_ActMoodOrderEvent) this.extensionGrantedIndicator.getValue();
    }
    public void setExtensionGrantedIndicator(x_ActMoodOrderEvent extensionGrantedIndicator) {
        this.extensionGrantedIndicator.setValue(extensionGrantedIndicator);
    }

}