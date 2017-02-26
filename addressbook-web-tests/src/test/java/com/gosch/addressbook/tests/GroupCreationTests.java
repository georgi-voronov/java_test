package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

   @Test
   public void testGroupCreation() {
      // Refactoring Mechanism - creating helping methods
      app.getNavigationHelper().gotoGroupPage();
      app.getGroupHelper().initGroupCreation();
      // Вместо того чтобы передавать несколько параметров - передаётся 1 объект
      app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
      app.getGroupHelper().submitGroupCreation();
      app.getGroupHelper().returnToGroupPage();
   }

}
