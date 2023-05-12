package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    public SelectNationalityPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "response")
    WebElement country;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;

    public void selectCountry(String country) {
        Reporter.log("Select country: " + this.country.toString());
        selectByVisibleTextFromDropDown((By) this.country, country);
        CustomListeners.test.log(Status.PASS, "Select country");
    }

    public void clickContinueButton() {
        Reporter.log("Click on continue: " + continueButton.toString());
        clickOnElement((By) continueButton);
        CustomListeners.test.log(Status.PASS, "Click on continue");
    }
}
