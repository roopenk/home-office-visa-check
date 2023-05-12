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

public class ReasonForTravelPage extends Utility {
    public ReasonForTravelPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@class='govuk-radios']//div//label")
    List<WebElement> reasonList;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement clickContinue;

    public void selectReasonForVisit(String reason){
        Reporter.log("Select a reason for visit: " + reasonList.toString());
        for (WebElement rsnElement : reasonList) {
            if (rsnElement.getText().contains(reason))
            {clickOnElement((By) rsnElement);
                break;}
        }
        CustomListeners.test.log(Status.PASS, "Select a reason for visit");
    }
    public void clickContinueButton() {
        Reporter.log("Click on continue: " + clickContinue.toString());
        clickOnElement((By) clickContinue);
        CustomListeners.test.log(Status.PASS, "Click on continue");
    }
}
