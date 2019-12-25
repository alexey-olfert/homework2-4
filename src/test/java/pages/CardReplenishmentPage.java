package pages;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

public class CardReplenishmentPage {
    private SelenideElement amount = $("[data-test-id=amount]");
    private SelenideElement from = $("[data-test-id=from]");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public DashboardPage makeDeposit() {
        DataHelper.CardsInfo cardsInfo = new DataHelper.CardsInfo();
        amount.setValue("200");
        $("[data-test-id=from]").sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        from.setValue(cardsInfo.getFirstCard());
        transferButton.click();
        return new DashboardPage();
    }
}
