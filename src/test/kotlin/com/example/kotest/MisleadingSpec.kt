/*
 * Copyright 2020 Shinya Mochida
 * 
 * Licensed under the Apache License,Version2.0(the"License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,software
 * Distributed under the License is distributed on an"AS IS"BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.kotest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class MisleadingSpec : FunSpec({

  val list = mutableListOf<String>()

  context("empty list に対して 要素を 1 個追加する") {
    list.add("foo")
    test("サイズは 1") {
      list shouldHaveSize 1
    }
  }

  list.add("bar")
  context("list(2) に対して何も操作しない") {
    test("サイズは 2") {
      list shouldHaveSize 2
    }
  }
})
