package com.gosch.addressbook.tests;

import com.gosch.addressbook.models.ContactData;
import com.gosch.addressbook.models.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    private final String groupName = "test1";

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (!app.group().all().stream().anyMatch(item -> groupName.equals(item.getName()))) {
            app.group().create(new GroupData().withName(groupName));
        }
    }

    @Test(enabled = true)
    public void ContactCreationTests() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();

        app.goTo().contactCreationPage();
        ContactData contact = new ContactData()
                .withFirstName("Georgi")
                .withLastName("Voronov")
                .withMobile("53089127")
                .withEmail("georgi.voronov@outlook.com")
                .withGroup(groupName);
        app.contact().create(contact, true);

        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
