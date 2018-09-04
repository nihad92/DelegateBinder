package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.AnimRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindAnim(@AnimRes protected val id: Int) : BindLazy<Animation>() {
    override fun getValue(
        thisRef: android.support.v4.app.Fragment,
        property: KProperty<*>
    ): Animation {
        createInitializer(thisRef, {AnimationUtils.loadAnimation(thisRef.view!!.context, id)})
        return value
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): Animation {
        createInitializer(thisRef, {AnimationUtils.loadAnimation(thisRef.view.context, id)})
        return value
    }

    override operator fun getValue(thisRef: Activity, property: KProperty<*>): Animation {
        createInitializer(thisRef, { AnimationUtils.loadAnimation(thisRef, id) })
        return value
    }

    override operator fun getValue(thisRef: View, property: KProperty<*>): Animation {
        createInitializer(thisRef, { AnimationUtils.loadAnimation(thisRef.context, id) })
        return value
    }

    override operator fun getValue(thisRef: Dialog, property: KProperty<*>): Animation {
        createInitializer(thisRef, { AnimationUtils.loadAnimation(thisRef.context, id) })
        return value
    }
}