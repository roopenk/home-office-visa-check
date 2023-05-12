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

public class DurationOfStayPage extends Utility {
    public DurationOfStayPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='govuk-radios']//label")
    List<WebElement> stay;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void selectLengthOfStay(String lengthOfStay){
        Reporter.log("Select Stay Time Length: " + stay.toString());
        switch(lengthOfStay){
            case "6 months or less":
                stay.get(0).click();
                break;
            case "longer than 6 months":
                stay.get(1).click();
                break;
        }
        CustomListeners.test.log(Status.PASS, "Select Stay Time Length");
    }
    public void clickNextStepButton(){
        Reporter.log("Click on next step:");
        clickOnElement((By) continueButton);
        CustomListeners.test.log(Status.PASS, "Click on next step:");
    }
}
