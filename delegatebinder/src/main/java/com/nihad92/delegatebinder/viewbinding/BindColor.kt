package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindColor(@ColorRes protected val id: Int) : Binder<Int>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): Int {
        return ContextCompat.getColor(thisRef.view.context, id)

    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): Int {
        return ContextCompat.getColor(thisRef.view!!.context, id)

    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): Int {
        return ContextCompat.getColor(thisRef, id)

    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): Int {
        return ContextCompat.getColor(thisRef.context, id)

    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): Int {
        return ContextCompat.getColor(thisRef.context, id)

    }
}