package com.gosch.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
   FirefoxDriver wd;

   public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
         wd.switchTo().alert();
         return true;
      } catch (NoAlertPresentException e) {
         return false;
      }
   }

   protected void init() {
      System.setProperty("webdriver.gecko.driver", "C:\\Users\\Georgi\\Documents\\Firefox Driver\\geckodriver.exe");
      wd = new FirefoxDriver();
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      login("admin", "secret");
   }

   protected void stop() {
      wd.quit();
   }

   private void login(String username, String password) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).click();
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
   }

   protected void returnToGroupPage() {
      wd.findElement(By.linkText("group page")).click();
   }

   protected void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
   }

   protected void fillGroupForm(GroupData groupData) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
   }

   protected void initGroupCreation() {
      wd.findElement(By.name("new")).click();
   }

   protected void gotoGroupPage() {
      wd.findElement(By.linkText("groups")).click();
   }

   protected void deleteSelectedGroups() {
      wd.findElement(By.name("delete")).click();
   }

   protected void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
   }

   protected void fillContactForm(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());
      wd.findElement(By.name("nickname")).click();
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactData.getNickName());
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactData.getMobile());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
   }

   protected void returnToHomePage() {
      wd.findElement(By.linkText("home page")).click();
   }

   protected void submitContactCreation() {
      wd.findElement(By.name("submit")).click();
   }

   protected void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
   }
}