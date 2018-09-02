package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.reflect.KProperty

internal interface Bind<T> {
    operator fun getValue(thisRef: Fragment, property: KProperty<*>): T
    operator fun getValue(thisRef: android.support.v4.app.Fragment, property: KProperty<*>): T
    operator fun getValue(thisRef: RecyclerView.ViewHolder, property: KProperty<*>) : T
    operator fun getValue(thisRef: Activity, property: KProperty<*>): T
    operator fun getValue(thisRef: View, property: KProperty<*>): T
    operator fun getValue(thisRef: Dialog, property: KProperty<*>): T
}