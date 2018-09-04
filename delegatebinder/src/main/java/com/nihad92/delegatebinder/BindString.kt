package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.StringRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindString(@StringRes protected val id: Int) : BindLazy<String>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): String {
        createInitializer(thisRef, { thisRef.resources.getString(id) })
        return value
    }

    override fun getValue(
        thisRef: android.support.v4.app.Fragment,
        property: KProperty<*>
    ): String {
        createInitializer(thisRef, { thisRef.resources.getString(id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): String {
        createInitializer(thisRef, { thisRef.resources.getString(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): String {
        createInitializer(thisRef, { thisRef.resources.getString(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): String {
        createInitializer(thisRef, { thisRef.context.resources.getString(id) })
        return value
    }
}