package FF;

public class Link8 {
	double tend;//終了時間
	static int howslot;//リンクのスロット数;
	static int[][] stslot; //[slot][time]の2次元配列（時間の単位は1秒）


	Link8(double ten,int hows){
		reset();
		tend = ten;
		howslot = hows;
		stslot = new int[hows][(int)(tend)+350];//範囲外対象のために、余裕を持たせる

		for(int i=0;i<hows;i++){
			for(int j=0;j<((int)(tend)/10+50);j++){
				stslot[i][j] = 0;
			}
		}
	}

	/*空きスロット探索*/
	public boolean Search(int slotn,int arrivaltime,int lifetime,int haba){
		boolean ksn=true;
		/*要求帯域1スロット*/
		if(haba == 1){
			for(int j=arrivaltime;j<=lifetime;j++){
				if(stslot[slotn][j] == 1){break;}
				if(j == lifetime){ksn = false;}
			}
		}
		/*要求帯域2スロット*/
		if(haba == 2){
			for(int j=arrivaltime;j<=lifetime;j++){
				if(stslot[slotn][j] == 1 || stslot[slotn+1][j] == 1){break;}
				if(j == lifetime){ksn = false;}
			}
		}
		/*要求帯域3スロット*/
		if(haba == 3){
			for(int j=arrivaltime;j<=lifetime;j++){
				if(stslot[slotn][j] == 1 || stslot[slotn+1][j] == 1 || stslot[slotn+2][j] == 1){break;}
				if(j == lifetime){ksn = false;}
			}
		}

		return ksn;
	}

	//呼の収容
	public void Insert(int alloN,int haba,int arrivaltime,int lifetime){
		/*要求帯域1スロット*/
		if(haba == 1){
			for(int j=arrivaltime;j<=lifetime;j++){
				stslot[alloN][j] = 1;
			}
		}
		/*要求帯域2スロット*/
		if(haba == 2){
			for(int j=arrivaltime;j<=lifetime;j++){
				stslot[alloN][j] = 1;
				stslot[alloN+1][j] = 1;
			}
		}
		/*要求帯域3スロット*/
		if(haba == 3){
			for(int j=arrivaltime;j<=lifetime;j++){
				stslot[alloN][j] = 1;
				stslot[alloN+1][j] = 1;
				stslot[alloN+2][j] = 1;
			}
		}
	}

	static void reset(){

	}
	static void LookNowStslot(int time){
		int n,m;

		for(m=0;m<howslot;m++){
			if(stslot[m][time] == 1){
				System.out.print("■");
			}else{
				System.out.print("□");
			}
		}
		System.out.println("time"+time*10);
	}


}
