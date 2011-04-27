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

package ca.infoway.messagebuilder.model.newfoundland.cerx.medicationprofile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.model.newfoundland.NoteBean;
import ca.infoway.messagebuilder.model.newfoundland.cerx.SubstitutionPermissionBean;

@Hl7PartTypeMapping({ "PORX_MT010120CA.CombinedMedicationRequest" })
public class CombinedMedication1Bean extends CombinedMedicationBaseBean {

    private static final long serialVersionUID = -260704236035475306L;

    private final List<NoteBean> annotations = Collections.synchronizedList(new ArrayList<NoteBean>());

    private SubstitutionPermissionBean substitutionPermission;

    public NoteBean getAnnotation() {
    	return this.annotations.isEmpty() ? null : this.annotations.get(0);
    }
    public void setAnnotation(NoteBean noteBean) {
    	this.annotations.clear();
    	this.annotations.add(noteBean);
    }
    
    @Hl7XmlMapping({ "subjectOf2/annotation" })
    public List<NoteBean> getAnnotations() {
        return this.annotations;
    }

    @Hl7XmlMapping({ "subjectOf1/substitutionPermission" })
    public SubstitutionPermissionBean getSubstitutionPermission() {
        return this.substitutionPermission;
    }
    public void setSubstitutionPermission(SubstitutionPermissionBean substitutionPermission) {
        this.substitutionPermission = substitutionPermission;
    }
}
