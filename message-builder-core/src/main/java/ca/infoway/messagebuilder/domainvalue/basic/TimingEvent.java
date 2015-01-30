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
 * Author:        $LastChangedBy: tmcgrady $
 * Last modified: $LastChangedDate: 2013-01-02 17:05:34 -0500 (Wed, 02 Jan 2013) $
 * Revision:      $LastChangedRevision: 6471 $
 */

package ca.infoway.messagebuilder.domainvalue.basic;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>An enum representing all the valid and applicable TimingEvent types used within MessageBuilder.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 *
 * @sharpen.ignore - datatype - translated manually
 */
public class TimingEvent extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.TimingEvent, Describable {

	static{ /*static init block for translation purposes. Please do not remove.*/ }
	
    private static final long serialVersionUID = -2569871003868077442L;
    
    public static final TimingEvent AC = new TimingEvent("AC");
    public static final TimingEvent ACD = new TimingEvent("ACD");
    public static final TimingEvent ACM = new TimingEvent("ACM");
    public static final TimingEvent ACV = new TimingEvent("ACV");
    public static final TimingEvent HS = new TimingEvent("HS");
    public static final TimingEvent IC = new TimingEvent("IC");
    public static final TimingEvent ICD = new TimingEvent("ICD");
    public static final TimingEvent ICM = new TimingEvent("ICM");
    public static final TimingEvent ICV = new TimingEvent("ICV");
    public static final TimingEvent PC = new TimingEvent("PC");
    public static final TimingEvent PCD = new TimingEvent("PCD");
    public static final TimingEvent PCM = new TimingEvent("PCM");
    public static final TimingEvent PCV = new TimingEvent("PCV");

//	AC	before meal (from lat. ante cibus)
//	ACD	ACD	before lunch (from lat. ante cibus diurnus)
//	ACM	ACM	before breakfast (from lat. ante cibus matutinus)
//	ACV	ACV	before dinner (from lat. ante cibus vespertinus)
//	HS	HS	Description: Prior to beginning a regular period of extended sleep (this would exclude naps). Note that this might occur at different times of day depending on a person's regular sleep schedule.
//	IC	IC	between meals (from lat. inter cibus)
//	ICD	ICD	between lunch and dinner
//	ICM	ICM	between breakfast and lunch
//	ICV	ICV	between dinner and the hour of sleep
//	PC	PC	after meal (from lat. post cibus)
//	PCD	PCD	after lunch (from lat. post cibus diurnus)
//	PCM	PCM	after breakfast (from lat. post cibus matutinus)
//	PCV	PCV	after dinner (from lat. post cibus vespertinus)    
    
	private final String description;

    private TimingEvent(String codeValue) {
    	super(codeValue);
        this.description = DescribableUtil.getDefaultDescription(name());
    }
    
    private TimingEvent(String codeValue, String description) {
    	super(codeValue);
		this.description = description;
    }
    
    /**
     * <p>Returns the code system for the URL.
     * 
     * @return the code system for the URL
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_TIMING_EVENT.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeSystemName() {
    	return null;
    }
    
    /**
     * <p>Returns the value (protocol) for the URL.
     * 
     * @return the value (protocol) for the URL.
     */
    public String getCodeValue() {
        return name();
    }

    /**
     * <p>A description of the URL.
     * 
     * @return the URL description
     */
	public String getDescription() {
		return this.description;
	}
	
}
