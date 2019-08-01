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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt040205ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.AD;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.ADImpl;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.datatype.lang.PostalAddress;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Responsible Person</p>
 * 
 * <p>Important for tracking source of information for decision 
 * making and other actions taken on behalf of a patient.</p>
 * 
 * <p>Describes a person (other than a health-care provider or 
 * patient) who is providing information and making decision on 
 * behalf of the patient, in relation to the delivery of 
 * healthcare for the patient. E.g. Patient's mother.</p>
 */
@Hl7PartTypeMapping({"COCT_MT040205CA.ResponsibleParty"})
@Hl7RootType
public class ResponsiblePersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.merged.Party, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.iehr.repc_mt000007ca.Consenter, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt470000ca.Consenter, ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.si.merged.Consenter {

    private static final long serialVersionUID = 20190730L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private AD addr = new ADImpl();
    private SET<TEL, TelecommunicationAddress> telecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private PN agentPersonName = new PNImpl();


    /**
     * <p>Business Name: B:Responsible Person ID</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB1.6 (Root)</p>
     * 
     * <p>ZPB1.7 (EXtension)</p>
     * 
     * <p>ZPB2.8 (Root)</p>
     * 
     * <p>ZPB2.9 (EXtension)</p>
     * 
     * <p>ZPB3.11 (Root)</p>
     * 
     * <p>ZPB3.12 (EXtension)</p>
     * 
     * <p>ZPB3.18 (Root)</p>
     * 
     * <p>ZPB3.19 (EXtension)</p>
     * 
     * <p>D60 (Root)</p>
     * 
     * <p>D61 (Extension)</p>
     * 
     * <p>D76</p>
     * 
     * <p>PVD.020-01 (Extension)</p>
     * 
     * <p>PVD.020-02 (Root)</p>
     * 
     * <p>PharmacyProvider.444-E9 (Extension)</p>
     * 
     * <p>PharmacyProvider.465-E7 (Root)</p>
     * 
     * <p>Prescriber.446-EZ (Extension)</p>
     * 
     * <p>PharmacyProvider.411-DB (Root)</p>
     * 
     * <p>ZDP.18.1 (Extension)</p>
     * 
     * <p>ZDP.18.2 (Root)</p>
     * 
     * <p>ZDP.19.1 (Extension)</p>
     * 
     * <p>ZDP.19.2 (Root)</p>
     * 
     * <p>ZDP.10.1 (Extension)</p>
     * 
     * <p>ZDP.10.2 (Root)</p>
     * 
     * <p>Provider.PproviderExternalKey (Extension)</p>
     * 
     * <p>Provider.providerKey (Extension)</p>
     * 
     * <p>Provider.wellnetProviderId (Extension)</p>
     * 
     * <p>ProviderRegistration.Identifier (Extension)</p>
     * 
     * <p>ProviderRegistration.IdentifierDomain (part of 
     * Extension)</p>
     * 
     * <p>ProviderRegistrationjurisdiction (part of Extension)</p>
     * 
     * <p>Allows a person to be uniquely referred to.</p>
     * 
     * <p>A unique identifier for the responsible person.</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: B:Responsible Person ID</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>ZPB1.6 (Root)</p>
     * 
     * <p>ZPB1.7 (EXtension)</p>
     * 
     * <p>ZPB2.8 (Root)</p>
     * 
     * <p>ZPB2.9 (EXtension)</p>
     * 
     * <p>ZPB3.11 (Root)</p>
     * 
     * <p>ZPB3.12 (EXtension)</p>
     * 
     * <p>ZPB3.18 (Root)</p>
     * 
     * <p>ZPB3.19 (EXtension)</p>
     * 
     * <p>D60 (Root)</p>
     * 
     * <p>D61 (Extension)</p>
     * 
     * <p>D76</p>
     * 
     * <p>PVD.020-01 (Extension)</p>
     * 
     * <p>PVD.020-02 (Root)</p>
     * 
     * <p>PharmacyProvider.444-E9 (Extension)</p>
     * 
     * <p>PharmacyProvider.465-E7 (Root)</p>
     * 
     * <p>Prescriber.446-EZ (Extension)</p>
     * 
     * <p>PharmacyProvider.411-DB (Root)</p>
     * 
     * <p>ZDP.18.1 (Extension)</p>
     * 
     * <p>ZDP.18.2 (Root)</p>
     * 
     * <p>ZDP.19.1 (Extension)</p>
     * 
     * <p>ZDP.19.2 (Root)</p>
     * 
     * <p>ZDP.10.1 (Extension)</p>
     * 
     * <p>ZDP.10.2 (Root)</p>
     * 
     * <p>Provider.PproviderExternalKey (Extension)</p>
     * 
     * <p>Provider.providerKey (Extension)</p>
     * 
     * <p>Provider.wellnetProviderId (Extension)</p>
     * 
     * <p>ProviderRegistration.Identifier (Extension)</p>
     * 
     * <p>ProviderRegistration.IdentifierDomain (part of 
     * Extension)</p>
     * 
     * <p>ProviderRegistrationjurisdiction (part of Extension)</p>
     * 
     * <p>Allows a person to be uniquely referred to.</p>
     * 
     * <p>A unique identifier for the responsible person.</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: C:Responsible Person Type</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be important for understanding the authority to 
     * perform certain actions. E.g. A 'friend' may not be able to 
     * make consent decisions, but may be able to pick up 
     * dispenses.</p>
     * 
     * <p>A coded value indicating how the responsible person is 
     * related to the person for whom they have accepted 
     * responsibility.</p>
     */
    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getCode() {
        return (x_SimplePersonalRelationship) this.code.getValue();
    }

