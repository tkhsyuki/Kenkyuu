package FF;

import java.util.Random;

public class EXcute {
	/*パラメータ*/
	static double t=0;//時刻
	static int num=0;//呼の製造番号
	static int koson = 0;

	/*条件*/
	static double lambda;//λ
	static int kensu; //呼の発生件
	static int kensu2;
	static int howslot; //リンクのスロット数;
	static double tend;//シュミレーション時間

	static Link1 link1;
	static Link2 link2;
	static Link3 link3;
	static Link4 link4;
	static Link5 link5;
	static Link6 link6;
	static Link7 link7;
	static Link8 link8;
	static Link9 link9;

	EXcute(double l,int k,int hs,double te){
		t=0;
		koson = 0;
		num = 0;
		lambda = l;
		kensu = k;
		kensu2 = k;
		howslot = hs;
		tend = te;

		link1 = new Link1(tend,howslot);
		link2 = new Link2(tend,howslot);
		link3 = new Link3(tend,howslot);
		link4 = new Link4(tend,howslot);
		link5 = new Link5(tend,howslot);
		link6 = new Link6(tend,howslot);
		link7 = new Link7(tend,howslot);
		link8 = new Link8(tend,howslot);
		link9 = new Link9(tend,howslot);
	}

	/*シミュレーション実行*/
	void Simulate(){
		double tm = -Math.log(1 - Math.random()) / (lambda); //次の呼の生成時刻
		Path path = new Path();
		
		while(kensu != 0){
			int s,d;
			int time = (int)(t);
			boolean judge;//true = 呼損
			/*              */
			/*    呼の発生  */
			/*              */
			//path
			int sd = SD();
			s = sd/10;//source
			d = sd%10;//destination
			//info
			Random rnd = new Random();
			Random rnd2 = new Random();

			int haba = rnd.nextInt(3) + 1;//要求帯域幅
			double hol = -Math.log(1 - Math.random()) / (1/180.0);//呼の保留時間
			int arrivaltime;//呼の到着時間
			int lifetime = ((int)(hol)/10)+(time/10);//呼の終了予定時刻 = 呼の生存時間＋現在時刻
			int IorA = rnd2.nextInt(2);//0=IR,1=AR
			
			int arasa = 10;

			if(IorA == 0){
				arrivaltime = time/arasa;
			}else{
				//開始時間の決定、ＡＲ
				int random = rnd.nextInt(2);
				if(random == 0){
					arrivaltime = 1+(time/arasa);
				}else{
					arrivaltime = 3+(time/arasa);
				}
				lifetime += arrivaltime;
			}
			
			//update
			kensu--;
			num++;
			tm = -Math.log(1 - Math.random()) / (lambda);

			/*                		 */
			/*    収容処理           */
			/*                 		 */
			int usenode[] = path.k3path(s,d);
			judge = Succes(haba,lifetime,arrivaltime,usenode);

			if(judge == true)koson++;

			/*発生した呼が全て終了したか？*/
			if(kensu == 0)break;
			t = t + tm;
			
			int nextime = (int)(t);
			int a = nextime/10 - time/10;

			
			if(a >= 1){
				link1.LookNowStslot(time/10);
				link2.LookNowStslot(time/10);
				link3.LookNowStslot(time/10);
				link4.LookNowStslot(time/10);
				link5.LookNowStslot(time/10);
				link6.LookNowStslot(time/10);
				link7.LookNowStslot(time/10);
				link8.LookNowStslot(time/10);
				link9.LookNowStslot(time/10);
				
				System.out.println("---------------"+"パスの生成件数:"+(kensu2-kensu)+",経過時間:"+t);
			}
		}
		System.out.println((double)koson/kensu2);
	}


	static int SD(){
		//10の位→source  1の位→destination
		int sd;
		Random rnd = new Random();
		int s = rnd.nextInt(6);
		int d = rnd.nextInt(6);

		while(s==d){d = rnd.nextInt(6);}
		sd = (s*10)+d;
		return sd;
	}
	/*空きスロット探索*/
	static boolean Succes(int haba,int lifetime,int arrivaltime,int usenode[]){
		boolean koson=true;
		int alloN;
		for(int i = 0; i<howslot-haba+1; i++){
			for(int n=0;n<usenode.length;n++){
				switch(usenode[n]){
				case 1:
					koson = link1.Search(i,arrivaltime,lifetime,haba);
					break;
				case 2:
					koson = link2.Search(i,arrivaltime,lifetime,haba);
					break;
				case 3:
					koson = link3.Search(i,arrivaltime,lifetime,haba);
					break;
				case 4:
					koson = link4.Search(i,arrivaltime,lifetime,haba);
					break;
				case 5:
					koson = link5.Search(i,arrivaltime,lifetime,haba);
					break;
				case 6:
					koson = link6.Search(i,arrivaltime,lifetime,haba);
					break;
				case 7:
					koson = link7.Search(i,arrivaltime,lifetime,haba);
					break;
				case 8:
					koson = link8.Search(i,arrivaltime,lifetime,haba);
					break;
				case 9:
					koson = link9.Search(i,arrivaltime,lifetime,haba);
					break;
				}
				if(koson == true)break;
			}
			if(koson == false){//ここに入らなければ呼損
				alloN = i;
				Insert(usenode,alloN,arrivaltime,lifetime,haba);
				return koson;
			}
		}
		return true;
	}

	static void Insert(int usenode[],int alloN,int arrivaltime,int lifetime,int haba){
		for(int n=0;n<usenode.length;n++){
			switch(usenode[n]){
			case 1:
				link1.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 2:
				link2.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 3:
				link3.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 4:
				link4.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 5:
				link5.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 6:
				link6.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 7:
				link7.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 8:
				link8.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			case 9:
				link9.Insert(alloN,haba,arrivaltime,lifetime);
				break;
			}
		}
	}

}



