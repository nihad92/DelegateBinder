package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.ArrayRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindStringArray(@ArrayRes protected val id: Int) : BindLazy<Array<String>>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Array<String> {
        createInitializer(thisRef, { thisRef.resources.getStringArray(id) })
        return value
    }

    override fun getValue(
        thisRef: android.support.v4.app.Fragment,
        property: KProperty<*>
    ): Array<String> {
        createInitializer(thisRef, { thisRef.resources.getStringArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Array<String> {
        createInitializer(thisRef, { thisRef.resources.getStringArray(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Array<String> {
        createInitializer(thisRef, { thisRef.resources.getStringArray(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Array<String> {
        createInitializer(thisRef, { thisRef.context.resources.getStringArray(id) })
        return value
    }
}