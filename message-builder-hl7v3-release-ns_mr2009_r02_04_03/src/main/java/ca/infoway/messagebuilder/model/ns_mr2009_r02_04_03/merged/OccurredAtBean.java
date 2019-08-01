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
package ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.ns_mr2009_r02_04_03.common.coct_mt240007ca.ServiceLocationBean;



/**
 * <p>REPC_MT210003CA.Location3: v:referred to</p>
 * 
 * <p>If the referral was targeted to a service delivery 
 * location then the identity of the location must be 
 * known.</p>
 * 
 * <p>Indicates the service Delivery Location where the 
 * referral service is targeted to be preformed.</p><p>The 
 * target site of the referral service provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>REPC_MT610001CA.Location: g:occurred at</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p>
 * 
 * <p> <i>This identifies the location where the Professional 
 * Service actually occurred. E.g. Patient's residence, clinic, 
 * work site, etc. It only needs to be specified when the 
 * occurrence location differs from the official record 
 * location.</i> </p>
 * 
 * <p>REPC_MT230001CA.Location: i:occurred at</p>
 * 
 * <p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>This identifies the location where the actual clinical 
 * event (observation or discharge/care) occurred. E.g. 
 * Patient's residence, clinic, work site, etc. It only needs 
 * to be specified when the occurrence location differs from 
 * the official record location. For referral report, it 
 * indicates the location where the referred service is to be 
 * performed.</p>
 * 
 * <p>REPC_MT500004CA.Location: h:occurred at</p>
 * 
 * <p>Must not be specified when Care Composition Type is 
 * 'Condition-based'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p><p>Multiple repetitions are 
 * allowed for telehealth and other remote encounters.</p>
 * 
 * <p> <i>This identifies the location where the Care 
 * Composition actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p><p>In circumstances where number of 
 * locations involved is greater than the limit supported by 
 * the message, multiple encounters should be used.</p>
 * 
 * <p>REPC_MT210002CA.Location3: v:referred to</p>
 * 
 * <p>If the referral was targeted to a service delivery 
 * location then the identity of the location must be 
 * known.</p>
 * 
 * <p>Indicates the service Delivery Location where the 
 * referral service is targeted to be preformed.</p><p>The 
 * target site of the referral service provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>REPC_MT420001CA.Location: *g:occurred at'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p>
 * 
 * <p> <i>This identifies the location where the Coded 
 * Observation actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p>
 * 
 * <p>REPC_MT230003CA.Location: i:occurred at</p>
 * 
 * <p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>This identifies the location where the actual clinical 
 * event (observation or discharge/care) occurred. E.g. 
 * Patient's residence, clinic, work site, etc. It only needs 
 * to be specified when the occurrence location differs from 
 * the official record location. For referral report, it 
 * indicates the location where the referred service is to be 
 * performed.</p>
 * 
 * <p>REPC_MT500002CA.Location: h:occurred at</p>
 * 
 * <p>Must not be specified when Care Composition Type is 
 * 'Condition-based'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p><p>Multiple repetitions are 
 * allowed for telehealth and other remote encounters.</p>
 * 
 * <p> <i>This identifies the location where the Care 
 * Composition actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p><p>In circumstances where number of 
 * locations involved is greater than the limit supported by 
 * the message, multiple encounters should be used.</p>
 * 
 * <p>REPC_MT220001CA.Location2: i:occurred at</p>
 * 
 * <p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>This identifies the location where the actual 
 * discharge/care event occurred. E.g. Patient's residence, 
 * clinic, work site, hospital, etc. It only needs to be 
 * specified when the occurrence location differs from the 
 * official record location.</p><p>The site of the actual event 
 * provides context for interpreting the record. In some cases, 
 * it may also provide follow-up information</p>
 * 
 * <p>REPC_MT220003CA.Location2: i:occurred at</p>
 * 
 * <p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>This identifies the location where the actual 
 * discharge/care event occurred. E.g. Patient's residence, 
 * clinic, work site, hospital, etc. It only needs to be 
 * specified when the occurrence location differs from the 
 * official record location.</p><p>The site of the actual event 
 * provides context for interpreting the record. In some cases, 
 * it may also provide follow-up information</p>
 * 
 * <p>POIZ_MT030060CA.Location: (no business name)</p>
 * 
 * <p>Needed to communicating where immunization events 
 * occurred. Service delivery location may not always be known, 
 * but is expected in most circumstances. As a result, this 
 * association is populated.</p>
 * 
 * <p>The service delivery location where the immunization 
 * event occurred.</p>
 * 
 * <p>REPC_MT610002CA.Location: g:occurred at</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p>
 * 
 * <p> <i>This identifies the location where the Professional 
 * Service actually occurred. E.g. Patient's residence, clinic, 
 * work site, etc. It only needs to be specified when the 
 * occurrence location differs from the official record 
 * location.</i> </p>
 * 
 * <p>REPC_MT220002CA.Location2: i:occurred at</p>
 * 
 * <p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>This identifies the location where the actual 
 * discharge/care event occurred. E.g. Patient's residence, 
 * clinic, work site, hospital, etc. It only needs to be 
 * specified when the occurrence location differs from the 
 * official record location.</p><p>The site of the actual event 
 * provides context for interpreting the record. In some cases, 
 * it may also provide follow-up information</p>
 * 
 * <p>REPC_MT410001CA.Location: *g:occurred at'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p>
 * 
 * <p> <i>This identifies the location where the Measured 
 * Observation actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p>
 * 
 * <p>REPC_MT420003CA.Location: *g:occurred at'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p>
 * 
 * <p> <i>This identifies the location where the Coded 
 * Observation actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p>
 * 
 * <p>REPC_MT230002CA.Location: i:occurred at</p>
 * 
 * <p>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</p>
 * 
 * <p>This identifies the location where the actual clinical 
 * event (observation or discharge/care) occurred. E.g. 
 * Patient's residence, clinic, work site, etc. It only needs 
 * to be specified when the occurrence location differs from 
 * the official record location. For referral report, it 
 * indicates the location where the referred service is to be 
 * performed.</p>
 * 
 * <p>REPC_MT500003CA.Location: h:occurred at</p>
 * 
 * <p>Must not be specified when Care Composition Type is 
 * 'Condition-based'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p><p>Multiple repetitions are 
 * allowed for telehealth and other remote encounters.</p>
 * 
 * <p> <i>This identifies the location where the Care 
 * Composition actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p><p>In circumstances where number of 
 * locations involved is greater than the limit supported by 
 * the message, multiple encounters should be used.</p>
 * 
 * <p>REPC_MT500001CA.Location: h:occurred at</p>
 * 
 * <p>Must not be specified when Care Composition Type is 
 * 'Condition-based'</p>
 * 
 * <p> <i>The site of the actual event provides context for 
 * interpreting the record. In some cases, it may also provide 
 * follow-up information</i> </p><p>Multiple repetitions are 
 * allowed for telehealth and other remote encounters.</p>
 * 
 * <p> <i>This identifies the location where the Care 
 * Composition actually occurred. E.g. Patient's residence, 
 * clinic, work site, etc. It only needs to be specified when 
 * the occurrence location differs from the official record 
 * location.</i> </p><p>In circumstances where number of 
 * locations involved is greater than the limit supported by 
 * the message, multiple encounters should be used.</p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.Location","POIZ_MT030060CA.Location","POIZ_MT060150CA.Location","REPC_MT210001CA.Location3","REPC_MT210002CA.Location3","REPC_MT210003CA.Location3","REPC_MT220001CA.Location2","REPC_MT220002CA.Location2","REPC_MT220003CA.Location2","REPC_MT230001CA.Location","REPC_MT230002CA.Location","REPC_MT230003CA.Location","REPC_MT410001CA.Location","REPC_MT410003CA.Location","REPC_MT420001CA.Location","REPC_MT420003CA.Location","REPC_MT500001CA.Location","REPC_MT500002CA.Location","REPC_MT500003CA.Location","REPC_MT500004CA.Location","REPC_MT610001CA.Location","REPC_MT610002CA.Location"})
public class OccurredAtBean extends MessagePartBean {

    private static final long serialVersionUID = 20190801L;
    private ServiceLocationBean serviceDeliveryLocation;


    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT610001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT230001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT420001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT230003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500002CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220003CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT610002CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220002CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT410001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT420003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT230002CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    @Hl7XmlMapping({"serviceDeliveryLocation"})
    public ServiceLocationBean getServiceDeliveryLocation() {
        return this.serviceDeliveryLocation;
    }

    /**
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030050CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210003CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT610001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT230001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500004CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210002CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT420001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT230003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500002CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220001CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220003CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT030060CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT610002CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT220002CA.Location2.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT410003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT410001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * POIZ_MT060150CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT420003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT230002CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500003CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT210001CA.Location3.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     * 
     * <p>Un-merged Business Name: (no business name specified)</p>
     * 
     * <p>Relationship: 
     * REPC_MT500001CA.Location.serviceDeliveryLocation</p>
     * 
     * <p>Conformance/Cardinality: REQUIRED (1)</p>
     */
    public void setServiceDeliveryLocation(ServiceLocationBean serviceDeliveryLocation) {
        this.serviceDeliveryLocation = serviceDeliveryLocation;
    }

}
