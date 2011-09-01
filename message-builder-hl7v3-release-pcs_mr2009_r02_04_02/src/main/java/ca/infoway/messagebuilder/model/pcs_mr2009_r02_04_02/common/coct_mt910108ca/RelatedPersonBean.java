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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt910108ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.domainvalue.x_SimplePersonalRelationship;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.merged.ActingPersonBean;



/**
 * <p>Related Person</p>
 * 
 * <p><p>Describes a person (other than a health-care provider 
 * or employee) who is providing information and making 
 * decision on behalf of the patient, in relation to the 
 * delivery of healthcare for the patient. E.g. Patient's 
 * mother. Also used with a relationship of &quot;self&quot; 
 * when the patient themselves is providing the 
 * care.</p><p>Represents information retrieved from the client 
 * registry.</p></p>
 * 
 * <p><p>Describes a person (other than a health-care provider 
 * or employee) who is providing information and making 
 * decision on behalf of the patient, in relation to the 
 * delivery of healthcare for the patient. E.g. Patient's 
 * mother. Also used with a relationship of &quot;self&quot; 
 * when the patient themselves is providing the 
 * care.</p><p>Represents information retrieved from the client 
 * registry.</p></p>
 * 
 * <p><p>Important for tracking source of information for 
 * decision making and other actions taken on behalf of a 
 * patient.</p></p>
 */
@Hl7PartTypeMapping({"COCT_MT910108CA.PersonalRelationship"})
@Hl7RootType
public class RelatedPersonBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.common.coct_mt911108ca.ActingPerson {

    private static final long serialVersionUID = 20110901L;
    private II relatedPersonIdentifier = new IIImpl();
    private CV responsiblePersonType = new CVImpl();
    private ActingPersonBean relationshipHolder;


    /**
     * <p>B:Related Person Identifier</p>
     * 
     * <p><p>A unique identifier for the related person (as found 
     * in a client registry).</p></p>
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
     * (part of Extension)</p></p>
     * 
     * <p><p>ZPB1.6 (Root)</p><p>ZPB1.7 (EXtension)</p><p>ZPB2.8 
     * (Root)</p><p>ZPB2.9 (EXtension)</p><p>ZPB3.11 
     * (Root)</p><p>ZPB3.12 (EXtension)</p><p>ZPB3.18 
     * (Root)</p><p>ZPB3.19 (EXtension)</p><p>D60 (Root)</p><p>D61 
 
     * ... [rest of documentation truncated due to excessive length]
     */
    @Hl7XmlMapping({"id"})
    public Identifier getRelatedPersonIdentifier() {
        return this.relatedPersonIdentifier.getValue();
    }
    public void setRelatedPersonIdentifier(Identifier relatedPersonIdentifier) {
        this.relatedPersonIdentifier.setValue(relatedPersonIdentifier);
    }


    /**
     * <p>C:Responsible Person Type</p>
     * 
     * <p><p>A coded value indicating how the person is related to 
     * the patient. If the code is &quot;SELF&quot;, it indicates 
     * that the action was performed by the patient themselves.</p></p>
     * 
     * <p></p></p>
     * 
     * <p></p></p>
     * 
     * <p><p>EPHS:this cmet is used for self-reports as well as 
     * reports by other related parties</p></p>
     */
    @Hl7XmlMapping({"code"})
    public x_SimplePersonalRelationship getResponsiblePersonType() {
        return (x_SimplePersonalRelationship) this.responsiblePersonType.getValue();
    }
    public void setResponsiblePersonType(x_SimplePersonalRelationship responsiblePersonType) {
        this.responsiblePersonType.setValue(responsiblePersonType);
    }


    @Hl7XmlMapping({"relationshipHolder"})
    public ActingPersonBean getRelationshipHolder() {
        return this.relationshipHolder;
    }
    public void setRelationshipHolder(ActingPersonBean relationshipHolder) {
        this.relationshipHolder = relationshipHolder;
    }

}
