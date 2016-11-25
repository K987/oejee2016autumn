package hun.restoffice.client.converter;

import java.util.List;

import hun.restoffice.client.model.EmployeeShiftModel;
import hun.restoffice.remoteClient.domain.CalendarScheduleStub;
import hun.restoffice.remoteClient.domain.CalendarScheduleStub.Assignee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class Converter {

	public static ObservableList<EmployeeShiftModel> to(List<CalendarScheduleStub> calendarschedule) {

		ObservableList<EmployeeShiftModel> rtrn = FXCollections.observableArrayList();

		for (CalendarScheduleStub sch : calendarschedule) {
			for (Assignee asg : sch.getAssignees()) {
				rtrn.add(new EmployeeShiftModel(asg.getName(), asg.getDefaultPosition(), asg.getActualPosition(), asg.getAcutalStart(), asg.getActualEnd(),
						sch.getStart()));
			}
		}
		return rtrn;
	}

}
