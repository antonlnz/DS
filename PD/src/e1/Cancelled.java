package e1;

import java.util.List;

public class Cancelled implements OrderStat {

    @Override
    public void screenInfo(Order order) {
        String log = "Order " + order.getNumeroPedido() + ": Cancelled";
        order.addLog(log);

        System.out.println("Order Number : " + order.getNumeroPedido());
        System.out.println("Phase : Cancelled ");
    }

    private boolean aux_remove(Product prod, List<Item> cart){
        int i;
        Item aux;
        for(i = 0; i < cart.size(); i++){
            aux = cart.get(i);
            if(aux.getProduct().equals(prod)){
                prod.setStock(prod.getStock() + aux.getCantidad());
                cart.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void cancellOrder(Order order) {
        Date date = new Date();
        Hour hour = new Hour();

        if(order.passed_24h(hour, date)){
            System.out.println("The order cannot be cancelled.");
            order.setEstado(new Payment());
            throw new IllegalStateException();
        } else {

            for(int i = 0; i < order.cart.size(); i++){
                aux_remove(order.cart.get(i).getProduct(),order.cart);
            }
            System.out.println("The order has been cancelled.");
        }
    }

}
