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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090302ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.II;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.impl.IIImpl;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.lang.Identifier;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT090302CA.AssignedDevice"})
@Hl7RootType
public class ApplicationBean extends MessagePartBean implements ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.pharmacy.merged.ChangedBy {

    private static final long serialVersionUID = 20110831L;
    private II applicationId = new IIImpl();
    private ST applicationName = new STImpl();


    /**
     * <p>C:Application Id</p>
     */
    @Hl7XmlMapping({"id"})
    public Identifier getApplicationId() {
        return this.applicationId.getValue();
    }
    public void setApplicationId(Identifier applicationId) {
        this.applicationId.setValue(applicationId);
    }


    /**
     * <p>B:Application Name</p>
     */
    @Hl7XmlMapping({"assignedDevice/name"})
    public String getApplicationName() {
        return this.applicationName.getValue();
    }
    public void setApplicationName(String applicationName) {
        this.applicationName.setValue(applicationName);
    }

}
