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
package ca.infoway.messagebuilder.model.common.pome_mt010100ca;

import ca.infoway.messagebuilder.annotation.Hl7PartTypeMapping;
import ca.infoway.messagebuilder.annotation.Hl7RootType;
import ca.infoway.messagebuilder.annotation.Hl7XmlMapping;
import ca.infoway.messagebuilder.datatype.MO;
import ca.infoway.messagebuilder.datatype.impl.MOImpl;
import ca.infoway.messagebuilder.datatype.lang.Money;
import ca.infoway.messagebuilder.model.MessagePartBean;
import ca.infoway.messagebuilder.model.merged.DistinguishedByBean;
import ca.infoway.messagebuilder.model.merged.DrugOrCompoundBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * <p>Medication 
 * 
 * <p>Represents a particular medicine or herbal product which 
 * might be prescribed or administered. 
 * 
 * <p>Allows retrieval of summary about one or more products 
 * when searching for a medication 
 */
@Hl7PartTypeMapping({"POME_MT010100CA.Medication"})
@Hl7RootType
public class MedicationBean extends MessagePartBean {

    private DrugOrCompoundBean player = new DrugOrCompoundBean();
    private MO drugCost = new MOImpl();
    private List<DistinguishedByBean> subjectOf2 = new ArrayList<DistinguishedByBean>();

    @Hl7XmlMapping({"player"})
    public DrugOrCompoundBean getPlayer() {
        return this.player;
    }
    public void setPlayer(DrugOrCompoundBean player) {
        this.player = player;
    }

    @Hl7XmlMapping({"subjectOf1/potentialCharge/unitPriceAmt"})
    public Money getDrugCost() {
        return this.drugCost.getValue();
    }
    public void setDrugCost(Money drugCost) {
        this.drugCost.setValue(drugCost);
    }

    @Hl7XmlMapping({"subjectOf2"})
    public List<DistinguishedByBean> getSubjectOf2() {
        return this.subjectOf2;
    }

}
