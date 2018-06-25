package regions;

import framework.Helper;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.RegionsPage;

public class TestRegions {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public static void setUpClass() {

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();

        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();

    }

    @Before
    public void setUp() {

        WebElement regions = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Regions")));
        regions.click();
    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
    }

    @Test
    public void createNewRegion() {

        for (int i = 0; i < 2; i++) {
            
              RegionsPage rp = new RegionsPage();
              rp.createNewRegion(driver);

//            WebElement navBar1 = driver.findElement(By.className("navbar-nav"));
//            List<WebElement> liTagsReg = navBar1.findElements(By.tagName("li"));
//            liTagsReg.get(3).click();
//
//            WebDriverWait waitReg = new WebDriverWait(driver, 10);
//            WebElement addRegionButton = waitReg.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
//            addRegionButton.click();
//
//            WebElement writeRegion = driver.findElement(By.id("title"));
//            writeRegion.sendKeys(Helper.getRandomTextReg());
//
//            WebElement saveRegButton = driver.findElement(By.id("save-region-button"));
//            saveRegButton.click();

            String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

            String expectedTitle = "Brze vesti admin  | Regions".replaceAll("\\s+", " ").trim();
//         System.out.println("expected title: '" + expectedTitle + "'");
            String actualTitle = driver.getTitle();
//         System.out.println("actual title: '" + actualTitle + "'");

            Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);
        }
    }

    @Test
    public void editLastRegion() {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        driver.switchTo().activeElement();

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"regionsTable\"]/tbody/tr[" + rows.size() + "]/td[5]/div/a/span"));
        editButton.click();

        driver.switchTo().defaultContent();

        WebElement writeRegion = driver.findElement(By.id("title"));
        writeRegion.clear();
        writeRegion.sendKeys(Helper.getRandomTextReg());

        WebElement saveRegButton = driver.findElement(By.id("save-region-button"));
        saveRegButton.click();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Regions".replaceAll("\\s+", " ").trim();
        System.out.println("expected title: '" + expectedTitle + "'");
        String actualTitle = driver.getTitle();
        System.out.println("actual title: '" + actualTitle + "'");

        Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);

    }

    @Test
    public void deleteFirstRegion() {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement firstRow = rows.get(0);

        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();

        driver.switchTo().activeElement();

        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();

        driver.switchTo().defaultContent();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/regions";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Regions".replaceAll("\\s+", " ").trim();
        System.out.println("expected title: '" + expectedTitle + "'");
        String actualTitle = driver.getTitle();
        System.out.println("actual title: '" + actualTitle + "'");

        Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);
    }
}
