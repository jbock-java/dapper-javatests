/*
 * Copyright (C) 2016 Google, Inc.
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
package dagger.internal.codegen;

import java.io.File;
import java.util.List;
import java.util.Optional;
import javax.annotation.processing.Processor;
import javax.tools.JavaCompiler;

public abstract class Compiler {

  abstract JavaCompiler javaCompiler();

  /** The annotation processors applied during compilation. */
  public abstract List<Processor> processors();

  /** The options passed to the compiler. */
  public abstract List<String> options();

  /** The compilation class path. If not present, the system class path is used. */
  public abstract Optional<List<File>> classPath();

  /**
   * The annotation processor path. If not present, the system annotation processor path is used.
   */
  public abstract Optional<List<File>> annotationProcessorPath();
}
