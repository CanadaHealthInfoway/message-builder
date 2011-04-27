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
package ca.infoway.messagebuilder.model.pcs_cerx_v01_r04_3.common.coct_mt090310ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.ST;
import ca.infoway.messagebuilder.datatype.TEL;
import ca.infoway.messagebuilder.datatype.impl.STImpl;
import ca.infoway.messagebuilder.datatype.impl.TELImpl;
import ca.infoway.messagebuilder.datatype.lang.TelecommunicationAddress;
import ca.infoway.messagebuilder.model.MessagePartBean;



@Hl7PartTypeMapping({"COCT_MT090310CA.AssignedDevice"})
@Hl7RootType
public class EHRRepositoryBean extends MessagePartBean {

    private static final long serialVersionUID = 20110407L;
    private ST repositoryName = new STImpl();
    private TEL repositoryURL = new TELImpl();
    private ST repositoryJurisdictionName = new STImpl();


    /**
     * <p>Repository Name</p>
     */
    @Hl7XmlMapping({"assignedRepositoryLocation/name"})
    public String getRepositoryName() {
        return this.repositoryName.getValue();
    }
    public void setRepositoryName(String repositoryName) {
        this.repositoryName.setValue(repositoryName);
    }


    /**
     * <p>Repository URL</p>
     */
    @Hl7XmlMapping({"assignedRepositoryLocation/telecom"})
    public TelecommunicationAddress getRepositoryURL() {
        return this.repositoryURL.getValue();
    }
    public void setRepositoryURL(TelecommunicationAddress repositoryURL) {
        this.repositoryURL.setValue(repositoryURL);
    }


    /**
     * <p>Repository Jurisdiction Name</p>
     */
    @Hl7XmlMapping({"representedRepositoryJurisdiction/name"})
    public String getRepositoryJurisdictionName() {
        return this.repositoryJurisdictionName.getValue();
    }
    public void setRepositoryJurisdictionName(String repositoryJurisdictionName) {
        this.repositoryJurisdictionName.setValue(repositoryJurisdictionName);
    }

}
