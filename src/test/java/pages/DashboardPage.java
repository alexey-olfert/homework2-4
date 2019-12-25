package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement topButton = $("div[data-test-id^=92d] button");
    private SelenideElement lowerButton = $("div[data-test-id^=0f3] button");

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public CardReplenishmentPage replenishAccount1() {
        topButton.click();
        return new CardReplenishmentPage();
    }


}
