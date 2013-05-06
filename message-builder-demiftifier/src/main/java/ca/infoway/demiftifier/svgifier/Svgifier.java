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

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.IOUtils;

import ca.infoway.demiftifier.Layout;

public class Svgifier {
	
	private static final String CHI_NAMESPACE = "xmlns:chi=\"urn:infoway-inforoute.ca/chi\"";
	private TrivialCoordinateSpace coordinateSpaceMapper;

	public Svgifier() {
		this(new TrivialCoordinateSpace());
	}
	public Svgifier(TrivialCoordinateSpace coordinateSpaceMapper) {
		this.coordinateSpaceMapper = coordinateSpaceMapper;
	}

	public void render(Layout layout, File file) throws IOException {
		
		FileWriter writer = new FileWriter(file);
		try {
			render(layout, writer);
		} finally {
			IOUtils.closeQuietly(writer);
		}
	}
	public void render(Layout layout, int maxWidth, Writer writer) throws IOException {
		Diagram diagram = new Diagram(layout, getStyleProvider());
		
		this.coordinateSpaceMapper.initialize(diagram);
		
		BoundingBox overall = this.coordinateSpaceMapper.getCoordinateSpaceBounds();
		double ratio = (((double) maxWidth) / (double) overall.getWidth());
		if (ratio < 1) {
			
			int maxHeight = (int) Math.ceil(overall.getHeight() * ratio);
			
			writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"" + maxWidth + 
					"\" height=\"" + maxHeight + "\" " + CHI_NAMESPACE + ">");
			
		} else {
			writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"" + overall.getWidth() + 
					"\" height=\"" + overall.getHeight() + "\" " + CHI_NAMESPACE + ">");
		}
		writeAllShapes(writer, diagram, ratio);
		writer.write("</svg>");
	}
	public void render(Layout layout, Writer writer) throws IOException {
		Diagram diagram = new Diagram(layout, getStyleProvider());
		
		this.coordinateSpaceMapper.initialize(diagram);
		
		BoundingBox overall = this.coordinateSpaceMapper.getCoordinateSpaceBounds();
		writer.write("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"" + overall.getWidth() + 
				"\" height=\"" + overall.getHeight() + "\" " + CHI_NAMESPACE + ">");
		writeAllShapes(writer, diagram, 1);
		writer.write("</svg>");
	}
	private void writeAllShapes(Writer writer, Diagram diagram, double scale)
			throws IOException {
		if (scale < 1) {
			writer.write("<g class=\"demiftifier-root\" transform=\"scale(" + String.format("%3.2f", scale) + ")\">");
		} else {
			writer.write("<g class=\"demiftifier-root\">");
		}
		for (Shape shape : getOrderedShapes(diagram)) {
			if (!shape.getItem().isSpecialization()) {
				shape.renderGroup(this.coordinateSpaceMapper, writer);
			}
		}
		writer.write("</g>");
	}

	private List<Shape> getOrderedShapes(Diagram diagram) {
		List<Shape> result = new ArrayList<Shape>(diagram.getShapes());
		Collections.sort(result, new Comparator<Shape>() {
			public int compare(Shape s1, Shape s2) {
				if (s1.getItem().getLogicalX() != s2.getItem().getLogicalX()) {
					return s1.getItem().getLogicalX() - s2.getItem().getLogicalX();
				} else if (s1.getItem().getLogicalY() != s2.getItem().getLogicalY()) {
					return s1.getItem().getLogicalY() - s2.getItem().getLogicalY();
				} else {
					return s1.getItem().getHeight() - s2.getItem().getHeight();
				}
			}
		});
		return result;
	}

	private StyleProvider getStyleProvider(){
		return this.coordinateSpaceMapper.getStyleProvider();
	}
}
