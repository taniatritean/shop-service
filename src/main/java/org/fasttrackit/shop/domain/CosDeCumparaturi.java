package org.fasttrackit.shop.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ttritean
 * @since 9/23/2018
 */
public class CosDeCumparaturi {

    private String cumparator;
    private List<Produs> produse = new ArrayList<>();

    public CosDeCumparaturi(String cumparator) {
        this.cumparator = cumparator;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public String getCumparator() {

        return cumparator;
    }

    public void setCumparator(String cumparator) {
        this.cumparator = cumparator;
    }

    public void addProdus(Produs produs) {
        this.getProduse().add(produs);
    }

//calculam totalul cosului
    public double computeTotalPrice() {
        double total = 0;
        for (Produs produs : produse) {
            total += produs.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CosDeCumparaturi{");
        sb.append("cumparator='").append(cumparator).append('\'');
        sb.append(", produse=").append(produse);
        sb.append('}');
        return sb.toString();
    }
}
