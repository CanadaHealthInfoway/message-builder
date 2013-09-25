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
 * Last modified: $LastChangedDate: 2013-08-13 19:55:44 -0300 (Tue, 13 Aug 2013) $
 * Revision:      $LastChangedRevision: 7826 $
 */
package ca.infoway.messagebuilder.j5goodies;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author <a href="http://www.intelliware.ca/">Intelliware Development</a>
 * 
 * @sharpen.ignore j5goodies - Translated manually
 */
public class CollectionSorter {

	public static <T> void sort(List<T> list, Comparator<? super T> c) {
		Collections.sort(list, c);
	}
}
