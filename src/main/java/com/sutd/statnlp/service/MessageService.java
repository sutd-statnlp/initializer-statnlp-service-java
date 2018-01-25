package com.sutd.statnlp.service;

import com.sutd.statnlp.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    public MessageService() {

    }

    public List<Message> findAll() {
        log.debug("Request to get all Messages");

        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            messages.add(new Message().title("title" + i).content("content" + i));
        }
        return messages;
    }
}
