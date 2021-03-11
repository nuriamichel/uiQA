package pomPages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SeccionRegistro {  public TextBox emailTextBox = new TextBox(By.xpath("//input[@class=\"input_email\"]"));
    public TextBox nonbreTextBox = new TextBox(By.xpath("//input[@class=\"input_name\"]"));
    public TextBox passwordTextBox = new TextBox(By.xpath("//input[@class=\"form_field_control\"]\n"));
    public Button registrarseButton = new Button(By.id("step_one_submit"));
    public Button submitButton = new Button(By.id("step_two_submit"));


    public SeccionRegistro(){}
}
