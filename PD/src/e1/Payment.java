package e1;


public class Payment implements OrderStat {

    @Override
    public void screenInfo(Order order) {
        String log = "Order " + order.getNumeroPedido() + ": Payment";
        order.getLogs().add(log);

        System.out.println("Order Number : " + order.getNumeroPedido());
        System.out.println("Phase : Payment -- " + order.getCart().size() + " products in the Shopping Cart");
    }

    @Override
    public void payOrder(Order order) {
        //order.print_ShoppingCart();
        order.setHour(new Hour());
        order.setDate(new Date());

        System.out.println( "Purchase confirmed sucessfully " + order.getDate().toString() + " at " + order.getHour().toString());

        order.setPayed(true);
    }

    @Override
    public void orderCompleted(Order order) {
        order.setEstado(new Completed());
        order.screenInfo();
        order.orderCompleted();
    }

    @Override
    public void cancellOrder(Order order) {
        order.setEstado(new Cancelled());
        order.screenInfo();
        order.cancellOrder();
    }

}
