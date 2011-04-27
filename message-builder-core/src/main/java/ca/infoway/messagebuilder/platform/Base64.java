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

package ca.infoway.messagebuilder.platform;

/**
 * @sharpen.ignore platform
 */
public class Base64 {
	
	public static byte[] decodeBase64(byte[] base64Data) {
		return org.apache.commons.codec.binary.Base64.decodeBase64(base64Data);
	}

	public static byte[] encodeBase64(byte[] binaryData) {
		return org.apache.commons.codec.binary.Base64.encodeBase64(binaryData);
	}

	public static String encodeBase64String(byte[] binaryData) {
		return new String(encodeBase64(binaryData));
	}

	public static byte[] decodeBase64String(String text) {
		return decodeBase64(text.getBytes());
	}

}
