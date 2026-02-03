

//enum defined
enum OrderStatus {
    PENDING,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED,
    REFUNDED
}

//yield keyword is used to return a value from switch case
class Ques8 {
    static String processOrderStatus(OrderStatus status){
        return switch(status){
            case PENDING -> "Order is awaiting confirmation.";

            case PROCESSING -> "Order is being prepared.";

            case SHIPPED -> {
                String message = "Order has been dispatched.";
                yield message;
            }
            case DELIVERED -> "Order has been successfully delivered.";

            case CANCELLED -> "Order has been canceled.";

            case REFUNDED ->{
                yield "Refund has been issued for the order.";
            }
            };
        }

    public static void main(String[] args) {
        System.out.println(Ques8.processOrderStatus(OrderStatus.PENDING));
        System.out.println(Ques8.processOrderStatus(OrderStatus.SHIPPED));

    }
}