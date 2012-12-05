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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2011-05-04 15:47:15 -0400 (Wed, 04 May 2011) $
 * Revision:      $LastChangedRevision: 2623 $
 */
/* This class was auto-generated by the message builder generator tools. */
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.lab.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CD;
import ca.infoway.messagebuilder.datatype.impl.CDImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.domainvalue.ReferralRedirectIndicator;



/**
 * <p>Business Name: ReferralRedirectIndicator</p>
 * 
 * <p>POLB_MT001000CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p>
 * 
 * <p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p>
 * 
 * <p>POLB_MT001001CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p>
 * 
 * <p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p>
 * 
 * <p>POLB_MT001999CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p>
 * 
 * <p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p>
 * 
 * <p>POLB_MT001010CA.ReferralRedirectIndicator: Referral 
 * Redirect Indicator</p>
 * 
 * <p>OLIS needs a flag at the ObservationRequest level test 
 * request to identify a &quot;reference&quot; test request 
 * because this limits the visibility of the test request in 
 * OLIS to the laboratory sector (i.e., practitioners and 
 * hospitals can't retrieve reference test requests).</p>
 * 
 * <p>This referral redirect flag object is present and the 
 * code is set to &quot;referral&quot; when the order is a 
 * referral order (an order from labA to labB, labA will report 
 * all results), set to &quot;redirect&quot; when the order is 
 * a redirect order (an order from labA to labB, labB will 
 * report the results to ordering provider), or this object is 
 * absent from orders requested by providers.</p>
 */
@Hl7PartTypeMapping({"POLB_MT001000CA.ReferralRedirectIndicator","POLB_MT001001CA.ReferralRedirectIndicator","POLB_MT001010CA.ReferralRedirectIndicator","POLB_MT001999CA.ReferralRedirectIndicator"})
public class ReferralRedirectIndicatorBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private CD code = new CDImpl();


    /**
     * <p>Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     */
    @Hl7XmlMapping({"code"})
    public ReferralRedirectIndicator getCode() {
        return (ReferralRedirectIndicator) this.code.getValue();
    }

    /**
     * <p>Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001000CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001001CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001010CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     * 
     * <p>Other Business Name: ReferralRedirectIndicator</p>
     * 
     * <p>Relationship: 
     * POLB_MT001999CA.ReferralRedirectIndicator.code</p>
     * 
     * <p>Conformance/Cardinality: MANDATORY (1)</p>
     * 
     * <p>Describes this act event as a referral or redirect 
     * indicator act.</p>
     */
    public void setCode(ReferralRedirectIndicator code) {
        this.code.setValue(code);
    }

}
