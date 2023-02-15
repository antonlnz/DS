package e1;

public class Completed implements OrderStat {

    @Override
    public void screenInfo(Order order) {
    String log = "Order " + order.getNumeroPedido() + ": Completed";
    order.addLog(log);

    System.out.println("Order Number : " + order.getNumeroPedido());
    System.out.println("Phase : Completed ");

    }

    @Override
    public void orderCompleted(Order order) {
        Date date = new Date();
        Hour hour = new Hour();
        if(order.passed_24h(hour, date))
            System.out.println("The order has been completed.");
        else{
            System.out.println("The order cannot be completed. ");
            order.setEstado(new Payment());
            throw new IllegalStateException();
        }

    }

}
