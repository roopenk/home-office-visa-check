package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ResultPage extends Utility {

    public ResultPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[@class='gem-c-heading gem-c-heading--font-size-27 govuk-!-margin-bottom-6']")
    WebElement resultText;

    public String getResultMessage(){
        Reporter.log("Get result text displayed: " + resultText.toString());
        CustomListeners.test.log(Status.PASS, "Get result text displayed");
        return getTextFromElement((By) resultText);
    }

    public void confirmResultMessage(String expectedMessage){
        Reporter.log("Verify result text displayed: " + resultText.toString());
        Assert.assertTrue(getResultMessage().equalsIgnoreCase(expectedMessage));
        CustomListeners.test.log(Status.PASS, "Verify result text displayed");
    }
}
