package com.odhill.garbarinoCart.dto;

/**
 * 
 * @author odhill
 *
 */
public class AddProductToCartDto {

    private Long id;
    
    private int quantity;

    /**
     * @return el id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el id a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return el quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity el quantity a establecer
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
