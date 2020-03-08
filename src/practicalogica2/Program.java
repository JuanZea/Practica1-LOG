package practicalogica2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JuanZea y Daniela Vásquez
 */
public class Program {
    static Scanner entry = new Scanner(System.in);
    static Boolean existMatrix = false;
    static int order;
    static int[][] matrix;
    
    public static void menu() throws IOException{
        String ans0;
        int ans = 1007238750;
        do {            
            System.out.println("Digite el número correspondiente a la opción que desea (Digite '*' para información):\n"
                    + "1.  leeMatriz.\n"
                    + "2.  muestraMatriz.\n"
                    + "3.  sumarDatos.\n"
                    + "4.  muestraMayor.\n"
                    + "5.  muestraMenor.\n"
                    + "6.  vectorConMenorPorFila.\n"
                    + "7.  vectorConMayorPorColumna.\n"
                    + "8.  muestraDatoConMayorSumaDigitosPorColumna.\n"
                    + "9.  ordenaCadaColumnaAscendentemente.\n"
                    + "10. promedioDiagonalSecundaria.\n"
                    + "11. ordenaDescendentementePorColumnasTodaLaMatriz.\n"
                    + "12. mostrarPorFilasTriangularSuperiorDerecha.\n"
                    + "13. ordenarAscendentementePorColumna1.\n"
                    + "14. intercambiarColumnas.\n"
                    + "15. datosQueSeanPrimos.\n"
                    + "0.  SALIR.");
            ans0 = entry.next();
            if(!isNumeric(ans0)){
                if(ans0.equals("*"))
                    information();
                else
                    System.out.println("El dato no es númerico.\n");
            }
            else{
                ans = Integer.parseInt(ans0);
                if(ans == 1 || ans == 0 || (existMatrix && (ans > 1 && ans < 16))){
                switch(ans){
                default:break;
                case 1:leeMatriz();
                break;
                case 2:muestraMatriz();
                break;
                case 3:sumarDatos();
                break;
                case 4:muestraMayor();
                break;
                case 5:muestraMenor();
                break;
                case 6:vectorConMenorPorFila();
                break;
                case 7:vectorConMayorPorColumna();
                break;
                case 8:muestraDatoConMayorSumaDigitosPorColumna();
                break;
                case 9:ordenaCadaColumnaAscendentemente();
                break;
                case 10:promedioDiagonalSecundaria();
                break;
                case 11:ordenaDescendentementePorColumnasTodaLaMatriz();
                break;
                case 12:mostrarPorFilasTriangularSuperiorDerecha();
                break;
                case 13:ordenarAscendentementePorColumna1();
                break;
                case 14:intercambiarColumnas();
                break;
                case 15:datosQueSeanPrimos();
                break;
                }
            }                
            else
                if(ans <= 15)
                    System.out.println("Primero debe leer una matriz.\n"); 
                else
                    System.out.println("La opción no existe.\n");
            }            
        } while (ans != 0);
    }
    public static void leeMatriz() throws IOException{
        Scanner in = null;
        ArrayList<Integer> numbers = new ArrayList<>();        
        System.out.println("Ingrese el nombre del archivo de texto sin la extensión '.txt' (Ejemplo: Matriz1):");
        String name = entry.next();
        System.out.println("Ingrese la direccion donde se encuentra el archivo a leer (Ejemplo: C:\\Users\\ASUS\\Desktop):");
        String dir = entry.next();
        try {            
            in = new Scanner(new BufferedReader(new FileReader(dir + "/" + name + ".txt")));
            while(in.hasNext()){
                numbers.add(Integer.parseInt(in.next()));
            }
        }finally{
            if(in != null){
                in.close();
                existMatrix = true;
                System.out.println("Matriz leída correctamente.\n");
            }
        }      
        order = numbers.get(0);
        numbers.remove(0);
        matrix = new int[order][order];
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                matrix[i][j] = numbers.get(j + i*order);
            }
        }
    }
    public static void muestraMatriz() {
        for(int i = 0; i < order; i++){
            for (int j = 0; j < order; j++) 
                System.out.print(matrix[i][j] + "\t");
            System.out.print("\n");
        }
        System.out.println("");
    }
    public static void sumarDatos() {
        int sum = 0;
        for (int[] is : matrix) {
            for (int i : is) {
                sum+=i;
            }
        }
        System.out.println("La suma de todos los datos de la matriz es: " + sum + "\n");
    }
    public static void muestraMayor() {
        int k = matrix[0][0];
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < order; i++) 
            for (int j = 0; j < order; j++) {
                if(k <= matrix[i][j]){
                    k = matrix[i][j];  
                    fila = i + 1;
                    columna = j + 1;
                }                  
            }
        System.out.println("El mayor dato de la matriz es: " + k + ", y su posición es:\n"
        + "Fila: " + fila + "\n"
        + "Columna: " + columna + "\n");
    }
    public static void muestraMenor() {
        int k = matrix[0][0];
        int fila = 0;
        int columna = 0;
        for (int i = 0; i < order; i++) 
            for (int j = 0; j < order; j++) {
                if(k >= matrix[i][j]){
                    k = matrix[i][j];  
                    fila = i + 1;
                    columna = j + 1;
                }                  
            }
        System.out.println("El menor dato de la matriz es: " + k + ", y su posición es:\n"
            + "Fila: " + fila + "\n"
            + "Columna: " + columna + "\n");
    }
    public static void vectorConMenorPorFila() {
        String[] menorPorFila = new String[order];
        for (int i = 0; i < order; i++) {
            int k = matrix[i][0];
            int columna = 0;
            for (int j = 0; j < order; j++) {
                if(k >= matrix[i][j]){
                    k = matrix[i][j]; 
                    columna = j + 1;
                }               
            }            
            menorPorFila[i] = k + "-" + columna;
        }
        System.out.println("VECTOR CON MENOR POR FILA:\nFILA:\tVALOR:\tCOLUMNA:");
        for (int i = 0; i < order; i++) {
            int v = Integer.parseInt(menorPorFila[i].substring(0, menorPorFila[i].indexOf('-')));
            String c = menorPorFila[i].substring(menorPorFila[i].indexOf('-') + 1);
            System.out.println((i + 1) + "\t" + v + "\t" + c);
        }
        System.out.println();
    }
    public static void vectorConMayorPorColumna() {
        String[] mayorPorColumna = new String[order];
        for (int j = 0; j < order; j++) {
            int k = matrix[0][j];
            int fila = 0;
            for (int i = 0; i < order; i++) {
                if(k <= matrix[i][j]){
                    k = matrix[i][j]; 
                    fila = i + 1;
                }               
            }            
            mayorPorColumna[j] = k + "-" + fila;
        }
        System.out.println("VECTOR CON MAYOR POR COLUMNA:\nCOLUMNA:\tVALOR:\tFILA:");
        for (int i = 0; i < order; i++) {
            int v = Integer.parseInt(mayorPorColumna[i].substring(0, mayorPorColumna[i].indexOf('-')));
            int f = Integer.parseInt(mayorPorColumna[i].substring(mayorPorColumna[i].indexOf('-') + 1));
            System.out.println((i + 1) + "\t\t" + v + "\t" + f);
        }
        System.out.println();
    }
    public static void muestraDatoConMayorSumaDigitosPorColumna() {
        ArrayList<String> datoConMayorSumaDigitosPorColumna = new ArrayList<>();
        ArrayList<String> variousPlus = new ArrayList<>();
        for (int j = 0; j < order; j++) {
            int k = -1007238750;
            int f = 0;
            boolean first = true;
            for (int i = 0; i < order; i++) {
                int num = matrix[i][j];
                int sum = 0;
                while (num > 0) {                    
                    sum += num%10;
                    num /= 10;
                }
                if(k <= sum){
                    if(k == sum){
                        if(first){
                            variousPlus.add(String.valueOf(k) + "-" + f + "+" + j);
                            f = i;                        
                            variousPlus.add(String.valueOf(k) + "-" + f + "+" + j); 
                            first = false;
                        }
                        else{
                            f = i;  
                            variousPlus.add(String.valueOf(k) + "-" + f + "+" + j); 
                        }                     
                    }
                    else{
                        k = sum;
                        variousPlus.clear();
                        f = i;
                    }                    
                }                    
            }
            if(variousPlus.isEmpty())
                datoConMayorSumaDigitosPorColumna.add(k + "-" + f);
            else{
                for(int x = 0; x < variousPlus.size(); x++){
                    datoConMayorSumaDigitosPorColumna.add(variousPlus.get(x));
                }                    
            }
        }  
        boolean first = true;
        System.out.println("DATO CON MAYOR SUMA DE DIGITOS POR COLUMNA:\nCOLUMNA:\tVALOR:\tFILA:\tSUMA:");
        int t = 1;
        int c = 0;
        int cTemp = 0;
        for (int i = 0; i < datoConMayorSumaDigitosPorColumna.size(); i++) {
            int v = Integer.parseInt(datoConMayorSumaDigitosPorColumna.get(i).substring(0, datoConMayorSumaDigitosPorColumna.get(i).indexOf('-')));
            if(datoConMayorSumaDigitosPorColumna.get(i).contains("+")){
                int f = Integer.parseInt(datoConMayorSumaDigitosPorColumna.get(i).substring(datoConMayorSumaDigitosPorColumna.get(i).indexOf('-') + 1,datoConMayorSumaDigitosPorColumna.get(i).indexOf('+')));                    
                cTemp = Integer.parseInt(datoConMayorSumaDigitosPorColumna.get(i).substring(datoConMayorSumaDigitosPorColumna.get(i).indexOf('+')));
                if(c != cTemp){
                    c = cTemp;
                    t = 1;
                }
                else
                    c = cTemp;
                System.out.println((c + 1) + "(" + t + ")" + "\t\t" + matrix[f][c] + "\t" + (f + 1) + "\t" + v);
                first = false;
                t++;
            }                    
            else{
                if(!first)
                    c++;
                int f = Integer.parseInt(datoConMayorSumaDigitosPorColumna.get(i).substring(datoConMayorSumaDigitosPorColumna.get(i).indexOf('-') + 1));
                System.out.println((c + 1) + "\t\t" + matrix[f][c] + "\t" + (f + 1) + "\t" + v);
                first = false;
                t = 1;
            }   
        }
        System.out.println();
    }
    public static void ordenaCadaColumnaAscendentemente() {
        int i, j, c;
        for (c = 0; c < order; c++) {
            for (i = 0; i < order - 1; i++) {
                for (j = 0; j <= order - 2 - i; j++) {
                    if(matrix[j][c] > matrix[j+1][c])
                        swap(j, c, j+1, c);
                }
            }
        }
        System.out.println("Las columnas de la matriz han sido ordenadas correctamente.\n");
    }
    public static void promedioDiagonalSecundaria() {
        int sum = 0;
        for(int i = 0; i < order; i++){
            int num = matrix[i][order - 1 - i];
            sum += num;
        }
        Double mean =(double)sum/order;
        System.out.println("El promedio de la diagonal secundaria es: " + mean + "\n");
    }
    public static void ordenaDescendentementePorColumnasTodaLaMatriz() {
        int[] numbers = new int[order*order];
        int f = 0;
        int c = 0;
        for (int x = 0; x < order*order; x++) {
            numbers[x] = matrix[f][c];
            c++;
            if(c == order){
                f++;
                c = 0;
            }
        }
        int i, j, d;
        for(i = 1; i <= numbers.length - 1; i++){
            d = numbers[i];
            j = i - 1;
            while (j >= 0 && d > numbers[j]) {                
                numbers[j + 1] = numbers[j];
                j = j - 1;                
            }
            numbers[j + 1] = d;
        }
        f = 0;
        c = 0;
        for (int x = 0; x < order*order; x++) {
            matrix[c][f] = numbers[x];
            c++;
            if(c == order){
                f++;
                c = 0;
            }
        }
        System.out.println("La matriz ha sido ordenada correctamente.\n");
    }
    public static void mostrarPorFilasTriangularSuperiorDerecha() {
        System.out.println("MATRIZ TRIANGULAR SUPERIOR DERECHA:\n");
        for (int f = 0; f < order; f++) {
            for (int c = 0; c < order; c++) {
                if(f > c)
                    System.out.print("\t");
                else
                    System.out.print(matrix[f][c] + "\t");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
    public static void ordenarAscendentementePorColumna1() {
        int i, j, sw;
        for (i = 0; i < order - 1; i++) {
            sw = 0;
            for (j = 0; j <= order - 2 - i; j++) {
                if(matrix[j][0] > matrix[j + 1][0]){                    
                    swapRows(j, j + 1);
                    sw = 1;
                }
            }
            if(sw == 0){
                System.out.println("La matriz ha sido ordenada correctamente.\n");
                return;
            }
        }
        System.out.println("La matriz ha sido ordenada correctamente.\n");
    }
    public static void intercambiarColumnas() {
        System.out.println("Ingrese la primera columna a cambiar:");
        String c1i = entry.next();
        int c1;
        if(!isNumeric(c1i)){
            System.out.println("El dato no es númerico.\n");
            return;
        }
        else
            c1 = Integer.parseInt(c1i) - 1;
        if (c1 < 0 || c1 >= order) {
            System.out.println("La columna no existe.\n");
            return;
        }
        System.out.println("Ingrese la segunda columna a cambiar:");
        String c2i = entry.next();
        int c2;
        if(!isNumeric(c2i)){
            System.out.println("El dato no es númerico.\n");
            return;
        }
        else
            c2 = Integer.parseInt(c2i) - 1;
        if (c2 < 0 || c2 >= order) {
            System.out.println("La columna no existe.\n");
            return;
        }
        for(int i = 0; i < order; i++)
            swap(i, c1, i, c2);
        System.out.println("Las columnas han sido intercambiadas correctamente.\n");
    }
    public static void datosQueSeanPrimos() {
        ArrayList<String> primes = new ArrayList<>();
        for(int i = 0; i < order; i++)
            for(int j = 0; j < order; j++){
                boolean prime = true;
                int count = 2;
                if(matrix[i][j] == 1)
                    prime = false;
                while(prime && count!=matrix[i][j]){
                    if(matrix[i][j]%count == 0)
                        prime = false;
                    count++;
                }
                if(prime)
                    primes.add(matrix[i][j] + "-" + (i + 1) + "+" + (j + 1));
            }
        if(primes.isEmpty())
            System.out.println("No hay datos que sean primos.\n");
        else{
            System.out.println("Los datos primos son:\n"
                    + "DATO:\tFILA:\tCOLUMNA:");
            for(int i = 0; i < primes.size(); i++)
                System.out.println(primes.get(i).substring(0, primes.get(i).indexOf('-')) + "\t" + primes.get(i).substring(primes.get(i).indexOf('-') + 1, primes.get(i).indexOf('+')) + "\t" + primes.get(i).substring(primes.get(i).indexOf('+') + 1));
            System.out.println();
        }
    }
  
    public static void information(){
        System.out.println("INFORMACIÓN:\n"
                + "*El programa trabaja con una matriz de '0' a 'n - 1', con 'n' el orden de la matriz, es decir, que \n"
                + " hay una fila '0' y una columna '0', pero en la interacción con el usuario se trabaja con \n"
                + " una matriz de '1' a 'n' por eso en la consola se muestra y se recibe la información de una matriz \n"
                + " que comienza en la fila 1 y en la columna 1.\n");
    }
    public static boolean isNumeric(String ans){
	try {
		Integer.parseInt(ans);
		return true;
	} catch (NumberFormatException e){
		return false;
	}
    }   
    public static void swapRows(int f1, int f2) {
        for(int i = 0; i < order; i++)
            swap(f1, i, f2, i);
    }
    public static void swap(int f1,int c1, int f2, int c2) {
        int aux = matrix[f1][c1];
        matrix[f1][c1] = matrix[f2][c2];
        matrix[f2][c2] = aux;
    }
    public static void main(String[] args) throws IOException{
        menu();
    }
}