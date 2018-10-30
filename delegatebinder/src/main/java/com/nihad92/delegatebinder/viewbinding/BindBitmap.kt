package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindBitmap(@DrawableRes protected val id: Int) : Binder<Bitmap>() {
    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): Bitmap {
        return BitmapFactory.decodeResource(thisRef.resources, id)
    }

    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): Bitmap {
        return BitmapFactory.decodeResource(thisRef.resources, id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): Bitmap {
        return BitmapFactory.decodeResource(thisRef.resources, id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): Bitmap {
        return BitmapFactory.decodeResource(thisRef.resources, id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): Bitmap {
        return BitmapFactory.decodeResource(thisRef.context.resources, id)
    }
}