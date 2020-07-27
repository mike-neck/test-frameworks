package com.example.spek

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assumptions.assumeThat
import org.spekframework.spek2.Spek

object BasicExampleTest: Spek({

  val list by memoized { mutableListOf<String>() }

  beforeEachTest { 
    assumeThat(list).isEmpty()
  }

  test("list に要素を 1 つ追加すると、サイズが 1 増える") {
    list.add("foo")

    assertThat(list).hasSize(1)
  }
})
