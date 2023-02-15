package e1;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Product cargador = new Product("CARGADOR TIPO C", 20, 7);
    Product protectorPantalla = new Product("PROTECTOR DE PANTALLA", 200, 2);
    Product telefono = new Product("SMARTPHONE", 10, 350);
    Product auriculares = new Product("AURICULARES",5, 6);
    Product funda = new Product("FUNDA", 200, 8);

    Order myOrder = new Order();
    @Test
    void testShoppingcart (){

        myOrder.addProduct(telefono, 3);
        assertEquals(3,myOrder.getCart().get(0).getCantidad());
        assertEquals(telefono, myOrder.getCart().get(0).getProduct());
        assertEquals(7, telefono.getStock());

        myOrder.removeProduct(telefono);
        assertEquals(0,myOrder.getCart().size());
        assertEquals(10, telefono.getStock());

        myOrder.addProduct(telefono, 1);

        myOrder.addProduct(cargador, 1);

        assertThrows(NoSuchElementException.class, () -> myOrder.addProduct(auriculares, 6));
        assertThrows(NoSuchElementException.class, () -> myOrder.removeProduct(funda));

        myOrder.addProduct(auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.changeQuantity(auriculares, 2);
        myOrder.changeQuantity(cargador, 3);

        assertThrows(NoSuchElementException.class, () -> myOrder.changeQuantity(funda, 1));
        assertThrows(NoSuchElementException.class, () -> myOrder.changeQuantity(auriculares, 6));

        myOrder.screenInfo();

        assertThrows(IllegalStateException.class, () -> myOrder.payOrder());
        assertThrows(IllegalStateException.class, () -> myOrder.cancellOrder());
        assertThrows(IllegalStateException.class, () -> myOrder.orderCompleted());

        assertNull(myOrder.getDate());
        assertNull(myOrder.getHour());
        assertFalse(myOrder.isPayed());

        myOrder.checkOut();
    }

    @Test
    void testCheckOut(){
        myOrder.addProduct(telefono, 3);
        myOrder.addProduct(cargador, 1);
        myOrder.addProduct( auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.checkOut();

        /* Hace lo mismo que en Shopping Cart */

        assertThrows(NoSuchElementException.class, () -> myOrder.addProduct(auriculares, 6));
        assertThrows(NoSuchElementException.class, () -> myOrder.removeProduct(funda));

        myOrder.changeQuantity(auriculares, 2);
        myOrder.changeQuantity(cargador, 3);

        assertThrows(NoSuchElementException.class, () -> myOrder.changeQuantity(funda, 1));
        assertThrows(NoSuchElementException.class, () -> myOrder.changeQuantity(auriculares, 6));

        myOrder.screenInfo();

        myOrder.checkOut();

        assertThrows(IllegalStateException.class, () -> myOrder.cancellOrder());
        assertThrows(IllegalStateException.class, () -> myOrder.orderCompleted());

        assertNull(myOrder.getDate());
        assertNull(myOrder.getHour());
        assertFalse(myOrder.isPayed());
        /* */

        myOrder.payOrder();
    }

    @Test
    void testPayment(){
        myOrder.addProduct(telefono, 3);
        myOrder.addProduct(cargador, 1);
        myOrder.addProduct( auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.checkOut();

        assertNull(myOrder.getDate());
        assertNull(myOrder.getHour());
        assertFalse(myOrder.isPayed());

        myOrder.payOrder();

        assertTrue(myOrder.isPayed());
        assertNotNull(myOrder.getDate());
        assertNotNull(myOrder.getHour());

        assertThrows(IllegalStateException.class, () -> myOrder.addProduct(funda, 1));
        assertThrows(IllegalStateException.class, () -> myOrder.removeProduct(funda));
        assertThrows(IllegalStateException.class, () -> myOrder.changeQuantity(funda, 1));
    }
    @Test
    void testCompletedTrue() throws InterruptedException {
        myOrder.addProduct(telefono, 3);
        myOrder.addProduct(cargador, 1);
        myOrder.addProduct( auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.checkOut();

        myOrder.payOrder();

        Thread.sleep(90000);
        myOrder.orderCompleted();

        assertThrows(IllegalStateException.class, () -> myOrder.addProduct(funda, 1));
        assertThrows(IllegalStateException.class, () -> myOrder.removeProduct(funda));
        assertThrows(IllegalStateException.class, () -> myOrder.changeQuantity(funda, 1));
        assertThrows(IllegalStateException.class, () -> myOrder.payOrder());
    }
    @Test
    void testCompletedFalse() throws InterruptedException {
        myOrder.addProduct(telefono, 3);
        myOrder.addProduct(cargador, 1);
        myOrder.addProduct( auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.checkOut();

        myOrder.payOrder();

        assertThrows(IllegalStateException.class, () -> myOrder.orderCompleted());

        assertThrows(IllegalStateException.class, () -> myOrder.addProduct(funda, 1));
        assertThrows(IllegalStateException.class, () -> myOrder.removeProduct(funda));
        assertThrows(IllegalStateException.class, () -> myOrder.changeQuantity(funda, 1));
    }

    @Test
    void testCancelledTrue() throws InterruptedException {
        myOrder.addProduct(telefono, 3);
        myOrder.addProduct(cargador, 1);
        myOrder.addProduct( auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.checkOut();

        myOrder.payOrder();

        myOrder.cancellOrder();

        assertThrows(IllegalStateException.class, () -> myOrder.addProduct(funda, 1));
        assertThrows(IllegalStateException.class, () -> myOrder.removeProduct(funda));
        assertThrows(IllegalStateException.class, () -> myOrder.changeQuantity(funda, 1));
    }
    @Test
    void testCancelledFalse() throws InterruptedException {
        myOrder.addProduct(telefono, 3);
        myOrder.addProduct(cargador, 1);
        myOrder.addProduct( auriculares, 5);
        myOrder.addProduct(protectorPantalla, 3);

        myOrder.checkOut();

        myOrder.payOrder();

        Thread.sleep(90000);

        assertThrows(IllegalStateException.class, () -> myOrder.cancellOrder());

        assertThrows(IllegalStateException.class, () -> myOrder.addProduct(funda, 1));
        assertThrows(IllegalStateException.class, () -> myOrder.removeProduct(funda));
        assertThrows(IllegalStateException.class, () -> myOrder.changeQuantity(funda, 1));
    }
}