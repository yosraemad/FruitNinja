package fruitNinja.views.guiUtils;

import javafx.scene.control.Alert;

// CLASS FOR SHOWING THE ALERTS IN THE VIEWS
public class Alerts {

    public void showSuccessAlert(String header, String errorMsg)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText(header);
        alert.setContentText(errorMsg);
        alert.showAndWait();
    }

    public void showErrorAlert(String header, String errorMsg)
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText(header);
        alert.setContentText(errorMsg);
        alert.showAndWait();
    }

    public void showInfoAlert(String header, String errorMsg)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info!");
        alert.setHeaderText(header);
        alert.setContentText(errorMsg);
        alert.showAndWait();
    }

}
