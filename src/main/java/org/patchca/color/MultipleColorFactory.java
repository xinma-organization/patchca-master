/*
 * Copyright (c) 2009 Piotr Piastucki
 * 
 * This file is part of Patchca CAPTCHA library.
 * 
 *  Patchca is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  Patchca is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with Patchca. If not, see <http://www.gnu.org/licenses/>.
 */
package org.patchca.color;

import java.awt.*;
import java.util.Random;

public class MultipleColorFactory implements ColorFactory {

	private static Random random = new Random();
	
	@Override
	public Color getColor(int index) {
        int[] c = new int[3];
        int i = random.nextInt(c.length);
        for (int fi = 0; fi < c.length; fi++) {
            if (fi == i) {
                c[fi] = random.nextInt(71);
            } else {
                c[fi] = random.nextInt(256);
            }
        }
        return new Color(c[0], c[1], c[2]);
	}

}
