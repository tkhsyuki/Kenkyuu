package FF;

public class main {

	public static void main(String[] args) {
		/*条件*/
		double lambda = 0.005;//λ
		int kensu = 10000; //呼の発生件
		int howslot = 200;//(100 * 1024) / 64; //リンクのスロット数;
		double tend = 1000000.0;//シュミレーション時間
		int kaisu = 1;//300;     //シミュレーション回数
		double n = 0.0001;//lambdaの精度
	
		System.out.println("FirstFit*toporogi*SIMULATE*START,lmabda:"+lambda+"～"+(lambda+n*(kaisu-1)));
		for(int i=0;i<kaisu;i++){
			EXcute e = new EXcute(lambda,kensu,howslot,tend);
			e.Simulate();
			lambda += n;
			
		}

	}

}
