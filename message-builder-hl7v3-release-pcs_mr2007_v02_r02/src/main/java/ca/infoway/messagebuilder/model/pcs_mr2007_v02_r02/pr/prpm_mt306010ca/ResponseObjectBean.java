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
package ca.infoway.messagebuilder.model.pcs_mr2007_v02_r02.pr.prpm_mt306010ca;

import ca.infoway.messagebuilder.Code;
import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.CV;
import ca.infoway.messagebuilder.datatype.SET;
import ca.infoway.messagebuilder.datatype.impl.CVImpl;
import ca.infoway.messagebuilder.datatype.impl.SETImpl;
import ca.infoway.messagebuilder.domainvalue.QueryParameterValue;
import ca.infoway.messagebuilder.model.MessagePartBean;
import java.util.Set;



/**
 * <p>Business Name: Response Object</p>
 * 
 * <p>Supports the business request to be able to specify 
 * expected response to this query</p>
 * 
 * <p>This is an optional output control parameter. Sender 
 * indicates via coded values which class or class attributes 
 * in the response model are to be valued in the response. By 
 * site agreement codes can be based upon local object model, 
 * or alternatively, the classes and attributes from the query 
 * response model, as in the example below. Example: requestor 
 * wants provider identifier, name and service delivery 
 * location data returned so ResponseObject is valued as 
 * follows:</p><p>&lt;ResponseObject&gt;&lt;value 
 * code=&quot;HealthCareProvider.id&quot;/&gt;&lt;/ResponseObject&gt;</p><p>&lt;ResponseObject&gt;&lt;value 
 * code=&quot;PrincipalPerson.name&quot;/&gt;&lt;/ResponseObject&gt;</p><p>&lt;ResponseObject&gt;&lt;value 
 * code=&quot;ServiceDeliveryLocation&quot;/&gt;&lt;/ResponseObject&gt;</p><p>Utilized 
 * to support cases when a source or consumer (such as a Health 
 * Authority) wants only specific information about a given set 
 * of providers. For example, a HA might want to know all the 
 * Work Locations for a given provider type, and wouldn't want 
 * to receive all information. The type of information expected 
 * in the response is provided via the response object.</p>
 */
@Hl7PartTypeMapping({"PRPM_MT306010CA.ResponseObject"})
public class ResponseObjectBean extends MessagePartBean {

    private static final long serialVersionUID = 20121204L;
    private SET<CV, Code> value = new SETImpl<CV, Code>(CVImpl.class);


    /**
     * <p>Business Name: Provider Query Response Object</p>
     * 
     * <p>Relationship: PRPM_MT306010CA.ResponseObject.value</p>
     * 
     * <p>Conformance/Cardinality: POPULATED (1-20)</p>
     * 
     * <p>Populated attribute provides tremendous value in giving 
     * the organization issuing the query the flexibility to 
     * request particular items in the response.</p>
     * 
     * <p>Outlines the values expected to be received by this 
     * query</p>
     */
    @Hl7XmlMapping({"value"})
    public Set<QueryParameterValue> getValue() {
        return this.value.rawSet(QueryParameterValue.class);
    }

}
