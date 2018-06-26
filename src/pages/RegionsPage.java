package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegionsPage  extends Setup{

    //PRIVATE METHODS
    private void addRegionBtn() {

        WebDriverWait waitReg = new WebDriverWait(driver, 10);
        WebElement addRegionButton = waitReg.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addRegionButton.click();
    }

    private void titleFieldRegion() {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.sendKeys(Helper.getRandomTextCat());

    }

    private void saveRegBtn() {

        WebElement saveRegButton = driver.findElement(By.id("save-region-button"));
        saveRegButton.click();
    }

    private void editRegBtn(WebElement row) {

        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
    }

    private void titleFieldWithClear() {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.clear();
        writeCategory.sendKeys(Helper.getRandomTextReg());
    }

    private void clickOnDeleteBtn(WebElement row) {

        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void confirmDelete() {

        driver.switchTo().activeElement();

        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();

        driver.switchTo().defaultContent();
    }
    
    private void closeBtn() {
        
        WebElement btnClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[1]")));
        btnClose.click();
    }

    private void clickOnDisableBtn(WebElement row) {

        WebElement disableBtn = row.findElement(By.cssSelector("button[title='Disable']"));
        disableBtn.click();
    }

    private void confirmDisable() {

        WebElement btnDisable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[2]")));
        btnDisable.click();

    }

    private void clickOnEnableBtn(WebElement row) {

        WebElement enableBtn = row.findElement(By.cssSelector("button[title='Enable']"));
        enableBtn.click();
    }

    private void confirmEnable() {

        WebElement btnEnable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[2]")));
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
    public void createNewRegion() {

        addRegionBtn();
        titleFieldRegion();
        saveRegBtn();
    }

    public void editFirstregion() {

        WebElement firstRow = chooseFirstRow();
        editRegBtn(firstRow);
        titleFieldWithClear();
        saveRegBtn();
    }

    public void editLastRegion() {

        WebElement lastRow = chooseLastRow();
        editRegBtn(lastRow);
        titleFieldWithClear();
        saveRegBtn();
    }

    public void editRandomRegion() {

        WebElement randomRow = chooseRandomRow();
        editRegBtn(randomRow);
        titleFieldWithClear();
        saveRegBtn();
    }

    public void deleteFirstRegion() {

        WebElement firstRow = chooseFirstRow();
        clickOnDeleteBtn(firstRow);
        confirmDelete();
    }

    public void deleteLastRegion() {

        WebElement lastRow = chooseLastRow();
        clickOnDeleteBtn(lastRow);
//        confirmDelete();
        closeBtn();
    }

    public void deleteRandomRegion() {

        WebElement randomRow = chooseRandomRow();
        clickOnDeleteBtn(randomRow);
        confirmDelete();
    }

    public void disableFirstRegion() {

        WebElement firstRow = chooseFirstRow();
        clickOnDisableBtn(firstRow);
        confirmDisable();

    }

    public void disableLastRegion() {

        WebElement lastRow = chooseLastRow();
        clickOnDisableBtn(lastRow);
        confirmDisable();
    }

    public void disableRandomRegion() {

        WebElement randomRow = chooseRandomRow();
        clickOnDisableBtn(randomRow);
        confirmDisable();
    }

    public void enableFirstRegion() {

        WebElement firstRow = chooseFirstRow();
        clickOnEnableBtn(firstRow);
        confirmEnable();
    }

    public void enableLastRegion() {

        WebElement lastRow = chooseLastRow();
        clickOnEnableBtn(lastRow);
        confirmEnable();
    }


}
