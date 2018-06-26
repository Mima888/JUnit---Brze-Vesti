package category;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.Setup;

public class TestCategories extends Setup{

    @BeforeClass
    public static void setUpClass() {
        
        Setup openBrowser = new Setup();
        openBrowser.startUp();

        LoginPage log = new LoginPage();

        log.logIn();

        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
    }

    @Before
    public void setUp() {

        DashboardPage navigation = new DashboardPage();

        navigation.goToCategories();

    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
    }

    @Test
    public void testCreateNewCategory() {

        for (int i = 0; i < 1; i++) {

            CategoriesPage categoriesPage = new CategoriesPage();

            categoriesPage.addNewCategory();
        }

    }

    @Test
    public void testEditCategory() {

        CategoriesPage categoriesPage = new CategoriesPage();

//        categoriesPage.editLastCategory();
//        categoriesPage.editFirstCategory();
        categoriesPage.editRandomCategory();

    }

    @Test
    public void testDeleteCategory() {

        CategoriesPage categriesPage = new CategoriesPage();
          categriesPage.deleteFirstCategory();
//          categriesPage.deleteLastCategory();
//        categriesPage.deleteRandomCategory();

    }
    
    @Test
    public void disableCategory() {

        CategoriesPage rp = new CategoriesPage();

//        rp.disableFirstCategory();
        rp.disableLastCategory();
//        rp.disableRandomCategory();

    }

    @Test
    public void enableCategory() {

        CategoriesPage rp = new CategoriesPage();

//        rp.enableFirstCategory();
        rp.enableLastCategory();
    }
}
