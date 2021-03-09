package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.*;
import singletonSession.Session;

public class CRUDItemTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    LeftSection leftSection = new LeftSection();
    CenterSection centerSection = new CenterSection();

    String user = "upbui@upbui.com";
    String pwd = "1234";
    String titleProject = "ProjectNuria";
    String titleItemUpdate = "ItemUpdate";
    String titleItem = "Item";

    @Test
    public void verify_crud_item_todoly() throws InterruptedException {
        //login
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        //create project
        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.set(titleProject);
        leftSection.addButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("El proyecto no fue creado", titleProject, centerSection.projectNameLabel.getText());

        //Create Item
        centerSection.addItemButton.click();
        centerSection.nameItemTextBox.set(titleItem);
        centerSection.addButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("El item no fue creado", titleItem, centerSection.nameItemLabel.getText());

        //Update Item
        centerSection.nameItemLabel.click();
        centerSection.editNameItemTextBox.clear();
        centerSection.editNameItemTextBox.set(titleItemUpdate);
        centerSection.editNameItemTextBox.enter();
        Thread.sleep(2000);
        Assert.assertEquals("El item no fue actualizado", titleItemUpdate, centerSection.nameItemLabel.getText());

        //Delete Item
        centerSection.nameItemLabel.click();
        centerSection.dropdownButton.click();
        centerSection.deleteButton.click();
        Thread.sleep(2000);
        Assert.assertTrue("No se eliminó el item", centerSection.infoMessageDeleteLabel.controlIsDisplayed());

        //Delete Project
        leftSection.projectButton.click();
        leftSection.dropdownButton.click();
        leftSection.deleteButton.click();
        Session.getSession().getDriver().switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertFalse("No se eliminó el proyecto", titleProject.equals(centerSection.projectNameLabel.getText()));
    }

    @After
    public void close() {
        Session.getSession().closeSession();
    }
}
