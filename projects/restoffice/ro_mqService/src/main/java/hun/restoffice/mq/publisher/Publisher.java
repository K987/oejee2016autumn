/**
 * 
 */
package hun.restoffice.mq.publisher;

import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hun.restoffice.remoteClient.domain.IncomeStub;

/**
 * 
 *
 * @author kalmankostenszky
 */
@Stateless(mappedName = "ejb/publisher")
public class Publisher implements PublisherLocal {

	private static final Logger LOG = Logger.getLogger(Publisher.class);

	//@Resource
	//private SessionContext sctx;

	//@Resource(mappedName = "jms/TopicConnectionFactory")
	//private TopicConnectionFactory topicConnectionFactory;

	//@Resource(mappedName = "jms/Topic")
	//private Topic topic;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hun.restoffice.mq.publisher.PublisherLocal#publish(java.util.List)
	 */
	@Override
	public void publish(List<IncomeStub> incomes)  {
		LOG.info("publisher called");
		/*
		Connection connection = null;
		try {
			connection = topicConnectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(topic);
			for (IncomeStub incomeStub : incomes) {
				producer.send(session.createObjectMessage(incomeStub));
			}
		} catch (JMSException e) {
			LOG.error(e);
		} finally {
			try {
				connection.close();
			} catch (JMSException e) {
				LOG.error(e);
			}
		}
		*/
		
		
	}

}
