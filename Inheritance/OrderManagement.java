class Order {
    String referenceCode;
    String placedOn;
}

class ShippedOrder extends Order {
    String parcelCode;
}

class DeliveredOrder extends ShippedOrder {
    String arrivalDate;

    String getOrderStatus() {
        return "Delivered on: " + arrivalDate;
    }
} 