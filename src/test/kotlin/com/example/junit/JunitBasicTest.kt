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

import com.example.logger
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.fail

// TODO side effects
@ExtendWith(Callbacks::class)
class JunitBasicTest {

  lateinit var list: MutableList<String>

  @BeforeEach
  fun beforeEach() {
    this.list = mutableListOf("init")
    logger.info("before each: {}", list)
  }

  @AfterEach
  fun afterEach() {
    logger.info("after each: {}", list)
  }

  @Test
  fun foo() {
    list.add("foo")
    logger.info("foo test: {}", list)
  }

  @Test
  fun bar() {
    list.add("bar")
    logger.info("bar test: {}", list)
  }

  @Nested
  inner class Inner {

    @BeforeEach
    fun beforeEachInner() {
      list.add("inner")
      logger.info("before each(inner): {}", list)
    }

    @AfterEach
    fun afterEachInner() {
      logger.info("after each(inner)")
    }

    @Test
    fun inner0() {
      list.add("inner-0")
      logger.info("inner-0: {}", list)
    }

    @Test
    fun inner1() {
      list.add("inner-test")
      logger.info("inner test: {}", list)
      fail { "example failure" }
    }

    @Test
    fun inner2() {
      list.add("inner-2")
      logger.info("inner-2: {}", list)
    }
  }

  companion object {

    @JvmStatic
    val logger = logger<JunitBasicTest>()

    @JvmStatic
    @BeforeAll
    fun beforeAll() {
      logger.info("before all")
    }

    @JvmStatic
    @AfterAll
    fun afterAll() {
      logger.info("after all")
    }
  }
}

class Callbacks:
    BeforeAllCallback,
    BeforeEachCallback,
    BeforeTestExecutionCallback,
    AfterTestExecutionCallback,
    AfterEachCallback,
    AfterAllCallback {

  override fun beforeAll(context: ExtensionContext?) {
    logger.info("beforeAll")
  }

  override fun beforeEach(context: ExtensionContext?) {
    logger.info("beforeEach")
  }

  override fun beforeTestExecution(context: ExtensionContext?) {
    logger.info("beforeTestExecution")
  }

  override fun afterTestExecution(context: ExtensionContext?) {
    logger.info("afterTestExecution")
  }

  override fun afterEach(context: ExtensionContext?) {
    logger.info("afterEach")
  }

  override fun afterAll(context: ExtensionContext?) {
    logger.info("afterAll")
  }

  val logger = logger<Callbacks>()
}
