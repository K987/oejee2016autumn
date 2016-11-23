package hun.restoffice.client.controller;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

public class DynamicEditableTextTableCell<S, T> extends TextFieldTableCell<S, T>{
 
  public BooleanProperty notEditableProperty() { return notEditable; }
  public final boolean isNotEditable() { return notEditableProperty().get(); }
  private final BooleanProperty notEditable = new SimpleBooleanProperty();
  
 
  public SimpleObjectProperty<S> recordProperty() { return record; }
  
  private SimpleObjectProperty<S> record = new SimpleObjectProperty<>();
 
  public DynamicEditableTextTableCell(StringConverter<T> converter)
  {
    super(converter);
    notEditable.bind(editableProperty().not());
    tableRowProperty().addListener((ChangeListener<TableRow>) (ov, vOld, vNew) -> {
	  record.unbind();
	  if (vNew != null)
	  {
	    record.bind(vNew.itemProperty());
	  }
	});
  }
}