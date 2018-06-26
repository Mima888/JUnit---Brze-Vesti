package portal;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PortalsPage;
import pages.Setup;

public class TestPortals extends Setup {

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

        navigation.goToPortals();
    }

    @After
    public void tearDown() throws InterruptedException {

        Thread.sleep(1000);
    }

    @Test
    public void createNewPortal() {

        for (int i = 0; i < 1; i++) {

            PortalsPage pp = new PortalsPage();

            pp.addNewPortal();

        }
    }

    @Test
    public void editPortal() {

        PortalsPage pp = new PortalsPage();
        
        pp.editFirstPortal();
//        pp.editLastPortal();
//        pp.editRandomPortal();

    }

    @Test
    public void deletePortal() {

        PortalsPage pp = new PortalsPage();
        
//        pp.deleteFirstPortal();
        pp.deleteLastPortal();
//        pp.deleteRandomPortal();

    }
    
     @Test
    public void disablePortal() {

        PortalsPage pp = new PortalsPage();

        pp.disableFirstPortal();
//        pp.disableLastPortal();
//        pp.disableRandomPortal();

    }
    
    @Test
    public void enablePortal() {

        PortalsPage pp = new PortalsPage();

        pp.enableFirstPortal();
//        pp.enableLastPortal();
    }
    
    
}
