package e1;

import java.util.Calendar;
import java.util.LinkedList;

public class Order {

    private final int numeroPedido;

    protected LinkedList<Item> cart;

    private LinkedList<String> logs;

    private OrderStat estado;

    private boolean payed;

    private Hour hour;

    private Date date;

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public LinkedList<Item> getCart() {
        return cart;
    }

    public LinkedList<String> getLogs() {
        return logs;
    }

    public void addLog(String log) {
        this.logs.add(log);
    }

    public OrderStat getEstado() {
        return estado;
    }

    public void setEstado(OrderStat estado) {
        this.estado = estado;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order() {
        numeroPedido = Math.round( (float) Math.random() * 100000);
        cart = new LinkedList<>();
        logs = new LinkedList<>();
        estado = new ShoppingCart();
        this.payed = false;
        this.hour = null;
        this.date = null;
        this.screenInfo();
    }

    public void printLogs() {
        for (String log : logs) {
            System.out.println(log);
        }
    }

    protected boolean passed_24h(Hour hour, Date date) {

        //No se comprueban las 24h, sino que haya pasado por lo menos 1 min.
        return hour.getMinutes() > this.hour.getMinutes() || hour.getHour() > this.hour.getHour();

        /*if( date.month > this.date.month || date.year > this.date.year)
            return true;
        else{
            return date.day > this.date.day && hour.hour > this.hour.hour;
        }*/
    }

    public void screenInfo() {
        estado.screenInfo(this);
    }

    public void addProduct(Product prod, int cantidad) {
        estado.addProduct(prod, cantidad, this);
    }

    public void removeProduct(Product prod) {
        estado.removeProduct(prod, this);
    }

    public void changeQuantity(Product prod, int cantidad) {
        estado.changeQuantity(prod, cantidad, this);
    }

    public void checkOut() {
        estado.checkOut(this);
    }

    public void payOrder() {
        estado.payOrder(this);
    }

    public void cancellOrder() {
        estado.cancellOrder(this);
    }

    public void orderCompleted() {
        estado.orderCompleted(this);
    }

}