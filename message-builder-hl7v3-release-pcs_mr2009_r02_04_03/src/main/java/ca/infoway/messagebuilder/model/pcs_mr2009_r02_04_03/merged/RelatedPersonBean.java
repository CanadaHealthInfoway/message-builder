/**
 * Copyright 2011 Canada Health Infoway, Inc.
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
 * Last modified: $LastChangedDate: 2011-05-04 16:47:15 -0300 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.merged;

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
 * <p>RelatedPerson</p>
 * 
 * <p>COCT_MT910107CA.PersonalRelationship: Related Person</p>
 * 
 * <p><p>Describes a person (other than a health-care provider 
 * or employee) who is providing information and making 
 * decision on behalf of the patient, in relation to the 
 * delivery of healthcare for the patient. E.g. Patient's 
 * mother.</p><p>Used when the person cannot be found in the 
 * Client registry.</p></p>
 * 
 * <p><p>Describes a person (other than a health-care provider 
 * or employee) who is providing information and making 
 * decision on behalf of the patient, in relation to the 
 * delivery of healthcare for the patient. E.g. Patient's 
 * mother.</p><p>Used when the person cannot be found in the 
 * Client registry.</p></p>
 * 
 * <p><p>Important for tracking source of information for 
 * decision making and other actions taken on behalf of a 
 * patient.</p></p>
 * 
 * <p>COCT_MT910102CA.PersonalRelationship: Related Person</p>
 * 
 * <p><p>Describes a person (other than a health-care provider 
 * or employee) who is providing information and making 
 * decision on behalf of the patient, in relation to the 
 * delivery of healthcare for the patient. E.g. Patient's 
 * mother. Also used with a relationship of &quot;self&quot; 
 * when the patient themselves is providing the care.</p><p>The 
 * expectation is that the person can be found in the client 
 * registry.</p></p>
 * 
 * <p><p>Describes a person (other than a health-care provider 
 * or employee) who is providing information and making 
 * decision on behalf of the patient, in relation to the 
 * delivery of healthcare for the patient. E.g. Patient's 
 * mother. Also used with a relationship of &quot;self&quot; 
 * when the patient themselves is providing the care.</p><p>The 
 * expectation is that the person can be found in the client 
 * registry.</p></p>
 * 
 * <p><p>Important for tracking source of information for 
 * decision making and other actions taken on behalf of a 
 * patient.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT910102CA.PersonalRelationship","COCT_MT910107CA.PersonalRelationship","FICR_MT400001CA.PersonalRelationship","FICR_MT400003CA.PersonalRelationship","FICR_MT400004CA.PersonalRelationship","FICR_MT490101CA.PersonalRelationship","FICR_MT490102CA.PersonalRelationship","FICR_MT500201CA.PersonalRelationship","FICR_MT510201CA.PersonalRelationship","FICR_MT600201CA.PersonalRelationship","FICR_MT610201CA.PersonalRelationship"})
@Hl7RootType
public class RelatedPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.iehr.merged.Party, Choice, Consenter, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.merged.ActingPerson, ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.common.coct_mt120600ca.AssignedPerson {

    private static final long serialVersionUID = 20120106L;
    private CV code = new CVImpl();
    private II id = new IIImpl();
    private PN relationshipHolderName = new PNImpl();
    private SET<TEL, TelecommunicationAddress> relationshipHolderTelecom = new SETImpl<TEL, TelecommunicationAddress>(TELImpl.class);
    private AD relationshipHolderAddr = new ADImpl();


    /**
     * <p>C:Responsible Person Type</p>
     * 
     * <p><p>A coded value indicating how the responsible person is 
     * related to the patient. If the code is &quot;SELF&quot;, it 
     * indicates that the action was performed by the patient 
     * themselves.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Personal relationship code</p>
     * 
     * <p>Personal Relationship Type</p>
     * 
     * <p>C:Related Person Type</p>
     * 
     * <p><p>A coded value indicating how the related person is 
     * related to the patient.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p>Examples are spouse, child</p>
     */
    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getCode() {
        return (x_SimplePersonalRelationship) this.code.getValue();
    }
    public void setCode(x_SimplePersonalRelationship code) {
        this.code.setValue(code);
    }


    /**
     * <p>RelatedPersonIdentifier</p>
     * 
     * <p>B:Related Person Identifier</p>
     * 
     * <p><p>A unique identifier for the related person. May 
     * include PHNs, drivers license or other identifiers.</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
     * (Extension)</p><p>D76</p><p>PVD.020-01 
     * (Extension)</p><p>PVD.020-02 
     * (Root)</p><p>PharmacyProvider.444-E9 
     * (Extension)</p><p>PharmacyProvider.465-E7 
     * (Root)</p><p>Prescriber.446-EZ 
     * (Extension)</p><p>PharmacyProvider.411-DB 
     * (Root)</p><p>ZDP.18.1 (Extension)</p><p>ZDP.18.2 
     * (Root)</p><p>ZDP.19.1 (Extension)</p><p>ZDP.19.2 
     * (Root)</p><p>ZDP.10.1 (Extension)</p><p>ZDP.10.2 
     * (Root)</p><p>Provider.PproviderExternalKey 
     * (Extension)</p><p>Provider.providerKey 
     * (Extension)</p><p>Provider.wellnetProviderId 
     * (Extension)</p><p>ProviderRegistration.Identifier 
     * (Extension)</p><p>ProviderRegistration.IdentifierDomain 
     * (part of Extension)</p><p>ProviderRegistrationjurisdiction 
     * (part of Extens
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }


    /**
     * <p>RelatedPersonName</p>
     * 
     * <p>A:Related Person Name</p>
     * 
     * <p><p>The name by which the responsible person is known</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-02 (PartType = Given - 1st rep; 
     * author/performer when supervisor is also specified 
     * )</p><p>PVD.100-03 PartType = Given - any rep other than the 
     * first; author/performer when supervisor is also 
     * specified)</p><p>PVD.100-04 (PartType = Suffix; 
     * author/performer when supervisor is also 
     * specified)</p><p>PVD.100-05 (PartType = Prefix; 
     * author/performer when supervisor is also 
     * specified)</p><p>D1a</p><p>Practitioner's 
     * Name</p><p>04.03</p><p>Prescriber.427-DR</p><p>Prescribing 
     * Physician 
     * Name</p><p>ZPS.18.3</p><p>ZPS.18.4</p><p>ZPS.18.5</p><p>ZPS.19.3</p><p>ZPS.19.4</p><p>ZPS.19.5</p><p>ZPS.10.3</p><p>ZPS.10.4</p><p>ZPS.10.5</p><p>ProviderPreviewInfo.ProviderName</p></p>
     * 
     * <p><p>ZPB3.13</p><p>PVD.050-01 (PartType = 
     * Family)</p><p>PVD.050-02 (PartType = Given - 1st 
     * rep)</p><p>PVD.050-03 PartType = Given - any rep other than 
     * the first)</p><p>PVD.050-04 (PartType = 
     * Suffix)</p><p>PVD.050-05 (PartType = 
     * Prefix)</p><p>PVD.100-01 (PartType = Family; 
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"relationshipHolder/name"})
    public PersonName getRelationshipHolderName() {
        return this.relationshipHolderName.getValue();
    }
    public void setRelationshipHolderName(PersonName relationshipHolderName) {
        this.relationshipHolderName.setValue(relationshipHolderName);
    }


    /**
     * <p>RelatedPersonPhonesAndEmails</p>
     * 
     * <p>E:Related Person Phones and Emails</p>
     * 
     * <p><p>The phone number(s) and email address(s) by which a 
     * related person may be contacted.</p></p>
     * 
     * <p><p>Used to contact the related person.</p></p>
     */
    @Hl7XmlMapping({"relationshipHolder/telecom"})
    public Set<TelecommunicationAddress> getRelationshipHolderTelecom() {
        return this.relationshipHolderTelecom.rawSet();
    }


    /**
     * <p>RelatedPersonAddress</p>
     * 
     * <p>D:Related Person Address</p>
     * 
     * <p><p>The mail and/or physical address associated with a 
     * related person.</p></p>
     * 
     * <p><p>Used to contact the related person.</p></p>
     */
    @Hl7XmlMapping({"relationshipHolder/addr"})
    public PostalAddress getRelationshipHolderAddr() {
        return this.relationshipHolderAddr.getValue();
    }
    public void setRelationshipHolderAddr(PostalAddress relationshipHolderAddr) {
        this.relationshipHolderAddr.setValue(relationshipHolderAddr);
    }

}
