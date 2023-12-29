package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @DisplayName("VIP 멤버 할인 금액 계산")
    @ParameterizedTest
    @CsvSource(value = {"10000, 1000", "20000, 2000", "30000, 3000"})
    void vip_o(int itemPrice, int expectedDiscount) {
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        int discount = rateDiscountPolicy.discount(member, itemPrice);

        assertThat(discount).isEqualTo(expectedDiscount);
    }

    @DisplayName("VIP 멤버가 아닌 경우 할인 금액 계산")
    @ParameterizedTest
    @ValueSource(ints = {10000, 20000, 30000})
    void vip_x(int itemPrice) {
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        int discount = rateDiscountPolicy.discount(member, itemPrice);

        assertThat(discount).isEqualTo(0);
    }
}