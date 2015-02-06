/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ccda_r1_1.unstructureddocument;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CS_R2;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.LIST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CS_R2Impl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.LISTImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.CodedTypeR2;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PatientBean;
import ca.infoway.messagebuilder.model.ccda_r1_1.merged.PatientRoleOrganizationBean;
import java.util.List;



@Hl7PartTypeMapping({"UnstructuredDocument.PatientRole"})
public class PatientRoleBean extends MessagePartBean {

    private static final long serialVersionUID = 20150206L;
    private LIST<CS_R2, CodedTypeR2<? extends Code>> realmCode = new LISTImpl<CS_R2, CodedTypeR2<? extends Code>>(CS_R2Impl.class);
    private II typeId = new IIImpl();
    private LIST<II, Identifier> templateId = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<II, Identifier> id = new LISTImpl<II, Identifier>(IIImpl.class);
    private LIST<AD, PostalAddress> addr = new LISTImpl<AD, PostalAddress>(ADImpl.class);
    private LIST<TEL, TelecommunicationAddress> telecom = new LISTImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PatientBean patient;
    private PatientRoleOrganizationBean providerOrganization;


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.realmCode</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"realmCode"})
    public List<CodedTypeR2<Code>> getRealmCode() {
        return this.realmCode.rawList(CodedTypeR2.class);
    }


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"typeId"})
    public Identifier getTypeId() {
        return this.typeId.getValue();
    }

    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.typeId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setTypeId(Identifier typeId) {
        this.typeId.setValue(typeId);
    }


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.templateId</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-*)</p>
     */
    @Hl7XmlMapping({"templateId"})
    public List<Identifier> getTemplateId() {
        return this.templateId.rawList();
    }


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.id</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1)</p>
     */
    @Hl7XmlMapping({"id"})
    public List<Identifier> getId() {
        return this.id.rawList();
    }


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.addr</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"addr"})
    public List<PostalAddress> getAddr() {
        return this.addr.rawList();
    }


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.telecom</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (*)</p>
     */
    @Hl7XmlMapping({"telecom"})
    public List<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawList();
    }


    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    @Hl7XmlMapping({"patient"})
    public PatientBean getPatient() {
        return this.patient;
    }

    /**
     * <p>Relationship: UnstructuredDocument.PatientRole.patient</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     */
    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }


    /**
     * <p>Relationship: 
     * UnstructuredDocument.PatientRole.providerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    @Hl7XmlMapping({"providerOrganization"})
    public PatientRoleOrganizationBean getProviderOrganization() {
        return this.providerOrganization;
    }

    /**
     * <p>Relationship: 
     * UnstructuredDocument.PatientRole.providerOrganization</p>
     * 
     * <p>Conformance/Cardinality: OPTIONAL (0-1)</p>
     */
    public void setProviderOrganization(PatientRoleOrganizationBean providerOrganization) {
        this.providerOrganization = providerOrganization;
    }

}
