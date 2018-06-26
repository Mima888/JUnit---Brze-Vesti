package regions;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RegionsPage;
import pages.Setup;

public class TestRegions extends Setup {

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

        navigation.goToRegions();
    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
    }

    @Test
    public void createNewRegion() {

        for (int i = 0; i < 1; i++) {

            RegionsPage rp = new RegionsPage();
            rp.createNewRegion();
        }
    }

    @Test
    public void editRegion() {

        RegionsPage rp = new RegionsPage();

//        rp.editFirstregion();
//        rp.editLastRegion();
        rp.editRandomRegion();

    }

    @Test
    public void deleteRegion() {

        RegionsPage rp = new RegionsPage();

//        rp.deleteFirstRegion();
        rp.deleteLastRegion();
//        rp.deleteRandomRegion();
    }

    @Test
    public void disableRegion() {

        RegionsPage rp = new RegionsPage();

//        rp.disableFirstRegion();
        rp.disableLastRegion();
//        rp.disableRandomRegion();

    }

    @Test
    public void enableRegion() {

        RegionsPage rp = new RegionsPage();

//        rp.enableFirstRegion();
        rp.enableLastRegion();
    }
}
