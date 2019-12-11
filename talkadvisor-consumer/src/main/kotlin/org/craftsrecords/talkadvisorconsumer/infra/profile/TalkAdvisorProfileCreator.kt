package org.craftsrecords.talkadvisorconsumer.infra.profile

import org.craftsrecords.talkadvisorconsumer.infra.resources.preferences.Preferences
import org.craftsrecords.talkadvisorconsumer.infra.resources.profile.Profile
import org.craftsrecords.talkadvisorconsumer.spi.CreateProfile
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.stereotype.Component

@Component
class TalkAdvisorProfileCreator(
        restTemplateBuilder: RestTemplateBuilder,
        @Value("\${talkAdvisor.api.base-uri}") private val talkAdvisorBaseUri: String): CreateProfile {

    private val restTemplate = restTemplateBuilder.build()

    override fun forUserWithPreferences(userId: String, preferences: Preferences): Profile {
        val request = toProfileRequest(userId, preferences)

        val response  = restTemplate.postForEntity("$talkAdvisorBaseUri/profiles", request, Profile::class.java)

        return response.body!!
    }

    private fun toProfileRequest(userId: String, preferences: Preferences): HttpEntity<Preferences> {
        val headers = HttpHeaders()
        headers.set("User-Id", userId)
        headers.set("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString())
        return HttpEntity(preferences, headers)
    }
}