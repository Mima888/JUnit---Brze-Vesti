package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalsPage extends Setup {

    //PRIVATE METHODS
    private void addPortalBtn() {

        WebDriverWait waitPort = new WebDriverWait(driver, 10);
        WebElement addPortalButton = waitPort.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addPortalButton.click();
    }

    private void titleFieldPortal() {

        WebElement writePortalTitle = driver.findElement(By.id("title"));
        writePortalTitle.sendKeys(Helper.getRandomTextPort());

    }

    private void urlFieldPortal() {

        WebElement writePortalUrl = driver.findElement(By.id("url"));
        writePortalUrl.sendKeys(Helper.getRandomUrl());
    }

    private void selectRegion() {

        Select dropDownReg = new Select(driver.findElement(By.name("region_id")));
        dropDownReg.selectByValue("4");
    }

    private void savePortBtn() {

        WebElement savePortButton = driver.findElement(By.id("save-portal-button"));
        savePortButton.click();
    }

    private void editPortBtn(WebElement row) {

        WebElement editPort = row.findElement(By.cssSelector("a[title='Edit']"));
        editPort.click();
    }

    private void titleFieldWithClear() {

        WebElement writePortal = driver.findElement(By.id("title"));
        writePortal.clear();
        writePortal.sendKeys(Helper.getRandomTextPort());
    }
    
    private void urlFieldWithClear() {
        
        WebElement writePortalUrl = driver.findElement(By.id("url"));
        writePortalUrl.clear();
        writePortalUrl.sendKeys(Helper.getRandomUrl());
    }
    
    private void selectNewRegion() {
        
        Select dropDownReg = new Select(driver.findElement(By.name("region_id")));
        dropDownReg.selectByValue("5");
    }

    private void clickOnDeleteBtn(WebElement row) {

        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void confirmDelete() {

        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();

    }

    private void closeBtn() {

        WebElement btnClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[1]")));
        btnClose.click();
    }

    private void clickOnDisableBtn(WebElement row) {

        WebElement disableBtn = row.findElement(By.cssSelector("button[title='Disable']"));
        disableBtn.click();
    }

    private void confirmDisable() {

        WebElement btnDisable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"portalDisableDialog\"]/div/div/div[3]/button[2]")));
        btnDisable.click();

    }

    private void clickOnEnableBtn(WebElement row) {

        WebElement enableBtn = row.findElement(By.cssSelector("button[title='Enable']"));
        enableBtn.click();
    }

    private void confirmEnable() {

        WebElement btnEnable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"portalEnableDialog\"]/div/div/div[3]/button[2]")));
        btnEnable.click();
    }

    private List<WebElement> getRowsFromTable() {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());

        return rows;

    }

    private WebElement chooseLastRow() {

        List<WebElement> rows = getRowsFromTable();
//        WebElement lastRow = rows.get(rows.size() - 1);
//
//        return lastRow;

        return rows.get(rows.size() - 1);
    }

    private WebElement chooseFirstRow() {

//        List<WebElement> rows = getRowsFromTable(wait);
//        WebElement firstRow = rows.get(0);
//
//        return firstRow;
        return getRowsFromTable().get(0);

    }

    private WebElement chooseRandomRow() {

        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));

        return randomRow;
    }
    
    //PUBLIC METHODS
    public void addNewPortal() {
        
        addPortalBtn();
        titleFieldPortal();
        urlFieldPortal();
        selectRegion();
        savePortBtn();
    }
    
    public void editFirstPortal() {
        
        WebElement firstRow = chooseFirstRow();
        editPortBtn(firstRow);
        titleFieldWithClear();
        urlFieldWithClear();
        selectNewRegion();
        savePortBtn();
    }
    
     public void editLastPortal() {
        
        WebElement lastRow = chooseLastRow();
        editPortBtn(lastRow);
        titleFieldWithClear();
        urlFieldWithClear();
        selectNewRegion();
        savePortBtn();
    }
     
      public void editRandomPortal() {
        
        WebElement randomRow = chooseRandomRow();
        editPortBtn(randomRow);
        titleFieldWithClear();
        urlFieldWithClear();
        selectNewRegion();
        savePortBtn();
    }
      
      public void deleteFirstPortal() {
          
          WebElement firstRow = chooseFirstRow();
          clickOnDeleteBtn(firstRow);
          confirmDelete();
      }
      
      public void deleteLastPortal() {
          
          WebElement lastRow = chooseLastRow();
          clickOnDeleteBtn(lastRow);
//          confirmDelete();
          closeBtn();
      }
      
      public void deleteRandomPortal() {
          
          WebElement randomRow = chooseRandomRow();
          clickOnDeleteBtn(randomRow);
          confirmDelete();
      }
      
      public void disableFirstPortal() {

        WebElement firstRow = chooseFirstRow();
        clickOnDisableBtn(firstRow);
        confirmDisable();

    }

    public void disableLastPortal() {

        WebElement lastRow = chooseLastRow();
        clickOnDisableBtn(lastRow);
        confirmDisable();
    }

    public void disableRandomPortal() {

        WebElement randomRow = chooseRandomRow();
        clickOnDisableBtn(randomRow);
        confirmDisable();
    }
    
    public void enableFirstPortal() {

        WebElement firstRow = chooseFirstRow();
        clickOnEnableBtn(firstRow);
        confirmEnable();
    }

    public void enableLastPortal() {

        WebElement lastRow = chooseLastRow();
        clickOnEnableBtn(lastRow);
        confirmEnable();
    }
}
