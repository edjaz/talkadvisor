package org.craftsrecords.talkadvisorconsumer.infra.resources.preferences

import org.craftsrecords.talkadvisorconsumer.infra.resources.talk.TalkFormat

data class Preferences(val topics: Set<Topic>, val talksFormats: Set<TalkFormat>)