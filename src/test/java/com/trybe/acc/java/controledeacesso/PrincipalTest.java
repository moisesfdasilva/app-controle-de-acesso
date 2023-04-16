package com.trybe.acc.java.controledeacesso;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class PrincipalTest {

  @BeforeAll
  public static void setup() {
    Locale.setDefault(Locale.US);
  }

  @Test
  @DisplayName("1 - Menu aceita entradas e mostra relatório")
  public void testePrincipal() {
    String entrada = "";

    for (int i = 0; i < 200; i++) {
      entrada += "1" + System.lineSeparator() + (i + 5) + System.lineSeparator(); 
    }
    
    entrada += "2";
      
    ByteArrayInputStream bais = new ByteArrayInputStream(entrada.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    Principal.main(null);

    String[] linha = baos.toString().split(System.lineSeparator());
    String saida = String.join(System.lineSeparator(), linha);

    assertTrue(saida.contains("77.5"));

  }
	
  @Test
  @DisplayName("2 - Menu rejeita opção inválida")
  public void testeOpcaoInvalida() {
    String entrada = "3" + System.lineSeparator(); 
    entrada += "2" + System.lineSeparator();
    
    ByteArrayInputStream bais = new ByteArrayInputStream(entrada.getBytes());
    System.setIn(bais);

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(baos);
    System.setOut(printStream);

    Principal.main(null);

    String saida = baos.toString();

    assertTrue(saida.contains("Entre com uma opção válida"));
  }

}
