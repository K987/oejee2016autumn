package hun.restoffice.client.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import hun.restoffice.client.model.EmployeeShiftModel;
import hun.restoffice.client.model.RegisterCloseModel;
import hun.restoffice.client.model.RegisterModel;
import hun.restoffice.ejbservice.domain.CalendarScheduleStub;
import hun.restoffice.ejbservice.domain.CalendarScheduleStub.Assignee;
import hun.restoffice.remoteClient.domain.RegisterCloseStub;
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
	public static RegisterCloseModel toRegisterCloseModel(List<RegisterCloseStub> registers) {
		List<RegisterModel> tmp = new ArrayList<>();
		for (RegisterCloseStub register : registers) {
			tmp.add(new RegisterModel(register.getRegisterStub().getRegisterId(), register.getRegisterStub().getRegisterType(), register.getCloseDate(),
					register.getCloseNo(), register.getCloseAmt().doubleValue()));
		}
		return new RegisterCloseModel(tmp);
	}

	/**
	 * Creates RegisterStub from RegisterModel
	 * 
	 * @param registerModel
	 * @return
	 */
	public static RegisterCloseStub fromRegModel(RegisterModel registerModel) {
		return new RegisterCloseStub(new RegisterStub(registerModel.idProperty().get(), registerModel.getType().ordinal()),
				new BigDecimal(registerModel.amountProperty().get()), registerModel.getDate().getTime(), registerModel.closeNoProperty().get());
	}
	
	/**
	 * Creates list of RegisterCloseStub from List of RegisterModels
	 * 
	 * @param models
	 * @return
	 */
	public static List<RegisterCloseStub> fromRegisterCloseModel(List<RegisterModel> models){
		List<RegisterCloseStub> rtrn = new ArrayList<>();
		for (RegisterModel model : models) {
			rtrn.add(fromRegModel(model));
		}
		return rtrn;
	}

}
