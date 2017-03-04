package com.gosch.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

// AppManager will delegate some functions to one of his Helpers
public class ApplicationManager {

   WebDriver wd;
   private SessionHelper sessionHelper;
   private NavigationHelper navigationHelper;
   private GroupHelper groupHelper;
   private ContactHelper contactHelper;
   private String browser;

   public ApplicationManager(String browser) {
      this.browser = browser;
   }

   public void init() {
      if (browser.equals(BrowserType.FIREFOX)) {
         //System.setProperty("webdriver.gecko.driver", "C:\\Firefox Driver\\geckodriver.exe");
         wd = new FirefoxDriver();
      } else if (browser.equals(BrowserType.CHROME)) {
         //System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
         wd = new ChromeDriver();
      } else if (browser.equals(BrowserType.IE)) {
         wd = new InternetExplorerDriver();
      }
      wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      wd.get("http://localhost/addressbook/");
      groupHelper = new GroupHelper(wd);
      navigationHelper = new NavigationHelper(wd);
      contactHelper = new ContactHelper(wd);
      sessionHelper = new SessionHelper(wd);
      sessionHelper.login("admin", "secret");
   }

   public void stop() {
      wd.quit();
   }

   public ContactHelper getContactHelper() {
      return contactHelper;
   }

   public GroupHelper getGroupHelper() {
      return groupHelper;
   }

   public NavigationHelper getNavigationHelper() {
      return navigationHelper;
   }
}
