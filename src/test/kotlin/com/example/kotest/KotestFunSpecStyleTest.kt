package com.example.kotest

import com.example.logger
import io.kotest.core.Tag
import io.kotest.core.spec.IsolationMode
import io.kotest.core.spec.style.FunSpec
import org.junit.jupiter.api.fail

class KotestFunSpecStyleTest : FunSpec({
    val logger = logger<KotestFunSpecStyleTest>()
    val list = mutableListOf<String>()
    fun add(item: String) {
        list.add(item)
    }

    add("init")
    logger.info("init, list: {}", list)

    context("context") {
        add("context")
        logger.info("context, list: {}", list)

        test("foo").config(tags = setOf(Tag("foo-test"))) {
            add("foo")
            logger.info("foo, list: {}", list)
        }

        test("fail") {
            add("fail")
            logger.info("fail, list: {}", list)
            fail { "fail, list: $list" }
        }

        test("bar") {
            add("bar")
            logger.info("bar, list: {}", list)
        }
    }

    add("init-2")
    logger.info("init-2, list: {}", list)

    test("baz") {
        add("baz")
        logger.info("baz, list: {}", list)
    }
}) {
    override fun isolationMode(): IsolationMode? = IsolationMode.SingleInstance
}
