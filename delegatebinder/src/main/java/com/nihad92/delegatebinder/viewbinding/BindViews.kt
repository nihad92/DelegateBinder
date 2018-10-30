package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IdRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindViews<T : View?>(@IdRes protected vararg val ids: Int) : Binder<List<T>>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): List<T> {
        return findViews(ids, { thisRef.view.findViewById<T>(it) })
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): List<T> {
        return findViews(ids, { thisRef.view!!.findViewById<T>(it) })
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): List<T> {
        return findViews(ids, { thisRef.findViewById<T>(it) })
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): List<T> {
        return findViews(ids, { thisRef.findViewById<T>(it) })
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): List<T> {
        return findViews(ids, { thisRef.findViewById<T>(it) })
    }

    private fun findViews(ids: IntArray,
                          finder: (Int) -> T): List<T> {
        return ids.map(finder)
    }
}