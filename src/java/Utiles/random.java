/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Beans.Cliente;
import java.util.Random;

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
        Double m = Math.random()*9000000+70000000;
        i = m.intValue();
        return i;
    }
    public String getRandomName(){
        String nombres[] = {"Manuel","Mijail","Sheillah","Kathy","Monica","Luis"};
        return nombres[new Random().nextInt(nombres.length)];
    }
    public String getRandomUser(Cliente cliente){
        String usuario ="";
        Object[] datos={cliente.getNombre_cliente(),cliente.getIdcliente()};
        return usuario;
    }
    public static void main(String[] args) {
        random r  = new random();
        System.out.println(r.getRandomDni());
        System.out.println(r.getRandomName());
    }
}
