package com.nihad92.delegatebinder.bundlebinding

import android.app.Activity
import android.app.Fragment
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

class BundleBinder<T : Any>(private val key: String, private val defaultValue: T) : Lazy<T>,
    Bind<T> {
    private lateinit var initializer: (() -> T)
    private var _value: Any = UNINITIALIZED

    override val value: T
        get() {
            if (_value == UNINITIALIZED) {
                _value = initializer.invoke()
            }
            @Suppress("UNCHECKED_CAST")
            return _value as T
        }

    override fun isInitialized(): Boolean = _value != UNINITIALIZED

    private fun createInitializer(initialize: () -> T) {
        if (!::initializer.isInitialized) {
            this.initializer = initialize
        }
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        createInitializer { thisRef.arguments.get(key) as? T ?: defaultValue }
        return value
    }

    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): T {
        createInitializer { thisRef.arguments?.get(key) as? T ?: defaultValue }
        return value
    }

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        createInitializer { thisRef.intent.extras.get(key) as? T ?: defaultValue }
        return value
    }

    object UNINITIALIZED
}