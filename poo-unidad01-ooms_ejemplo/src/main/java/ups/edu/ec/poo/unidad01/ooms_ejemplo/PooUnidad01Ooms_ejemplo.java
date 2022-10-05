/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ups.edu.ec.poo.unidad01.ooms_ejemplo;

/**
 *
 * @author Mauricio Ortiz Ochoa
 */
public class PooUnidad01Ooms_ejemplo {

    public static void main(String[] args) {
        System.out.println("Clase 01_01_02");

        var perro1 = new Perro();
        var perro2 = new Perro();
        var perro3 = new Perro();
        perro1.nombre = "firulais";
        perro1.raza = "mestizo";
        perro1.edad = 5;

        System.out.println("Mi perro se llama: " + perro1.nombre + " tiene "
                + perro1.edad + " años" + " y es un " + perro1.raza);

        perro2.nombre = "titi";
        perro2.raza = "beagle";
        perro2.edad = 2;

        System.out.println("Mi perro se llama: " + perro2.nombre + " tiene "
                + perro2.edad + " años" + " y es un " + perro2.raza);
    }
}
