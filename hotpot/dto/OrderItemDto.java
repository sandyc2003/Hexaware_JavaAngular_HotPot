package com.hexaware.hotpot.dto;

public class OrderItemDto {
    private Long id;
    private Long orderId;
    private String username;         // user who placed order
    private Long menuItemId;
    private String menuItemName;
    private int quantity;
    private double price;

    public OrderItemDto() {}

	public OrderItemDto(Long id, Long orderId, String username, Long menuItemId, String menuItemName, int quantity,
			double price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.username = username;
		this.menuItemId = menuItemId;
		this.menuItemName = menuItemName;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}