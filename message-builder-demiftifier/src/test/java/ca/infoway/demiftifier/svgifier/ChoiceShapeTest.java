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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.demiftifier.LogicalDimensions;
import ca.infoway.demiftifier.MessagePartLayoutItem;

// WARNING: the build machine calculates font heights differently than my dev box
@RunWith(MockitoJUnitRunner.class)
public class ChoiceShapeTest {

	@Mock
	MessagePartLayoutItem choiceItem;
	@Mock
	ShapeFactory shapeFactory;
	@Mock
	Shape shape1;
	@Mock
	MessagePartLayoutItem item1;
	@Mock
	Shape shape2;
	@Mock
	MessagePartLayoutItem item2;
	@Mock
	CoordinateSpace coordinateSpace;
	
	@Before
	public void setUp() throws Exception {
		Mockito.when(this.shapeFactory.getShape(this.item1)).thenReturn(this.shape1);
		Mockito.when(this.shapeFactory.getShape(this.item2)).thenReturn(this.shape2);
		
		Mockito.when(this.shape1.getItem()).thenReturn(this.item1);
		Mockito.when(this.shape1.getBounds()).thenReturn(new BoundingBox(0, 0, 30, 100));
		Mockito.when(this.shape2.getItem()).thenReturn(this.item2);
		Mockito.when(this.shape2.getBounds()).thenReturn(new BoundingBox(0, 0, 20, 100));
		
		Mockito.when(this.item1.getLabel()).thenReturn("Item1");
		Mockito.when(this.item2.getLabel()).thenReturn("Item2");
		Mockito.when(this.choiceItem.getLabel()).thenReturn("ChoiceItem");
		
		Mockito.when(this.choiceItem.getSpecializationChilds()).thenReturn(Arrays.asList(this.item1, this.item2));
	}
	
	@Test
	public void shouldExpandRowToAccommodateTrivialSpecializations() {
		Mockito.when(this.item1.getHeight()).thenReturn(0);
		Mockito.when(this.item1.isTrivial()).thenReturn(true);
		Mockito.when(this.item2.getHeight()).thenReturn(1);
		Mockito.when(this.item1.getLogicalY()).thenReturn(4);
		Mockito.when(this.item2.getLogicalY()).thenReturn(5);
		Mockito.when(this.choiceItem.getLogicalY()).thenReturn(4);
		ChoiceShape choiceShape = new ChoiceShape(this.choiceItem, new StyleProvider(), this.shapeFactory);
		int baseHeight = choiceShape.calculateContentHeight();
		
		int height = choiceShape.getMinimalHeightForRow(this.coordinateSpace, 4);
		assertEquals("minimal height -- needs extra height for item1", baseHeight + 50, height); 
		
		int fullHeight = choiceShape.getBounds().getHeight();
		assertEquals("full height -- includes shapes", baseHeight + 85, fullHeight); 
	}
	@Test
	public void shouldExpandRowToAccommodateTrivialSpecializationsThatCanFitInMoreThanOneRow() {
		Mockito.when(this.item1.getHeight()).thenReturn(0);
		Mockito.when(this.item1.isTrivial()).thenReturn(true);
		Mockito.when(this.item2.getHeight()).thenReturn(1);
		Mockito.when(this.item1.getLogicalY()).thenReturn(4);
		Mockito.when(this.item2.getLogicalY()).thenReturn(6);
		Mockito.when(this.choiceItem.getLogicalY()).thenReturn(4);
		Mockito.when(this.coordinateSpace.getCoordinates(Mockito.any(LogicalDimensions.class))).thenReturn(new BoundingBox(0, 0, 10, 80));
		ChoiceShape choiceShape = new ChoiceShape(this.choiceItem, new StyleProvider(), this.shapeFactory);
		
		int baseHeight = choiceShape.calculateContentHeight();
		
		int height = choiceShape.getMinimalHeightForRow(this.coordinateSpace, 4);
		assertEquals("minimal height of row 4 -- basic height for label and margins", baseHeight + 10, height); 
		
		int height2 = choiceShape.getMinimalHeightForRow(this.coordinateSpace, 5);
		assertEquals("minimal height of row 5 -- needs extra height for item1", 30, height2); 
		
		int fullHeight = choiceShape.getBounds().getHeight();
		assertEquals("full height -- includes shapes", baseHeight + 85, fullHeight); 
	}
	@Test
	public void shouldIndicateABaseSize() {
		Mockito.when(this.item1.getHeight()).thenReturn(0);
		Mockito.when(this.item2.getHeight()).thenReturn(0);
		Mockito.when(this.item1.getLogicalY()).thenReturn(4);
		Mockito.when(this.item2.getLogicalY()).thenReturn(4);
		Mockito.when(this.choiceItem.getLogicalY()).thenReturn(4);
		ChoiceShape choiceShape = new ChoiceShape(this.choiceItem, new StyleProvider(), this.shapeFactory);
		int baseHeight = choiceShape.calculateContentHeight();
		
		int height = choiceShape.getMinimalHeightForRow(this.coordinateSpace, 4);
		assertEquals("minimal height -- doesn't include shapes", baseHeight + 10, height); 
		
		int fullHeight = choiceShape.getBounds().getHeight();
		assertEquals("full height -- includes shapes", baseHeight + 85, fullHeight); 
	}

}
