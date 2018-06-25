package pages;

import framework.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage {

    public void clickOnRegionButton(WebDriver driver) {

        WebDriverWait waitReg = new WebDriverWait(driver, 10);
        WebElement addRegionButton = waitReg.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addRegionButton.click();
    }
    
     private void saveRegButton(WebDriver driver) {

        WebElement saveRegButton = driver.findElement(By.id("save-region-button"));
        saveRegButton.click();
    }
    
    private void titleFieldCategory(WebDriver driver) {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.sendKeys(Helper.getRandomTextCat());

    }
    
    private void clearAndWriteInTitleField(WebDriver driver) {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.clear();
        writeCategory.sendKeys(Helper.getRandomTextCat());
    }

    //public methods 
    public void createNewRegion(WebDriver driver) {
        
        clickOnRegionButton(driver);
        titleFieldCategory(driver);
        saveRegButton(driver);
    }

    public void editFirstregion() {

    }

    public void editLastRegion() {

    }

    public void editRandomRegion() {

    }

    public void deleteFirstRegion() {

    }

    public void deleteLastRegion() {

    }

    public void deleteRandomRegion() {

    }

    public void enableRegion() {

    }

    public void disableRegion() {

    }

}
