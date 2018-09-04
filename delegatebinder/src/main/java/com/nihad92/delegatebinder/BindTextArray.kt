package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindTextArray(@ArrayRes protected val id: Int) : BindLazy<Array<CharSequence>>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Array<CharSequence> {
        createInitializer(thisRef, { thisRef.resources.getTextArray(id) })
        return value
    }

    override fun getValue(
        thisRef: android.support.v4.app.Fragment,
        property: KProperty<*>
    ): Array<CharSequence> {
        createInitializer(thisRef, { thisRef.resources.getTextArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Array<CharSequence> {
        createInitializer(thisRef, { thisRef.resources.getTextArray(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Array<CharSequence> {
        createInitializer(thisRef, { thisRef.resources.getTextArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Array<CharSequence> {
        createInitializer(thisRef, { thisRef.context.resources.getTextArray(id) })
        return value
    }
}