/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		string white = Chessman.WHITE.getChessman();
		string black = Chessman.BLACK.getChessman();
		int[] result;
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "十"){
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
				if(board[i][j] != "十"){
					if(countAll(i,j,white)==4){
						return {i,j};
					}
					if(countAll(i,j,black)==4){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "十"){
					if(countAll(i,j,white)==3){
						return {i,j};
					}
					if(countAll(i,j,black)==3){
						return {i,j};
					}
				}
			}
		}
		for(int i=0;i<=21;i++){
			for(int j=0;j<=21;j++){
				if(board[i][j] != "十"){
					if(countAll(i,j,white)==2){
						return {i,j};
					}
				}
			}
		}
		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		return { posX, posY };
	}

	public int conutAll(int posX, int posY,String ico) {
		int c1=countAtV(posX,posY,ico)；
		int c2=countAtH(posX,posY,ico);
		int c3=countAtRD(posX,posY,ico);
		int c4=countAtLD(posX,posY,ico);
		int rel=Math.max(c1,c2,c3,c4);
		return rel;
	}

	public int countAtV(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posY;// i是列下标
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

	public int countAtH(int posX, int posY,String ico) {
		String[][] board = chessboard.getBoard();
		int i = posX;// i是行下标
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