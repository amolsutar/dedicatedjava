/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class LinearSearch {

    public static int linearsearch(int argArray[], int numberToFind) {
        for (int i = 0; i <= argArray.length; i++) {
            if (argArray[i] == numberToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int ArrayNumbers[] = {34, 76, 45, 8, 6, 912, 12};
        int key=8;
        System.out.println(" The 8 element is found at index "+linearsearch(ArrayNumbers,key));
        
    }

}
