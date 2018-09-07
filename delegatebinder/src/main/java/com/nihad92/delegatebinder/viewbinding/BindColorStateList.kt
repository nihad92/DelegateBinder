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

open class BindColorStateList(@ColorRes protected val id: Int) : BindLazy<ColorStateList>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): ColorStateList {
        createInitializer(thisRef, { ContextCompat.getColorStateList(thisRef.view.context, id)!! })
        return value
    }

    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): ColorStateList {
        createInitializer(thisRef, { ContextCompat.getColorStateList(thisRef.view!!.context, id)!! })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): ColorStateList {
        createInitializer(thisRef, { ContextCompat.getColorStateList(thisRef, id)!! })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): ColorStateList {
        createInitializer(thisRef, { ContextCompat.getColorStateList(thisRef.context, id)!! })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): ColorStateList {
        createInitializer(thisRef, { ContextCompat.getColorStateList(thisRef.context, id)!! })
        return value
    }
}