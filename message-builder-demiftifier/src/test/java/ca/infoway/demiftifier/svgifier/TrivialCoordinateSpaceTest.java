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

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import ca.infoway.demiftifier.PackageLocationLayout;
import ca.infoway.demiftifier.LayoutItemBuilder;
import ca.infoway.demiftifier.MessagePartLayoutItem;

@RunWith(MockitoJUnitRunner.class)
public class TrivialCoordinateSpaceTest {
	
	@Mock
	Diagram diagram;
	
	@Mock
	PackageLocationLayout layout;
	
	@Mock
	Shape shape_0_0;
	@Mock
	Shape shape_1_0;
	@Mock
	Shape shape_1_1;
	@Mock
	Shape shape_2_0;
	
	// (2,0) has tallest contents and (1,1) has widest contents
	// Minimum dimensions HxW: (0,0) is 30x50, (1,0) is 30x50, (1,1) is 30x75 and (2,0) is 49x50
	@Test
	public void testMapping() {
		//Inputs
		MessagePartLayoutItem item_0_0 = LayoutItemBuilder.basicBuilder("ABCD_MT123456CA.Type0_0", layout)
				.withLogicalBoundingBox(new BoundingBox(0,0,2,1)).build();
		MessagePartLayoutItem item_1_0 = LayoutItemBuilder.basicBuilder("ABCD_MT123456CA.Type1_0", layout)
				.withLogicalBoundingBox(new BoundingBox(1,0,1,1)).build();
		MessagePartLayoutItem item_1_1 = LayoutItemBuilder.basicBuilder("ABCD_MT123456CA.Type1_1", layout)
				.withLogicalBoundingBox(new BoundingBox(1,1,1,1)).build();
		MessagePartLayoutItem item_2_0 = LayoutItemBuilder.basicBuilder("ABCD_MT123456CA.Type2_0", layout)
				.withLogicalBoundingBox(new BoundingBox(2,0,1,1)).build();
		
		List<Shape> shapes = new ArrayList<Shape>();
		shapes.add(this.shape_1_0);
		shapes.add(this.shape_1_1);
		shapes.add(this.shape_2_0);
		shapes.add(this.shape_0_0);
		
		TrivialCoordinateSpace trivialCoordinateSpace = new TrivialCoordinateSpace();
		
		Mockito.when(this.shape_0_0.getItem()).thenReturn(item_0_0);
		Mockito.when(this.shape_0_0.getBounds()).thenReturn(new BoundingBox(0, 0, 30, 50));
		
		Mockito.when(this.shape_1_0.getItem()).thenReturn(item_1_0);
		Mockito.when(this.shape_1_0.getBounds()).thenReturn(new BoundingBox(0, 0, 30, 50));

		Mockito.when(this.shape_1_1.getItem()).thenReturn(item_1_1);
		Mockito.when(this.shape_1_1.getBounds()).thenReturn(new BoundingBox(0, 0, 30, 75));
				
		Mockito.when(this.shape_2_0.getItem()).thenReturn(item_2_0);
		Mockito.when(this.shape_2_0.getBounds()).thenReturn(new BoundingBox(0, 0, 49, 50));

		Mockito.when(this.diagram.getShapes()).thenReturn(shapes);
		
		//Class under test + required initialisation
		trivialCoordinateSpace.initialize(this.diagram);
		
		//Test getCoordinateSpaceBounds() and assert 
		BoundingBox coordinateSpaceBounds = trivialCoordinateSpace.getCoordinateSpaceBounds();
		assertEqualsIgnorePadding(new BoundingBox(0,0,119,215), coordinateSpaceBounds); //Includes 20 padding on all sides

		//Test getCoordinates() and assert
		
		assertEqualsIgnorePadding(new BoundingBox(20,20,79,50), trivialCoordinateSpace.getCoordinates(item_0_0)); // start at 20,20 because of padding
		assertEqualsIgnorePadding(new BoundingBox(70,20,49,75), trivialCoordinateSpace.getCoordinates(item_1_0));
		assertEqualsIgnorePadding(new BoundingBox(70,69,30,75), trivialCoordinateSpace.getCoordinates(item_1_1));
		assertEqualsIgnorePadding(new BoundingBox(145,20,49,50), trivialCoordinateSpace.getCoordinates(item_2_0));

	}
}
