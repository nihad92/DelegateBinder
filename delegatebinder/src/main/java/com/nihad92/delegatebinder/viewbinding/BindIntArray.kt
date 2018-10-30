package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindIntArray(@ArrayRes protected val id: Int) : Binder<IntArray>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): IntArray {
        return thisRef.resources.getIntArray(id)
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): IntArray {
        return thisRef.resources.getIntArray(id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): IntArray {
        return thisRef.resources.getIntArray(id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): IntArray {
        return thisRef.resources.getIntArray(id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): IntArray {
        return thisRef.context.resources.getIntArray(id)
    }
}