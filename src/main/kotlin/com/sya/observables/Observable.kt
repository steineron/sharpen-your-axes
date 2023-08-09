package com.sya.observables

interface Observer<T> {
    fun update(value:T)
}

class Observable<T> {

    private val observers = mutableSetOf<Observer<T>>()

    fun register(observer: Observer<T>) {
        observers.add(observer)
    }

    fun unregister(observer: Observer<T>) {
        observers.remove(observer)
    }

    fun emit(value:T) {
        observers.onEach {
            it.update(value)
        }
    }
}