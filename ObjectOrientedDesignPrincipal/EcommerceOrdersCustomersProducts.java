import java.util.List;
import java.util.ArrayList;
public class EcommerceOrdersCustomersProducts {
    class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    class Order {
        int orderId;
        Customer customer;
        List<Product> products;

        Order(int orderId, Customer customer) {
            this.orderId = orderId;
            this.customer = customer;
            this.products = new ArrayList<>();
        }

        void addProduct(Product product) {
            products.add(product);
        }

        void displayOrderDetails() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Customer: " + customer.getName());
            System.out.println("Products in Order:");
            for (Product product : products) {
                System.out.println("- " + product.getName() + ": $" + product.getPrice());
            }
        }
    }

    class Customer {
        String name;

        Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        EcommerceOrdersCustomersProducts ecommerce = new EcommerceOrdersCustomersProducts();
        Customer customer = ecommerce.new Customer("John Doe");
        Product product1 = ecommerce.new Product("Laptop", 999.99);
        Product product2 = ecommerce.new Product("Mouse", 25.50);
        
        Order order = ecommerce.new Order(1, customer);
        order.addProduct(product1);
        order.addProduct(product2);
        
        order.displayOrderDetails();
    }
}