
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Setup {
    
    public static WebDriver driver;
    public static WebDriverWait wait;
    
    public void startUp() {
        
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        
    }
}
