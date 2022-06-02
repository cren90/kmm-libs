package com.cren90.kmm.eventbus

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.datetime.Clock

@ExperimentalCoroutinesApi
object EventBus {
    private val channel = BroadcastChannel<Pair<Any, Long>>(Channel.BUFFERED)

    fun post(event: Any) {
        channel.trySend(Pair(event, Clock.System.now().toEpochMilliseconds()))
    }

    fun getEvents(includeCurrentValue: Boolean = false): Flow<Any> {
        val now = Clock.System.now().toEpochMilliseconds()

        return channel.asFlow().filter { includeCurrentValue || it.second > now }.map { it.first }
    }
}