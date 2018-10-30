package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IdRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindView<T : View?>(@IdRes protected val id: Int) : Binder<T>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): T {
        return thisRef.view.findViewById<T>(id)
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): T {
        return thisRef.view!!.findViewById<T>(id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): T {
        return thisRef.findViewById<T>(id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): T {
        return thisRef.findViewById<T>(id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): T {
        return thisRef.findViewById<T>(id)
    }
}