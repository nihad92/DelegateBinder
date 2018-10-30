package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.BoolRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindBool(@BoolRes protected val id: Int) : Binder<Boolean>() {
    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): Boolean {
        return thisRef.resources.getBoolean(id)
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): Boolean {
        return thisRef.resources.getBoolean(id)
    }
    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Boolean {
        return thisRef.resources.getBoolean(id)
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Boolean {
        return thisRef.resources.getBoolean(id)
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Boolean {
        return thisRef.context.resources.getBoolean(id)
    }
}