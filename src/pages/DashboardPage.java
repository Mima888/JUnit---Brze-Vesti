package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static pages.Setup.driver;

public class DashboardPage extends Setup {

    //PUBLIC METHODS
    public void goToSinatures() {

        WebElement signatures = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Signatures")));
        signatures.click();
    }

    public void goToCategories() {

//        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categorieqas")));
//        categories.click();
        WebElement navBar = driver.findElement(By.className("navbar-nav"));
        List<WebElement> liTagsCat = navBar.findElements(By.tagName("li"));
        liTagsCat.get(2).click();
    }

    public void goToRegions() {

        WebElement regions = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Regions")));
        regions.click();
    }

    public void goToPortals() {

        WebElement portals = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Portals")));
        portals.click();
    }

    public void goToSources() {

        WebElement sources = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sources")));
        sources.click();
    }
}
