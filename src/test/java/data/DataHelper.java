package data;

import lombok.Value;
import pages.DashboardPage;

public class DataHelper {
    private DataHelper() {}

    @Value
    public static class AuthInfo {
        private String login;
        private String password;

    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        private String code;
    }

    public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {
        return new VerificationCode("12345");
    }

    @Value
    public static class CardsInfo {

        private String firstCard = "5559 0000 0000 0001";
        private String secondCard = "5559 0000 0000 0002";
        private static int amountValue;
        private static int firstCardBalance;
        private static int secondCardBalance;

        public static int getAmountValue() {
            return amountValue;
        }

        public static void setAmountValue(int amountValue) {
            CardsInfo.amountValue = amountValue;
        }

        public static int getFirstCardBalance() {
            return firstCardBalance;
        }

        public static void setFirstCardBalance(int firstCardBalance) {
            CardsInfo.firstCardBalance = firstCardBalance;
        }

        public static int getSecondCardBalance() {
            return secondCardBalance;
        }

        public static void setSecondCardBalance(int secondCardBalance) {
            CardsInfo.secondCardBalance = secondCardBalance;
        }

    }


}
