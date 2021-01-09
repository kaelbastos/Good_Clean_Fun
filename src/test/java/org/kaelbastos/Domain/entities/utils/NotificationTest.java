package org.kaelbastos.Domain.entities.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {
    Notification notification = new Notification();

    @Test
    void addError() {
        notification.addError("error message", new Exception());
        assertTrue(notification.getMessage().contains("error message"));
        notification.addError("other error");
        assertTrue(notification.getMessage().contains("other error"));
    }

    @Test
    void isCorrect() {
        assertTrue(notification.isCorrect());
    }

    @Test
    void hasErrors() {
        notification.addError("error");
        assertTrue(notification.hasErrors());
    }
}