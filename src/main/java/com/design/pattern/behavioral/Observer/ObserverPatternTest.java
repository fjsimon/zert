package com.design.pattern.behavioral.Observer;

import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternTest {

    public static void main(String[] args) {
        //create subject
        MyTopic topic = new MyTopic();

        //create observers
        List<MyTopicSubscriber> myTopicSubscribers = new ArrayList<>();
        for(int i=0; i<10; i++) {

            myTopicSubscribers.add(new MyTopicSubscriber(RandomStringUtils.randomAlphanumeric(5)));
        }

        for(int i=0; i<10; i++) {

            //register observers to the subject
            topic.register(myTopicSubscribers.get(i));

            //attach observer to subject
            myTopicSubscribers.get(i).setSubject(topic);
        }

        //check if any update is available
        myTopicSubscribers.get(0).update();

        //now send message to subject
        topic.postMessage("New Message");

        for(int i=0; i<10; i++) {

            //register observers to the subject
            topic.unregister(myTopicSubscribers.get(i));
        }

        //now send message to subject
        topic.postMessage("New Message 2");

    }

}
