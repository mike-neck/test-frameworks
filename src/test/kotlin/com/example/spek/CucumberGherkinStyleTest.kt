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
import org.spekframework.spek2.style.gherkin.Feature

// TODO side effects
object CucumberGherkinStyleTest : Spek({
  val logger = logger<CucumberGherkinStyleTest>()
  val list = mutableListOf<String>()

  logger.info("init: {}", list)
  fun add(item: String) {
    list.add(item)
  }

  Feature("feature") {
    add("feature")
    logger.info("feature phase 1, list: {}", list)

    Scenario("foo") {
      logger.info("foo phase 1, list: {}", list)
      When("foo-when") {
        logger.info("foo-when, list: {}", list)
      }
      logger.info("foo phase 2, list: {}", list)
      Then("foo-then-1") {
        logger.info("foo-then-1, list: {}", list)
      }
      logger.info("foo phase 3, list: {}", list)
      Then("foo-then-2") {
        logger.info("foo-then-2, list: {}", list)
      }
    }

    logger.info("feature phase 2, list: {}", list)
    Scenario("bar") {
      logger.info("bar phase, list: {}", list)
      Then("bar-then") {
        logger.info("bar-then, list: {}", list)
      }
    }

    Scenario("baz") {
      add("baz scenario 1")
      logger.info("baz phase 1, list: {}", list)
      Given("given 1") {
        add("baz-given-1")
        logger.info("baz-given-1, list: {}", list)
      }
      Given("given 2") {
        add("baz-given-2")
        logger.info("baz-given-2, list: {}", list)
      }
      add("baz scenario 2")
      When("when 1") {
        add("baz-when-1")
        logger.info("baz-when-1, list: {}", list)
      }
      When("when 2") {
        add("baz-when-2")
        logger.info("baz-when-2, list: {}", list)
      }
      Then("then-1") {
        add("baz-then-1")
        logger.info("baz-then-1, list: {}", list)
        fail { "then error 1" }
      }
      Then("then-2") {
        add("baz-then-2")
        logger.info("baz-then-2, list: {}", list)
      }
      add("baz scenario 3")
    }

    Scenario("qux") {
      Then("then") {
        logger.info("qux-then, list: {}", list)
      }
    }
  }

  group("group") {
    test("test") {
      logger.info("group-test, list: {}", list)
    }
  }
})
