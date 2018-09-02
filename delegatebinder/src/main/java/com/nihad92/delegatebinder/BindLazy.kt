package com.nihad92.delegatebinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlin.reflect.KProperty

abstract class BindLazy<T> : Lazy<T> , Bind<T>{
    private var initializer: (() -> T)? = null
    private var _value: Any? = UNINITIALIZED

    override val value: T
        get() {
            if (_value == UNINITIALIZED) {
                _value = initializer?.invoke()
            }
            @Suppress("UNCHECKED_CAST")
            return _value as T
        }

    override fun isInitialized(): Boolean = _value != UNINITIALIZED

    protected fun createInitializer(thisRef: Any, valueInitializer : () -> T) {
        if (initializer == null) {
            initializer = {
                Unbinder.with(thisRef).subscribe(Subscriber({_value = UNINITIALIZED}))
                valueInitializer.invoke()
            }
        }
    }

    override operator fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return this.getValue(thisRef.view, property)
    }

    override operator fun getValue(thisRef: android.support.v4.app.Fragment, property: KProperty<*>): T {
        return this.getValue(thisRef.view!!, property)
    }

    override operator fun getValue(thisRef: RecyclerView.ViewHolder, property: KProperty<*>) : T {
        return this.getValue(thisRef.itemView, property)
    }

    object UNINITIALIZED
}