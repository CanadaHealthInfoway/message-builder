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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.common.coct_mt090107ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.PN;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.PNImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.datatype.lang.PersonName;
import ca.infoway.messagebuilder.domainvalue.HealthcareProviderRoleType;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Business Name: Provider</p>
 * 
 * <p>Important for tracking responsibility for healthcare 
 * events, as well as for identifying appropriate individuals 
 * to contact for further information or follow-up.</p><p>While 
 * an important piece of identifying information, not all 
 * providers will have identifiers, thus this attribute is only 
 * 'populated'.</p>
 * 
 * <p>Describes a healthcare provider involved in the delivery 
 * of healthcare services. Encompasses both professional and 
 * non-professional members.</p>
 */
@Hl7PartTypeMapping({"COCT_MT090107CA.AssignedPerson"})
@Hl7RootType
public class ProviderBean extends MessagePartBean implements ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.iehr.repc_mt000007ca.Consenter, ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.iehr.repc_mt000012ca.Choice, ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.pharmacy.merged.ChangedBy, ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.merged.Recipient, ca.infoway.messagebuilder.model.ns_cerx_v01_r04_3.iehr.merged.Party {

    private static final long serialVersionUID = 20150902L;
    private II id = new IIImpl();
    private CV code = new CVImpl();
    private PN representedPersonName = new PNImpl();
    private II representedPersonAsLicensedEntityId = new IIImpl();


    /**
     * <p>Business Name: A:Provider Id</p>
     * 
     * <p>Relationship: COCT_MT090107CA.AssignedPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Allows a provider to be uniquely referred to but will not 
     * always be known and is therefore 'populated'.</p>
     * 
     * <p>A unique identifier for a provider (e.g. the Prescriber 
     * on a new prescription).</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }

    /**
     * <p>Business Name: A:Provider Id</p>
     * 
     * <p>Relationship: COCT_MT090107CA.AssignedPerson.id</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
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
     * <p>Allows a provider to be uniquely referred to but will not 
     * always be known and is therefore 'populated'.</p>
     * 
     * <p>A unique identifier for a provider (e.g. the Prescriber 
     * on a new prescription).</p>
     */
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>Business Name: Provider Type</p>
     * 
     * <p>Relationship: COCT_MT090107CA.AssignedPerson.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Necessary for ascertaining providers' ability/competence 
     * in providing different types of health services.</p>
     * 
     * <p>A coded value indicating the professional category of a 
     * provider. This is usually the discipline of the provider 
     * (e.g. physician, pharmacist, dentist, etc).</p>
     */
    @Hl7XmlMapping({"code"})
    public HealthcareProviderRoleType getCode() {
        return (HealthcareProviderRoleType) this.code.getValue();
    }

    /**
     * <p>Business Name: Provider Type</p>
     * 
     * <p>Relationship: COCT_MT090107CA.AssignedPerson.code</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (0-1)</p>
     * 
     * <p>Necessary for ascertaining providers' ability/competence 
     * in providing different types of health services.</p>
     * 
     * <p>A coded value indicating the professional category of a 
     * provider. This is usually the discipline of the provider 
     * (e.g. physician, pharmacist, dentist, etc).</p>
     */
    public void setCode(HealthcareProviderRoleType code) {
        this.code.setValue(code);
    }


    /**
     * <p>Business Name: B:Provider Name</p>
     * 
     * <p>Relationship: COCT_MT090107CA.Person.name</p>
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
     * <p>Used when contacting the provider. Also used by others to 
     * recognize a provider and then evaluate the information 
     * provided by a particular provider. This is the one piece of 
     * provider information which should always be known and is 
     * therefore mandatory.</p>
     * 
     * <p>The name by which the provider is known (e.g. the 
     * Prescriber on a new prescription).</p>
     */
    @Hl7XmlMapping({"representedPerson/name"})
    public PersonName getRepresentedPersonName() {
        return this.representedPersonName.getValue();
    }

    /**
     * <p>Business Name: B:Provider Name</p>
     * 
     * <p>Relationship: COCT_MT090107CA.Person.name</p>
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
     * <p>Used when contacting the provider. Also used by others to 
     * recognize a provider and then evaluate the information 
     * provided by a particular provider. This is the one piece of 
     * provider information which should always be known and is 
     * therefore mandatory.</p>
     * 
     * <p>The name by which the provider is known (e.g. the 
     * Prescriber on a new prescription).</p>
     */
    public void setRepresentedPersonName(PersonName representedPersonName) {
        this.representedPersonName.setValue(representedPersonName);
    }


    /**
     * <p>Business Name: D:Provider License Number</p>
     * 
     * <p>Relationship: COCT_MT090107CA.LicensedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>License Number</p>
     * 
     * <p>ZDP.18.6</p>
     * 
     * <p>ZDP.19.6</p>
     * 
     * <p>ZPS.10.6</p>
     * 
     * <p>Allows providers to verify/ascertain authority for 
     * clinical services.</p>
     * 
     * <p>If a provider possesses multiple licenses, this is the 
     * license that applies to the current action.</p>
     * 
     * <p>The identifier of a professional license issued to the 
     * provider by a licensing body.</p>
     */
    @Hl7XmlMapping({"representedPerson/asLicensedEntity/id"})
    public Identifier getRepresentedPersonAsLicensedEntityId() {
        return this.representedPersonAsLicensedEntityId.getValue();
    }

    /**
     * <p>Business Name: D:Provider License Number</p>
     * 
     * <p>Relationship: COCT_MT090107CA.LicensedEntity.id</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>License Number</p>
     * 
     * <p>ZDP.18.6</p>
     * 
     * <p>ZDP.19.6</p>
     * 
     * <p>ZPS.10.6</p>
     * 
     * <p>Allows providers to verify/ascertain authority for 
     * clinical services.</p>
     * 
     * <p>If a provider possesses multiple licenses, this is the 
     * license that applies to the current action.</p>
     * 
     * <p>The identifier of a professional license issued to the 
     * provider by a licensing body.</p>
     */
    public void setRepresentedPersonAsLicensedEntityId(Identifier representedPersonAsLicensedEntityId) {
        this.representedPersonAsLicensedEntityId.setValue(representedPersonAsLicensedEntityId);
    }

}
