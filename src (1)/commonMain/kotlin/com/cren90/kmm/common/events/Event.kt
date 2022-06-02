package com.cren90.kmm.common.events

import kotlinx.datetime.Clock

class Event(val value: Any) {
    var isConsumed = false
        private set

    fun consume(): Any {
        isConsumed = true

        return value
    }

    val postedAt: Long = Clock.System.now().epochSeconds

}