package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class WorkTypePage extends Utility {
    public WorkTypePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='govuk-radios']//div//label")
    List<WebElement> workType;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueBtn;


    public void selectJobTypeList(String jobType) {
        Reporter.log("Select job type: " + workType.toString());
        for (WebElement job : workType) {
            if (job.getText().contains(jobType))
                clickOnElement((By) job);
            break;
        }
        CustomListeners.test.log(Status.PASS, "Select job type");
    }

    public void clickContinueButton() {
        Reporter.log("Click on continue: " + continueBtn.toString());
        clickOnElement((By) continueBtn);
        CustomListeners.test.log(Status.PASS, "Click on continue");
    }
}
