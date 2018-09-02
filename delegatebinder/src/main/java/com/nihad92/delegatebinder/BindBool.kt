package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.BoolRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindBool(@BoolRes protected val id: Int) : BindLazy<Boolean>() {

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Boolean {
        createInitializer(thisRef, { thisRef.resources.getBoolean(id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Boolean {
        createInitializer(thisRef, { thisRef.resources.getBoolean(id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Boolean {
        createInitializer(thisRef, { thisRef.context.resources.getBoolean(id) })
        return value
    }
}