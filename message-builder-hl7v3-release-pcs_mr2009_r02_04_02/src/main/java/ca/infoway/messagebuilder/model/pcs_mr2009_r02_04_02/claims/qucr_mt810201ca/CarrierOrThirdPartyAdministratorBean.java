/**
 * Copyright 2012 Canada Health Infoway, Inc.
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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_02.claims.qucr_mt810201ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>Carrier or Third Party Administrator</p>
 * 
 * <p><p>An organization that establishes insurance policies, 
 * determines eligibility and benefits under those insurance 
 * policies, and underwrites payments for products and/or 
 * services provided to a beneficiary (person or 
 * organization).</p><p>A Carrier may retain a TPA (Third Party 
 * Administrator) to perform some or all invoice validation, 
 * adjudication and payment.</p><p>This may also be known as 
 * the insurance company or public insurance carrier.</p><p>A 
 * Carrier or TPA (Third Party Administrator) who performs some 
 * or all invoice validation, adjudication and payment.</p></p>
 * 
 * <p><p>An organization that establishes insurance policies, 
 * determines eligibility and benefits under those insurance 
 * policies, and underwrites payments for products and/or 
 * services provided to a beneficiary (person or 
 * organization).</p><p>A Carrier may retain a TPA (Third Party 
 * Administrator) to perform some or all invoice validation, 
 * adjudication and payment.</p><p>This may also be known as 
 * the insurance company or public insurance carrier.</p><p>A 
 * Carrier or TPA (Third Party Administrator) who performs some 
 * or all invoice validation, adjudication and payment.</p></p>
 * 
 * <p><p>An organization that establishes insurance policies, 
 * determines eligibility and benefits under those insurance 
 * policies, and underwrites payments for products and/or 
 * services provided to a beneficiary (person or 
 * organization).</p><p>A Carrier may retain a TPA (Third Party 
 * Administrator) to perform some or all invoice validation, 
 * adjudication and payment.</p><p>This may also be known as 
 * the insurance company or public insurance carrier.</p><p>A 
 * Carrier or TPA (Third Party Administrator) who performs some 
 * or all invoice validation, adjudication and payment.</p></p>
 * 
 * <p><p>An organization that establishes insurance policies, 
 * determines eligibility and benefits under those insurance 
 * policies, and underwrites payments for products and/or 
 * services provided to a beneficiary (person or 
 * organization).</p><p>A Carrier may retain a TPA (Third Party 
 * Administrator) to perform some or all invoice validation, 
 * adjudication and payment.</p><p>This may also be known as 
 * the insurance company or public insurance carrier.</p><p>A 
 * Carrier or TPA (Third Party Administrator) who performs some 
 * or all invoice validation, adjudication and payment.</p></p>
 */
@Hl7PartTypeMapping({"QUCR_MT810201CA.AdjudResultsCarrierRole"})
public class CarrierOrThirdPartyAdministratorBean extends MessagePartBean {

    private static final long serialVersionUID = 20111117L;
    private II id = new IIImpl();


    /**
     * <p>Carrier Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getId() {
        return this.id.getValue();
    }
    public void setId(Identifier id) {
        this.id.setValue(id);
    }

}
