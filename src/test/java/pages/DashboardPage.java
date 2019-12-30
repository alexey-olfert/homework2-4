package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {

    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement topButton = $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] button");
    private SelenideElement lowerButton = $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d'] button");
    private static SelenideElement firstAccount = $("div[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0']");
    private static SelenideElement secondAccount = $("div[data-test-id='0f3f5c2a-249e-4c3d-8287-09f7a039391d']");

    public static String getIncreasedAmount(SelenideElement account) {
        DataHelper.CardsInfo cardsInfo = new DataHelper.CardsInfo();
        int amount;
        if (account==firstAccount) {
            amount = DataHelper.CardsInfo.getFirstCardBalance() + cardsInfo.getAmountValue();
        } else {
            amount = DataHelper.CardsInfo.getSecondCardBalance() + cardsInfo.getAmountValue();
        }

        return Integer.toString(amount);
    }

    public static String getReducedAmount(SelenideElement account) {
        DataHelper.CardsInfo cardsInfo = new DataHelper.CardsInfo();
        int amount;
        if (account==firstAccount) {
            amount = DataHelper.CardsInfo.getFirstCardBalance() - cardsInfo.getAmountValue();
        } else {
            amount = DataHelper.CardsInfo.getSecondCardBalance() - cardsInfo.getAmountValue();
        }

        return Integer.toString(amount);
    }

    public static int getCardBalance(SelenideElement account) {
        String text = account.text();
        String balanceValue = text.replaceAll("\\D", "").substring(4);
        return Integer.parseInt(balanceValue);
    }

    public DashboardPage() {
        heading.shouldBe(Condition.visible);
    }

    public CardReplenishmentPage replenishAccount1() {
        topButton.click();
        return new CardReplenishmentPage();
    }

    public static void checkIncreasedAmount(SelenideElement account) {
        account.shouldHave(text(DashboardPage.getIncreasedAmount(account)));
    }

    public static void checkReducedAmount(SelenideElement account) {
        account.shouldHave(text(DashboardPage.getReducedAmount(account)));

    }

    public static SelenideElement getFirstAccount() {
        return firstAccount;
    }

    public static SelenideElement getSecondAccount() {
        return secondAccount;
    }
}
