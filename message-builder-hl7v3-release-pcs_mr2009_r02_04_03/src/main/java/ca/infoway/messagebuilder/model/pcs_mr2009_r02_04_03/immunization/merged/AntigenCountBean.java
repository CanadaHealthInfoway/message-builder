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
package ca.infoway.messagebuilder.model.pcs_mr2009_r02_04_03.immunization.merged;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.INT;
import ca.infoway.messagebuilder.datatype.impl.INTImpl;
import ca.infoway.messagebuilder.model.MessagePartBean;



/**
 * <p>AntigenCount</p>
 * 
 * <p>POIZ_MT030050CA.AntigenCount: Antigen Count</p>
 * 
 * <p><p>Represents the asserted antigen count.</p></p>
 * 
 * <p><p>Allows for an immunization registry to communicate the 
 * current antigen count value.</p></p>
 * 
 * <p>POIZ_MT060150CA.AntigenCount: Antigen Count</p>
 * 
 * <p><p>Represents the asserted antigen count.</p></p>
 * 
 * <p><p>Allows for an immunization registry to communicate the 
 * current antigen count value.</p></p>
 * 
 * <p>POIZ_MT030060CA.AntigenCount: Antigen Count</p>
 * 
 * <p><p>Represents the asserted antigen count.</p></p>
 * 
 * <p><p>Allows for an immunization registry to communicate the 
 * current antigen count value.</p></p>
 */
@Hl7PartTypeMapping({"POIZ_MT030050CA.AntigenCount","POIZ_MT030060CA.AntigenCount","POIZ_MT060150CA.AntigenCount"})
public class AntigenCountBean extends MessagePartBean {

    private static final long serialVersionUID = 20120106L;
    private INT value = new INTImpl();


    /**
     * <p>AntigenCountValue</p>
     * 
     * <p>Antigen Count Value</p>
     * 
     * <p><p>Represents the asserted antigen count.</p></p>
     * 
     * <p><p>Allows for an immunization registry to communicate the 
     * current antigen count value.</p></p>
     */
    @Hl7XmlMapping({"value"})
    public Integer getValue() {
        return this.value.getValue();
    }
    public void setValue(Integer value) {
        this.value.setValue(value);
    }

}
