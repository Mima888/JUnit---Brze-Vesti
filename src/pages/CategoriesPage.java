package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage extends Setup {

    private void clickOnAddCategoryButton() {

        WebDriverWait waitCat = new WebDriverWait(driver, 8);
        WebElement addCategoryButton = waitCat.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addCategoryButton.click();
    }

    private void titleFieldCategory() {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.sendKeys(Helper.getRandomTextCat());

    }

    private void saveCatButton() {

        WebElement saveCatButton = driver.findElement(By.id("save-category-button"));
        saveCatButton.click();
    }

    private void clickOnEditButton(WebElement row) {

        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();

//        driver.switchTo().activeElement();
//        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[" + rows.size() +"]/td[5]/div/a/span"));
//        driver.switchTo().defaultContent();
    }

    private void clearAndWriteInTitleField() {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.clear();
        writeCategory.sendKeys(Helper.getRandomTextCat());
    }

    private void clickOnDeleteButton(WebElement row) {

        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void confirmDelete() {

        driver.switchTo().activeElement();

        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();

        driver.switchTo().defaultContent();
    }
    
    private void closeBtn() {
        
        WebElement btnClose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[1]")));
        btnClose.click();
    }

    private void clickOnDisableBtn(WebElement row) {

        WebElement disableBtn = row.findElement(By.cssSelector("button[title='Disable']"));
        disableBtn.click();
    }

    private void confirmDisable() {

        WebElement btnDisable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]")));
        btnDisable.click();

    }

    private void clickOnEnableBtn(WebElement row) {

        WebElement enableBtn = row.findElement(By.cssSelector("button[title='Enable']"));
        enableBtn.click();
    }

    private void confirmEnable() {

        WebElement btnEnable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[2]")));
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

    public void addNewCategory() {

        clickOnAddCategoryButton();
        titleFieldCategory();
        saveCatButton();
    }

    public void editLastCategory() {

        WebElement lastRow = chooseLastRow();
        clickOnEditButton(lastRow);
        clearAndWriteInTitleField();
        saveCatButton();

    }

    public void editFirstCategory() {

        WebElement firstRow = chooseFirstRow();
        clickOnEditButton(firstRow);
        clearAndWriteInTitleField();
        saveCatButton();
    }

    public void editRandomCategory() {

        WebElement randomRow = chooseRandomRow();
        clickOnEditButton(randomRow);
        clearAndWriteInTitleField();
        saveCatButton();

    }

    public void deleteFirstCategory() {

        WebElement firstRow = chooseFirstRow();
        clickOnDeleteButton(firstRow);
        confirmDelete();

    }

    public void deleteLastCategory() {

        WebElement lastRow = chooseLastRow();
        clickOnDeleteButton(lastRow);
        confirmDelete();
//        closeBtn();
    }

    public void deleteRandomCategory() {

        WebElement randomRow = chooseRandomRow();
        clickOnDeleteButton(randomRow);
        confirmDelete();
    }
    
    public void disableFirstCategory() {

        WebElement firstRow = chooseFirstRow();
        clickOnDisableBtn(firstRow);
        confirmDisable();

    }

    public void disableLastCategory() {

        WebElement lastRow = chooseLastRow();
        clickOnDisableBtn(lastRow);
        confirmDisable();
    }

    public void disableRandomCategory() {

        WebElement randomRow = chooseRandomRow();
        clickOnDisableBtn(randomRow);
        confirmDisable();
    }

    public void enableFirstCategory() {

        WebElement firstRow = chooseFirstRow();
        clickOnEnableBtn(firstRow);
        confirmEnable();
    }

    public void enableLastCategory() {

        WebElement lastRow = chooseLastRow();
        clickOnEnableBtn(lastRow);
        confirmEnable();
    }

}
