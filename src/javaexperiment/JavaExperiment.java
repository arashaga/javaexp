/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaexperiment;

import java.util.Scanner;

/**
 *
 * @author arash
 */
public class JavaExperiment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here


        Scanner s = new Scanner(System.in);
        String stop;
        int a, b;
        try {
            do {

                a = b = 0;
                System.out.println("Please enter a: ");
                //     a = Integer.parseInt(s.nextLine());
                a = s.nextInt();
                System.out.println("Please enter b: ");
                //     b = Integer.parseInt(s.nextLine());
                b = s.nextInt();

                System.out.println("The multiplication is this a*b= : " + a * b);

                System.out.println("Another one?");
                stop = s.next();
            } while (!stop.equalsIgnoreCase("Q"));
        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

        return;

    }
}
