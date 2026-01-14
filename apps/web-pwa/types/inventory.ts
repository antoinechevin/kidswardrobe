import { Child } from "./child";
import { ClothingType } from "./clothing-type";

export interface InventoryItem {
    id: string;
    child: Child;
    clothingType: ClothingType;
    size: string;
    quantity: number;
}
