import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.CreateTaskPage;
import page_objects.TasksListPage;
import utils.JsonReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class AndroidToDoAppTest extends TestBase{

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
        androidSetUp();
        tasksListPage = new TasksListPage(driver);
        createTaskPage = new CreateTaskPage(driver);
        tasksListPage.clickAddTaskButton();
        createTaskPage.enterTaskName(taskName);
        createTaskPage.enterTaskDesc(taskDescription);
        driver.hideKeyboard();
        createTaskPage.clickSaveButton();
        tearDown();
    }
}
