package pomPages.todoLy;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

public class CenterSection {
    public Label projectNameLabel = new Label(By.xpath("//div[@id='CurrentProjectTitle']"));
    public Button addItemButton = new Button(By.xpath("//textarea[@id='NewItemContentInput']"));
    public Button addButton = new Button(By.xpath("//input[@id='NewItemAddButton']"));
    public TextBox nameItemTextBox = new TextBox(By.xpath("//textarea[@id='NewItemContentInput']"));
    public Label nameItemLabel = new Label(By.xpath("//li[last()]//td/div[@class ='ItemContentDiv']"));
    public TextBox editNameItemTextBox = new TextBox(By.id("ItemEditTextbox"));
    public Button dropdownButton = new Button(By.xpath("//img[@class='ItemMenu' and @style='display: inline;']"));
    public Button deleteButton = new Button(By.xpath("//li[@class='delete separator']//a[@href=\"#delete\"]"));
    public Label infoMessageDeleteLabel = new Label(By.id("InfoMessageText"));

    public CenterSection() {
    }
}
