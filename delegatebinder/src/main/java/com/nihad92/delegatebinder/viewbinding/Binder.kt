package com.nihad92.delegatebinder.viewbinding

import android.support.v7.widget.RecyclerView
import kotlin.reflect.KProperty

abstract class Binder<T> : Bind<T> {

    override operator fun getValue(thisRef: RecyclerView.ViewHolder,
                                   property: KProperty<*>): T {
        return this.getValue(thisRef.itemView, property)
    }

}