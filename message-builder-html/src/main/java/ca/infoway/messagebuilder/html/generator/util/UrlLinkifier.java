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
package ca.infoway.messagebuilder.html.generator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UrlLinkifier {
	
	private static final String URL_REGEX = "(?i)\\b((?:https?:(?:/{1,3}|[a-z0-9%])|www\\d{0,3}[.]|[a-z0-9.\\-]+[.][a-z]{2,4}/)(?:[^\\s()<>]+|\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\))+(?:\\(([^\\s()<>]+|(\\([^\\s()<>]+\\)))*\\)|[^\\s`!()\\[\\]{};:'\".,<>?«»“”‘’]))";
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	private static final String EMAIL_REGEX = "([a-z0-9](?:[-a-z0-9._]*[a-z0-9])?\\@[a-z0-9](?:[a-z0-9-]*[a-z0-9])?(?:\\.[a-z0-9][-a-z0-9_]*[a-z0-9])+)";
	private static final Pattern REGEX_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static String linkify(String rawText) {
		Matcher urlMatcher = URL_PATTERN.matcher(rawText);
		String urlText = urlMatcher.replaceAll("<a href=\"$1\" target=\"_blank\">$1</a>");
		
		Matcher emailMatcher = REGEX_PATTERN.matcher(urlText);
		String finalText = emailMatcher.replaceAll("<a href=\"mailto:$1\">$1</a>");
		
		return finalText;
	}
}
