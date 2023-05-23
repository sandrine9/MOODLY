package com.bnpp.epita.spring.domaine;

import net.bytebuddy.asm.Advice;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.time.LocalDate;

public class MessageFileMoodly implements MessageCreator {
    private User user;

    public MessageFileMoodly(User user) {
        this.user = user;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        ObjectMessage msg = session.createObjectMessage();
        return msg;
    }
}
