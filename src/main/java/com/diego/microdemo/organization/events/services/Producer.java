package com.diego.microdemo.organization.events.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.diego.microdemo.organization.events.model.OrganizationChangeModel;

@Service
public class Producer {
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "orgChangeTopic";
	@Autowired
	private KafkaTemplate<String, OrganizationChangeModel> kafkaTemplate;

    public void publishOrgChange(String action,String orgId){
        logger.debug("Sending Kafka message {} for Organization Id: {}", action, orgId);
         OrganizationChangeModel change =  new OrganizationChangeModel(
                 OrganizationChangeModel.class.getTypeName(),
                 action,
                 orgId);
         Message<OrganizationChangeModel> message = MessageBuilder
                 .withPayload(change)
                 .setHeader(KafkaHeaders.TOPIC, TOPIC)
                 .build();
         logger.info(String.format("$$ -> Producing message --> %s", message));
         this.kafkaTemplate.send(message);

     }
	
}