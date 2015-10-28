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
					if(coountNum(i,j,white)==4){
						return {i,j};
					}
					if(coountNum(i,j,black)==4){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "ʮ"){
					if(coountNum(i,j,white)==3){
						return {i,j};
					}
					if(coountNum(i,j,black)==3){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "ʮ"){
					if(coountNum(i,j,white)==2){
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
	public int coountNum(int posX, int posY, String ico) {
		String[][] board = chessboard.getBoard();
		
		//����һ��boolean���ж��Ƿ�Ӯ flag
		boolean num = num; //һ��ʼ��Ӯ
		int i1 = 1;    //������ѭ���ڼ�������
		int count1 = 1; //�����������ж��ٸ�����������
		// ����
		while��ico == board[x + i][y]��{
			
		     i1++;
		     count1 ++;
		}
		while(ico == board[x - i][y]) {
		     i1++;
		     count1 ++;       
		}
		if(count1 >= 5){ return 5; }     //����>=5��Ӯ�� flagΪtrue
		//����
		int i2 = 1;  
		int count2 = 1;
		while��ico == board[x][y + i]��{
		     i2++;
		     count2 ++;
		}
		while(ico == board[x][y - i]) {
		     i2++;
		     count2 ++;       
		}
		if(count2 >= 5){ return 5; }
		//б��
		int i3 = 1;
		int count3 = 1;
		while��ico == board[x + i][y - i]��{
		     i3++;
		     count3 ++;
		}
		while(ico == board[x - i][y + i]) {
		     i3++;
		     count3 ++;       
		}
		if(count3 >= 5){ return 5; }
		//б��
		int i4 =1��
		int count4 = 1��
		while��ico == board[x + i][y + i]��{
		     i4++;
		     count4 ++;
		}
		while(ico == board[x - i][y - i]) {
		     i4++;
		     count4 ++;       
		}
		if(count4 >= 5){return 5; }
		return Math.max(count1,count2,count3,count4);
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
		String[][] board = chessboard.getBoard();
		
		//����һ��boolean���ж��Ƿ�Ӯ flag
		boolean flag = false; //һ��ʼ��Ӯ
		int i1 = 1;    //������ѭ���ڼ�������
		int count1 = 1; //�����������ж��ٸ�����������
		// ����
		while��ico == board[x + i][y]��{
			
		     i1++;
		     count1 ++;
		}
		while(ico == board[x - i][y]) {
		     i1++;
		     count1 ++;       
		}
		if(count1 >= 5){ flag = true; }     //����>=5��Ӯ�� flagΪtrue
		//����
		int i2 = 1;  
		int count2 = 1;
		while��ico == board[x][y + i]��{
		     i2++;
		     count2 ++;
		}
		while(ico == board[x][y - i]) {
		     i2++;
		     count2 ++;       
		}
		if(count2 >= 5){ flag = true; }
		//б��
		int i3 = 1;
		int count3 = 1;
		while��ico == board[x + i][y - i]��{
		     i3++;
		     count3 ++;
		}
		while(ico == board[x - i][y + i]) {
		     i3++;
		     count3 ++;       
		}
		if(count3 >= 5){ flag = true; }
		//б��
		int i4 =1��
		int count4 = 1��
		while��ico == board[x + i][y + i]��{
		     i4++;
		     count4 ++;
		}
		while(ico == board[x - i][y - i]) {
		     i4++;
		     count4 ++;       
		}
		if(count4 >= 5){ flag = true; }
		return flag;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
