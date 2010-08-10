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

package org.springmodules.validation.bean.rule;

import org.springmodules.validation.util.condition.Condition;
import org.springmodules.validation.util.condition.date.jodatime.IsInTheFutureInstantCondition;

/**
 * An {@link AbstractValidationRule} implementation that validates and checks that a {@link org.joda.time.Instant}
 * occures in the future (relative to the time of validation).
 *
 * @author Uri Boness
 */
public class InstantInTheFutureValidationRule extends AbstractValidationRule {

    private final static String DEFAULT_ERROR_CODE = "in.future";

    /**
     * Constructs a new InstantInTheFutureValidationRule.
     */
    public InstantInTheFutureValidationRule() {
        super(InstantInTheFutureValidationRule.DEFAULT_ERROR_CODE);
    }

    /**
     * Returns the condition of this validation rule.
     *
     * @see org.springmodules.validation.bean.rule.AbstractValidationRule#getCondition()
     */
    public Condition getCondition() {
        return new IsInTheFutureInstantCondition();
    }

}
