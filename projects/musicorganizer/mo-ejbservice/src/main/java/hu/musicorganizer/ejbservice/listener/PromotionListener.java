package hu.musicorganizer.ejbservice.listener;

import hu.musicorganizer.ejbservice.facade.TracklistFacade;

import java.util.Arrays;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;

@MessageDriven(name = "PromotionListener", activationConfig = { //
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "musicorganizerqueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class PromotionListener implements MessageListener  {

	private static final Logger LOGGER = Logger.getLogger(PromotionListener.class);

	@EJB
	private TracklistFacade facade;

	@PostConstruct
	public void initialize() {
		LOGGER.info("Promotion Listener created...");
	}
	

	@Override
	public void onMessage(final Message message) {
		try {
			if (LOGGER.isDebugEnabled()) {
				final Queue destination = (Queue) message.getJMSDestination();
				final String queueName = destination.getQueueName();
				LOGGER.debug("New JMS message arrived into " + queueName + " queue (correlation id: " + message.getJMSCorrelationID() + ")");
			}

			if (message instanceof TextMessage) {
				final TextMessage textMessage = (TextMessage) message;
				String content = textMessage.getText();
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Received message: " + content);
				}
				content = content.replace("[", "");
				content = content.replace("]", "");
				final String[] urlStr = content.split(";");
				
				this.facade.promoteTracks(Arrays.asList(urlStr));
			} else {
				LOGGER.error("Received message is not a TextMessage (" + message + ")");
			}
		} catch (final Exception e) {
			LOGGER.error(e, e);
		}
	}
}
