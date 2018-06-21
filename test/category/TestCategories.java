package category;

import framework.Helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCategories {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DateFormat dateFormat;

    @BeforeClass
    public static void setUpClass() {
        
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("@BeforeClass: " + dateFormat.format(new Date()));

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
        System.out.println("@AfterClass: " + dateFormat.format(new Date()));
        driver.quit();
    }

    @Before
    public void setUp() {
        
        System.out.println("@Before: " + dateFormat.format(new Date()));

        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));
        categories.click();

    }

    @After
    public void tearDown() throws InterruptedException {
        
        Thread.sleep(1000);
        System.out.println("@After: " + dateFormat.format(new Date()));
    }

    
    @Test
    public void testCreateNewCategory() {

        for (int i = 0; i < 2; i++) {

            WebDriverWait waitCat = new WebDriverWait(driver, 8);
            WebElement addCategoryButton = waitCat.until(ExpectedConditions.elementToBeClickable(By.className("pull-right")));
            addCategoryButton.click();

            WebElement writeCategory = driver.findElement(By.id("title"));
            writeCategory.sendKeys(Helper.getRandomTextCat());

            WebElement saveCatButton = driver.findElement(By.id("save-category-button"));
            saveCatButton.click();

            String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

            String expectedTitle = "Brze vesti admin  | Categories".replaceAll("\\s+", " ").trim();
//         System.out.println("expected title: '" + expectedTitle + "'");
            String actualTitle = driver.getTitle();
//         System.out.println("actual title: '" + actualTitle + "'");

            Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);
        }

    }

    @Test
    public void testEditLastCategory() {

        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());
        
        driver.switchTo().activeElement();

        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"categoriesTable\"]/tbody/tr[" + rows.size() +"]/td[5]/div/a/span"));
        
//        WebElement editButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[title='Edit']")));
        editButton.click();
        
        driver.switchTo().defaultContent();

        WebElement writeCategory = driver.findElement(By.id("title"));
        writeCategory.clear();
        writeCategory.sendKeys(Helper.getRandomTextCat());

        WebElement saveCatButton = driver.findElement(By.id("save-category-button"));
        saveCatButton.click();

        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Categories".replaceAll("\\s+", " ").trim();
//         System.out.println("expected title: '" + expectedTitle + "'");
        String actualTitle = driver.getTitle();
//         System.out.println("actual title: '" + actualTitle + "'");

        Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);

    }
    
    @Test
    public void testDeleteFirstCategory() {
        
        WebElement tbody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        System.out.println("Number of rows: " + rows.size());

        WebElement firstRow = rows.get(0);
        
        WebElement deleteButton = firstRow.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
        
        driver.switchTo().activeElement();
        
        WebElement buttonDelete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"categoryDeleteDialog\"]/div/div/div[3]/button[2]")));
        buttonDelete.click();
        
        driver.switchTo().defaultContent();
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
        String actualUrl = driver.getCurrentUrl();
        
        Assert.assertEquals("Url does not match.", expectedUrl, actualUrl);

        String expectedTitle = "Brze vesti admin  | Categories".replaceAll("\\s+", " ").trim();
//         System.out.println("expected title: '" + expectedTitle + "'");
        String actualTitle = driver.getTitle();
//         System.out.println("actual title: '" + actualTitle + "'");

        Assert.assertEquals("Title does not match.", expectedTitle, actualTitle);
        
        
        
    }
}
