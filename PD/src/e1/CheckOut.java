package e1;

public class CheckOut implements OrderStat {

    @Override
    public void screenInfo(Order order) {
        String log = "Order " + order.getNumeroPedido() + ": CheckOut";
        order.getLogs().add(log);

        System.out.println("Order Number : " + order.getNumeroPedido());
        System.out.println("Phase : CheckOut -- " + order.getCart().size() + " products in the Shopping Cart");
    }

    @Override
    public void addProduct(Product prod, int cantidad, Order order) {
        order.setEstado(new ShoppingCart());
        order.screenInfo();
        order.addProduct(prod, cantidad);
    }

    @Override
    public void removeProduct(Product prod, Order order) {
        order.setEstado(new ShoppingCart());
        order.screenInfo();
        order.removeProduct(prod);
    }

    @Override
    public void changeQuantity(Product prod, int cantidad, Order order) {
        order.setEstado(new ShoppingCart());
        order.screenInfo();
        order.changeQuantity(prod, cantidad);
    }

    @Override
    public void checkOut(Order order) {
        String log = "If you want to continue with the purchase, please pay the order";
        System.out.println(log);
        order.getLogs().add(log);
    }

    @Override
    public void payOrder(Order order) {
        order.setEstado(new Payment());
        order.screenInfo();
        order.payOrder();
    }

}
