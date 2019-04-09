package abcd;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.util.concurrent.TimeUnit;

import static sun.plugin.javascript.navig.JSType.Element;

// to choose the order of execution of the methods within a test class
//in order to check whether logic works in implemented methods
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Register
{
    protected static WebDriver driver;

    //Under this annotation will be executed in each test case
    @Before
    //Used to start browser before running test
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","src\\test\\java\\abcd\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        //set the implicit wait for the WebDriver object instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

        //Get the registration webpage
        driver.get("https://demo.nopcommerce.com");
    }

    //Execute the @Test annotation
    @Test
    public void aUserShouldBeRegisterSuccessfully()
    {
        //User should be registered successfully on demo nopcommerce.com website
        WebElement registerElement = driver.findElement(By.linkText("Register"));
        registerElement.click();

        //Retrieve the gender button and perform click
        WebElement genderWebElement =driver.findElement(By.xpath("//input[@type='radio' and contains(@id,'gender-female') ]"));
        genderWebElement.click();

        //Retrieve the firstname element and set the value
        WebElement firstNameWebElement =driver.findElement(By.xpath("//input[@type='text' and contains(@id,'FirstName')]"));
        firstNameWebElement.sendKeys("Hetal");

        //Retrieve the lastname element and set the value
        WebElement lastNameWebElement =driver.findElement(By.xpath("//input[@type='text' and contains(@id,'LastName')]"));
        lastNameWebElement.sendKeys("Patel");

        //Retrieve the DateOfBirthDay select box
        WebElement dobWebElement=driver.findElement(By.xpath("//select[contains(@name,'DateOfBirthDay')]"));
        dobWebElement.sendKeys("25");

        //Retrieve the DateOfBirthMonth select box
        dobWebElement=driver.findElement(By.xpath("//select[contains(@name,'DateOfBirthMonth')]"));
        dobWebElement.sendKeys("March");

        //Retrieve the DateOfBirthYear select box
        dobWebElement=driver.findElement(By.xpath("//select[contains(@name,'DateOfBirthYear')]"));
        dobWebElement.sendKeys("1985");

        //Retrieve the email address element and set the value
        WebElement emailWebElement =driver.findElement(By.xpath("//input[contains(@id,'Email')]"));
        EmailStorage.emailAddress = "hetalpatel" + System.currentTimeMillis() +"@gmail.com";
        emailWebElement.sendKeys(EmailStorage.emailAddress);

        ////Retrieve the company name element and set the value
        WebElement companyNameWebElement =driver.findElement(By.xpath("//input[@type='text' and contains(@name,'Company')]"));
        companyNameWebElement.sendKeys("abc");

        //Retrieve the newsletter checkbox and perform click which untick the checkbox
        WebElement newsletterWebElement =driver.findElement(By.xpath("//input[@type='checkbox']"));
        newsletterWebElement.click();

        //Retrieve the password element and set the value
        WebElement passwordWebElement =driver.findElement(By.xpath("//input[contains(@name,'Password')]"));
        passwordWebElement.sendKeys("abcd1234");

        //Retrieve the confirm password element and set the value
        WebElement confirmpasswordWebElement =driver.findElement(By.xpath("//input[contains(@name,'ConfirmPassword')]"));
        confirmpasswordWebElement.sendKeys("abcd1234");

        //Retrieve the submit button and perform click
        WebElement submitWebElement;
        submitWebElement = driver.findElement(By.xpath("//input[@type='submit' and @value = 'Register']"));
        submitWebElement.click();


        WebElement resultWebElement = driver.findElement(By.xpath("//div[@class='result']"));
        String message = resultWebElement.getText();
        //Assert statements return true:expected.equals(actual)
        Assert.assertEquals("Your registration completed",message);

    }

    //Execute the @Test annotation
    @Test
    //User should be able to navigate to Notebook category page(Computer>>Notebooks)
    public void navigateToNotebookCategory()
    {
        //Mouse hover action is performed,
        //To identify the sub menu item and click on it
        WebElement computerElement = driver.findElement(By.linkText("Computers"));
        Actions action = new Actions(driver);
        action.moveToElement(computerElement).build().perform();
        driver.findElement(By.linkText("Notebooks")).click();

        //Assert statements return true:expected.equals(actual)
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/notebooks",actualResult);
        System.out.println("Expected Result : https://demo.nopcommerce.com/notebooks = Actual Result : " + actualResult);
    }

    //Execute the @Test annotation
    @Test
    //User should be able to navigate cell phone page via Electronics>>Cellphone
    public void electronicCellphone()
    {
        //Mouse hover action is performed,
        //To identify the sub menu item and click on it
        WebElement electronicsElement = driver.findElement(By.linkText("Electronics"));
        Actions action = new Actions(driver);
        action.moveToElement(electronicsElement).build().perform();
        WebElement cellphoneElement = driver.findElement(By.linkText("Cell phones"));
        cellphoneElement.click();

        //Assert statements return true:expected.equals(actual)
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals("https://demo.nopcommerce.com/cell-phones",actualResult);
        System.out.println("Expected Result : https://demo.nopcommerce.com/cell-phones = Actual Result : " + actualResult);

    }
    //Execute the @Test annotation
    @Test
    public void loginSuccessfully()
    {
        // User should be able to login Successfully
        WebElement logInElement = driver.findElement(By.linkText("Log in"));
        logInElement.click();
        //Retrieve the email address element and set the value
        WebElement emailLoginWebElement =driver.findElement(By.xpath("//input[@class='email']"));
        emailLoginWebElement.sendKeys(EmailStorage.emailAddress);
        //Retrieve the password element and set the value
        WebElement passwordWebElement =driver.findElement(By.xpath("//input[@class='password']"));
        passwordWebElement.sendKeys("abcd1234");

        //Retrieve the submit button and perform click
        WebElement submitLoginWebElement;
        submitLoginWebElement = driver.findElement(By.xpath("//input[@type='submit' and @value = 'Log in']"));
        submitLoginWebElement.click();

        //To check that an object is not null
        WebElement logoutElement = driver.findElement(By.linkText("Log out"));
        //A non-null value so assertNotNull will return true
        Assert.assertNotNull(logoutElement);
    }

    //Execute the @Test annotation
    @Test
    //User should be able to add product to shopping cart
    public void addToCart()
    {
        //Retrieve the books option by using linktext and perform click
        WebElement bookWebElement =driver.findElement(By.linkText("Books"));
        bookWebElement.click();
        //Retrieve the book name and perform click
        WebElement bookNameWebElement =driver.findElement(By.linkText("First Prize Pies"));
        bookNameWebElement.click();
        //Retrieve the add to cart button and perform click
        WebElement addToCartWebElement =driver.findElement(By.xpath("//input[@id ='add-to-cart-button-38']"));
        addToCartWebElement.click();
        //Mouse hover action is performed,
        //To identify the sub menu item and click on it
        WebElement shoopingCartWebElement =driver.findElement(By.xpath("//span[@class='cart-label']"));
        Actions action = new Actions(driver);
        action.moveToElement(shoopingCartWebElement).build().perform();
        //A non-null value so assertNotNull will return true
        WebElement resultWebElement = driver.findElement(By.xpath("//div[@id='bar-notification']"));
        Assert.assertNotNull(resultWebElement);
    }

    //Under this annotation will be executed after each test case
    @After
    //Used to cleanly exit it when the test has completed
    public void tearDown()
    {
        driver.quit();

}
}
