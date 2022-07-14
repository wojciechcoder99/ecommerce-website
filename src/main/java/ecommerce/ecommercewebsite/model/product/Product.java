package ecommerce.ecommercewebsite.model.product;

import ecommerce.ecommercewebsite.model.product.category.ProductCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "product")
public class Product implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private double price;

    private String description;

    private String imageUrl;

    private boolean active;

    private int quantity;

    @CreationTimestamp
    private Date dateCreated;

    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    private ProductCategory category;
}
