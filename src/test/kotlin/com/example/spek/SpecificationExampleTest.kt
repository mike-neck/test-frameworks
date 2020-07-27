package com.example.spek

import org.assertj.core.api.Assertions.assertThat
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object SpecificationExampleTest: Spek({

  val list by memoized { mutableListOf<String>() }

  describe("empty な list") {
    describe("要素を 1 つ追加する") {
      it("サイズは 1") {
        list.add("foo")
        assertThat(list).hasSize(1)
      }
    }

    it("サイズは 0") {
      assertThat(list).isEmpty()
    }
  }
})
