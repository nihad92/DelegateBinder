package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindDrawable(@DrawableRes protected val id: Int) : Binder<Drawable>() {
    override fun getValue(thisRef: V4Fragment, property: KProperty<*>): Drawable {
        return ContextCompat.getDrawable(thisRef.view!!.context, id)!!
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): Drawable {
        return ContextCompat.getDrawable(thisRef.view.context, id)!!
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Drawable {
        return ContextCompat.getDrawable(thisRef, id)!!
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Drawable {
        return ContextCompat.getDrawable(thisRef.context, id)!!
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Drawable {
        return ContextCompat.getDrawable(thisRef.context, id)!!
    }
}