package pojo;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private Map<Integer,CartItem> items=new LinkedHashMap<>();
    //购物车商品总数
    public Integer getTotalCount() {
        Integer totalCount = 0;
        for(Map.Entry<Integer,CartItem> entry: items.entrySet()){
            totalCount +=entry.getValue().getCount();
        }
        return totalCount;
    }


    //购物车商品总价
    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        for(Map.Entry<Integer,CartItem> entry: items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
    //添加商品
    public void addItem(CartItem cartItem){
       CartItem item=items.get(cartItem.getId());
       if(item==null){
           items.put(cartItem.getId(),cartItem);
       }else{
           item.setCount(item.getCount()+1);
           item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
       }
    }
    //删除商品
    public void deleteItem(Integer id){
        items.remove(id);
    }
    //清空购物车
    public void clear(){
        items.clear();
    }

    public void update(Integer id,Integer count){
        CartItem item = items.get(id);
        if(item!=null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
