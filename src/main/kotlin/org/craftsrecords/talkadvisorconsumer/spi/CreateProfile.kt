package org.craftsrecords.talkadvisorconsumer.spi

import org.craftsrecords.talkadvisorconsumer.infra.resources.preferences.Preferences
import org.craftsrecords.talkadvisorconsumer.infra.resources.profile.Profile


@FunctionalInterface
interface CreateProfile {
    fun forUserWithPreferences(userId: String, preferences: Preferences): Profile
}