import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class iOSToDoAppTest extends TestBase{

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @Test
    public void testAddTask() throws MalformedURLException {
        iOSSetUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskButton();
        createTaskPage.enterTaskName("Finish Appium");
        createTaskPage.enterTaskDesc("Finishing Desc");
        createTaskPage.clickSaveButton();
        tearDown();
    }

}
