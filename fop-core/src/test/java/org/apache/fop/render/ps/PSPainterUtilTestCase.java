/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.fop.render.ps;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Test;

import org.apache.xmlgraphics.ps.PSGenerator;

public class PSPainterUtilTestCase {
    @Test
    public void testDrawTransparency() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PSGenerator generator = new PSGenerator(bos);
        Color color = new Color(0, 0, 0, 128);
        PSPainterUtil.drawTransparency(generator, new Rectangle(10000, 10000), color);
        Assert.assertTrue(bos.toString().contains("imagemask"));
    }
}
