package vending;

/**
 * Esta classe representa uma poss�vel implementa��o do componente respons�vel
 * pela entrega do item comprado. Para que a entrega do item se concretize,
 * algumas restri��es precisam ser satisfeitas. Tais condi��es s�o descritas
 * abaixo.
 * 
 * @author Auri Marcelo Rizzo Vincenzi
 */
public class Dispenser {
	final protected int MINSEL = 1; // �ndice do primeiro item
	final protected int MAXSEL = 20; // �ndice do �ltimo item
	final protected int VAL = 50; // Pre�o m�ximo dos itens

	// Lista dos itens dispon�veis para compra. N�meros comentados representam
	// produtos esgotados.
	protected int[] availSelectionVals = { 1, 2, 3, 4,/* 5, */6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, /* 18, */19 /* ,20 */};

	/**
	 * Simula o comportamento do componente que faz a entrega de determinado
	 * item em uma m�quina de venda. Um item � entregue quando uma quantidade de
	 * cr�ditos suficiente para a sua compra estiver dispon�vel, o c�digo do
	 * item ser um c�digo v�lido e o item estiver dispon�vel para compra (n�o
	 * estiver esgotado).
	 * 
	 * @param credit
	 *            - o valor atual em centavos do cr�dito dispon�ve no
	 *            compartimento de moedas. Um valor de 50 centavos � necess�iro
	 *            para a compra de qualquer item.
	 * 
	 * @param sel
	 *            - o �ndice do item selecionado para compra. Um item v�lido tem
	 *            um �ndice representado por um n�mero inteiro variando de 1 a
	 *            20. Observa-se que embora o �ndice seja v�lido, pode ser que o
	 *            item em quest�o esteja esgotado e n�o possa ser vendido.
	 * 
	 * @return O valor pago pelo item desejado. Atualmente esse valor � sempre
	 *         50.
	 * 
	 *         Em caso de erro, uma exce��o � lan�ada, indicando o erro ocorrido
	 *         conforme descrito abaixo:
	 * 
	 * @throws NoCoinsException
	 *             nenhuma moeda foi inserida.
	 * @throws InvalidItemException
	 *             item selecionado � inv�lido.
	 * @throws UnavailableItemException
	 *             item selecionado encontra-se esgotado.
	 * @throws NotEnoughtCreditException
	 *             cr�dito insuficiente para a compra do item desejado.
	 */
	public int dispense(int credit, int sel) {
		int val = 0;

		if (credit == 0) // nenhuma moeda inserida
			throw new NoCoinsException();
		else if ((sel < MINSEL) || (sel > MAXSEL)) // item selecionado fora do
			// intervalo
			throw new InvalidItemException();
		else if (!available(sel)) // item esgotado
			throw new UnavailableItemException();
		else {
			val = VAL;
			if (credit < val) { // sem cr�dito suficiente para a compra do item
				int value = val - credit;

				val = 0;
				throw new NotEnoughtCreditException("Mais " + value
						+ " centavos s�o necess�rios para a compra do item.");
			} else { // venda realizada com sucesso
				return val;
			}
		}
	}

	/**
	 * Este m�todo verifica se determinado item encontra-se dispon�vel, ou seja,
	 * n�o esgotado.
	 * 
	 * @param sel
	 *            �ndice do item desejado.
	 * @return true se o item n�o estiver esgotado ou false caso o item esteja
	 *         esgotado.
	 */
	protected boolean available(int sel) {
		for (int i = 0; i < availSelectionVals.length; i++)
			if (availSelectionVals[i] == sel)
				return true;
		return false;
	}
} // classe Dispenser
