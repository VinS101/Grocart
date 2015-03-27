
package shoppingcartapplication_main;

import java.util.ArrayList;
import java.util.Iterator;



public class ShoppingCart implements Iterable
{
    public ShoppingCart(){
        cart = new ArrayList<Product>();
    }
    
    //Example from the book
    public Iterator<LineItem> getItems()
   {
      return new
         Iterator<LineItem>()
         {
            @Override
            public boolean hasNext()
            {
               return current < items.size();
            }

            @Override
            public LineItem next()
            {
               return items.get(current++);
            }

            @Override
            public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }
    
    ArrayList<Product> cart;
    
}
