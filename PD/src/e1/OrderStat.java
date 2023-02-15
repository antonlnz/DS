package e1;

public interface OrderStat {

    /**
     * Add the log and prints it. This function variates depending on the state.
     * The default operation is to throw an exception
     * @param order: Order to be added to the log.
     */
    default void screenInfo(Order order){
        throw new IllegalStateException();
    }

    /**
     * Adds a product to the shopping cart in the given order. This function is defined in the ShoppingCart State
     * and it is also called from the CheckOut state. The default operation is to throw an exception
     * @param prod: the product to be added.
     * @param cantidad: number of products to be added.
     * @param order: the order where the product will be added.
     */
    default void addProduct(Product prod, int cantidad, Order order){
        throw new IllegalStateException();
    }

    /**
     *
     * Removes a product from the shopping cart in the given order.
     * The default operation is to throw an exception.
     * This function is defined in the ShoppingCart State
     * and it is also called from the CheckOut State
     * @param prod: the product to be removed.
     * @param order: the order where the product will be removed.
     */
    default void removeProduct(Product prod, Order order){
        throw new IllegalStateException();
    }

    /**
     * Changes the quantity of a product in the shopping cart in the given order.
     * The default operation is to throw an exception.
     * This function is defined in the ShoppingCart State
     * and it is also called form the CheckOut State.
     * @param prod: the product to be changed.
     * @param cantidad: the new quantity of the product.
     * @param order: the order where the product will be changed.
     */
    default void changeQuantity(Product prod, int cantidad, Order order) {
        throw new IllegalStateException();
    }

    /**
     * Changes the order from not-payed order to payed order.
     * The default operation is to throw an exception
     * @param order: the order to be changed.
     */
    default void payOrder(Order order){
        throw new IllegalStateException();
    }

    /**
     * Cancels the order, restoring the stock of the product.
     * The default operation is to throw an exception
     * @param order: the order to be changed.
     */
    default void cancellOrder(Order order){
        throw new IllegalStateException();
    }

    /**
     * Completes the order.
     * The default operation is to throw an exception
     * @param order: the order to be changed.
     */
    default void orderCompleted(Order order){
        throw new IllegalStateException();
    }

    /**
     * Checks out the order and allows return to the Shopping phase.
     * The default operation is to throw an exception
     * @param order: the order to be changed.
     */
    default void checkOut(Order order){
        throw new IllegalStateException();
    }

}
