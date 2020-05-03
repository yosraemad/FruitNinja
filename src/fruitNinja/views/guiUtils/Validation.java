package fruitNinja.views.guiUtils;

import fruitNinja.data.services.PlayerService;
import fruitNinja.models.users.Player;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

// CLASS TO VALIDATE THE INPUT IN THE APPLICATION
public class Validation {
    PlayerService playerService = new PlayerService();
    private Boolean flag = false;


    public  boolean isStringOnlyAlphabet(String str) {
        if ((str != null)) return true;
        assert false;
        return (str.matches("\\S+"))
        && (str.matches("^[a-zA-Z]*$"));
    }


    public boolean allowedPassword(String password) {
        boolean valid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCaseChars = "(.*[a-z].*)";
        String numbers = "(.*[0-9].*)";
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if ((password.length() > 15 || password.length() < 8)) {
            valid = false;
        }
        if (!password.matches(upperCaseChars) && !password.matches(lowerCaseChars) && !password.matches(numbers) && !password.matches(specialChars))
            valid = false;

        return valid;
    }

    public Validation() {
    }

    private final Alerts alerts = new Alerts();

    public void validateEmptyTextField(TextField textField) {
        String text = textField.getText();
        if (text.equals("") &&!flag) {
            flag = true;
            alerts.showErrorAlert("Missing Field", "You must enter data in the text fields");
        }
    }


    public void validateUsernameTextField(TextField textField) {

        String username = textField.getText();
        for (Player player:playerService.readData()){
            if(player.getUsername().equalsIgnoreCase(username) && !flag){
                flag = true;
                alerts.showErrorAlert("Invalid Username","Username already exits");
            }
        }
    }

    public void validateFullNameTextField(TextField textField) {
        String fullName = textField.getText().toLowerCase();
        if( !isStringOnlyAlphabet(fullName)&&!flag){
            flag = true;
            alerts.showErrorAlert("Invalid Full Name","Full Name must be letters");
        }
    }


    public void validateEmptyTextFields(TextField fullName,TextField username,PasswordField passwordField){
        validateEmptyTextField(fullName);
        validateEmptyTextField(username);
        validateEmptyTextField(passwordField);
    }

    public void validatePasswordField(PasswordField passwordField) {
        validateLongPassword(passwordField.getText());

          if( !allowedPassword(passwordField.getText()) && !flag)
          {
              flag = true;

              alerts.showErrorAlert("error in pass","please enter pass between 8 and 15");
          }
    }

    public void validateLongPassword(String password) {
        if (password.length() < 6 &&!flag) {
            flag = true;

            alerts.showErrorAlert("Weak Password", "Please choose a password which is at least 6 chars long");
        }
    }

    public Boolean getFlag() {
        return flag;
    }
}
