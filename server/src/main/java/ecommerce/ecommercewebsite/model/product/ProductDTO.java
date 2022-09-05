package ecommerce.ecommercewebsite.model.product;

import ecommerce.ecommercewebsite.model.AbstractDTO;
import lombok.Data;

@Data
public class ProductDTO implements AbstractDTO {
    Long id;
    String name;
    double price;
    String description;
    String imageUrl;
    boolean active;
    int quantity;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, double price, String description, String imageUrl, boolean active, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.active = active;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", active=" + active +
                ", quantity=" + quantity +
                '}';
    }
}
