package com.nihad92.delegatebinder.bundlebinding

import android.app.Activity
import android.app.Fragment
import android.support.v4.app.Fragment as V4Fragment
import kotlin.reflect.KProperty

interface Bind<T> {
    operator fun getValue(thisRef: Fragment, property: KProperty<*>): T
    operator fun getValue(thisRef: V4Fragment, property: KProperty<*>): T
    operator fun getValue(thisRef: Activity, property: KProperty<*>): T

}