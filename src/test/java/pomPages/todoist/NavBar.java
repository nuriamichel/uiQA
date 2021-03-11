package pomPages.todoist;

import controls.Button;
import org.openqa.selenium.By;

public class NavBar {
    public Button registrarseButton = new Button(By.xpath("//ul[@class='_3XsmI']//a[contains(.,'Regístrate')]"));
    public NavBar(){}
}
