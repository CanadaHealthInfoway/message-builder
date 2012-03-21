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
package ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.pharmacy.porx_mt980030ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.sk_cerx_v01_r04_3.common.coct_mt220210ca.DrugProductBean;



/**
 * <p>*a:dispensed</p>
 * 
 * <p><p>Indicates the drug that was dispensed</p></p>
 * 
 * <p><p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p></p>
 * 
 * <p><p>Important information for issue management.</p><p>The 
 * association is marked as populated because it may be 
 * masked.</p></p>
 */
@Hl7PartTypeMapping({"PORX_MT980030CA.Product"})
public class DispensedBean extends MessagePartBean {

    private static final long serialVersionUID = 20120320L;
    private DrugProductBean medication;


    @Hl7XmlMapping({"medication"})
    public DrugProductBean getMedication() {
        return this.medication;
    }
    public void setMedication(DrugProductBean medication) {
        this.medication = medication;
    }

}