    /**
     * <p>Business Name: C:Responsible Person Type</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>May be important for understanding the authority to 
     * perform certain actions. E.g. A 'friend' may not be able to 
     * make consent decisions, but may be able to pick up 
     * dispenses.</p>
     * 
     * <p>A coded value indicating how the responsible person is 
     * related to the person for whom they have accepted 
     * responsibility.</p>
     */
    public void setCode(x_SimplePersonalRelationship code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: D:Responsible Person Address</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>PVD.080-01 (PartType=SAL)</p>
     * 
     * <p>PVD.080-02 (PartType=CTY)</p>
     * 
     * <p>PVD.080-03 (PartType=CNT)</p>
     * 
     * <p>PVD.080-04 (PartType=ZIP)</p>
     * 
     * <p>D.1b</p>
     * 
     * <p>Shipping Address (PartType=SAL)</p>
     * 
     * <p>City PartType=CTY)</p>
     * 
     * <p>Province (PartType=STA)</p>
     * 
     * <p>Postal Code (PartType=ZIP)</p>
     * 
     * <p>Send care of(PartType=CARE)</p>
     * 
     * <p>Used to contact the responsible person.</p>
     * 
     * <p>The mail and/or physical address associated with a 
     * responsible person.</p>
     */
    @Hl7XmlMapping({"addr"})
    public PostalAddress getAddr() {
        return this.addr.getValue();
    }

    /**
     * <p>Business Name: D:Responsible Person Address</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.addr</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>PVD.080-01 (PartType=SAL)</p>
     * 
     * <p>PVD.080-02 (PartType=CTY)</p>
     * 
     * <p>PVD.080-03 (PartType=CNT)</p>
     * 
     * <p>PVD.080-04 (PartType=ZIP)</p>
     * 
     * <p>D.1b</p>
     * 
     * <p>Shipping Address (PartType=SAL)</p>
     * 
     * <p>City PartType=CTY)</p>
     * 
     * <p>Province (PartType=STA)</p>
     * 
     * <p>Postal Code (PartType=ZIP)</p>
     * 
     * <p>Send care of(PartType=CARE)</p>
     * 
     * <p>Used to contact the responsible person.</p>
     * 
     * <p>The mail and/or physical address associated with a 
     * responsible person.</p>
     */
    public void setAddr(PostalAddress addr) {
        this.addr.setValue(addr);
    }


    /**
     * <p>Business Name: E:Responsible Person Phones and Emails</p>
     * 
     * <p>Relationship: COCT_MT040205CA.ResponsibleParty.telecom</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-5)</p>
     * 
     * <p>PVD.090-01 (url)</p>
     * 
     * <p>PVD.090-02 (url.scheme)</p>
     * 
     * <p>PVD.090-01 (use)</p>
     * 
     * <p>D.1c</p>
     * 
     * <p>Tell #</p>
     * 
     * <p>Fax #</p>
     * 
     * <p>Contact Tel #</p>
     * 
     * <p>Contact Fax #</p>
     * 
     * <p>Prescriber.498-PM</p>
     * 
     * <p>Prescroibing Physician Phone Number</p>
     * 
     * <p>Used to contact the responsible person.</p>
     * 
     * <p>The phone number(s) and email address(s) by which a 
     * responsible person may be contacted.</p>
     */
    @Hl7XmlMapping({"telecom"})
    public Set<TelecommunicationAddress> getTelecom() {
        return this.telecom.rawSet();
    }


