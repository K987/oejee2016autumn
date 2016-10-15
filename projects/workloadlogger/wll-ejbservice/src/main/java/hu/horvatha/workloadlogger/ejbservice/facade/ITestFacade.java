package hu.horvatha.workloadlogger.ejbservice.facade;
import java.util.List;
import javax.ejb.Local;
import hu.horvatha.workloadlogger.ejbservice.domain.TestStub;

@Local
public interface ITestFacade {
	List<TestStub> getBooks();
}

