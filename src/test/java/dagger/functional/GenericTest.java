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

import dagger.functional.sub.Exposed;
import dagger.functional.sub.PublicSubclass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenericTest {

  @Test
  void testGenericComponentCreate() {
    GenericComponent component = DaggerGenericComponent.create();
    assertNotNull(component);
  }

  @Test
  void testGenericSimpleReferences() {
    GenericComponent component = DaggerGenericComponent.create();
    assertNotNull(component.referencesGeneric().genericA.t);
  }

  @Test
  void testGenericDoubleReferences() {
    GenericComponent component = DaggerGenericComponent.create();
    GenericDoubleReferences<A> doubleA = component.doubleGenericA();
    assertNotNull(doubleA.a);
    assertNotNull(doubleA.a2);
    assertNotNull(doubleA.t);
    assertNotNull(doubleA.t2);

    GenericDoubleReferences<B> doubleB = component.doubleGenericB();
    assertNotNull(doubleB.a);
    assertNotNull(doubleB.a2);
    assertNotNull(doubleB.t);
    assertNotNull(doubleB.t2);
  }

  @Test
  void complexGenerics() {
    GenericComponent component = DaggerGenericComponent.create();
    // validate these can be called w/o exceptions.
    component.complexGenerics();
  }

  @Test
  void noDepsGenerics() {
    GenericComponent component = DaggerGenericComponent.create();
    // validate these can be called w/o exceptions.
    component.noDepsA();
    component.noDepsB();
  }

  @Test
  void boundedGenerics() {
    BoundedGenericModule expected = new BoundedGenericModule();
    BoundedGenericComponent component = DaggerBoundedGenericComponent.create();
    BoundedGenerics<Integer, ArrayList<String>, LinkedList<CharSequence>, Integer, List<Integer>>
        b1 = component.bounds1();
    assertEquals(expected.provideInteger(), b1.a);
    assertEquals(expected.provideArrayListString(), b1.b);
    assertEquals(expected.provideLinkedListCharSeq(), b1.c);
    assertEquals(expected.provideInteger(), b1.d);
    assertEquals(expected.provideListOfInteger(), b1.e);

    BoundedGenerics<Double, LinkedList<String>, LinkedList<Comparable<String>>, Double, Set<Double>>
        b2 = component.bounds2();
    assertEquals(expected.provideDouble(), b2.a);
    assertEquals(expected.provideLinkedListString(), b2.b);
    assertEquals(expected.provideArrayListOfComparableString(), b2.c);
    assertEquals(expected.provideDouble(), b2.d);
    assertEquals(expected.provideSetOfDouble(), b2.e);
  }

  @Test
  void packagePrivateTypeParameterDependencies() {
    GenericComponent component = DaggerGenericComponent.create();
    Exposed exposed = component.exposed();
    assertNotNull(exposed.gpp.t);
    assertNotNull(exposed.gpp2);
  }

  @SuppressWarnings("rawtypes")
  @Test
  void publicSubclassWithPackagePrivateTypeParameterOfSuperclass() {
    GenericComponent component = DaggerGenericComponent.create();
    PublicSubclass publicSubclass = component.publicSubclass();
    assertNotNull(((Generic) publicSubclass).t);
  }

  @Test
  void singletonScopesAppliesToEachResolvedType() {
    SingletonGenericComponent component = DaggerSingletonGenericComponent.create();
    ScopedGeneric<A> a = component.scopedGenericA();
    assertSame(component.scopedGenericA(), a);
    assertNotNull(a.t);

    ScopedGeneric<B> b = component.scopedGenericB();
    assertSame(component.scopedGenericB(), b);
    assertNotNull(b.t);

    assertNotSame(b, a);
  }

  @Test
    // See https://github.com/google/dagger/issues/671
  void scopedSimpleGenerics() {
    SingletonGenericComponent component = DaggerSingletonGenericComponent.create();
    ScopedSimpleGeneric<A> a = component.scopedSimpleGenericA();
    assertSame(component.scopedSimpleGenericA(), a);

    ScopedSimpleGeneric<B> b = component.scopedSimpleGenericB();
    assertSame(component.scopedSimpleGenericB(), b);

    assertNotSame(b, a);
  }

  @Test
  void genericModules() {
    GenericComponent component = DaggerGenericComponent.create();
    List<Integer> iterableInt = new ArrayList<>();
    component.iterableInt().forEach(iterableInt::add);
    assertEquals(List.of(1, 2), iterableInt);
    List<Double> iterableDouble = new ArrayList<>();
    component.iterableDouble().forEach(iterableDouble::add);
    assertEquals(List.of(3d, 4d), iterableDouble);
  }
}
