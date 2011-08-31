/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>ReferencedRecord</p>
 * 
 * <p>COMT_MT001104CA.ActEvent: Referenced Record</p>
 * 
 * <p><p>References an existing event record by identifier.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 * 
 * <p><p>As a request, refers to the event to be acted upon or 
 * which has been acted upon.</p><p>As a response, may be used 
 * to indicate the identifier assigned to a created object.</p></p>
 */
@Hl7PartTypeMapping({"COMT_MT001104CA.ActEvent","REPC_MT230001CA.ActEvent","REPC_MT230002CA.ActEvent","REPC_MT230003CA.ActEvent","REPC_MT500001CA.ActEvent","REPC_MT500002CA.ActEvent","REPC_MT500004CA.ActEvent"})
@Hl7RootType
public class ActEventBean extends MessagePartBean {

    private static final long serialVersionUID = 20110831L;
    private II id = new IIImpl();


    /**
     * <p>K:Contained Service Event Ids</p>
     * 
     * <p><p>References health service event records to be added to 
     * or removed from the care composition.</p></p>
     * 
     * <p><p>One of the primary purposes of a care composition is 
     * to 'group' information. This attribute is the representation 
     * of that grouping.</p></p>
     * 
     * <p>Record Identifier</p>
     * 
     * <p><p>The identifier assigned by the central system (EHR) to 
     * the Event record being referred to.</p><p>For the retract 
     * interaction, the identfier of the control act requested to 
     * be nullified.</p></p>
     * 
     * <p><p>The identifier assigned by the central system (EHR) to 
     * the Event record being referred to.</p><p>For the retract 
     * interaction, the identfier of the control act requested to 
     * be nullified.</p></p>
     * 
     * <p><p>Allows the event record to be uniquely referenced and 
     * is therefore mandatory.</p></p>
     * 
     * <p>Reported On Service Link</p>
     * 
     * <p><p>A unique identifier assigned to the discrete record 
     * associated with the procedure or observation being reported 
     * upon.</p></p>
     * 
     * <p><p>Provides a direct link for drill-down to the discrete 
     * record of the procedure or observation being reported 
     * on.</p></p>
     * 
     * <p>K:Contained Service Event Ids</p>
     * 
     * <p><p>References any existing health service event records 
     * that should be associated with this care composition when it 
     * is created</p></p>
     * 
     * <p><p>One of the primary purposes of a care composition is 
     * to 'group' information. This attribute is the representation 
     * of that grouping.</p></p>
     * 
     * <p>K:Contained Service Event Ids</p>
     * 
     * <p><p>References existing health service event records that 
     * are associated this care composition</p></p>
     * 
     * <p><p>One of the primary purposes of a care composition is 
     * to 'group' information. This attribute is the representation 
     * of that grouping.</p></p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
