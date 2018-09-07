package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.v4.app.Fragment as V4Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.reflect.KProperty

internal interface Bind<T> {
    operator fun getValue(thisRef: Fragment, property: KProperty<*>): T
    operator fun getValue(thisRef: V4Fragment, property: KProperty<*>): T
    operator fun getValue(thisRef: RecyclerView.ViewHolder, property: KProperty<*>) : T
    operator fun getValue(thisRef: Activity, property: KProperty<*>): T
    operator fun getValue(thisRef: View, property: KProperty<*>): T
    operator fun getValue(thisRef: Dialog, property: KProperty<*>): T
}