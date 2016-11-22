/**
 * 
 */
package hun.restoffice.client.register;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;

import hun.restoffice.remoteClient.domain.RegisterCloseStub;
import hun.restoffice.remoteClient.domain.RegisterType;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

/**
 * Model for register closing
 *
 * @author kalmankostenszky
 */
public class RegisterCloseModel {

	private static final Logger LOG = Logger.getLogger(RegisterCloseModel.class);

	private Calendar date;

	private ObservableList<RegisterModel> regModels;

	private DoubleBinding card;
	private DoubleBinding cash;
	private DoubleBinding sum;

	public RegisterCloseModel(List<RegisterCloseStub> registerCloses) {

		Callback<RegisterModel, Observable[]> extractor = new Callback<RegisterModel, Observable[]>() {

			@Override
			public Observable[] call(RegisterModel p) {
				Observable[] rtrn = new Observable[] { p.amountProperty() };
				return rtrn;
			}
		};

		regModels = FXCollections.observableArrayList(extractor);

		for (RegisterCloseStub regClose : registerCloses) {
			RegisterModel tmp = new RegisterModel(regClose);
			regModels.add(new RegisterModel(regClose));
		}

		sum = Bindings.createDoubleBinding(new Callable<Double>() {

			@Override
			public Double call() throws Exception {
				double rtrn = 0;
				for (RegisterModel rm : regModels) {
					if (rm.typeProperty().get().equals(RegisterType.CASH.toString())) {
						rtrn += rm.amountProperty().doubleValue();
					}
				}
				return rtrn;
			}
		}, regModels);

		card = Bindings.createDoubleBinding(new Callable<Double>() {

			@Override
			public Double call() throws Exception {
				double rtrn = 0;
				for (RegisterModel rm : regModels) {
					if (rm.typeProperty().get().equals(RegisterType.CARD.toString())) {
						rtrn += rm.amountProperty().doubleValue();
					}
				}
				return rtrn;
			}
		}, regModels);

		cash = sum.subtract(card);
	}

	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * edit
	 */
	public ObservableList<RegisterModel> getRegModels() {
		return regModels;
	}

	/**
	 * @return the card
	 */
	public DoubleBinding getCard() {
		return card;
	}

	/**
	 * @return the cash
	 */
	public DoubleBinding getCash() {
		return cash;
	}

	/**
	 * @return the sum
	 */
	public DoubleBinding getSum() {
		return sum;
	}

}
