package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindIntArray(@ArrayRes protected val id: Int) : BindLazy<IntArray>() {

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): IntArray {
        createInitializer(thisRef, { thisRef.resources.getIntArray(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): IntArray {
        createInitializer(thisRef, { thisRef.resources.getIntArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): IntArray {
        createInitializer(thisRef, { thisRef.context.resources.getIntArray(id) })
        return value
    }
}