package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.res.TypedArray
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindTypedArray(@ArrayRes protected val id: Int) : BindLazy<TypedArray>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): TypedArray {
        createInitializer(thisRef, { thisRef.resources.obtainTypedArray(id) })
        return value
    }

    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): TypedArray {
        createInitializer(thisRef, { thisRef.resources.obtainTypedArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): TypedArray {
        createInitializer(thisRef, { thisRef.resources.obtainTypedArray(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): TypedArray {
        createInitializer(thisRef, { thisRef.resources.obtainTypedArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): TypedArray {
        createInitializer(thisRef, { thisRef.context.resources.obtainTypedArray(id) })
        return value
    }
}