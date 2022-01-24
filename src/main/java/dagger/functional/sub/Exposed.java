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

package dagger.functional.sub;

import dagger.Lazy;
import dagger.functional.Generic;
import dagger.functional.Generic2;
import jakarta.inject.Inject;
import jakarta.inject.Provider;

public class Exposed {

  public final PackagePrivate pp2;
  public final Provider<PackagePrivate> ppp2;
  public final Lazy<PackagePrivate> lpp2;
  public final Provider<Lazy<PackagePrivate>> plpp2;
  public final Generic2<PackagePrivate> gpp2;
  public final Generic2<PackagePrivateContainer.PublicEnclosed> gppc2;
  public final Provider<Generic2<PackagePrivate>> pgpp2;
  public final Lazy<Generic2<PackagePrivate>> lgpp2;
  public final Provider<Lazy<Generic2<PackagePrivate>>> plgpp2;

  public PackagePrivate pp;
  public Provider<PackagePrivate> ppp;
  public Lazy<PackagePrivate> lpp;
  public Provider<Lazy<PackagePrivate>> plpp;
  public Generic<PackagePrivate> gpp;
  public Generic<PackagePrivateContainer.PublicEnclosed> gppc;
  public Provider<Generic<PackagePrivate>> pgpp;
  public Lazy<Generic<PackagePrivate>> lgpp;
  public Provider<Lazy<Generic<PackagePrivate>>> plgpp;

  /** Injects inaccessible dependencies to test casting of these dependency arguments. */
  @Inject
  Exposed(
      PackagePrivate pp2,
      Provider<PackagePrivate> ppp2,
      Lazy<PackagePrivate> lpp2,
      Provider<Lazy<PackagePrivate>> plpp2,
      Generic2<PackagePrivate> gpp2,
      Generic2<PackagePrivateContainer.PublicEnclosed> gppc2,
      Provider<Generic2<PackagePrivate>> pgpp2,
      Lazy<Generic2<PackagePrivate>> lgpp2,
      Provider<Lazy<Generic2<PackagePrivate>>> plgpp2,
      PackagePrivate pp,
      Provider<PackagePrivate> ppp,
      Lazy<PackagePrivate> lpp,
      Provider<Lazy<PackagePrivate>> plpp,
      Generic<PackagePrivate> gpp,
      Generic<PackagePrivateContainer.PublicEnclosed> gppc,
      Provider<Generic<PackagePrivate>> pgpp,
      Lazy<Generic<PackagePrivate>> lgpp,
      Provider<Lazy<Generic<PackagePrivate>>> plgpp) {
    this.pp2 = pp2;
    this.ppp2 = ppp2;
    this.lpp2 = lpp2;
    this.plpp2 = plpp2;
    this.gpp2 = gpp2;
    this.gppc2 = gppc2;
    this.pgpp2 = pgpp2;
    this.lgpp2 = lgpp2;
    this.plgpp2 = plgpp2;
    this.pp = pp;
    this.ppp = ppp;
    this.lpp = lpp;
    this.plpp = plpp;
    this.gpp = gpp;
    this.gppc = gppc;
    this.pgpp = pgpp;
    this.lgpp = lgpp;
    this.plgpp = plgpp;
  }
}
