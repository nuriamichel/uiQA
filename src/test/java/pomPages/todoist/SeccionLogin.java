package pomPages.todoist;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class SeccionLogin {
    public Button IrASesionButton = new Button(By.xpath("//a[@class=\"tdo-button js-cta js-cta-finish\"]"));
    public Label verfy =new Label(By.xpath("//img[@class=\"user_avatar big settings_avatar\"]\n"));




    public SeccionLogin(){}
}
