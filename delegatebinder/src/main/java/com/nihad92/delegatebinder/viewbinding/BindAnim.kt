package com.nihad92.delegatebinder.viewbinding

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.AnimRes
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as V4Fragment

open class BindAnim(@AnimRes protected val id: Int) : Binder<Animation>() {
    override fun getValue(thisRef: V4Fragment,
                          property: KProperty<*>): Animation {
        return AnimationUtils.loadAnimation(thisRef.view!!.context, id)
    }

    override fun getValue(thisRef: Fragment,
                          property: KProperty<*>): Animation {
        return AnimationUtils.loadAnimation(thisRef.view.context, id)
    }

    override operator fun getValue(thisRef: Activity,
                                   property: KProperty<*>): Animation {
        return AnimationUtils.loadAnimation(thisRef, id)
    }

    override operator fun getValue(thisRef: View,
                                   property: KProperty<*>): Animation {
        return AnimationUtils.loadAnimation(thisRef.context, id)
    }

    override operator fun getValue(thisRef: Dialog,
                                   property: KProperty<*>): Animation {
        return AnimationUtils.loadAnimation(thisRef.context, id)
    }
}