package e1;

import java.util.List;
import java.util.NoSuchElementException;

public class ShoppingCart implements OrderStat {

    /**
     * Auxiliar function to add items to the list in the shopping cart.
     * @param prod: Product to be added to the shopping cart.
     * @param cantidad: Quantity of the product to be added to the shopping cart.
     * @param cart: List of products in the shopping cart.
     */
    private void aux_add(Product prod, int cantidad, List<Item> cart){
        int i;
        boolean prodequals = false;
        if(cart.size() > 0){
            Item prodonlist = cart.get(0);
            for(i = 0; i < cart.size() && !prodequals; i++){
                prodonlist = cart.get(i);
                prodequals = prodonlist.getProduct() == prod;
            }
            if(prodequals){
                /* Si el producto esta en el carrito, modifico la cantidad */
                cantidad +=cantidad;
                prodonlist.setCantidad(cantidad);
            }
            else{
                Item aux = new Item (prod, cantidad);
                cart.add(aux);
            }
            prod.setStock(prod.getStock() - cantidad);
        }
        else{
            //Si la lista esta vacia, no hay que mirar si existe el mismo producto en la lista;
            Item aux = new Item (prod, cantidad);
            cart.add(aux);
            prod.setStock(prod.getStock() - cantidad);
        }
    }

    /**
     * Auxiliar function to add items to the list in the shopping cart.
     * @param prod: Product to be removed from the shopping cart.
     * @param cart: List of products in the shopping cart.
     * @return
        true: if the product has been found and removed.
        false: if the product is not on the list.  */
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
    public void screenInfo(Order order) {
        String log = "Order " + order.getNumeroPedido() + ": Shopping Phase";
        order.addLog(log);

        System.out.println("Order Number : " + order.getNumeroPedido());
        System.out.println("Phase : Shopping -- " + order.getCart().size() + " products in the Shopping Cart");
    }

    @Override
    public void addProduct(Product prod, int cantidad, Order order) {
        String log;

        if (prod.getStock() == 0) {
            log = "Cannot add product: OUT OF STOCK  -> " + "Shopping" + " -- Products : " + order.getCart().size();
            order.addLog(log);
            System.out.println();
            throw new NoSuchElementException();
        }
        else if (prod.getStock() < cantidad){
            log = "Cannot add product: NOT ENOUGH STOCK -> "+ "Shopping" + " -- Products : " + order.getCart().size();
            order.addLog(log);
            System.out.println(log);
            throw new NoSuchElementException();
        }
        else{
            aux_add(prod, cantidad, order.cart);
            log = "Add : Item : "+ prod.getId() + " - Quantity : " + cantidad + " -> " + "Shopping" + " -- Products : " + order.getCart().size();
            order.addLog(log);
            System.out.println(log);
        }
    }

    @Override
    public void removeProduct(Product prod, Order order) {
        String log = "ERROR: Cannot removeProduct";

        if(aux_remove(prod, order.cart)){
            log = "Remove : Item : " + prod.getId() + " -> " + "Shopping" + " -- Products : " + order.getCart().size();
            order.addLog(log);
            System.out.println(log);
        }
        else{
            order.addLog(log);
            System.out.println(log);
            throw new NoSuchElementException();
        }

    }

    @Override
    public void changeQuantity(Product prod, int cantidad, Order order) {
        String log ;
        if(cantidad == 0){
            removeProduct(prod, order);
        }
        else{
            if(order.getCart().size() > 0){
                Item aux = order.cart.get(0);
                for (int i = 0; i < order.cart.size() && !aux.getProduct().equals(prod); i++) {
                    aux = order.cart.get(i);
                }
                if(aux.getProduct().equals(prod)){
                    //Encuentra el producto
                    if(aux.getCantidad() > cantidad){
                        //quitar del carrito
                        log = "- Change quantity : Item : " + prod.getId() + "- Quantity : " +
                                aux.getCantidad() + " -> " + cantidad + " | Shopping Cart -- Products : " + order.getCart().size();
                        int diferencia = aux.getCantidad() - cantidad;
                        prod.setStock(prod.getStock() + diferencia);
                        aux.setCantidad(cantidad);
                        System.out.println(log);
                    }
                    else if(cantidad == aux.getCantidad()){
                        log = "- Change quantity : Item : " + prod.getId() + "- Quantity : " +
                        cantidad + " -> " + cantidad + " | Shopping Cart -- Products : " + order.getCart().size();
                        System.out.println(log);
                        order.addLog(log);
                    }
                    else{
                        //añadir al carrito
                        int diferencia = cantidad - aux.getCantidad();
                        if(prod.getStock() > diferencia){
                            log = "- Change quantity : Item : " + prod.getStock() + "- Quantity : " +
                                    aux.getCantidad() + " -> " + cantidad + " | Shopping Cart -- Products : " + order.getCart().size();
                            prod.setStock(prod.getStock() - diferencia);
                            aux.setCantidad(cantidad);
                            System.out.println(log);
                            order.addLog(log);
                        }
                        else{
                            log = "Error: not enough stock of " + prod.getId() ;
                            System.out.println(log);
                            order.addLog(log);
                            throw new NoSuchElementException();
                        }
                    }
                }
                else{
                    log = "Error: the product " + prod.getId() + "is not in the Shopping Cart";
                    order.addLog(log);
                    throw new NoSuchElementException();
                }
            }
            else{
                log = "Error: the product " + prod.getId() + "is not in the Shopping Cart";
                order.addLog(log);
                throw new NoSuchElementException();
            }
        }
    }

    @Override
    public void checkOut(Order order) {
        order.setEstado(new CheckOut());
        order.screenInfo();
        order.checkOut();
    }

}
