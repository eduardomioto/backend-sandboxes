package com.mioto.sandbox.springcloud.controller;

import org.springframework.cloud.aws.messaging.config.annotation.NotificationMessage;
import org.springframework.cloud.aws.messaging.config.annotation.NotificationSubject;
import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationMessageMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sns/receive")
public class SnsEndpointController {

	@NotificationMessageMapping
	public void receiveNotification(@NotificationMessage String message, @NotificationSubject String subject) {
		// ...
	}

	@NotificationSubscriptionMapping
	public void confirmSubscription(NotificationStatus notificationStatus) {
		notificationStatus.confirmSubscription();
	}
}
