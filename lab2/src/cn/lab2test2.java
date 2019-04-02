package cn;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import jxl.Cell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;
 
public class lab2test2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
//	  System.setProperty("webdriver.firefox.bin","D:\\Firefox\\firefox.exe"); 
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
    driver.get(baseUrl + "/");
    WebElement we = driver.findElement(By.name("id"));
    we.click();
//    driver.findElement(By.id("kw")).click();
    driver.findElement(By.name("id")).clear(); 
    driver.findElement(By.name("id")).sendKeys("3016218141");
    WebElement we1 = driver.findElement(By.name("password"));
    we1.click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("218141");
    driver.findElement(By.id("btn_login")).click();
   // assertEquals("天津大学_百度搜索", driver.getTitle());
    
    WebElement element = driver.findElement(By.id("student-git"));
    String alignStr = element.getText();
    assertEquals("https://github.com/everlastingstars",alignStr);

  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

