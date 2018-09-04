package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import android.view.View
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindBitmap(@DrawableRes protected val id: Int) : BindLazy<Bitmap>() {
    override fun getValue(thisRef: Fragment, property: KProperty<*>): Bitmap {
        createInitializer(thisRef, { BitmapFactory.decodeResource(thisRef.resources, id) })
        return value
    }

    override fun getValue(
        thisRef: android.support.v4.app.Fragment,
        property: KProperty<*>
    ): Bitmap {
        createInitializer(thisRef, { BitmapFactory.decodeResource(thisRef.resources, id) })
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Bitmap {
        createInitializer(thisRef, { BitmapFactory.decodeResource(thisRef.resources, id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Bitmap {
        createInitializer(thisRef, { BitmapFactory.decodeResource(thisRef.resources, id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Bitmap {
        createInitializer(thisRef, { BitmapFactory.decodeResource(thisRef.context.resources, id) })
        return value
    }
}