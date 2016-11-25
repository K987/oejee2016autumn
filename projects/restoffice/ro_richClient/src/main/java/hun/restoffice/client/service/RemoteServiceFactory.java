/**
 * 
 */
package hun.restoffice.client.service;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import hun.restoffice.remoteClient.service.ShiftFacadeRemote;

/**
 *  
 *
 * @author kalmankostenszky
 */
public class RemoteServiceFactory {
	
	private static final String JBOSS_INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
	private static final String JBOSS_PROVIDER_URL = "remote://localhost:4447";
	private static final String JBOSS_URL_PKG_PREFIXES = "org.jboss.ejb.client.naming";

	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY = "jboss.naming.client.ejb.context";
	private static final String JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE = "true";
	
	
	public static ShiftFacadeRemote lookup() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, JBOSS_INITIAL_CONTEXT_FACTORY);
		jndiProperties.put(Context.PROVIDER_URL, JBOSS_PROVIDER_URL);
		jndiProperties.put(Context.URL_PKG_PREFIXES, JBOSS_URL_PKG_PREFIXES);
		jndiProperties.put(JBOSS_NAMING_CLIENT_EJB_CONTEXT_KEY, JBOSS_NAMING_CLIENT_EJB_CONTEXT_VALUE);
		final Context context = new InitialContext(jndiProperties);
		return null;
		//return (RegisterFacadeRemote) context.lookup("diskstore/ds-ejbservice/DiskFacadeImpl!hu.qwaevisz.diskstore.ejbserviceclient.DiskFacadeRemote");
		//return (RegisterFacadeRemote) context.lookup("diskstore/ds-ejbservice/DiskFacadeImpl!hu.qwaevisz.diskstore.ejbserviceclient.DiskFacadeRemote");
	}

}
