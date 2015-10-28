
public boolean isWon(int posX, int posY, String ico) {
	if((isWin1(posX, posY,ico) || isWin2(posX, posY,ico) || isWin3(posX, posY,ico)|| isWin4(posX, posY,ico))){
		return true;
	}else{
		return false;
	}
}



public static boolean isWin1(int posX, int posY,String ico) {
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
	if(num>=5){
	    	return true;
	}else{
		return false;
	}

}

public static boolean isWin2(int posX, int posY,String ico) {
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
	if(num>=5){
	    	return true;
	}else{
		return false;
	}

}

public static boolean isWin3(int posX, int posY,String ico) {
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

public static boolean isWin4(int posX, int posY,String ico) {
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