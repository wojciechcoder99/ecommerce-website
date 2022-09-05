package ecommerce.ecommercewebsite.model.product.category;

import ecommerce.ecommercewebsite.model.AbstractEntity;
import ecommerce.ecommercewebsite.model.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "product_category")
public class ProductCategory implements AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
