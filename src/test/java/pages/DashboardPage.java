package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement topButton = $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    //private SelenideElement lowerButton = $("div[data-test-id^=0f3] button");

    public static String getReducedAmount() {
        DataHelper.CardsInfo cardsInfo = new DataHelper.CardsInfo();
        int amount = cardsInfo.getStartAmountValue() - cardsInfo.getAmountValue();
        return Integer.toString(amount);

    }

    public static String getIncreasedAmount() {
        DataHelper.CardsInfo cardsInfo = new DataHelper.CardsInfo();
        int amount = cardsInfo.getStartAmountValue() + cardsInfo.getAmountValue();
        return Integer.toString(amount);
    }

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public CardReplenishmentPage replenishAccount1() {
        topButton.click();
        return new CardReplenishmentPage();
    }

    public static void checkFirstAmount() {
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']").shouldHave(text(DashboardPage.getIncreasedAmount()));
    }

    public static void checkSecondAmount() {
        $("[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']").shouldHave(text(DashboardPage.getReducedAmount()));
    }


}
