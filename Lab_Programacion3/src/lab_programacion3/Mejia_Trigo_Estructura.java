/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_programacion3;

/**
 *
 * @author trigo
 */
import java.util.*;

public class Mejia_Trigo_Estructura {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        Random random = new Random();

        int opcion;
        int contador1 = 0, contador2 = 0, contador3 = 0, contador4 = 0;

        do {

            System.out.println("**** MENÚ PRINCIPAL****");
            System.out.println("1. Palabra al revés");
            System.out.println("2. Número perfecto");
            System.out.println("3. Números primos");
            System.out.println("4. Votaciones");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opción");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    contador1++;
                    System.out.print("¿Cuántas palabras desea ingresar?: ");
                    int cantidad = sc.nextInt();
                    

                    String palabraMasLarga = "";
                    boolean hayPalindromo = false;

                    for (int i = 0; i <= cantidad; i++) {
                        System.out.print("Ingrese palabra: ");
                        String palabra = sc.nextLine();

                        //Mostrar palabra al revés
                        String alreves = "";
                        for (int j = palabra.length() - 1; j >= 0; j--) {
                            alreves += palabra.charAt(j);
                        }
                        System.out.println("Al revés: " + alreves);

                        // Verificar si hay al menos un palíndromo
                        if (palabra.equalsIgnoreCase(alreves)) {
                            hayPalindromo = true;
                        }

                        // Verificar palabra más larga
                        if (palabra.length() > palabraMasLarga.length()) {
                            palabraMasLarga = palabra;
                        }
                    }

                    System.out.println("Palabra más larga: " + palabraMasLarga);
                    System.out.println(hayPalindromo ? "Se ingresó al menos un palíndromo." : "No se ingresaron palíndromos.");
                }  
                    
                case 2 -> { 
                    contador2++;
                    System.out.println("Ingrese un número: ");
                    int numero = sc.nextInt();
                    int suma = 0;
                    int k = 1;
                    
                    
                    while (k < numero){
                        if (numero % k == 0){
                            suma += k;
                        }    
                        k++;
                    }
                    
                    //Verificar si el número es perfecto
                    if (suma == numero){
                        System.out.println(numero + " es un número perfecto.");
                    } else {
                        System.out.println(numero + " no es un número perfecto.");
                    }
                }
                    
                    
                case 3 -> {
                    contador3++;
                    int aleatorio = random.nextInt(100) + 1; //Sirve para generar un número entre 1 y 100
                    int contadorDivisores = 0;
                    String listaDivisores = "";
                    
                    //Buscar divisores
                    for (int i = 1; i <= aleatorio; i++) {
                        if( aleatorio % i == 0){
                            contadorDivisores++;
                            if ( listaDivisores.isEmpty()){
                                listaDivisores = listaDivisores + 1; //primer divisor
                            }else{
                                listaDivisores += ", " + i;
                            }
                        }
                        
                    }
                    //Mostrar resultado
                    System.out.println("Número generado: " + aleatorio);
                    
                    
                    if (contadorDivisores == 2 ){
                        System.out.println("Es primo debido a que solo tiene 2 divisores.");
                    } else {
                        System.out.println("No es primo debido a que tiene más de dos divisores.");
                    }
                    
                    System.out.println("Número de divisores: " + contadorDivisores);
                    System.out.println("Divisores de " + aleatorio +" son: " + listaDivisores);
                }
                    
                case 4 -> {
                    contador4++;
                    System.out.println("Ingrese la cantidad de votantes: ");
                    int totalVotantes = sc.nextInt();
                    int azul = 0, rojo = 0, negro = 0, amarillo = 0, nulo = 0;
                    int v =1;
                    while (v <= totalVotantes) {
                        System.out.println("Voto " + v + "(AZUL, ROJO, NEGRO, AMARILLO): ");
                        String voto = sc.nextLine().toUpperCase();
                        
                        switch (voto) {
                            case "AZUL": azul++; break;
                            case "ROJO": rojo++; break;
                            case "NEGRO": negro++; break;
                            case "AMARILLO": amarillo++; break;
                        }
                        v++;
                    }
                    int votosValidos = azul + rojo + negro + amarillo;
                    double porcentajeValidos  = (double) votosValidos / totalVotantes *100;
                    if (porcentajeValidos < 60){
                        System.out.println("VOTACIÓN FALLIDA (solo "+ (int)porcentajeValidos + "% de votos válidos)");
                    } else {
                        String ganador = "";
                        int max = Math.max(Math.max(azul, rojo), Math.max(negro, amarillo));

                        if (azul == max) ganador = "AZUL";
                        else if (rojo == max) ganador = "ROJO";
                        else if (negro == max) ganador = "NEGRO";
                        else ganador = "AMARILLO";

                        System.out.println("Planilla ganadora: " + ganador);
                    }
                }
                    
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción invalida. Intentelo nuevamente.");
                    
            }   

        } while (opcion != 5);
        //Salidas finales y estadsticas
        System.out.println("\n**** RESUMEN DE OPCIONES USADAS ****");
        System.out.println("Opción 1 (Palabra al revés): " + contador1 + " veces");
        System.out.println("Opción 2 (Número perfecto): " + contador2 + " veces");
        System.out.println("Opción 3 (Primos): " + contador3 + " veces");
        System.out.println("Opción 4 (Votaciones): " + contador4 + " veces");

    }

}
