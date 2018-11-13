package org.fasttrackit.shop.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ttritean
 * @since 9/23/2018
 */
@Entity
@Table(name = "produse")
public class Produs implements Serializable {

    @Id
    @GeneratedValue(generator = "produs_generator")
    @SequenceGenerator(
            name = "produs_generator",
            sequenceName = "produs_sequence",
            initialValue = 1
    )
    private Long id;

    private String name;
    private double price;
    private CategorieProdus category;

    public Produs(String name, double price, CategorieProdus category) {
        this.name = name;
        this.price = price;
        this.category = category;
        //adaugam in categorie produsul
        category.getProduse().add(this);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CategorieProdus getCategory() {
        return category;
    }

    public void setCategory(CategorieProdus category) {
        this.category = category;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produs{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        if (category != null) {
            sb.append(", category=").append(category.getName());
        }
        sb.append('}');
        return sb.toString();
    }
}
