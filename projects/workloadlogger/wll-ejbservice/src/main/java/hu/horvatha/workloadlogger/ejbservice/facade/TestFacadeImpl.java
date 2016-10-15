package hu.horvatha.workloadlogger.ejbservice.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import hu.horvatha.workloadlogger.ejbservice.domain.TestStub;

@Stateless(mappedName = "ejb/TestFacade")
public class TestFacadeImpl implements ITestFacade {
	
	private static final Logger LOGGER = 
			Logger.getLogger(TestFacadeImpl.class);

	@Override
	public List<TestStub> getBooks() {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Get stubs debug message");
		}
		
		List<TestStub> stubs = new ArrayList<>();
		stubs.add(new TestStub());
		return stubs;
	}
}