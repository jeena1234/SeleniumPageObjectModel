package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class RegistrationPage extends BaseClass {
	
	public boolean Register(String FName,String LName,String Email,String MaritalStaus,String Hobby,int month,int day,int year,String Country,int phone,String Pass,String Fileloc){
		boolean bvalue =false;
		 driver.findElement(By.xpath(".//a[text()='Registration']")).click();
		 driver.findElement(By.name("first_name")).sendKeys(FName);
		 driver.findElement(By.name("last_name")).sendKeys(LName);
		 driver.findElement(By.xpath(".//label[text()='"+MaritalStaus+"']")).click();
		 driver.findElement(By.xpath(".//label[text()='"+Hobby+"']")).click();
		 
		 Select sel=new Select(driver.findElement(By.id("dropdown_7")));
		 sel.selectByValue(Country);
		 
		 Select sel1=new Select(driver.findElement(By.id("mm_date_8")));
		 sel1.selectByValue(""+month);
		 
		 Select sel2=new Select(driver.findElement(By.id("dd_date_8")));
		 sel2.selectByValue(""+day);
		 
		 Select sel3=new Select(driver.findElement(By.id("yy_date_8")));
		 sel3.selectByValue(""+year);
		 
		 WebElement UploadImg = driver.findElement(By.name("profile_pic_10"));
		 UploadImg.sendKeys(Fileloc);
		 
		 
		 driver.findElement(By.id("phone_9")).sendKeys(""+phone);;
		 driver.findElement(By.id("username")).sendKeys(FName);;
		 driver.findElement(By.id("email_1")).sendKeys(Email);;
		 driver.findElement(By.id("password_2")).sendKeys(Pass);
		 driver.findElement(By.id("confirm_password_password_2'")).sendKeys(Pass);
		 
		 driver.findElement(By.name("pie_submit")).click();
		 
		 bvalue= BaseClass.isElementPresent(By.xpath(".//p[text()='Thank you for your registration']"));

		return bvalue;
		
	}

}
