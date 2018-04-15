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
        stores.put(2L, new Store(2L, "Plaza Mayor", "Madrid"));
        stores.put(3L, new Store(3L, "Aljafería", "Zaragoza"));
        stores.put(4L, new Store(4L, "Bioparc", "Valencia"));

        products.put(1L, new Product(1L, "Ecstasy", "40", SHOES, "http://www.gorgeous-cakes.co.uk/images/large/gorgeous%20cakes/Women%20Adidas%20TrainersHot%20Sale%20Design%20AR676853_LRG.jpg"));
        products.put(2L, new Product(2L, "Half Shell", "41", SHOES, "https://images.solecollector.com/complex/image/upload/cguq9gz8cfes5e7dngbs.jpg"));
        products.put(3L, new Product(3L, "Superstar", "38", SHOES, "https://media.journeys.com/images/products/1_396077_ZM.JPG"));
        products.put(4L, new Product(4L, "SL 72", "43", SHOES, "https://media.office.co.uk/medias/sys_master/root/hcc/h48/9044407320606.jpg"));
        products.put(5L, new Product(5L, "Stan Smith", "47", SHOES, "https://media.journeys.com/images/products/1_396087_ZM.JPG"));
        products.put(6L, new Product(6L, "Gazelle", "50", SHOES, "https://media.journeys.com/images/products/1_428680_ZM.JPG"));
        products.put(7L, new Product(7L, "Top Ten", "36", SHOES, "http://s7d1.scene7.com/is/image/ShiekhShoes/10-7774.1A?$shiekh_large$"));
        products.put(8L, new Product(8L, "Americana", "48", SHOES, "https://boogiedownproductions.files.wordpress.com/2015/08/americana1.jpg?w=1500&h=1261&crop=1"));
        products.put(9L, new Product(9L, "Oregon", "27", SHOES, "https://i1.adis.ws/i/jpl/jd_053254_a?qlt=80&w=600&h=425&v=1"));
        products.put(10L, new Product(10L, "Energy Boost", "28", SHOES, "https://runnerclick.com/wp-content/uploads/2017/09/Adidas-Energy-Boost-left-to-right-slider1400x900.jpg?t=1504792961"));
        products.put(11L, new Product(11L, "Rod Laver", "29", SHOES, "https://images-na.ssl-images-amazon.com/images/I/616hrsyGQYL._UY395_.jpg"));

        products.put(12L, new Product(12L, "Spain", "S", CLOTHES, "https://images.sportsdirect.com/images/products/37128708_l.jpg"));
        products.put(13L, new Product(13L, "Argentina", "M", CLOTHES, "https://www.soccermaster.com/wp-content/uploads/bq9329_adidas_argentina_authentic_home_jsy_sm_01.jpg"));
        products.put(14L, new Product(14L, "Brazil", "L", CLOTHES, "https://i3.stycdn.net/images/article/06.07/KT49429-2-0.jpg"));
        products.put(15L, new Product(15L, "Germany", "XL", CLOTHES, "https://images.sportsdirect.com/images/products/37128130_l.jpg"));
        products.put(16L, new Product(16L, "Portugal", "XXL", CLOTHES, "http://www.footballshirtculture.com/images/2017/adidas_1992_portugal_match_worn_us_cup_home_shirt_domingos.jpg"));
        products.put(17L, new Product(17L, "Peru", "XXXL", CLOTHES, "https://http2.mlstatic.com/casaca-adidas-peru-original-nueva-talla-s-roja-retro-mundial-D_NQ_NP_977174-MPE26211095456_102017-F.jpg"));
        products.put(18L, new Product(18L, "Greece", "XS", CLOTHES, "https://www.footy-boots.com/wp-content/uploads/2007/10/greeceshirt.jpg"));
        products.put(19L, new Product(19L, "Venezuela", "XXS", CLOTHES, "https://images-na.ssl-images-amazon.com/images/I/71eXyiZ8KYL._SY355_.jpg"));
        products.put(20L, new Product(20L, "South Africa", "M", CLOTHES, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQi05C3Tj1max8_3k1TtepH688vvM1XOy-Hz1isRW5iC3aJVI-PNA"));
        products.put(21L, new Product(21L, "China", "M", CLOTHES, "http://www.sportingplus.net/5608-thickbox_default/camiseta-de-futbol-seleccion-china-primera-201415-adidas.jpg"));
        products.put(22L, new Product(22L, "Japan", "S", CLOTHES, "http://picture-cdn.wheretoget.it/y3bcia-i.jpg"));
        products.put(23L, new Product(23L, "Australia", "L", CLOTHES, "https://i.ebayimg.com/images/g/TFgAAOSw~CFY6vyR/s-l300.jpg"));

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
