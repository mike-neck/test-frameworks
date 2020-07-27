package com.example.kotest

import com.example.logger
import io.kotest.assertions.fail
import io.kotest.core.extensions.Extension
import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.StringSpec
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult
import kotlin.reflect.KClass

class KotestStringSpecTest : StringSpec({
    val logger = logger<KotestStringSpecTest>()

    val list = mutableListOf<String>()
    fun add(item: String) {
        list.add(item)
    }

    add("init-1")
    logger.info("init 1, list: {}", list)

    "foo" {
        add("foo")
        logger.info("foo, list: {}", list)
    }

    add("init-2")
    logger.info("init 2, list: {}", list)

    "fail" {
        add("fail")
        logger.info("fail, list: {}", list)
        fail("fail, list: $list")
    }

    "bar" {
        add("bar")
        logger.info("bar, list: {}", list)
    }
})

class KotestStringSpecTest2: StringSpec() {

    private val logger = logger<KotestStringSpecTest2>()

    init {

        val list = mutableListOf<String>()
        fun add(item: String) {
            list.add(item)
        }

        add("init-1")
        logger.info("init 1, list: {}", list)

        "foo" {
            add("foo")
            logger.info("foo, list: {}", list)
        }

        add("init-2")
        logger.info("init 2, list: {}", list)

        "fail" {
            add("fail")
            logger.info("fail, list: {}", list)
            fail("fail, list: $list")
        }

        "bar" {
            add("bar")
            logger.info("bar, list: {}", list)
        }
    }

    override fun afterSpec(spec: Spec) {
        logger.info("afterSpec")
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        logger.info("afterTest")
    }

    override fun beforeSpec(spec: Spec) {
        logger.info("beforeSpec")
    }

    override fun beforeTest(testCase: TestCase) {
        logger.info("beforeTest")
    }

    override fun extensions(): List<Extension> {
        logger.info("extensions")
        return listOf(object : Extension {})
    }

    override fun listeners(): List<TestListener> {
        logger.info("listeners")
        return listOf(ExampleListener)
    }
}

object ExampleListener: TestListener {

    private val logger = logger<ExampleListener>()

    override suspend fun afterInvocation(testCase: TestCase, iteration: Int) {
        logger.info("afterInvocation ${testCase.displayName}")
    }

    override suspend fun afterSpec(spec: Spec) {
        val names = spec.rootTests().map { it.testCase.displayName }
        logger.info("afterSpec $names")
    }

    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        logger.info("afterTest ${testCase.displayName}, ${result.status}")
    }

    override suspend fun beforeInvocation(testCase: TestCase, iteration: Int) {
        logger.info("beforeInvocation ${testCase.displayName}")
    }

    override suspend fun beforeSpec(spec: Spec) {
        val names = spec.rootTests().map { it.testCase.displayName }
        logger.info("beforeSpec $names")
    }

    override suspend fun beforeTest(testCase: TestCase) {
        logger.info("beforeTest ${testCase.displayName}")
    }

    override suspend fun finalizeSpec(kclass: KClass<out Spec>, results: Map<TestCase, TestResult>) {
        logger.info("finalizeSpec")
    }

    override suspend fun prepareSpec(kclass: KClass<out Spec>) {
        logger.info("prepareSpec")
    }
}
