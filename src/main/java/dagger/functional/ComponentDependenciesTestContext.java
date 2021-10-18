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

import dagger.Component;

/**
 * Tests component dependencies.
 */
public final class ComponentDependenciesTestContext {
  public interface One {
    String getString();
  }

  public interface Two {
    String getString();
  }

  public interface Merged extends One, Two {
  }

  @Component(dependencies = Merged.class)
  interface TestComponent {
    String getString();

    @Component.Builder
    interface Builder {
      Builder dep(Merged dep);

      TestComponent build();
    }
  }

  public interface OneOverride {
    Object getString();
  }

  public interface TwoOverride {
    Object getString();
  }

  public interface MergedOverride extends OneOverride, TwoOverride {
    @Override
    String getString();
  }

  @Component(dependencies = MergedOverride.class)
  interface TestOverrideComponent {
    String getString();

    @Component.Builder
    interface Builder {
      Builder dep(MergedOverride dep);

      TestOverrideComponent build();
    }
  }
}
