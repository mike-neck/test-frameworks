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

object CucumberGherkinStyleTest : Spek({
  val logger = logger<CucumberGherkinStyleTest>()

  logger.info("raw")

  Feature("feature") {
    logger.info("feature phase 1")

    Scenario("foo") {
      logger.info("foo phase 1")
      When("foo-when") {
        logger.info("foo-when")
      }
      logger.info("foo phase 2")
      Then("foo-then-1") {
        logger.info("foo-then-1")
      }
      logger.info("foo phase 3")
      Then("foo-then-2") {
        logger.info("foo-then-2")
      }
    }

    logger.info("feature phase 2")
    Scenario("bar") {
      logger.info("bar phase")
      Then("bar-then") {
        logger.info("bar-then")
      }
    }

    Scenario("baz") {
      logger.info("baz phase 1")
      Given("given 1") {
        logger.info("baz-given-1")
      }
      Given("given 2") {
        logger.info("baz-given-2")
      }
      When("when 1") {
        logger.info("baz-when-1")
      }
      When("when 2") {
        logger.info("baz-when-2")
      }
      Then("then-1") {
        logger.info("baz-then-1")
        fail { "then error 1" }
      }
      Then("then-2") {
        logger.info("baz-then-2")
      }
    }

    Scenario("qux") {
      Then("then") {
        logger.info("qux-then")
      }
    }
  }

  group("group") {
    test("test") {
      logger.info("group-test")
    }
  }
})
