package tests;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPageV1;


import static com.codeborne.selenide.Selenide.open;

public class TransferMoneyTest {
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV1();
        // можно заменить на val loginPage = open("http://localhost:9999", LoginPageV1.class);
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        val dashboard = verificationPage.validVerify(verificationCode);
        DataHelper.CardsInfo.setFirstCardBalance(DashboardPage.getCardBalance(DashboardPage.getFirstAccount()));
        DataHelper.CardsInfo.setSecondCardBalance(DashboardPage.getCardBalance(DashboardPage.getSecondAccount()));
        val cardReplenishmentPage = dashboard.replenishAccount1();
        cardReplenishmentPage.makeDeposit();
        DashboardPage.checkIncreasedAmount(DashboardPage.getFirstAccount());
        DashboardPage.checkReducedAmount(DashboardPage.getSecondAccount());
    }



}
