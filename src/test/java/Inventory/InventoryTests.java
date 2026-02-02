package Inventory;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryTests extends BaseTest {

    @Test
    public void verifyInventoryPageElements() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);

        // Login first
        loginPage.login("standard_user", "secret_sauce");

        // Assertions
        Assert.assertEquals(
                inventoryPage.getPageTitle(),
                "Swag Labs",
                "Page title is incorrect"
        );

        Assert.assertTrue(
                inventoryPage.isCartIconDisplayed(),
                "Cart icon is not displayed"
        );

        Assert.assertEquals(
                inventoryPage.getProductsCount(),
                6,
                "Number of products is incorrect"
        );
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
