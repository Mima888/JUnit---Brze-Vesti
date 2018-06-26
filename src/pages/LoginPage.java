
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Setup {
    
    //PRIVATE METHODS
    
    private void checkEmail() {
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");
    }
    
    private void checkPass() {
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");
    }
    
    private void clickLogin() {
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();
    }
    

    
    //PUBLIC METHODS
    
    public void logIn() {
        
        checkEmail();
        checkPass();
        clickLogin();
        
    }
}
