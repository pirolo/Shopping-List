package com.molina.controller;

import com.molina.model.Product;
import com.molina.model.ShoppingList;

import java.util.Scanner;

/**
 * Created by User01 on 20/04/2017.
 */
public class ShoppingListApp {

    //Atributos

    private ShoppingList shoppingList;

    //Constructores

    public ShoppingListApp() {
        shoppingList = new ShoppingList();
    }

    public void run() {
        int option;

        while ( (option = showMenu()) != 0 ) {
            switch ( option ) {
                case 1:
                    readProduct();
                    break;
                case 2:
                    readIndex();
                    break;
                case 3:
                    showShoppingList();
                    break;
                case 4:
                    showTotalAmount();
                    break;
                default:
                    break;
            }
        }
    }

    private void showShoppingList() {
        int index = 1;
        for (Product product: shoppingList.getProductsList()){
            System.out.println( (index) + "# " + product );
            index++;
        }
    }

    private void showTotalAmount() {
        System.out.println("Total amount: " + shoppingList.totalAmount() + "€");
    }

    private void readIndex() {
        Scanner input = new Scanner(System.in);
        int index;

        showShoppingList();

        do {
            System.out.println("Enter index of the product:");
            index = input.nextInt();
        }while (index <= 0 || index > shoppingList.getProductsList().size());

        shoppingList.removeProduct(index-1);
    }

    private void readProduct() {
        Scanner input = new Scanner(System.in);
        Product product;
        String name;
        double price;

        do {
            System.out.println("Enter product name:");
            name = input.nextLine().trim().replaceAll("\\s+"," ");
        }while (name.equals(""));

        System.out.println("Enter product price:");
        price = input.nextDouble();

        product = new Product(name, price);
        shoppingList.addProduct( product );
    }

    private int showMenu() {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println("**************************");
        System.out.println("* 1.- Add Product        *");
        System.out.println("* 2.- Remove Product     *");
        System.out.println("* 3.- Show Product List  *");
        System.out.println("* 4.- Show Total Amount  *");
        System.out.println("* 0.- Exit               *");
        System.out.println("**************************");
        System.out.println("Option: ");
        option = input.nextInt();

        return option;
    }
}
