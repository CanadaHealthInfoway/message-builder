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

package ca.infoway.messagebuilder.util.telephone;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * <p>A utility to parse standard North-American telephone numbers.
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore util.telephone
 */
public class TelephoneParser {
	
	private static final String PUNCTUATION = "+()- :;=";

	/**
	 * <p>Parse a string representation of a telephone into an object.
	 * @param telephoneNumber - the string representation of the telephone.
	 * @return - the telephone number as a parsed object.
	 */
	public Telephone createTelephone(String telephoneNumber) {
		if (StringUtils.isBlank(telephoneNumber)) {
			return null;
		} else if (isOnlyNumbers(telephoneNumber)) {
			return processNumericNumber(telephoneNumber);
		} else {
			return processFormattedTelephoneNumber(telephoneNumber);
		}
	}

	/* This is a bit dreadful, but it seems to work */ 
	private Telephone processFormattedTelephoneNumber(String telephoneNumber) {
		String areaCode = null;
		String extension = null;
		String firstPart = null;
		TelephoneLocalNumber number = null;
		boolean bracket = false;
		boolean invalid = false;
		boolean extensionIndicator = false;
		boolean firstTime = true;
		
		for (String token : tokenize(telephoneNumber)) {
			
			if (StringUtils.isBlank(token)) {
				// ignore it
			} else if ("(".equals(token)) {
				if (bracket || areaCode != null || number != null) {
					invalid = true;
					break;
				} else {
					bracket = true;
				}
			} else if (")".equals(token)) {
				if (bracket && areaCode != null) {
					bracket = false;
				} else {
					invalid = true;
					break;
				}
			} else if (isExtensionIndicator(token)) {
				if (extension == null) {
					extensionIndicator = true;
				} else {
					invalid = true;
					break;
				}
			} else if (isOnlyNumbers(token) && extensionIndicator) {
				extension = token;
				extensionIndicator = false;
			} else if (isOnlyNumbers(token) && token.length() == 3 && bracket) {
				if (areaCode == null) {
					areaCode = token;
				} else {
					invalid = true;
					break;
				}
			} else if (isOnlyNumbers(token) && token.length() == 3) {
				if (firstPart == null) {
					firstPart = token;
				} else if (areaCode == null) {
					areaCode = firstPart;
					firstPart = token;
				} else {
					invalid = true;
					break;
				}
			} else if (isOnlyNumbers(token) && token.length() == 4) {
				if (firstPart == null) {
					invalid = true;
					break;
				} else {
					Telephone temp = processNumericNumber(firstPart + token);
					number = temp.getPhoneNumber();
					firstPart = null;
				}
			} else if (isOnlyNumbers(token) && token.length() == 7) {
				if (firstPart != null) {
					if (areaCode == null) {
						areaCode = firstPart;
						firstPart = null;
					} else {
						invalid = true;
						break;
					}
				}
				Telephone temp = processNumericNumber(token);
				number = temp.getPhoneNumber();
			} else if (isPunctuation(token)) {
				// ignore it
			} else if ("1".equals(token) && firstTime) {
				// ignore it
			} else {
				invalid = true;
				break;
			}
			if (!"+".equals(token)) {
				firstTime = false;
			}
		}
		
		if (number != null && !bracket && !invalid && !extensionIndicator) {
			Telephone result = new Telephone();
			result.setAreaCode(areaCode);
			result.setPhoneNumber(number);
			result.setExtension(extension);
			return result;
		} else {
			return null;
		}
	}

	private boolean isPunctuation(String token) {
		return PUNCTUATION.indexOf(token) >= 0;
	}

	private boolean isExtensionIndicator(String token) {
		return "x".equalsIgnoreCase(token) || "ext".equalsIgnoreCase(token);
	}

	private Telephone processNumericNumber(String telephoneNumber) {
		Telephone telephone = new Telephone();
		switch (telephoneNumber.length()) {
		case 11:
			if ("1".equals(StringUtils.substring(telephoneNumber, 0, 1))) {
				return processNumericNumber(StringUtils.substring(telephoneNumber, 1));
			} else {
				return null;
			}
		case 10:
			telephone.setAreaCode(StringUtils.substring(telephoneNumber, 0, 3));
			telephoneNumber = StringUtils.substring(telephoneNumber, 3);
			telephone.setPhoneNumber(TelephoneLocalNumber.create(telephoneNumber));
			return telephone;
			
		case 7:
			telephone.setPhoneNumber(TelephoneLocalNumber.create(telephoneNumber));
			return telephone;
		
		default:
			return null;
		}
	}

	private boolean isOnlyNumbers(String telephoneNumber) {
		boolean result = true;
		for (Character c : telephoneNumber.toCharArray()) {
			if ("0123456789".indexOf(c) < 0) {
				result = false;
				break;
			}
		}
		return result;
	}
	
	private List<String> tokenize(String number) {
		List<String> result = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		
		for (Character c : number.toCharArray()) {
			if (isPunctuation(c.toString()) || Character.isWhitespace(c)) {
				if (builder.length() > 0) {
					result.add(builder.toString());
					builder.setLength(0);
				}
				result.add(c.toString());
			} else if (isOnlyNumbers(c.toString())) {
				if (builder.length() > 0 && !isOnlyNumbers(builder.toString())) {
					result.add(builder.toString());
					builder.setLength(0);
				}
				builder.append(c);
			} else {
				if (builder.length() > 0 && isOnlyNumbers(builder.toString())) {
					result.add(builder.toString());
					builder.setLength(0);
				}
				builder.append(c);
			}
		}
		if (builder.length() > 0) {
			result.add(builder.toString());
			builder.setLength(0);
		}
		
		return result;
	}
}
