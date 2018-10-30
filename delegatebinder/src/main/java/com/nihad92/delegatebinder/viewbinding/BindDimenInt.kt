package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.DimenRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindDimenInt(@DimenRes protected val id: Int) : Binder<Int>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Int {
        return thisRef.resources.getDimensionPixelSize(id)
    }

    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): Int {
        return thisRef.resources.getDimensionPixelSize(id)
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Int {
        return thisRef.resources.getDimensionPixelSize(id)
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Int {
        return thisRef.resources.getDimensionPixelSize(id)
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Int {
        return thisRef.context.resources.getDimensionPixelSize(id)
    }
}