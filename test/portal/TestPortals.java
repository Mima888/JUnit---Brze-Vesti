package portal;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestPortals {

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

        WebElement portals = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Portals")));
        portals.click();
    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
    }

    @Test
    public void createNewPortal() {

        for (int i = 0; i < 3; i++) {

            WebElement navBar2 = driver.findElement(By.className("navbar-nav"));
            List<WebElement> liTagsPort = navBar2.findElements(By.tagName("li"));
            liTagsPort.get(4).click();

            WebDriverWait waitPort = new WebDriverWait(driver, 10);
            WebElement addPortalButton = waitPort.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
            addPortalButton.click();

            WebElement writePortalTitle = driver.findElement(By.id("title"));
            writePortalTitle.sendKeys(Helper.getRandomTextPort());

            WebElement writePortalUrl = driver.findElement(By.id("url"));
            writePortalUrl.sendKeys(Helper.getRandomUrl());

            Select dropDownReg = new Select(driver.findElement(By.name("region_id")));
            dropDownReg.selectByValue("498");

            WebElement savePortButton = driver.findElement(By.id("save-portal-button"));
            savePortButton.click();

            String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

            String expectedTitle = "Brze vesti admin  | Portals".replaceAll("\\s+", " ").trim();
            System.out.println("expected title: '" + expectedTitle + "'");
            String actualTitle = driver.getTitle();
            System.out.println("actual title: '" + actualTitle + "'");

            Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);
        }
    }

    @Test
    public void editLastPortal() {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        driver.switchTo().activeElement();

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"portalsTable\"]/tbody/tr[" + rows.size() + "]/td[5]/div/a/span"));
        editButton.click();

        driver.switchTo().defaultContent();

        WebElement writePortal = driver.findElement(By.id("title"));
        writePortal.clear();
        writePortal.sendKeys(Helper.getRandomTextPort());

        WebElement writePortalUrl = driver.findElement(By.id("url"));
        writePortalUrl.sendKeys(Helper.getRandomUrl());

        Select dropDownReg = new Select(driver.findElement(By.name("region_id")));
        dropDownReg.selectByValue("499");

        WebElement savePortButton = driver.findElement(By.id("save-portal-button"));
        savePortButton.click();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Portals".replaceAll("\\s+", " ").trim();
        System.out.println("expected title: '" + expectedTitle + "'");
        String actualTitle = driver.getTitle();
        System.out.println("actual title: '" + actualTitle + "'");

        Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);

    }

    @Test
    public void deleteFirstPortal() {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement firstRow = rows.get(0);

        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();

        driver.switchTo().activeElement();

        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();

        driver.switchTo().defaultContent();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/portals";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Portals".replaceAll("\\s+", " ").trim();
        System.out.println("expected title: '" + expectedTitle + "'");
        String actualTitle = driver.getTitle();
        System.out.println("actual title: '" + actualTitle + "'");

        Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);

    }
}
