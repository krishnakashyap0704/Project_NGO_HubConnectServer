//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class DonorRegistrationSeleniumTest {
//
//    @Test
//    public void testDonorRegistration() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("http://localhost:9090/donorRegister");
//
//        // Navigate to the registration page
//        WebElement registerLink = driver.findElement(By.linkText("Register"));
//        registerLink.click();
//
//        // Fill in the registration form
//        WebElement nameInput = driver.findElement(By.id("donorName"));
//        nameInput.sendKeys("John Doe");
//
//        WebElement emailInput = driver.findElement(By.id("donorEmail"));
//        emailInput.sendKeys("john@example.com");
//
//        WebElement phoneInput = driver.findElement(By.id("donorPhone"));
//        phoneInput.sendKeys("1234567890");
//
//        WebElement passwordInput = driver.findElement(By.id("donorPassword"));
//        passwordInput.sendKeys("password123");
//
//        WebElement addressInput = driver.findElement(By.id("donorAddress"));
//        addressInput.sendKeys("123 Main St");
//
//        WebElement zipCodeInput = driver.findElement(By.id("donorZipCode"));
//        zipCodeInput.sendKeys("12345");
//
//        // Submit the form
//        WebElement submitButton = driver.findElement(By.id("registerButton"));
//        submitButton.click();
//        
//        // Wait for success message to appear
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement successMessage;
//        try {
//            successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successMessage")));
//        } catch (NoSuchElementException e) {
//            // If the element is not found, it means the registration failed
//            fail("Registration failed: Success message not found");
//            return;
//        }
//
//        // Verify that the registration was successful
//        assertEquals("Registration successful!", successMessage.getText());
//
//        driver.quit();
//    }
//}
