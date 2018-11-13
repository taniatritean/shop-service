package org.fasttrackit.shop.domain;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author ttritean
 * @since 9/23/2018
 */
public class OOPExercise2 {


    public static void main(String args[]) {

        //creem magazinul
        Shop shop = new Shop("Tania's shop");
//se creaza categoria

        CategorieProdus categorieMobila = new CategorieProdus("mobila");
        //se creaza pridusele
        Produs scaun = new Produs("scaun", 10, categorieMobila);

        Produs dulap = new Produs("dulap", 5.3, categorieMobila);

        //se adauga in magazin categoria de produse
        shop.getCategoriiProduse().add(categorieMobila);


//se construieste cosul de cumparaturi cu 3 produse: 2 scaune si un dulap
        CosDeCumparaturi cosDeCumparaturi = new CosDeCumparaturi("user1");
        cosDeCumparaturi.addProdus(scaun);
        cosDeCumparaturi.addProdus(dulap);
        cosDeCumparaturi.addProdus(scaun);

        System.out.println("In cosul de cumparaturi avem " + cosDeCumparaturi.getProduse().size() + " produse.");
        System.out.println("Totalul cosului este " + cosDeCumparaturi.computeTotalPrice());


        //Save the shop in file

        //WHY the root??
        //try without serializable
        // try without toString
        //try serializing other way

//        FilesUtil.saveInFile("shopFile.txt", shop);
//
        //List<String> strings = FilesUtil.readFromFileAsList("shopFile.txt");

        try {
            File fileToRead=new File("shopFile.txt"); // sau orice nume ai dat la fisier
            FileInputStream fis=new FileInputStream(fileToRead);
            ObjectInputStream ois=new ObjectInputStream(fis);

            Shop shopRead = (Shop)ois.readObject();
//perform actions here
            System.out.println(shop);
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //read a new sho[p from file:

    }
}
