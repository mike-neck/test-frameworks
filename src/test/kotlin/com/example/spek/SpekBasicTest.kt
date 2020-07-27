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
package com.example.spek

import com.example.logger
import org.junit.jupiter.api.fail
import org.spekframework.spek2.Spek

object SpekBasicTest : Spek({
  val logger = logger<SpekBasicTest>()

  val list = mutableListOf<String>()
  lateinit var items: MutableList<String>

  fun add(item: String) {
    list.add(item)
    items.add(item)
  }

  beforeEachTest {
    add("beforeEachTest")
    logger.info("before each test, items: {}, list: {}", items, list)
  }

  beforeEachGroup {
    items = mutableListOf()
    add("beforeEachGroup")
    logger.info("before each group, items: {}, list: {}", items, list)
  }

  beforeEachTest {
    add("beforeEachTest")
    logger.info("before each test 2, items: {}, list: {}", items, list)
  }

  afterEachTest {
    add("afterEachTest")
    logger.info("after each test, items: {}, list: {}", items, list)
  }

  afterEachGroup {
    add("afterEachGroup")
    logger.info("after each group, items: {}, list: {}", items, list)
  }

  logger.info("plain, items: not initialized, list: {}", list)

  test("foo") {
    add("foo")
    logger.info("foo test, items: {}, list: {}", items, list)
  }

  test("bar") {
    add("bar")
    logger.info("bar test, items: {}, list: {}", items, list)
  }

  group("group") {
    beforeEachTest {
      add("beforeEachTest")
      logger.info("before each test in group, items: {}, list: {}", items, list)
    }
    beforeEachGroup {
      add("beforeEachGroup")
      logger.info("before each group in group, items: {}, list: {}", items, list)
    }
    afterEachTest {
      add("afterEachTest")
      logger.info("after each test in group, items: {}, list: {}", items, list)
    }
    afterEachGroup {
      add("afterEachGroup")
      logger.info("after each group in group, items: {}, list: {}", items, list)
    }

    test("inner") {
      add("inner")
      logger.info("inner test, items: {}, list: {}", items, list)
      fail { "example failure" }
    }

    test("inner-2") {
      add("inner-2")
      logger.info("inner-test-2, items: {}, list: {}", items, list)
    }
  }
})
