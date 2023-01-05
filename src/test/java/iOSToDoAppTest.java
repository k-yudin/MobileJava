import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.CreateTaskPage;
import page_objects.TasksListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class iOSToDoAppTest extends TestBase{

    CreateTaskPage createTaskPage;
    TasksListPage tasksListPage;

    @DataProvider(name = "task data")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/data/TaskData.json",
                "Tasks Data",
                2);
    }

    @Test(dataProvider = "task data")
    public void testAddTask(String taskName, String taskDescription) throws MalformedURLException {
        iOSSetUp("10000", "iPhone 14 Pro", "603BDE57-20A3-41C9-889B-C1B8A0BE8195", "8200");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskButton();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDescription);
        createTaskPage.clickSaveButton();
        tearDown();
    }

    @Test(dataProvider = "task data")
    public void testAddTask2(String taskName, String taskDescription) throws MalformedURLException {
        iOSSetUp("10001", "iPhone 14 Plus)", "04104EA8-3CE5-4525-8101-E5E39CAC26C6", "8100");
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskButton();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDescription);
        createTaskPage.clickSaveButton();
        tearDown();
    }
}
