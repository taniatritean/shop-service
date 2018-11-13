package org.fasttrackit.shop.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 9/23/2018
 */
@Entity
@Table(name = "categorii")
public class CategorieProdus  implements Serializable {
    @Id
    @GeneratedValue(generator = "categorie_generator")
    @SequenceGenerator(
            name = "categorie_generator",
            sequenceName = "categorie_sequence",
            initialValue = 1
    )
    private Long id;

    private String name;
    private String owner;

    @OneToMany
    @JoinColumn(name = "product_id", nullable = false)
    private List<Produs> produse= new ArrayList<>();


    public CategorieProdus(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CategorieProdus{");
        sb.append("name='").append(name).append('\'');
        sb.append(", owner='").append(owner).append('\'');
        sb.append(", produse=").append(produse);
        sb.append('}');
        return sb.toString();
    }
}
