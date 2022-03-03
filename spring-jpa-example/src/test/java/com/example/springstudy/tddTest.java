package com.example.springstudy;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import javax.transaction.Transactional;

public class tddTest {
    @Test
    public void test(){
        Dollar five = new Dollar(5);
        five.times(2);
        assertThat(10).isEqualTo(five.amount);
    }

    static class Dollar {
        public Dollar(int amount) {
            this.amount = amount;
        }

        void times(int multiplier) {

        }
        int amount = 10;

    }
}
