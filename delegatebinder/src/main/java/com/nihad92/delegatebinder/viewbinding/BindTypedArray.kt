package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.res.TypedArray
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindTypedArray(@ArrayRes protected val id: Int) : Binder<TypedArray>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): TypedArray {
        return thisRef.resources.obtainTypedArray(id)
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): TypedArray {
        return thisRef.resources.obtainTypedArray(id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): TypedArray {
        return thisRef.resources.obtainTypedArray(id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): TypedArray {
        return thisRef.resources.obtainTypedArray(id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): TypedArray {
        return thisRef.context.resources.obtainTypedArray(id)
    }
}