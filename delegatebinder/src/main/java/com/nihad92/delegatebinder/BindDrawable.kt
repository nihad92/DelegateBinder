package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindDrawable(@DrawableRes protected val id: Int) : BindLazy<Drawable>() {

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Drawable {
        createInitializer(thisRef, { ContextCompat.getDrawable(thisRef, id)!! })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Drawable {
        createInitializer(thisRef, { ContextCompat.getDrawable(thisRef.context, id)!! })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Drawable {
        createInitializer(thisRef, { ContextCompat.getDrawable(thisRef.context, id)!! })
        return value
    }
}