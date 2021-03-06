/*
 * Copyright (C) 2020 The Dagger Authors.
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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests component dependencies.
 */
public final class ComponentDependenciesTest {

  @Test
  void testSameMethodTwice() {
    ComponentDependenciesTestContext.TestComponent component =
        DaggerComponentDependenciesTestContext_TestComponent.builder().dep(() -> "test").build();
    assertEquals("test", component.getString());
  }

  @Test
  void testPolymorphicOverridesStillCompiles() {
    ComponentDependenciesTestContext.TestOverrideComponent component =
        DaggerComponentDependenciesTestContext_TestOverrideComponent.builder().dep(() -> "test").build();
    assertEquals("test", component.getString());
  }
}
