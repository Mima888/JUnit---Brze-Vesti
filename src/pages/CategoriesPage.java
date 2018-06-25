package pages;

import framework.Helper;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage {

    private void clickOnAddCategoryButton(WebDriver driver) {

        WebDriverWait waitCat = new WebDriverWait(driver, 8);
        WebElement addCategoryButton = waitCat.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
        addCategoryButton.click();
    }

    private void saveCatButton(WebDriver driver) {

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

    private void clickOnDeleteButton(WebElement row) {

        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void confirmDelete(WebDriver driver, WebDriverWait wait) {

        driver.switchTo().activeElement();

        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();

        driver.switchTo().defaultContent();
    }

    private void clearAndWriteInTitleField(WebDriver driver) {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.clear();
        writeCategory.sendKeys(Helper.getRandomTextCat());
    }

    private void titleFieldCategory(WebDriver driver) {

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.sendKeys(Helper.getRandomTextCat());

    }

    private List<WebElement> getRowsFromTable(WebDriverWait wait) {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());

        return rows;

    }

    private WebElement chooseLastRow(WebDriverWait wait) {

        List<WebElement> rows = getRowsFromTable(wait);
//        WebElement lastRow = rows.get(rows.size() - 1);
//
//        return lastRow;

        return rows.get(rows.size() - 1);
    }

    private WebElement chooseFirstRow(WebDriverWait wait) {

//        List<WebElement> rows = getRowsFromTable(wait);
//        WebElement firstRow = rows.get(0);
//
//        return firstRow;
        return getRowsFromTable(wait).get(0);

    }

    private WebElement chooseRandomRow(WebDriverWait wait) {

        List<WebElement> rows = getRowsFromTable(wait);
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));

        return randomRow;
    }

    public void addNewCategory(WebDriver driver) {

        clickOnAddCategoryButton(driver);
        titleFieldCategory(driver);
        saveCatButton(driver);
    }

    public void editLastCategory(WebDriver driver, WebDriverWait wait) {

//        chooseLastCategory(wait);
        WebElement lastRow = chooseLastRow(wait);
        clickOnEditButton(lastRow);
        clearAndWriteInTitleField(driver);
        saveCatButton(driver);

    }

    public void editFirstCategory(WebDriver driver, WebDriverWait wait) {

        WebElement firstRow = chooseFirstRow(wait);
        clickOnEditButton(firstRow);
        clearAndWriteInTitleField(driver);
        saveCatButton(driver);
    }

    public void editRandomCategory(WebDriver driver, WebDriverWait wait) {

        WebElement randomRow = chooseRandomRow(wait);
        clickOnEditButton(randomRow);
        clearAndWriteInTitleField(driver);
        saveCatButton(driver);

    }

    public void deleteFirstCategory(WebDriver driver, WebDriverWait wait) {

        WebElement firstRow = chooseFirstRow(wait);
        clickOnDeleteButton(firstRow);
        confirmDelete(driver, wait);

    }

    public void deleteLastCategory(WebDriver driver, WebDriverWait wait) {

        WebElement lastRow = chooseLastRow(wait);
        clickOnDeleteButton(lastRow);
        confirmDelete(driver, wait);
    }

    public void deleteRandomCategory(WebDriver driver, WebDriverWait wait) {

        WebElement randomRow = chooseRandomRow(wait);
        clickOnDeleteButton(randomRow);
        confirmDelete(driver, wait);
    }

}
