/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
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

package org.optaplanner.quarkus.gizmo.annotations;

import java.lang.annotation.Annotation;
import java.util.Comparator;
import java.util.Map;

import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariableGraphType;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

public class QuarkusRecordablePlanningVariable extends AbstractQuarkusRecordableAnnotation implements PlanningVariable {

    public QuarkusRecordablePlanningVariable() {
    }

    public QuarkusRecordablePlanningVariable(Map<String, Object> map) {
        super(map);
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return PlanningVariable.class;
    }

    @Override
    public String[] valueRangeProviderRefs() {
        return getParameter("valueRangeProviderRefs", String[].class);
    }

    @Override
    public boolean nullable() {
        return getParameter("nullable", Boolean.class);
    }

    @Override
    public PlanningVariableGraphType graphType() {
        return PlanningVariableGraphType.valueOf(getParameter("graphType", String.class));
    }

    @Override
    public Class<? extends Comparator> strengthComparatorClass() {
        return getParameter("strengthComparatorClass", Class.class);
    }

    @Override
    public Class<? extends SelectionSorterWeightFactory> strengthWeightFactoryClass() {
        return getParameter("strengthWeightFactoryClass", Class.class);
    }
}
