import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSalesTrackerTest {
    private ProductSalesTracker tracker1;
    private ProductSalesTracker tracker2;

    @BeforeEach
    public void setUp() {
        tracker1 = new ProductSalesTracker(5);
        tracker2 = new ProductSalesTracker(3);

        tracker1.addSale(100.0);
        tracker1.addSale(200.0);
        tracker1.addSale(50.0);

        tracker2.addSale(500.0);
        tracker2.addSale(300.0);
        tracker2.addSale(200.0);
    }

    @AfterEach
    public void tearDown() {
        tracker1 = null;
        tracker2 = null;
    }

    @Test
    public void testAddSale() {
        assertTrue(tracker1.addSale(400.0)); // Should add successfully
        assertFalse(tracker2.addSale(700.0)); // Tracker2 is full
    }

    @Test
    public void testTotalSales() {
        assertEquals(350.0, tracker1.totalSales(), 0.001);
        assertEquals(1000.0, tracker2.totalSales(), 0.001);
    }

    @Test
    public void testLowestSale() {
        assertEquals(50.0, tracker1.lowestSale(), 0.001);
        assertEquals(200.0, tracker2.lowestSale(), 0.001);
    }

    @Test
    public void testFinalSalesTotal() {
        assertEquals(300.0, tracker1.finalSalesTotal(), 0.001);
        assertEquals(800.0, tracker2.finalSalesTotal(), 0.001);
    }

    @Test
    public void testToString() {
        assertEquals("100.0 200.0 50.0", tracker1.toString());
        assertEquals("500.0 300.0 200.0", tracker2.toString());
    }
}
