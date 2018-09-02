package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.support.annotation.IdRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindViews<T : View?>(@IdRes protected vararg val ids: Int) : BindLazy<List<T>>() {

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): List<T> {
        createInitializer(thisRef, {
            val views = ArrayList<T>()
            for (id in ids) {
                views.add(thisRef.findViewById<T>(id))
            }
            views
        })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): List<T> {
        createInitializer(thisRef, {
            val views = ArrayList<T>()
            for (id in ids) {
                views.add(thisRef.findViewById<T>(id))
            }
            views
        })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): List<T> {
        createInitializer(thisRef, {
            val views = ArrayList<T>()
            for (id in ids) {
                views.add(thisRef.findViewById<T>(id))
            }
            views
        })
        return value
    }
}