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

package org.springmodules.validation.util.cel.valang;

import org.springmodules.validation.util.cel.CelParseException;
import org.springmodules.validation.util.cel.ConditionExpressionParser;
import org.springmodules.validation.util.condition.Condition;
import org.springmodules.validation.util.condition.adapter.CommonsPredicateCondition;
import org.springmodules.validation.valang.parser.ParseException;
import org.springmodules.validation.valang.parser.SimpleValangBased;

/**
 * A {@link ConditionExpressionParser} implementation that knows how to parse valang boolean expressions.
 *
 * @author Uri Boness
 */
public class ValangConditionExpressionParser extends SimpleValangBased implements ConditionExpressionParser {

    public Condition parse(String expression) throws CelParseException {
        try {
            return new CommonsPredicateCondition(createValangParser(expression).parseExpression());
        } catch (ParseException pe) {
            throw new CelParseException("Could not parse valang expression '" + expression + "'", pe);
        }
    }

}
