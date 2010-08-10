/*
 * Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springmodules.validation.util.condition.common;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.TestCase;
import org.springmodules.validation.util.condition.Condition;

/**
 * Tests for {@link InstanceOfCondition}.
 *
 * @author Uri Boness
 */
public class InstanceOfConditionTests extends TestCase {

    public void testConstructor_WithNullClass() throws Exception {
        try {
            new InstanceOfCondition(null);
            fail("An IllegalArgumentException must be thrown if the given class is null");
        } catch (IllegalArgumentException iae) {
            // expected
        }
    }

    public void testCheck_Success() throws Exception {
        Condition condition = new InstanceOfCondition(String.class);
        assertTrue(condition.check("test"));
    }

    public void testCheck_SuccessWithInheritance() throws Exception {
        Condition condition = new InstanceOfCondition(Collection.class);
        assertTrue(condition.check(new ArrayList()));
    }

    public void testCheck_Failure() throws Exception {
        Condition condition = new InstanceOfCondition(String.class);
        assertFalse(condition.check(new Integer(3)));
    }

}