package abcd.Webdriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest
{
    protected static WebDriver driver;
    public static void main(String[] args)
    {

        System.setProperty("webdriver.chrome.driver","src\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        //user should be registered successfully on demo nopcommerce.com website
        //Get the registration webpage
        driver.get("https://demo.nopcommerce.com/register");

        //Defining object and retrieve node using X-path as a locator
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
        dobWebElement.click();
        dobWebElement.sendKeys("25");
        //Select dobWebElement = new Select(driver.findElement(By.name("DateOfBirthday")));
        //dobWebElement.selectByVisibleText("11");


        //Retrieve the DateOfBirthMonth select box
        dobWebElement=driver.findElement(By.xpath("//select[contains(@name,'DateOfBirthMonth')]"));
        dobWebElement.sendKeys("March");

        //dobWebElement = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        //dobWebElement.selectByVisibleText("January");


        //Retrieve the DateOfBirthYear select box
        dobWebElement=driver.findElement(By.xpath("//select[contains(@name,'DateOfBirthYear')]"));
        dobWebElement.sendKeys("1985");

        //dobWebElement = new Select(driver.findElement(By.name("DateOfBirthYear")));
        //dobWebElement.selectByVisibleText("1999");

        //Retrieve the email address element and set the value
        WebElement emailWebElement =driver.findElement(By.xpath("//input[contains(@id,'Email')]"));
        emailWebElement.sendKeys("hetalpatel3@gmail.com");

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


        Assert.assertEquals("Your registration completed",message);

    }
}

