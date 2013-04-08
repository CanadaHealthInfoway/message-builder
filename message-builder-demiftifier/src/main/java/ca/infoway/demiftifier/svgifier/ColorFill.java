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

import static java.lang.Integer.toHexString;
import static org.apache.commons.lang.StringUtils.leftPad;

import java.awt.Color;

public class ColorFill implements Fill {

	private final Color color;

	public ColorFill(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

	public String toSvgString() {
		return "#" 
				+ leftPad(toHexString(this.color.getRed()), 2, '0')
				+ leftPad(toHexString(this.color.getGreen()), 2, '0')
				+ leftPad(toHexString(this.color.getBlue()), 2, '0');
	}
	
	public Fill makeGrey() {
		return new ColorFill(interpolate(this.color, new Color(0xaa, 0xaa, 0xaa), 0.5f));
	}

	private Color interpolate(Color a, Color b, float percent) {
		float[] aValues = a.getRGBComponents(null);
		float[] bValues = b.getRGBComponents(null);
		return new Color(interpolate(aValues[0], bValues[0], percent),
				interpolate(aValues[1], bValues[1], percent),
				interpolate(aValues[2], bValues[2], percent),
				interpolate(aValues[3], bValues[3], percent));
	}

	float interpolate(float a, float b, float percent) {
        return a * (1.0f - percent) + b * percent;
    }
}
