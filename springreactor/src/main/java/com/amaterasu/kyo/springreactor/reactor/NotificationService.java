package com.amaterasu.kyo.springreactor.reactor;

public interface NotificationService {

    void initiateNotification(NotificationData notificationData)
            throws InterruptedException;
}
