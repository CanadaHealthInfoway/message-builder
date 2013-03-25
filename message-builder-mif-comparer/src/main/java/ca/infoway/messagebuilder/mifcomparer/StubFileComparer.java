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

package ca.infoway.messagebuilder.mifcomparer;

import static ca.infoway.messagebuilder.mifcomparer.Message.MessageType.TESTING_CODE;
import static ca.infoway.messagebuilder.mifcomparer.Message.Severity.DEBUG;

import java.io.File;

/**
 * {@link FileComparer} that always reports the files as having no differences.
 * Used for unit testing -- <i>not</i> expected to be useful in production.
 */
public class StubFileComparer extends FileComparer {
	public StubFileComparer(MifFile l, MifFile r, MessageList m) {
		super(l, r, m);

	}

	public StubFileComparer(File l, File r, MessageList m) {
		super(l, r, m);
	}

	/**
	 * Compare two files, adding details of any differences to msgs.
	 * 
	 * @return	the number of differences between the files
	 */
	public int compare() {
		messages.add(new Message(DEBUG, TESTING_CODE, "These files were paired up for comparison", left.getFile(),
				right.getFile()));
		return 0;
	}

}
