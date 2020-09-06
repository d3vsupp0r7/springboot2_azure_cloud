package org.lba.springboot2.azure.servicebus;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jms.core.JmsTemplate;

@RestController
public class AzureServiceBusServiceProducerController {

	private static final String DESTINATION_NAME = "<DestinationName>";

    private static final Logger logger = LoggerFactory.getLogger(AzureServiceBusServiceProducerController.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    public String postMessage(@RequestParam String message) {
        logger.info("Sending message");
        jmsTemplate.convertAndSend(DESTINATION_NAME, new MessageData(new BigDecimal("1"), message));
        return message;
    }
}
