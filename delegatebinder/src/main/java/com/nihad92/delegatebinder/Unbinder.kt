package com.nihad92.delegatebinder

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

object Unbinder {

    /*
    BindInt.java
    BindViews.java
     */
    private val unbindSubject: PublishSubject<Any> = PublishSubject.create()

    fun unbind(unbindTarget: Any) {
        unbindSubject.onNext(unbindTarget)
    }

    internal fun with(obj: Any): Observable<Any> = unbindSubject.filter(
        { it === obj }).observeOn(AndroidSchedulers.mainThread())
}

internal class Subscriber<T>(private val clearValueAction: () -> Unit) : Observer<T> {
    private lateinit var disposable: Disposable
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {
        disposable = d
    }

    override fun onNext(t: T) {
        clearValueAction.invoke()
        disposable.dispose()
    }

    override fun onError(e: Throwable) {
        clearValueAction.invoke()
    }
}