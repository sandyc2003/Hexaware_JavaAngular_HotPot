package com.hexaware.hotpot.dto;

public class CartItemDto {
    private Long id;
    private Long userId;
    private String username;
    private Long menuItemId;
    private String itemName;
    private int quantity;

    public CartItemDto() {}

	public CartItemDto(Long id, Long userId, String username, Long menuItemId, String itemName, int quantity) {
		super();
		this.id = id;
		this.userId = userId;
		this.username = username;
		this.menuItemId = menuItemId;
		this.itemName = itemName;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(Long menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

    
}

