package com.adidas.backend.database;

import com.adidas.backend.appointment.Appointment;
import com.adidas.backend.product.Product;
import com.adidas.backend.stock.Stock;
import com.adidas.backend.store.Store;

import javax.annotation.PostConstruct;
import java.time.DayOfWeek;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static com.adidas.backend.product.Product.ProductType.CLOTHES;
import static com.adidas.backend.product.Product.ProductType.SHOES;
import static java.util.stream.Collectors.toList;

public class InMemoryDatabase {

    private final Map<Long, Store> stores;
    private final Map<Long, Product> products;
    private final Map<String, Stock> stocks;
    private final Map<Long, Appointment> appointments;

    private static final AtomicLong appointmentId = new AtomicLong();

    public InMemoryDatabase() {
        stores = new HashMap<>();
        products = new HashMap<>();
        stocks = new HashMap<>();
        appointments = new HashMap<>();
    }

    @PostConstruct
    public void init() {
        stores.put(1L, new Store(1L, "Sagrada Familia", "Barcelona"));
        stores.put(2L, new Store(2L, "Bernabeu", "Madrid"));
        stores.put(3L, new Store(3L, "Bridge", "Zaragoza"));
        stores.put(4L, new Store(4L, "Paella", "Valencia"));

        products.put(1L, new Product(1L, "Cool Sneakers", "40", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw5dae7545/zoom/CQ2624_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(2L, new Product(2L, "Cool Sneakers", "41", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwc4d7e56c/zoom/CQ2373_01_standard.jpg?sh=840&strip=false&sw=840"));

        products.put(3L, new Product(3L, "Original Boot", "38", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwc7a601dc/zoom/CQ2626_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(4L, new Product(4L, "Original Boot", "43", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw44c162a4/zoom/BB5476_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(5L, new Product(5L, "Original Boot", "47", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw2051f732/zoom/B22681_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(6L, new Product(6L, "Original Boot", "50", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw5af3ce36/zoom/BB2091_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(7L, new Product(7L, "Original Boot", "36", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw9d6ca300/zoom/CQ2631_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(8L, new Product(8L, "Original Boot", "48", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw3c05e2f0/zoom/DA9165_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(9L, new Product(9L, "Original Boot", "27", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw17a358cc/zoom/CQ0414_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(10L, new Product(10L, "Original Boot", "28", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw13a39234/zoom/B27140_01_standard.jpg?sh=840&strip=false&sw=840"));
        products.put(11L, new Product(11L, "Original Boot", "29", SHOES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw5abb04a3/zoom/AC8597_01_standard.jpg?sh=840&strip=false&sw=840"));

        products.put(12L, new Product(12L, "Spain", "40", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwe2b9a02c/zoom/CZ4546_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(13L, new Product(13L, "Argentina", "41", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw0a45fb0c/zoom/CW0705_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(14L, new Product(14L, "Brazil", "38", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw6e5f999d/zoom/CE2343_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(15L, new Product(15L, "Germany", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw1406f4e6/zoom/CW1202_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(16L, new Product(16L, "Portugal", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw30f58148/zoom/CW1207_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(17L, new Product(17L, "Peru", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwfc8e29f6/zoom/CZ4545_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(18L, new Product(18L, "Greece", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw54ab193f/zoom/CE2340_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(19L, new Product(19L, "Venezuela", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw3f81aa4f/zoom/CE2337_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(20L, new Product(20L, "South Africa", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw318a9d2e/zoom/CE1557_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(21L, new Product(21L, "China", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dw1b7fedff/zoom/CW0709_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(22L, new Product(22L, "Japan", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwc1032e84/zoom/CE1819_21_model.jpg?sh=840&strip=false&sw=840"));
        products.put(23L, new Product(23L, "Australia", "43", CLOTHES, "https://www.adidas.es/dis/dw/image/v2/aagl_prd/on/demandware.static/-/Sites-adidas-products/default/dwbbb4ee78/zoom/CW2339_21_model.jpg?sh=840&strip=false&sw=840"));

        stocks.put("1-1", new Stock(stores.get(1L), products.get(1L), 1));
        stocks.put("1-2", new Stock(stores.get(1L), products.get(2L), 45));
        stocks.put("1-3", new Stock(stores.get(1L), products.get(3L), 56));
        stocks.put("1-4", new Stock(stores.get(1L), products.get(4L), 45));
        stocks.put("1-5", new Stock(stores.get(1L), products.get(5L), 41235));
        stocks.put("1-6", new Stock(stores.get(1L), products.get(6L), 45));
        stocks.put("1-7", new Stock(stores.get(1L), products.get(7L), 88));
        stocks.put("2-8", new Stock(stores.get(2L), products.get(8L), 45));
        stocks.put("2-9", new Stock(stores.get(2L), products.get(9L), 45));
        stocks.put("2-10", new Stock(stores.get(2L), products.get(10L), 0));
        stocks.put("2-11", new Stock(stores.get(2L), products.get(11L), 55));
        stocks.put("3-12", new Stock(stores.get(3L), products.get(12L), 45));
        stocks.put("3-13", new Stock(stores.get(3L), products.get(13L), 23));
        stocks.put("3-14", new Stock(stores.get(3L), products.get(14L), 456));
        stocks.put("3-15", new Stock(stores.get(3L), products.get(15L), 45));
        stocks.put("3-16", new Stock(stores.get(3L), products.get(16L), 2));
        stocks.put("3-17", new Stock(stores.get(3L), products.get(17L), 45));
        stocks.put("3-18", new Stock(stores.get(3L), products.get(18L), 45));
        stocks.put("4-19", new Stock(stores.get(4L), products.get(19L), 2));
        stocks.put("4-20", new Stock(stores.get(4L), products.get(20L), 8));
        stocks.put("4-21", new Stock(stores.get(4L), products.get(21L), 90));
        stocks.put("4-22", new Stock(stores.get(4L), products.get(22L), 45));
        stocks.put("4-23", new Stock(stores.get(4L), products.get(23L), 4533));

        appointmentId.set(1);

        appointments.put(appointmentId.getAndIncrement(), new Appointment(1L, 1L, DayOfWeek.FRIDAY, 15));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(1L, 3L, DayOfWeek.MONDAY, 10));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(2L, 8L, DayOfWeek.WEDNESDAY, 9));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(2L, 9L, DayOfWeek.MONDAY, 20));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(3L, 13L, DayOfWeek.THURSDAY, 17));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(4L, 19L, DayOfWeek.SATURDAY, 16));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(4L, 20L, DayOfWeek.SUNDAY, 13));
        appointments.put(appointmentId.getAndIncrement(), new Appointment(4L, 21L, DayOfWeek.FRIDAY, 15));
    }

    public Collection<Store> getAllStores() {
        return stores.values();
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Stock> getAllStocks() {
        return stocks.values();
    }

    public Collection<Appointment> getAllAppointments() {
        return appointments.values();
    }

    public Long saveAppointment(Appointment appointment) {
        Long appointmentId = InMemoryDatabase.appointmentId.getAndIncrement();
        appointments.put(appointmentId, appointment);
        return appointmentId;
    }

    public void decreaseStock(Long storeId, Long productId) {
        String key = String.valueOf(storeId) + "-" + String.valueOf(productId);
        Stock stock = stocks.get(key);
        stock.setQuantity(decreaseOrZero(stock.getQuantity()));
    }

    private Integer decreaseOrZero(Integer quantity) {
        return quantity <= 0 ? 0 : quantity - 1;
    }

    public void cancelAppointment(Long appointmentId) {
        appointments.remove(appointmentId);
    }

    public void increaseStock(Long appointmentId) {
        Appointment appointment = appointments.get(appointmentId);
        Long storeId = appointment.getStoreId();
        Long productId = appointment.getProductId();
        String key = String.valueOf(storeId) + "-" + String.valueOf(productId);
        Stock stock = stocks.get(key);
        stock.setQuantity(stock.getQuantity() + 1);
    }

    public Collection<Product> getShoes() {
        return products.values()
                .stream()
                .filter(product -> SHOES.equals(product.getProductType()))
                .collect(toList());
    }

    public Collection<Product> getClothes() {
        return products.values()
                .stream()
                .filter(product -> CLOTHES.equals(product.getProductType()))
                .collect(toList());
    }

    void resetDatabase() {
        stores.clear();
        products.clear();
        stocks.clear();
        appointments.clear();
        init();
    }

    public Product getProductById(Long id) {
        return products.get(id);
    }

    public Store getStoreById(Long id) {
        return stores.get(id);
    }

    public Stock getStockById(String id) {
        return stocks.get(id);
    }

}
