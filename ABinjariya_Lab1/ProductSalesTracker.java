public class ProductSalesTracker {
    private double[] sales;
    private int salesSize;

    public ProductSalesTracker(int capacity) {
        sales = new double[capacity];
        salesSize = 0;
    }

    public boolean addSale(double sale) {
        if (salesSize < sales.length) {
            sales[salesSize] = sale;
            salesSize++;
            return true;
        }
        return false; // Tracker is full
    }

    public double totalSales() {
        double total = 0;
        for (int i = 0; i < salesSize; i++) {
            total += sales[i];
        }
        return total;
    }

    public double lowestSale() {
        if (salesSize == 0) return 0; // No sales

        double lowest = sales[0];
        for (int i = 1; i < salesSize; i++) {
            if (sales[i] < lowest) {
                lowest = sales[i];
            }
        }
        return lowest;
    }

    public double finalSalesTotal() {
        if (salesSize < 2) return 0; // Less than two sales

        double total = totalSales();
        double lowest = lowestSale();

        return total - lowest;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < salesSize; i++) {
            sb.append(sales[i]);
            if (i < salesSize - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
