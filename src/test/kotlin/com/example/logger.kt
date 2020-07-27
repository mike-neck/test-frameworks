package com.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

inline fun <reified K: Any> logger(klass: KClass<K> = K::class): Logger = LoggerFactory.getLogger(klass.java)
