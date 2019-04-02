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
 
public class lab2test3 {
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
 	  String  sFilePath="C:/Users/1122/Desktop/������Լ���/�����������.xls";
	  
 	 InputStream is = new FileInputStream(sFilePath);
 	// 2����������������
 	 Workbook rwb = Workbook.getWorkbook(is);

 	 // 3����ù������ĸ���,��Ӧ��һ��excel�еĹ��������

 	 rwb.getNumberOfSheets();  
 
 	 Sheet oFirstSheet = rwb.getSheet(0);// ʹ��������ʽ��ȡ��һ��������Ҳ����ʹ��rwb.getSheet(sheetName);����sheetName��ʾ���ǹ����������


 	 //   System.out.println("���������ƣ�" + oFirstSheet.getName());
 

 	 int rows = oFirstSheet.getRows();//��ȡ�������е�������

 	// int columns = oFirstSheet.getColumns();//��ȡ�������е�������
	 driver.get(baseUrl + "/");
     WebElement we = driver.findElement(By.name("id")); 
     we.click(); 
    for (int i=0;i<rows-2;i++)     
    {  
    	
    		Cell oCell=oFirstSheet.getCell(1,i+2);
    		String sid= oCell.getContents();
    		Cell pCell=oFirstSheet.getCell(2,i+2); 
    		String sname= pCell.getContents();
    		Cell qCell=oFirstSheet.getCell(3,i+2);
    		String surl= qCell.getContents();
    		System.out.println(rows);
    		System.out.println(sid+" "+sname+" "+surl+i); 
    		
    		
    	    driver.findElement(By.name("id")).clear(); 
    	    driver.findElement(By.name("id")).sendKeys(sid);
    	    WebElement we1 = driver.findElement(By.name("password"));
    	   // we1.click();
    	    we1.sendKeys(Keys.ENTER);
    	    driver.findElement(By.name("password")).clear(); 
    	    driver.findElement(By.name("password")).sendKeys(sid.substring(sid.length()-6));
    	    driver.findElement(By.id("btn_login")).click();
    		
    	    //�����Ƿ�ƥ��
    	    WebElement element1 = driver.findElement(By.id("student-id"));
    	    WebElement element2 = driver.findElement(By.id("student-name"));
    	    WebElement element3 = driver.findElement(By.id("student-git"));
    	   
    	    String alignStr1 = element1.getText();
    	    assertEquals(sid,alignStr1); 
    	    String alignStr2 = element2.getText();
    	    assertEquals(sname,alignStr2); 
    	    String alignStr3 = element3.getText();
    	    assertEquals(surl,alignStr3); 
    	    
    	    driver.findElement(By.id("btn_logout")).click();
    	    driver.findElement(By.id("btn_return")).click();
    	    	
     } 
	
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

