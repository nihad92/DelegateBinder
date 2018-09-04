package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IntegerRes
import android.support.annotation.StringRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindInt(@IntegerRes protected val id: Int) : BindLazy<Int>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Int {
        createInitializer(thisRef, { thisRef.resources.getInteger(id) })
        return value
    }

    override fun getValue(thisRef: android.support.v4.app.Fragment, property: KProperty<*>): Int {
        createInitializer(thisRef, { thisRef.resources.getInteger(id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Int {
        createInitializer(thisRef, { thisRef.resources.getInteger(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Int {
        createInitializer(thisRef, { thisRef.resources.getInteger(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Int {
        createInitializer(thisRef, { thisRef.context.resources.getInteger(id) })
        return value
    }
}