package org.craftsrecords.talkadvisorconsumer.contracts

import org.craftsrecords.talkadvisorconsumer.infra.profile.TalkAdvisorProfileCreator
import org.craftsrecords.talkadvisorconsumer.infra.resources.preferences.Preferences
import org.craftsrecords.talkadvisorconsumer.infra.resources.preferences.Topic
import org.craftsrecords.talkadvisorconsumer.infra.resources.talk.TalkFormat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@AutoConfigureStubRunner(workOffline = true, ids = ["org.craftsrecords:talkadvisor-infra-application:+:8090"])
class TalkAdvisorCheckTest {

    private val createProfile = TalkAdvisorProfileCreator(RestTemplateBuilder(), "http://localhost:8090")

    @Test
    fun `should create a profile`() {
        val userId = "mySelf"
        val preferences = Preferences(
                setOf(Topic("DDD"), Topic("Hexagonal Architecture")),
                setOf(TalkFormat.CONFERENCE, TalkFormat.QUICKIE))

        createProfile.forUserWithPreferences(userId, preferences)
    }
}