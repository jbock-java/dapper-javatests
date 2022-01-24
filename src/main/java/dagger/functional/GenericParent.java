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

import jakarta.inject.Inject;
import jakarta.inject.Provider;

class GenericParent<X, Y> {

  final Provider<X> registeredX;
  final Y registeredY;
  final B registeredB;
  final Parameterized<Y> registerParameterizedOfY;
  final Provider<X> x;
  final Y y;
  final B b;
  final Parameterized<X> parameterizedOfX;

  @Inject
  GenericParent(
      Provider<X> registeredX,
      Y registeredY,
      B registeredB,
      Parameterized<Y> registerParameterizedOfY,
      Provider<X> x,
      Y y,
      B b,
      Parameterized<X> parameterizedOfX) {
    this.registeredX = registeredX;
    this.registeredY = registeredY;
    this.registeredB = registeredB;
    this.registerParameterizedOfY = registerParameterizedOfY;
    this.x = x;
    this.y = y;
    this.b = b;
    this.parameterizedOfX = parameterizedOfX;
  }


  static class Parameterized<P> {
    private final P p;

    @Inject
    Parameterized(P p) {
      this.p = p;
    }
  }
}
