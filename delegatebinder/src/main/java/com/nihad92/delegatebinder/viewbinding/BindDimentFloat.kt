package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.DimenRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindDimentFloat(@DimenRes protected val id: Int) : Binder<Float>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Float {
        return thisRef.resources.getDimension(id)
    }

    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): Float {
        return thisRef.resources.getDimension(id)
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Float {
        return thisRef.resources.getDimension(id)
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Float {
        return thisRef.resources.getDimension(id)
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Float {
        return thisRef.context.resources.getDimension(id)
    }
}