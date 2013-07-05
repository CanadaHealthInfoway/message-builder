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
 * Author:        $LastChangedBy: spd $
 * Last modified: $LastChangedDate: 2012-01-10 20:35:55 -0500 (Tue, 10 Jan 2012) $
 * Revision:      $LastChangedRevision: 3319 $
 */

package ca.infoway.messagebuilder.xml.util;

import ca.infoway.messagebuilder.xml.Cardinality;
import ca.infoway.messagebuilder.xml.ConformanceLevel;
import ca.infoway.messagebuilder.xml.Relationship;

public class ConformanceLevelUtil {
	
	public static final String ASSOCIATION_IS_IGNORED_AND_CAN_NOT_BE_USED = "Association is ignored and can not be used: ({0})";
	public static final String ASSOCIATION_IS_IGNORED_AND_WILL_NOT_BE_USED = "Association is ignored and will not be used: ({0})";
	public static final String ATTRIBUTE_IS_IGNORED_AND_CAN_NOT_BE_USED = "Attribute is ignored and can not be used: ({0})";
	public static final String ATTRIBUTE_IS_IGNORED_AND_WILL_NOT_BE_USED = "Attribute is ignored and will not be used: ({0})";
	public static final String ASSOCIATION_IS_NOT_ALLOWED = "Association is not allowed: ({0})";
	public static final String ATTRIBUTE_IS_NOT_ALLOWED = "Attribute is not allowed: ({0})";
	public static final String IGNORED_AS_NOT_ALLOWED = "ignored.as.not.allowed";
	
	public static boolean isIgnoredNotAllowed() {
		return Boolean.valueOf(System.getProperty(IGNORED_AS_NOT_ALLOWED));
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is mandatory.
	 * @return true if the relationship is mandatory; false otherwise.
	 */
	public static boolean isMandatory(Relationship relationship) {
		return isMandatory(relationship.getConformance(), relationship.getCardinality());
	}

	/**
	 * <p>Get a flag indicating whether or not the relationship is mandatory.
	 * @return true if the relationship is mandatory; false otherwise.
	 */
	public static boolean isMandatory(ConformanceLevel conformanceLevel, Cardinality cardinality) {
		return ConformanceLevel.MANDATORY.equals(conformanceLevel);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is populated.
	 * @return true if the relationship is populated; false otherwise.
	 */
	public static boolean isPopulated(Relationship relationship) {
		return isPopulated(relationship.getConformance(), relationship.getCardinality());
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is populated.
	 * @return true if the relationship is populated; false otherwise.
	 */
	public static boolean isPopulated(ConformanceLevel conformanceLevel, Cardinality cardinality) {
		// - this *almost* matches what MB was doing prior to a Remixer change to BaseMifProcessorImpl
		// - IGNORED and NOT_ALLOWED with a min cardinality > 0 (a very strange state!) will behave differently than before the Remixer change 
		// - populated should eventually be removed as a conformance altogether
		return ConformanceLevel.POPULATED.equals(conformanceLevel) ||
				(ConformanceLevel.REQUIRED.equals(conformanceLevel) && cardinality.isMandatory());
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is required.
	 * @return true if the relationship is required; false otherwise.
	 */
	public static boolean isRequired(Relationship relationship) {
		return isRequired(relationship.getConformance(), relationship.getCardinality());
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is required.
	 * @return true if the relationship is required; false otherwise.
	 */
	public static boolean isRequired(ConformanceLevel conformanceLevel, Cardinality cardinality) {
		return ConformanceLevel.REQUIRED.equals(conformanceLevel) && !cardinality.isMandatory();
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is optional.
	 * @return true if the relationship is optional; false otherwise.
	 */
	public static boolean isOptional(Relationship relationship) {
		return isOptional(relationship.getConformance(), relationship.getCardinality());
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is optional.
	 * @return true if the relationship is optional; false otherwise.
	 */
	public static boolean isOptional(ConformanceLevel conformanceLevel, Cardinality cardinality) {
		return ConformanceLevel.OPTIONAL.equals(conformanceLevel);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is ignored.
	 * @return true if the relationship is ignored; false otherwise.
	 */
	public static boolean isIgnored(Relationship relationship) {
		return isIgnored(relationship.getConformance(), relationship.getCardinality());
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is ignored.
	 * @return true if the relationship is ignored; false otherwise.
	 */
	public static boolean isIgnored(ConformanceLevel conformanceLevel, Cardinality cardinality) {
		return ConformanceLevel.IGNORED.equals(conformanceLevel);
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is not allowed.
	 * @return true if the relationship is not allowed; false otherwise.
	 */
	public static boolean isNotAllowed(Relationship relationship) {
		return isNotAllowed(relationship.getConformance(), relationship.getCardinality());
	}
	
	/**
	 * <p>Get a flag indicating whether or not the relationship is not allowed.
	 * @return true if the relationship is not allowed; false otherwise.
	 */
	public static boolean isNotAllowed(ConformanceLevel conformanceLevel, Cardinality cardinality) {
		return ConformanceLevel.NOT_ALLOWED.equals(conformanceLevel);
	}
	
}
