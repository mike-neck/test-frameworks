package com.example.spek

import com.example.logger
import org.junit.jupiter.api.fail
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import org.spekframework.spek2.style.specification.xdescribe

object SpecificationStyleTest: Spek({
    val logger = logger<SpecificationStyleTest>()
    val list = mutableListOf<String>()
    val items by memoized { mutableListOf<String>() }

    fun add(item: String) {
        list.add(item)
        items.add(item)
    }
    // cannot access items
/*
Caused by: java.lang.AssertionError: 'items' can not be accessed in this context.
	at org.spekframework.spek2.runtime.lifecycle.MemoizedValueAdapter.get(MemoizedValueAdapter.kt:33)
	at org.spekframework.spek2.runtime.lifecycle.MemoizedValueAdapter.getValue(MemoizedValueAdapter.kt:22)
	at com.example.spek.SpecificationStyleTest$1.invoke(SpecificationStyleTest.kt:18)
	at com.example.spek.SpecificationStyleTest$1.invoke(SpecificationStyleTest.kt:9)
	at org.spekframework.spek2.runtime.SpekRuntime.resolveSpec(SpekRuntime.kt:49)
	at org.spekframework.spek2.runtime.SpekRuntime.discover(SpekRuntime.kt:23)
	at org.spekframework.spek2.junit.SpekTestEngine.discover(SpekTestEngine.kt:92)
	at org.junit.platform.launcher.core.DefaultLauncher.discoverEngineRoot(DefaultLauncher.java:181)
	... 31 more
 */
    logger.info("init, list: {}", list)

    describe("desc 1") {
        // cannot access items
//        add("desc 1")
//        logger.info("desc 1, memoized: {}, list: {}", items, list)
/*
Caused by: java.lang.AssertionError: 'items' can not be accessed in this context.
	at org.spekframework.spek2.runtime.lifecycle.MemoizedValueAdapter.get(MemoizedValueAdapter.kt:33)
	at org.spekframework.spek2.runtime.lifecycle.MemoizedValueAdapter.getValue(MemoizedValueAdapter.kt:22)
	at com.example.spek.SpecificationStyleTest$1$1.invoke(SpecificationStyleTest.kt:16)
	at com.example.spek.SpecificationStyleTest$1$2.invoke(SpecificationStyleTest.kt:34)
	at com.example.spek.SpecificationStyleTest$1$2.invoke(SpecificationStyleTest.kt:9)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt$createSuite$1.invoke(specificationStyle.kt:88)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt$createSuite$1.invoke(specificationStyle.kt)
	at org.spekframework.spek2.runtime.Collector.group(Collectors.kt:91)
	at org.spekframework.spek2.dsl.GroupBody$DefaultImpls.group$default(dsl.kt:24)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt.createSuite(specificationStyle.kt:87)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt.describe(specificationStyle.kt:77)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt.describe$default(specificationStyle.kt:76)
	at com.example.spek.SpecificationStyleTest$1.invoke(SpecificationStyleTest.kt:33)
	at com.example.spek.SpecificationStyleTest$1.invoke(SpecificationStyleTest.kt:9)
 */

        beforeEachTest {
            add("beforeEachTest-desc-1")
            logger.info("beforeEach in desc 1, memoized: {}, list: {}", items, list)
        }

        afterEachTest {
            add("afterEachTest-desc-1")
            logger.info("afterEachTest in desc 1, memoized: {}, list: {}", items, list)
        }

        it("is foo") {
            add("foo")
            logger.info("foo, memoized: {}, list: {}", items, list)
        }

        it("fails") {
            add("fail")
            logger.info("fail, memoized: {}, list: {}", items, list)
            fail { "fail: $items, $list" }
        }

        it("is bar") {
            add("bar")
            logger.info("bar, memoized: {}, list: {}", items, list)
        }

        describe("inner") {
            // cannot access items
//            add("inner")
//            logger.info("desc-1-inner, memoized: {}, list: {}", items, list)
/*
Caused by: java.lang.AssertionError: 'items' can not be accessed in this context.
	at org.spekframework.spek2.runtime.lifecycle.MemoizedValueAdapter.get(MemoizedValueAdapter.kt:33)
	at org.spekframework.spek2.runtime.lifecycle.MemoizedValueAdapter.getValue(MemoizedValueAdapter.kt:22)
	at com.example.spek.SpecificationStyleTest$1$1.invoke(SpecificationStyleTest.kt:16)
	at com.example.spek.SpecificationStyleTest$1$2$5.invoke(SpecificationStyleTest.kt:76)
	at com.example.spek.SpecificationStyleTest$1$2$5.invoke(SpecificationStyleTest.kt:9)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt$createSuite$1.invoke(specificationStyle.kt:88)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt$createSuite$1.invoke(specificationStyle.kt)
	at org.spekframework.spek2.runtime.Collector.group(Collectors.kt:91)
	at org.spekframework.spek2.dsl.GroupBody$DefaultImpls.group$default(dsl.kt:24)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt.createSuite(specificationStyle.kt:87)
	at org.spekframework.spek2.style.specification.SpecificationStyleKt.access$createSuite(specificationStyle.kt:1)
	at org.spekframework.spek2.style.specification.Suite.describe(specificationStyle.kt:20)
	at org.spekframework.spek2.style.specification.Suite.describe$default(specificationStyle.kt:19)
	at com.example.spek.SpecificationStyleTest$1$2.invoke(SpecificationStyleTest.kt:75)
	at com.example.spek.SpecificationStyleTest$1$2.invoke(SpecificationStyleTest.kt:9)
 */

            beforeEachTest {
                add("beforeEachTest-inner")
                logger.info("beforeEachTest in inner, memoized: {}, list: {}", items, list)
            }

            it("inner") {
                add("inner-test")
                logger.info("inner-test, memoized: {}, list: {}", items, list)
            }
        }
    }

    xdescribe("desc skipped") {
        logger.info("desc skipped, memoized: {}, list: {}", items, list)
        it("will be skipped") {
            logger.info("it will be skipped, memoized: {}, list: {}", items, list)
            fail { "skip: $list" }
        }
    }
})
