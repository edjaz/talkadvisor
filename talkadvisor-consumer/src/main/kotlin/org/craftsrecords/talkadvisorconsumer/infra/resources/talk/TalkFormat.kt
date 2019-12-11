package org.craftsrecords.talkadvisorconsumer.infra.resources.talk

import org.springframework.util.Assert.isTrue
import java.time.Duration
import java.time.Duration.ofHours
import java.time.Duration.ofMinutes

enum class TalkFormat(val format: String, private val durationRange: ClosedRange<Duration>) {
    IGNITE("IGNITE", ofMinutes(1).rangeTo(ofMinutes(10).minusNanos(1))),
    QUICKIE("QUICKIE", ofMinutes(10).rangeTo(ofMinutes(20).minusNanos(1))),
    TOOL_IN_ACTION("TOOL_IN_ACTION", ofMinutes(20).rangeTo(ofMinutes(40).minusNanos(1))),
    CONFERENCE("CONFERENCE", ofMinutes(40).rangeTo(ofMinutes(60).minusNanos(1))),
    UNIVERSITY("UNIVERSITY", ofHours(1).rangeTo(ofHours(4)));
}