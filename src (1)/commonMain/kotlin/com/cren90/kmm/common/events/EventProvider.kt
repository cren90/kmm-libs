package com.cren90.kmm.common.events

import com.cren90.kmm.eventbus.EventBus
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
object EventProvider {

    fun post(event: Any) {
        EventBus.post(event)
    }

    fun getEvents(includeCurrentValue: Boolean = false): Flow<Any> =
        EventBus.getEvents(includeCurrentValue)
}