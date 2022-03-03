package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.*;

public class tddExample {
    @Test
    public void test(){
        Dollar five = new Dollar(5);

        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));

        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
    }

    static class Dollar {
        public Dollar(int amount) {
            this.amount = amount;
        }
        private int amount = 0;

        Dollar times(int multiplier) {
            return new Dollar(amount * multiplier);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Dollar)) return false;
            Dollar dollar = (Dollar) o;
            return amount == dollar.amount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount);
        }
    }
}
