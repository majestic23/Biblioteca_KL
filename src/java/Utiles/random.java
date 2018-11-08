/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author retr0
 */
public class random {
    public int getInt() {
        int i;
        Double m = Math.random()*100+10000;
        i=m.intValue();
        return i;
    }
    public int getRandomDni(){
        int i;
        Double m = Math.random()*900000+70000000;
        i = m.intValue();
        return i;
    }
    public static void main(String[] args) {
        random r  = new random();
        System.out.println(r.getRandomDni());
    }
}
