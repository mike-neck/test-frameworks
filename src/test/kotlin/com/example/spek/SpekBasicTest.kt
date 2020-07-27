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

  beforeEachTest { 
    logger.info("before each test")
  }

  beforeEachGroup { 
    logger.info("before each group")
  }

  beforeEachTest { 
    logger.info("before each test 2")
  }

  afterEachTest { 
    logger.info("after each test")
  }

  afterEachGroup { 
    logger.info("after each group")
  }

  logger.info("plain")

  test("foo") {
    logger.info("foo test")
  }

  test("bar") {
    logger.info("bar test")
  }

  group("group") {
    beforeEachTest {
      logger.info("before each test in group")
    }
    beforeEachGroup {
      logger.info("before each group in group")
    }
    afterEachTest { 
      logger.info("after each test in group")
    }
    afterEachGroup { 
      logger.info("after each group in group")
    }

    test("inner") {
      logger.info("inner test")
      fail { "example failure" }
    }
  }
})
