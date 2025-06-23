export interface MenuItem {
  id?: number;
  itemName: string;
  description?: string;
  category: string;
  price: number;
  availabilityTime: string;
  dietaryInfo: string;
  tasteInfo?: string;
  nutritionalInfo?: string;
  available?: boolean;

  // Optional if you want to show restaurant details on the frontend
  restaurant?: {
    id: number;
    restaurantName: string;
    location: string;
    contact: string;
  };
}
