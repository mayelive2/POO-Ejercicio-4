
/*integrantres: 
  Mayeleen Rodriguez Gomez cod:2016114118
  Luis Hatum
*/

package perfectprimefactorlist;

import java.util.Scanner;

/**
 *
 * @author Maye
 */
public class PerfectPrimeFactorList {

  
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.print("Ingese el límite superior (entero positivo): ");
        Scanner in = new Scanner(System.in);
        if ( ! in.hasNextInt()) {
            System.out.println("El límite superior no es válido. Inténtalo de nuevo.");
            return;
        }
        int upperBound = in.nextInt();
        
        PerfectPrimeFactorList aPerfectPrimeFactorList = new PerfectPrimeFactorList();
        
        System.out.println(aPerfectPrimeFactorList.isProductOfPrimeFactors(30));
        System.out.println(aPerfectPrimeFactorList.isProductOfPrimeFactors(20));
        
        aPerfectPrimeFactorList.printPerfectPrimeFactors(upperBound);
    }
    
    private boolean isPrime(int posInt)
    {
        for (int i = 2; i <= Math.sqrt(posInt); i++)
        {
            if (posInt%i != 0) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    private boolean isProductOfPrimeFactors(int posInt)
    {
        int prod = 1;
        for (int i = 2; i < posInt; i++) {
            prod *= isPrime(i) && (posInt%i == 0) ? i : 1;
        }
        return (prod == posInt);
    }
    
    private void printPerfectPrimeFactors(int limiteSuperior)
    {
        System.out.println("Estos números son iguales al producto de factores primos: ");
        
        int countProductOfPrimeFactors = 0;
        for (int i = 1; i <= limiteSuperior; i++) {
            if (! isProductOfPrimeFactors(i)) {
                continue;
            }
            System.out.printf("%1$d ", i);
            countProductOfPrimeFactors++;
        }
        System.out.printf("\n[%1$d Numeros Encontrados (%2$.2f%%)]\n"
                , countProductOfPrimeFactors, ((double) 100 * countProductOfPrimeFactors/limiteSuperior));
        
    }
    
}
