import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidToDoAppTest extends TestBase{

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Test
    public void testAddTask() throws MalformedURLException {
        androidSetUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskButton();
        createTaskPage.enterTaskName("Finish Appium");
        createTaskPage.enterTaskDesc("Finishing Desc");
        driver.hideKeyboard();
        createTaskPage.clickSaveButton();
        tearDown();
    }
}
