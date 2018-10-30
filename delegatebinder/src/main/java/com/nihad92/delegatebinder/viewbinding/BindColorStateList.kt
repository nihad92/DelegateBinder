package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.res.ColorStateList
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindColorStateList(@ColorRes protected val id: Int) : Binder<ColorStateList>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): ColorStateList {
        return ContextCompat.getColorStateList(thisRef.view.context, id)!!
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): ColorStateList {
        return ContextCompat.getColorStateList(thisRef.view!!.context, id)!!
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): ColorStateList {
        return ContextCompat.getColorStateList(thisRef, id)!!
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): ColorStateList {
        return ContextCompat.getColorStateList(thisRef.context, id)!!
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): ColorStateList {
        return ContextCompat.getColorStateList(thisRef.context, id)!!
    }
}