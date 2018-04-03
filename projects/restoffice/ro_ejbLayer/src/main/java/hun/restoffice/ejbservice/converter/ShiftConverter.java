/**
 *
 */
package hun.restoffice.ejbservice.converter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import hun.restoffice.ejbservice.domain.EmployeeShiftCloseStub;
import hun.restoffice.ejbservice.domain.ShiftStub;
import hun.restoffice.persistence.entity.employee.EmployeeShift;
import hun.restoffice.persistence.entity.employee.Shift;
import hun.restoffice.remoteClient.domain.CalendarScheduleStub;
import hun.restoffice.remoteClient.domain.EmployeeShiftStub;

/**
 * Convert shift entity and stub back and forth
 *
 * @author kalmankostenszky
 */
@Stateless
public class ShiftConverter implements ShiftConverterLocal {

    /**
     * @param shift
     * @return
     */
    private CalendarScheduleStub to(final Shift shift) {
        List<EmployeeShiftStub> empShfits = new ArrayList<>();
        for (EmployeeShift item : shift.getEmployeeShifts()) {
            empShfits.add(new EmployeeShiftStub(item.getActualStart(), item.getRowId(), item.getActualEnd(),
                    (item.getActualPosition() == null ? -1 : item.getActualPosition().ordinal()), item.getEmployee().getEmployeeName(),
                    item.getEmployee().getDefaultPosition().ordinal()));
        }

        return new CalendarScheduleStub(shift.getStartDate(), shift.getStartTime(), shift.getId(), empShfits);
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.converter.ShiftConverterLocal#to(java.util.List)
     */
    @Override
    public List<CalendarScheduleStub> toSchedule(final List<Shift> shifts) {
        List<CalendarScheduleStub> rtrn = new ArrayList<>();
        for (Shift s : shifts) {
            rtrn.add(to(s));
        }
        return rtrn;
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.converter.ShiftConverterLocal#to(java.util.List)
     */
    @Override
    public List<ShiftStub> to(final List<Shift> shifts) {
        List<ShiftStub> rtrn = new ArrayList<>();
        for (Shift s : shifts) {
            rtrn.add(new ShiftStub(s));
        }
        return rtrn;
    }

    /*
     * (non-Javadoc)
     *
     * @see hun.restoffice.ejbservice.converter.ShiftConverterLocal#from(java.util.List)
     */
    @Override
    public List<EmployeeShift> from(final List<EmployeeShiftStub> models) {
        List<EmployeeShift> rtrn = new ArrayList<>();
        for (EmployeeShiftStub stub : models) {
            rtrn.add(from(stub));
        }
        return rtrn;
    }

    private EmployeeShift from(final EmployeeShiftStub stub) {
        return new EmployeeShift(stub.getName(), stub.getShiftid(), stub.getActualStart().getTime(), stub.getActualEnd().getTime(), stub.getActualPosition());
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.converter.ShiftConverterLocal#toShiftClose(java.
     * util.List)
     */
    @Override
    public List<EmployeeShiftCloseStub> toShiftClose(final List<Shift> shifts) {
        List<EmployeeShiftCloseStub> rtrn = new ArrayList<>();
        for (Shift shift : shifts) {
            for (EmployeeShift empShift : shift.getEmployeeShifts()) {
                Calendar start = empShift.getActualStart() == null ? setCal(shift.getStartDate(), shift.getStartTime(), null) : toCal(empShift.getActualStart());
                Calendar end = (empShift.getActualEnd() == null ? setCal(shift.getStartDate(), shift.getStartTime(), shift.getDuration()) : toCal(empShift.getActualEnd()));

                rtrn.add(new EmployeeShiftCloseStub(
                        shift.getId(),
                        empShift.getRowId(),
                        empShift.getEmployee().getId(),
                        empShift.getEmployee().getEmployeeName(),
                        start,
                        end,
                        (empShift.getActualPosition() == null ? empShift.getEmployee().getDefaultPosition() : empShift.getActualPosition()),
                        empShift.getEmployee().getDefaultPosition(),
                        empShift.getActualPosition() != null));

            }
        }
        return rtrn;
    }

    private Calendar toCal(final Date date) {
        Calendar rtrn = Calendar.getInstance();
        rtrn.setTime(date);
        return rtrn;
    }
    /**
     * @param startDate
     * @param startTime
     * @param duration
     * @return
     */
    private Calendar setCal(final Date startDate, final Date startTime, final BigDecimal duration) {
        Calendar rtrn = Calendar.getInstance();
        Calendar date = Calendar.getInstance();
        Calendar time = Calendar.getInstance();
        date.setTime(startDate);
        time.setTime(startTime);
        rtrn.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH),
                time.get(Calendar.HOUR), time.get(Calendar.MINUTE), time.get(Calendar.SECOND));
        if (duration != null) {
            rtrn.add(Calendar.HOUR, duration.intValue());
        }
        return rtrn;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * hun.restoffice.ejbservice.converter.ShiftConverterLocal#fromCloseStub(java.
     * util.List)
     */
    @Override
    public List<EmployeeShift> fromCloseStub(final List<EmployeeShiftCloseStub> models) {
        List<EmployeeShift> rtrn = new ArrayList<>();
        for (EmployeeShiftCloseStub stub : models) {
            rtrn.add(new EmployeeShift(stub.getEmployeeName(), stub.getShiftId(), stub.getActualStart().getTime(),
                    stub.getActualEnd().getTime(), stub.getActualPosition()));
        }
        return rtrn;
    }

}
