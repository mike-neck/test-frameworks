package com.example.spek

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assumptions.assumeThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object GherkinExampleTest: Spek({

  Feature("empty list") {
    val list by memoized { mutableListOf<String>() }

    Scenario("サイズの増減量") {
      Given("empty のまま") {
        assumeThat(list).isEmpty()
      }
      When("要素を 1 つ追加") {
        list.add("foo")
      }
      Then("サイズは 1") {
        assertThat(list).hasSize(1)
      }
    }
  }
})
