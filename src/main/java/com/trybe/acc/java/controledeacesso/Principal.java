package com.trybe.acc.java.controledeacesso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/** Classe principal. */
public class Principal {
  /** Método principal. */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    short initialInput = 0;
    ArrayList<Short> underAge = new ArrayList<Short>();
    ArrayList<Short> adult = new ArrayList<Short>();
    ArrayList<Short> upperAge = new ArrayList<Short>();
    do {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Acessar o estabelecimento");
      System.out.println("2 - Finalizar sistema e mostrar relatório");
      initialInput = scanner.nextShort();

      if (initialInput != 1 && initialInput != 2) {
        System.out.println("Entre com uma opção válida!");
      } else if (initialInput == 1) {
        System.out.println("Entre com a idade:");
        short secondInput = scanner.nextShort();
        if (secondInput < 18) {
          underAge.add(secondInput);
          System.out.println("Pessoa cliente menor de idade, catraca liberada!");
        } else if (secondInput >= 18 && secondInput <= 49) {
          adult.add(secondInput);
          System.out.println("Pessoa adulta, catraca liberada!");
        } else {
          upperAge.add(secondInput);
          System.out.println("Pessoa adulta a partir de 50, catraca liberada!");
        }
      }
    } while (initialInput != 2);

    int total = underAge.size() + adult.size() + upperAge.size();
    
    float percentageUnderAge = 0;
    float percentageAdult = 0;
    float percentageUpperAge = 0;

    if (total != 0) {
      percentageUnderAge = (float) underAge.size() / total;
      percentageAdult = (float) adult.size() / total;
      percentageUpperAge = (float) upperAge.size() / total;
    }

    System.out.println("----- Quantidade -----");
    System.out.println("menores: " + underAge.size());
    System.out.println("adultas: " + adult.size());
    System.out.println("a partir de 50: " + upperAge.size());

    DecimalFormat percent = new DecimalFormat("0.0#%");

    System.out.println("----- Percentual -----");
    System.out.println("menores: " + percent.format(percentageUnderAge));
    System.out.println("adultas: " + percent.format(percentageAdult));
    System.out.println("a partir de 50: " + percent.format(percentageUpperAge));

    System.out.println("TOTAL: " + total);

    scanner.close();
  }
}
