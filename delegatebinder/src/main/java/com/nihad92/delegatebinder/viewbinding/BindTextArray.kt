package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindTextArray(@ArrayRes protected val id: Int) : Binder<Array<CharSequence>>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): Array<CharSequence> {
        return thisRef.resources.getTextArray(id)
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): Array<CharSequence> {
        return thisRef.resources.getTextArray(id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): Array<CharSequence> {
        return thisRef.resources.getTextArray(id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): Array<CharSequence> {
        return thisRef.resources.getTextArray(id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): Array<CharSequence> {
        return thisRef.context.resources.getTextArray(id)
    }
}