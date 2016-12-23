package hu.musicorganizer.jmsclient;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Application {
	private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String PROVIDER_URL = "remote://localhost:4547"; //incl. 100 offset (default: 4447)
	private static final String USERNAME = "levaijmstest";
	private static final String PASSWORD = "Levai#123";
	private static final String DESTINATION_MUSICORGANIZER = "jms/queue/musicorganizerqueue";

	public static void main(String[] args) throws NamingException, JMSException {
		
		if (args.length == 0) {
			throw new RuntimeException("Please provide streaming url's seperated by ;'s as parameter nr.1");
		}
		
		final Properties environment = new Properties();
		environment.put(Context.INITIAL_CONTEXT_FACTORY, Application.INITIAL_CONTEXT_FACTORY);
		environment.put(Context.PROVIDER_URL, Application.PROVIDER_URL);
		environment.put(Context.SECURITY_PRINCIPAL, Application.USERNAME);
		environment.put(Context.SECURITY_CREDENTIALS, Application.PASSWORD);
		final Context context = new InitialContext(environment);

		final ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
		final Destination destination = (Destination) context.lookup(Application.DESTINATION_MUSICORGANIZER);

		final Connection connection = connectionFactory.createConnection(Application.USERNAME, Application.PASSWORD);
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		final MessageProducer producer = session.createProducer(destination);
		connection.start();
		

		final TextMessage textMessage = session.createTextMessage(args[0]);
		producer.send(textMessage);

		connection.close();
		
	}
}
