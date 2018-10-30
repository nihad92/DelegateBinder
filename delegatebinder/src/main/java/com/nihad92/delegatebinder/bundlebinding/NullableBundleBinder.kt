package com.nihad92.delegatebinder.bundlebinding

import android.app.Activity
import android.app.Fragment
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

class NullableBundleBinder<T>(private val key: String,
                              private val defaultValue: T? = null) : Bind<T?> {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): T? {
        return thisRef.arguments?.get(key) as? T ?: defaultValue as T
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): T? {
        return thisRef.arguments?.get(key) as? T ?: defaultValue as T
    }

    override fun getValue(thisRef: Activity,
                          property: KProperty<*>): T? {
        return thisRef.intent?.extras?.get(key) as? T ?: defaultValue as T
    }
}