import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CreateTaskPage extends PageBase{
    public CreateTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "editTextTitre")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Title'")
    MobileElement taskNameTxt;

    @AndroidFindBy(id = "editTextNote")
    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Description'")
    MobileElement taskDescTxt;

    @AndroidFindBy(id = "action_save")
    @iOSXCUITFindBy(accessibility = "Save")
    MobileElement saveBtn;

    public void enterTaskName(String taskName) {
        clear(taskNameTxt);
        sendKeys(taskNameTxt, taskName);
    }

    public void enterTaskDesc(String taskDesc) {
        clear(taskDescTxt);
        sendKeys(taskDescTxt, taskDesc);
    }

    public void clickSaveButton() {
        click(saveBtn);
    }
}
