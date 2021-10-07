/*
 * Criar um projeto Java (EscalonamentoProcessos) e importe a biblioteca 
 * FilaStrings. Esse novo projeto irá receber uma cadeia de Strings de proces_
 * sos com o seguinte formato 
 * (nomeProcesso;qtdDeVezesQueDeveRetornarAoProcessador) 
 * e simular o escalonamento de processos RoundRobin. A classe 
 * EscalonadorController no package controller deve ter 1 método:
 * • O método escalonador que recebe uma Fila de processos, quebra a String, 
 * apresentado o nome do processo que está em processamento e coloca o número 
 * numa variável int. Esse número deve ser decrementado e, se esse número for 
 * maior que 1, deve remontar a String (com o número de vezes decrementado) e 
 * retornar o processo à fila;
 * A classe Principal, no package view, no seu método Main, deve inicializar 
 * uma fila e, inicializar um array de processos que pode ser como o exemplo 
 * abaixo, com um forEach colocar todos os processos do vetor na fila e, na 
 * sequência chamar o escalonador.
 * 
 * Exemplo de vetor de entrada: {"notepad.exe;14","write.exe;35","chrome.exe;27",
 * "acrobat.exe;52","firefox.exe;18","word.exe;25"}
 */

package controller;

import br.edu.fateczl.ingridcosme.filastr.Fila;

public class EscalonadorController {

	public EscalonadorController() {
		super();
	}
	
	public void escalonador(Fila f) throws Exception {
		while(!f.isEmpty()) {
			String processo = f.remove();
			String dadosProcesso[] = processo.split(";");
			
			int tempo = (int)((Math.random() * 201) + 50);
			Thread.sleep(tempo);
			
			StringBuffer buffer = new StringBuffer();
        	buffer.append("O processo ");
        	buffer.append(dadosProcesso[0]);
        	buffer.append(" está em processamento.");
			System.out.println(buffer.toString());
			
			int repeticoes = Integer.parseInt(dadosProcesso[1]) - 1;
			
			if(repeticoes >= 1) {
				dadosProcesso[1] = String.valueOf(repeticoes);
				processo = dadosProcesso[0]+";"+dadosProcesso[1];
				f.insert(processo);
			}
		}
	}

}
