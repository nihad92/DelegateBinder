package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.StringRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindString(@StringRes protected val id: Int) : Binder<String>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): String {
        return thisRef.resources.getString(id)
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): String {
        return thisRef.resources.getString(id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): String {
        return thisRef.resources.getString(id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): String {
        return thisRef.resources.getString(id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): String {
        return thisRef.context.resources.getString(id)
    }
}