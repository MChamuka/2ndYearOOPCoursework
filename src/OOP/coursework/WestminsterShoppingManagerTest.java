package OOP.coursework;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class WestminsterShoppingManagerTest {
    @Test
    void testaddNewProduct(){
        WestminsterShoppingManager westminsterShoppingManager=new WestminsterShoppingManager();
        westminsterShoppingManager.addProduct(new Electronics("e12223","yamaha",34,2000,"suzu",12));
        assertTrue(westminsterShoppingManager.productList.contains(new Electronics("e12223","yamaha",34,2000,"suzu",12)));
    }

}