package org.craftsrecords.talkadvisorconsumer.infra.resources.profile

import org.craftsrecords.talkadvisorconsumer.infra.resources.preferences.Preferences

class Profile(val id: String, val preferences: Preferences) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Profile

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}