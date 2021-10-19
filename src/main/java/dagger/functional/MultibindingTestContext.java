/*
 * Copyright (C) 2015 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.functional;

import com.google.auto.value.AutoAnnotation;
import dagger.multibindings.ClassKey;
import dagger.multibindings.StringKey;

public class MultibindingTestContext {

    @AutoAnnotation
    static StringKey testStringKey(String value) {
        return new AutoAnnotation_MultibindingTestContext_testStringKey(value);
    }

    @AutoAnnotation
    static NestedAnnotationContainer.NestedWrappedKey nestedWrappedKey(Class<?> value) {
        return new AutoAnnotation_MultibindingTestContext_nestedWrappedKey(value);
    }

    @AutoAnnotation
    static WrappedAnnotationKey testWrappedAnnotationKey(
            StringKey value, int[] integers, ClassKey[] annotations, Class<? extends Number>[] classes) {
        return new AutoAnnotation_MultibindingTestContext_testWrappedAnnotationKey(
                value, integers, annotations, classes);
    }
}
