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
package ca.infoway.demiftifier.svgifier;

import static ca.infoway.demiftifier.AssertWrapper.assertEqualsIgnorePadding;
import junit.framework.Assert;

import org.junit.Test;

public class BoundingBoxTest {

	@Test
	public void testGetContentBounds_NoPadding() {
		BoundingBox boundingBox = new BoundingBox(30, 50, 22, 39); 
		Assert.assertSame(boundingBox, boundingBox.getUnpaddedBounds());
	}

	@Test
	public void testWithPadding() {
		BoundingBox boundingBox = new BoundingBox(30, 50, 22, 39);
		BoundingBox paddedBox = boundingBox.withPadding(Padding.padAllSides(17));
		assertEqualsIgnorePadding(new BoundingBox(30, 50, 56, 73), paddedBox);
	}

	@Test
	public void testGetContentBounds_WithPadding() {
		BoundingBox boundingBox = new BoundingBox(30, 50, 22, 39);
		BoundingBox paddedBox = boundingBox.withPadding(Padding.padAllSides(17));
		assertEqualsIgnorePadding(new BoundingBox(47, 67, 22, 39), paddedBox.getUnpaddedBounds());
	}

}
