import java.io.BufferedReader;
import java.io.InputStreamReader;

 
public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	/**
	 * ������������
	 */
	public int[] computerDo() {
		string white = Chessman.WHITE.getChessman();
		string black = Chessman.BLACK.getChessman();
		int[] result;
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "ʮ"){
					if(isWon(i,j,white)){
						return {i,j};
					}
					if(isWon(i,j,black)){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "ʮ"){
					if(count(i,j,white)==4){
						return {i,j};
					}
					if(count(i,j,black)==4){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "ʮ"){
					if(count(i,j,white)==3){
						return {i,j};
					}
					if(count(i,j,black)==3){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "ʮ"){
					if(count(i,j,white)==2){
						return {i,j};
					}
				}
			}
		}
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		return { posX, posY };
	}
	// �����ж�
	public int conut(int posX, int posY,String ico) {
		int c1=countAtV(posX,posY,ico)��
		int c2=countAtH(posX,posY,ico);
		int c3=countAtRD(posX,posY,ico);
		int c4=countAtLD(posX,posY,ico);
		int rel=Math.max(c1,c2,c3,c4);
		return rel;
	}
	// �����ж�
	public int countAtV(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posY;// i�����±�
		int num = 0;
		while (i >= 0&&ico == board[posX][i]) {
			i--;
			num++;
		}
		i=posY;
		while (i<=21&&ico==board[posX][i]) {
			num++;
			i++;
		}
		return num;

	}
	// �����ж�
	public int countAtH(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;// i�����±�
		int num = 0;
		while (i >= 0&&ico == board[i][posY]) {
			i--;
			num++;
		}
		i=posX;
		while (i<=21&&ico==board[i][posY]) {
			num++;
			i++;
		}
		return num;

	}
	// �����ж�
	public int countAtRD(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;
		int j=posY;
		int num = 0;
		while (i >= 0&&j>=0&&ico == board[i][j]) {
			i--;
			j--;
			num++;
		}
		i=posX;
		j=posY;
		while (i<=21&&j<=21&&ico==board[i][j]) {
			num++;
			i++;
			j++;
		}
		return num;

	}
	// �����ж�
	public int countAtLD(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;
		int j=posY;
		int num = 0;
		while (i >= 0&&j<=21&&ico == board[i][j]) {
			i--;
			j++;
			num++;
		}
		i=posX;
		j=posY;
		while (i<=21&&j>=0&&ico==board[i][j]) {
			num++;
			i++;
			j--;
		}
		return num;

	}

	/**
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
	 */
	public boolean isWon(int posX, int posY, String ico) {
		if((isWinAtV(posX, posY,ico) || isWinAtH(posX, posY,ico) || isWinAtRD(posX, posY,ico)|| isWinAtLD(posX, posY,ico))){
			return true;
		}else{
			return false;
		}
	}



	// �����ж�
	public static boolean isWinAtV(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posY;// i�����±�
		int num = 0;
		while (i >= 0&&ico == board[posX][i]) {
			i--;
			num++;
		}
		i=posY;
		while (i<=21&&ico==board[posX][i]) {
			num++;
			i++;
		}
		if(num>=5){
	    		return true;
		}else{
			return false;
		}

	}
	// �����ж�
	public static boolean isWinAtH(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;// i�����±�
		int num = 0;
		while (i >= 0&&ico == board[i][posY]) {
			i--;
			num++;
		}
		i=posX;
		while (i<=21&&ico==board[i][posY]) {
			num++;
			i++;
		}
		if(num>=5){
	    		return true;
		}else{
			return false;
		}

	}
	// �����ж�
	public static boolean isWinAtRD(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;
		int j=posY;
		int num = 0;
		while (i >= 0&&j>=0&&ico == board[i][j]) {
			i--;
			j--;
			num++;
		}
		i=posX;
		j=posY;
		while (i<=21&&j<=21&&ico==board[i][j]) {
			num++;
			i++;
			j++;
		}
		if(num>=5){
	    		return true;
		}else{
			return false;
		}

	}
	// �����ж�
	public static boolean isWinAtLD(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;
		int j=posY;
		int num = 0;
		while (i >= 0&&j<=21&&ico == board[i][j]) {
			i--;
			j++;
			num++;
		}
		i=posX;
		j=posY;
		while (i<=21&&j>=0&&ico==board[i][j]) {
			num++;
			i++;
			j--;
		}
		if(num>=5){
	    		return true;
		}else{
			return false;
		}

	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
