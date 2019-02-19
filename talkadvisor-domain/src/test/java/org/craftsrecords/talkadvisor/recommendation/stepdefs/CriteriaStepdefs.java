package org.craftsrecords.talkadvisor.recommendation.stepdefs;

import cucumber.api.java8.En;
import org.craftsrecords.talkadvisor.recommendation.criteria.Topic;
import org.craftsrecords.talkadvisor.recommendation.talk.TalkFormat;

import java.util.Set;

import static java.util.Collections.singleton;

public class CriteriaStepdefs implements En {
    public CriteriaStepdefs(TestContext testContext) {
        Given("^a guest user who wants to learn (.+)",
                (String topicName) -> testContext.setRequestedTopic(new Topic(topicName)));
        Given("^he has only time to watch (.+) talks$",
                (String format) -> {
                    Set<TalkFormat> talkFormats = singleton(TalkFormat.valueOf(format));
                    testContext.setRequestedTalksFormats(talkFormats);
                });
    }
}
