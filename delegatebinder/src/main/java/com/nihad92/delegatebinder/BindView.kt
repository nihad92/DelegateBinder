package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IdRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindView<T : View?>(@IdRes protected val id: Int) : BindLazy<T>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        createInitializer(thisRef, { thisRef.view.findViewById<T>(id) })
        return value
    }

    override fun getValue(thisRef: android.support.v4.app.Fragment, property: KProperty<*>): T {
        createInitializer(thisRef, { thisRef.view!!.findViewById<T>(id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): T {
        createInitializer(thisRef, { thisRef.findViewById<T>(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): T {
        createInitializer(thisRef, { thisRef.findViewById<T>(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): T {
        createInitializer(thisRef, { thisRef.findViewById<T>(id) })
        return value
    }
}