    /**
     * <p>Business Name: A:Responsible Person Name</p>
     * 
     * <p>Relationship: COCT_MT040205CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB3.13</p>
     * 
     * <p>PVD.050-01 (PartType = Family)</p>
     * 
     * <p>PVD.050-02 (PartType = Given - 1st rep)</p>
     * 
     * <p>PVD.050-03 PartType = Given - any rep other than the 
     * first)</p>
     * 
     * <p>PVD.050-04 (PartType = Suffix)</p>
     * 
     * <p>PVD.050-05 (PartType = Prefix)</p>
     * 
     * <p>PVD.100-01 (PartType = Family; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-02 (PartType = Given - 1st rep; author/performer 
     * when supervisor is also specified )</p>
     * 
     * <p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p>
     * 
     * <p>PVD.100-04 (PartType = Suffix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-05 (PartType = Prefix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>D1a</p>
     * 
     * <p>Practitioner's Name</p>
     * 
     * <p>04.03</p>
     * 
     * <p>Prescriber.427-DR</p>
     * 
     * <p>Prescribing Physician Name</p>
     * 
     * <p>ZPS.18.3</p>
     * 
     * <p>ZPS.18.4</p>
     * 
     * <p>ZPS.18.5</p>
     * 
     * <p>ZPS.19.3</p>
     * 
     * <p>ZPS.19.4</p>
     * 
     * <p>ZPS.19.5</p>
     * 
     * <p>ZPS.10.3</p>
     * 
     * <p>ZPS.10.4</p>
     * 
     * <p>ZPS.10.5</p>
     * 
     * <p>ProviderPreviewInfo.ProviderName</p>
     * 
     * <p>Used when contacting or addressing the responsible 
     * person. Because this will be the principle means of 
     * identifying the responsible person, it is mandatory.</p>
     * 
     * <p>The name by which the responsible person is known</p>
     */
    @Hl7XmlMapping({"agentPerson/name"})
    public PersonName getAgentPersonName() {
        return this.agentPersonName.getValue();
    }

    /**
     * <p>Business Name: A:Responsible Person Name</p>
     * 
     * <p>Relationship: COCT_MT040205CA.Person.name</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>ZPB3.13</p>
     * 
     * <p>PVD.050-01 (PartType = Family)</p>
     * 
     * <p>PVD.050-02 (PartType = Given - 1st rep)</p>
     * 
     * <p>PVD.050-03 PartType = Given - any rep other than the 
     * first)</p>
     * 
     * <p>PVD.050-04 (PartType = Suffix)</p>
     * 
     * <p>PVD.050-05 (PartType = Prefix)</p>
     * 
     * <p>PVD.100-01 (PartType = Family; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-02 (PartType = Given - 1st rep; author/performer 
     * when supervisor is also specified )</p>
     * 
     * <p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p>
     * 
     * <p>PVD.100-04 (PartType = Suffix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>PVD.100-05 (PartType = Prefix; author/performer when 
     * supervisor is also specified)</p>
     * 
     * <p>D1a</p>
     * 
     * <p>Practitioner's Name</p>
     * 
     * <p>04.03</p>
     * 
     * <p>Prescriber.427-DR</p>
     * 
     * <p>Prescribing Physician Name</p>
     * 
     * <p>ZPS.18.3</p>
     * 
     * <p>ZPS.18.4</p>
     * 
     * <p>ZPS.18.5</p>
     * 
     * <p>ZPS.19.3</p>
     * 
     * <p>ZPS.19.4</p>
     * 
     * <p>ZPS.19.5</p>
     * 
     * <p>ZPS.10.3</p>
     * 
     * <p>ZPS.10.4</p>
     * 
     * <p>ZPS.10.5</p>
     * 
     * <p>ProviderPreviewInfo.ProviderName</p>
     * 
     * <p>Used when contacting or addressing the responsible 
     * person. Because this will be the principle means of 
     * identifying the responsible person, it is mandatory.</p>
     * 
     * <p>The name by which the responsible person is known</p>
     */
    public void setAgentPersonName(PersonName agentPersonName) {
        this.agentPersonName.setValue(agentPersonName);
    }

}
