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

package ca.infoway.messagebuilder.domainvalue.transport;

import ca.infoway.messagebuilder.Describable;
import ca.infoway.messagebuilder.codesystem.CodeSystem;
import ca.infoway.messagebuilder.domainvalue.NullFlavor;
import ca.infoway.messagebuilder.domainvalue.util.DescribableUtil;
import ca.infoway.messagebuilder.lang.EnumPattern;

/**
 * <p>The Enum AcknowledgementDetailCode. A site specific code indicating the specific problem being reported by this Ack Detail.
 */
public class AcknowledgementDetailCode extends EnumPattern implements ca.infoway.messagebuilder.domainvalue.AcknowledgementDetailCode, Describable {
    
	private static final long serialVersionUID = 7919022582239626775L;
	
	public static final AcknowledgementDetailCode INTERNAL_SYSTEM_ERROR = new AcknowledgementDetailCode("INTERNAL_SYSTEM_ERROR", "INTERR");
	public static final AcknowledgementDetailCode MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE = new AcknowledgementDetailCode("MESSAGE_ROUTING_ERROR_DESTINATION_UNREACHABLE", "RTEDEST");
	public static final AcknowledgementDetailCode MESSAGE_ROUTING_ERROR_UNKNOWN_DESTINATION = new AcknowledgementDetailCode("MESSAGE_ROUTING_ERROR_UNKNOWN_DESTINATION", "RTUDEST");
	public static final AcknowledgementDetailCode MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE = new AcknowledgementDetailCode("MESSAGE_ROUTING_WARNING_DESTINATION_UNREACHABLE", "RTWDEST");
	public static final AcknowledgementDetailCode NO_STORAGE_SPACE_FOR_MESSAGE = new AcknowledgementDetailCode("NO_STORAGE_SPACE_FOR_MESSAGE", "NOSTORE");
	public static final AcknowledgementDetailCode SYNTAX_ERROR = new AcknowledgementDetailCode("SYNTAX_ERROR", "SYN");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_REQUIRED_ASSOCIATION_MISSING = new AcknowledgementDetailCode("SYNTAX_ERROR_REQUIRED_ASSOCIATION_MISSING", "SYN100");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_REQUIRED_ATTRIBUTE_MISSING = new AcknowledgementDetailCode("SYNTAX_ERROR_REQUIRED_ATTRIBUTE_MISSING", "SYN101");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_DATA_TYPE_ERROR = new AcknowledgementDetailCode("SYNTAX_ERROR_DATA_TYPE_ERROR", "SYN102");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_VALUE_NOT_FOUND_IN_CODE_SYSTEM = new AcknowledgementDetailCode("SYNTAX_ERROR_VALUE_NOT_FOUND_IN_CODE_SYSTEM", "SYN103");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_INVALID_CODE_SYSTEM_IN_CNE = new AcknowledgementDetailCode("SYNTAX_ERROR_INVALID_CODE_SYSTEM_IN_CNE", "SYN104");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_NUMBER_OF_ASSOCIATION_REPETITIONS_EXCEEDS_LIMIT = new AcknowledgementDetailCode("SYNTAX_ERROR_NUMBER_OF_ASSOCIATION_REPETITIONS_EXCEEDS_LIMIT", "SYN110");
	public static final AcknowledgementDetailCode SYNTAX_ERROR_NUMBER_OF_ATTRIBUTE_REPETITIONS_EXCEEDS_LIMIT = new AcknowledgementDetailCode("SYNTAX_ERROR_NUMBER_OF_ATTRIBUTE_REPETITIONS_EXCEEDS_LIMIT", "SYN112");
	public static final AcknowledgementDetailCode UNKNOWN_SENDER = new AcknowledgementDetailCode("UNKNOWN_SENDER", "NS260");
	public static final AcknowledgementDetailCode UNRECOGNIZED_ATTENTIONLINE = new AcknowledgementDetailCode("UNRECOGNIZED_ATTENTIONLINE", "NS261");
	public static final AcknowledgementDetailCode UNSUPPORTED_INTERACTION = new AcknowledgementDetailCode("UNSUPPORTED_INTERACTION", "NS200");
	public static final AcknowledgementDetailCode UNSUPPORTED_PROCESSING_ID = new AcknowledgementDetailCode("UNSUPPORTED_PROCESSING_ID", "NS202");
	public static final AcknowledgementDetailCode UNSUPPORTED_VERSION_ID = new AcknowledgementDetailCode("UNSUPPORTED_VERSION_ID", "NS203");
	public static final AcknowledgementDetailCode UNSUPPORTED_PROCESSING_MODE = new AcknowledgementDetailCode("UNSUPPORTED_PROCESSING_MODE", "NS250");
	 
	public static final AcknowledgementDetailCode NOT_APPLICABLE = new AcknowledgementDetailCode("NOT_APPLICABLE", ca.infoway.messagebuilder.domainvalue.nullflavor.NullFlavor.NOT_APPLICABLE);

    private final String codeValue;
	private final NullFlavor nullFlavor;

    private AcknowledgementDetailCode(String name, String codeValue) {
    	super(name);
        this.codeValue = codeValue;
        this.nullFlavor = null;
    }

    private AcknowledgementDetailCode(String name, NullFlavor nullFlavor) {
    	super(name);
    	this.codeValue = null;
        this.nullFlavor = nullFlavor;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getCodeSystem() {
        return CodeSystem.VOCABULARY_ACKNOWLEDGEMENT_DETAIL_CODE.getRoot();
    }

    /**
     * {@inheritDoc}
     */
    public String getCodeValue() {
        return this.codeValue;
    }
    
	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return DescribableUtil.getDefaultDescription(this);
	}

	/**
	 * <p>Gets the null flavor.
	 *
	 * @return the null flavor
	 */
	public NullFlavor getNullFlavor() {
		return this.nullFlavor;
	}
	
	/**
	 * <p>Checks for null flavor.
	 *
	 * @return true, if successful
	 */
	public boolean hasNullFlavor() {
		return this.nullFlavor != null;
	}
}
