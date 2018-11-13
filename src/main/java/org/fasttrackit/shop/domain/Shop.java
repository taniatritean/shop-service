package org.fasttrackit.shop.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ttritean
 * @since 9/23/2018
 */

@Entity
@Table(name = "shops")
public class Shop implements Serializable {

    @Id
    @GeneratedValue(generator = "shop_generator")
    @SequenceGenerator(
            name = "shop_generator",
            sequenceName = "shop_sequence",
            initialValue = 1
    )
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<CategorieProdus> categoriiProduse = new HashSet<>();

    public Shop(String name) {
        this.name = name;
    }

    public Shop(String name, Set<CategorieProdus> categoriiProduse) {
        this.name = name;
        this.categoriiProduse = categoriiProduse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategorieProdus> getCategoriiProduse() {
        return categoriiProduse;
    }

    public void setCategoriiProduse(Set<CategorieProdus> categoriiProduse) {
        this.categoriiProduse = categoriiProduse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Shop{");
        sb.append("id='").append(id).append('\'');

        sb.append("name='").append(name).append('\'');
        sb.append(", categoriiProduse=").append(categoriiProduse);
        sb.append('}');
        return sb.toString();
    }
}
