package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.CenterSection;
import pomPages.todoLy.LeftSection;
import pomPages.todoLy.LoginModal;
import pomPages.todoLy.MainPage;
import singletonSession.Session;

public class CRUDProjectTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    LeftSection leftSection = new LeftSection();
    CenterSection centerSection = new CenterSection();
    String user = "upbui@upbui.com";
    String pwd = "1234";
    String title = "ProjectClean";
    String titleUpdate = "ProjectCleanUpdate";

    @Test
    public void verify_crud_project_todoly() throws InterruptedException {
        //login
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        //create
        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.set(title);
        leftSection.addButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("El proyecto no fue creado", title, centerSection.projectNameLabel.getText());

        //update
        leftSection.projectButton.click();
        leftSection.dropdownButton.click();
        leftSection.editButton.click();
        leftSection.editNameProjectTextBox.clear();
        leftSection.editNameProjectTextBox.set(titleUpdate);
        leftSection.saveButton.click();
        Thread.sleep(2000);
        Assert.assertEquals("El proyecto no fue actualizado", titleUpdate, centerSection.projectNameLabel.getText());

        //delete
        leftSection.projectButton.click();
        leftSection.dropdownButton.click();
        leftSection.deleteButton.click();
        Session.getSession().getDriver().switchTo().alert().accept();
        Thread.sleep(2000);
        Assert.assertFalse("No se eliminó el proyecto", titleUpdate.equals(centerSection.projectNameLabel.getText()));
    }

    @After
    public void close() {
        Session.getSession().closeSession();
    }
}
