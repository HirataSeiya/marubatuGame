package task;

import	java.util.Scanner;
public class marubatu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

//		マス数の定義
		int size = 3;
		int[][] masu = new int [size][size];

		for(int y=0;y<size;y++) {
			for(int x=0;x<size;x++) {
				masu[x][y] = 0;
			}
		}

//		マークの配列
		String mark [] = {" ","O","X"};
		Scanner sc = new Scanner(System.in);

//		ターン決め
		for(int turn=0;turn<size*size;turn++){
			int player = turn%2+1;
			System.out.println("Palyer"+player+"のターンです！");

//			座標入力
			int putX,putY;
			do {
				System.out.println("X座標を入力してください");
				putX = sc.nextInt();
				System.out.println("Y座標を入力してください");
				putY = sc.nextInt();
			}while(putX<0 || putY<0 || putX>=size || putY>=size || masu[putX][putY] != 0);//ループを抜けない条件
			masu[putX][putY] = player;

//			 マス目を作る
			for(int y=0;y<size;y++) {
				String sen = "|";
				for(int x=0;x<size;x++) {
					sen +=mark[masu[x][y]] + "|";
				}
				System.out.println(sen);
			}
//			横ラインを判定
			int tmp = 0;
			for(int x=0;x<size;x++) {
				if( masu[x][putY] == player) {
					tmp++;
				}
				if(tmp==size) {
					System.out.println("～" + mark[player] + "の勝ち" + "～");
				};
			}


//			縦ラインを判断
			tmp = 0;
			for(int y=0;y<size;y++) {
				if( masu[putX][y] == player) {
					tmp++;
				}
				if(tmp==size) {
					System.out.println("～" + mark[player] + "の勝ち" + "～");
				};
			}
//			右上がり斜めを判断   0.2    1.1     2.0
			tmp = 0;
			int a [] = {2,1,0};
			for(int x=0;x<size;x++) {
				if(masu[x][a[x]] == player) {
					tmp++;
				}
				if(tmp==size) {
					System.out.println("～" + mark[player] + "の勝ち" + "～");
				};
			}


//			右下がり斜めを判断
			tmp = 0;
			for(int x=0;x<size;x++) {
				if(masu[x][x]==player) {
					tmp++;
				}
				if(tmp==size) {
					System.out.println("～" + mark[player] + "の勝ち" + "～");
				};

			}

		}
		System.out.println("～引き分けです～");
	}
}
