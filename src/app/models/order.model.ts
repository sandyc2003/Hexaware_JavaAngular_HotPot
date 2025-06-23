export interface Order {
  id?: number;
  user: {
    id: number;
  };
  status?: string;
  totalPrice?: number;
  orderItems: {
    menuItem: {
      id: number;
    };
    quantity: number;
  }[];
}
