package hun.restoffice.client.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import hun.restoffice.client.model.EmployeeShiftModel;
import hun.restoffice.client.model.RegisterCloseModel;
import hun.restoffice.client.model.RegisterModel;
import hun.restoffice.remoteClient.domain.CalendarScheduleStub;
import hun.restoffice.remoteClient.domain.CalendarScheduleStub.Assignee;
import hun.restoffice.remoteClient.domain.RegisterStub;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 
 * Converts stubs to models and back
 * 
 * @author kalmankostenszky
 */
public class Converter {

	private static final Logger LOG = Logger.getLogger(Converter.class);

	/**
	 * Creates List of EmployeeShiftModels from List of CalendarScheduleStubs
	 * 
	 * @param calendarSchedules
	 * @return
	 */
	public static ObservableList<EmployeeShiftModel> toEmployeeShiftModel(List<CalendarScheduleStub> calendarSchedules) {
		ObservableList<EmployeeShiftModel> rtrn = FXCollections.observableArrayList();

		for (CalendarScheduleStub sch : calendarSchedules) {
			for (Assignee asg : sch.getAssignees()) {
				LOG.debug(asg);
				rtrn.add(new EmployeeShiftModel(asg.getName(), asg.getDefaultPosition(), asg.getActualPosition(), asg.getAcutalStart(), asg.getActualEnd(),
						sch.getStart()));
			}
		}
		return rtrn;
	}

	/**
	 * Creates RegisterCloseModel from List of RegisteStubs
	 * 
	 * @param registers
	 * @return
	 */
	public static RegisterCloseModel toRegisterCloseModel(List<RegisterStub> registers) {
		List<RegisterModel> tmp = new ArrayList<>();
		for (RegisterStub register : registers) {
			tmp.add(new RegisterModel(register.getId(), register.getType(), register.getDate(), register.getCloseNo(), register.getAmt()));
		}
		return new RegisterCloseModel(tmp);
	}

	/**
	 * Creates RegisterStub from RegisterModel
	 * 
	 * @param registerModel
	 * @return
	 */
	public static RegisterStub fromRegModel(RegisterModel registerModel) {
		return new RegisterStub(new BigDecimal(registerModel.amountProperty().get()), registerModel.getDate().getTime(), registerModel.idProperty().get(),
				registerModel.closeNoProperty().get(), registerModel.getType().ordinal());
	}

}
