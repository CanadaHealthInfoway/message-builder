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
 * Author:        $LastChangedBy$
 * Last modified: $LastChangedDate$
 * Revision:      $LastChangedRevision$
 */

/**
 * Tests against third-party dependencies.
 * 
 * <p>This package contains JUnit tests against third-party dependencies.  The tests are intended to:<ul>
 * 		<li>document behaviour that has been discovered about the package in question (which might mean,
 * 			codifying the exploration that was done while learning to use the API), and
 * 		<li>verify that the behaviour continues to hold (i.e. after upgrading to a new version of the dependency).
 * </ul>
 * The first of these is especially important for behaviour that is <i>surprising</i>, and/or caused the developer
 * trouble (e.g. requiring workarounds).
 * 
 * <p>These tests do <i>not</i> test our own code; thus, they should <i>not</i> be considered "unit tests",
 * or even "integration tests", even though they use the JUnit framework and testing style.
 * 
 * <p>Classes are named for the third-party package in question.
 * 
 * @see http://groboutils.sourceforge.net/testing-junit/art_eut.html
 */
package ca.infoway.messagebuilder.mifcomparer.thirdpartytests;
