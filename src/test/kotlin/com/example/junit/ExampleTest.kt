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
package com.example.junit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import kotlin.test.BeforeTest
import kotlin.test.Test

class ExampleTest {

  private lateinit var list: MutableList<String>

  @BeforeTest fun setup() {
    list = mutableListOf()
  }

  @DisplayName("list に要素を 1 つ追加すると、サイズが 1 増える")
  @Test fun afterAddingElementToListThenSizeIsIncreasedBy1() {
    list.add("foo")

    assertThat(list).hasSize(1)
  }
}
