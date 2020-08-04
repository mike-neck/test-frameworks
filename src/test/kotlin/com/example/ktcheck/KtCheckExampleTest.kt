package com.example.ktcheck

import run.ktcheck.Given
import run.ktcheck.KtCheck
import run.ktcheck.assertion.IterableMatchers.haveSize
import run.ktcheck.assertion.NoDep.should

object KtCheckExampleTest: KtCheck by
    Given("empty list", { emptyList<String>() })
        .When("要素を 1 つ追加する", { it + "foo" })
        .Then("サイズは 1", { _, list -> list should haveSize(1) })


object KtCheckFailTest: KtCheck by
    Given("empty list", { emptyList<String>() })
        .When("要素を 1 つ追加する", { it + "foo" })
        .Then("初期状態のリストのサイズは 1", { list, _ ->
            list should haveSize(1) 
        })
