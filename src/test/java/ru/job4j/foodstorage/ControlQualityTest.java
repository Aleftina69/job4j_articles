package ru.job4j.foodstorage;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    @Test
    void whenDistributeFoodThenGoToCorrectStore() {
        Store warehouse = new Warehouse();
        Store shop = new Shop();
        Store trash = new Trash();
        ControlQuality control = new ControlQuality(List.of(warehouse, shop, trash));

        Food freshFood = new Food("Fresh", LocalDate.now().plusDays(10), LocalDate.now(), 100, 10);
        Food normalFood = new Food("Normal", LocalDate.now().plusDays(4), LocalDate.now().minusDays(2), 100, 10);
        Food oldFood = new Food("Old", LocalDate.now().plusDays(1), LocalDate.now().minusDays(4), 100, 20);
        Food expiredFood = new Food("Expired", LocalDate.now().minusDays(1), LocalDate.now().minusDays(10), 100, 20);

        control.distribute(freshFood);
        control.distribute(normalFood);
        control.distribute(oldFood);
        control.distribute(expiredFood);

        assertThat(warehouse.getFoods()).contains(freshFood);
        assertThat(shop.getFoods()).anyMatch(f -> f.getName().equals("Normal"));
        assertThat(shop.getFoods()).anyMatch(f -> f.getName().equals("Old") && f.getPrice() < 100);
        assertThat(trash.getFoods()).contains(expiredFood);
    }
}
