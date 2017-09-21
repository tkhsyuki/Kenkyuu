package FF;

import java.util.ArrayList;

public class Path {

	Path(){
		int a[] = {0,50,0,0,0,50};
		int b[] = {50,0,50,0,80,50};
		int c[] = {0,50,0,50,50,0};
		int d[] = {0,0,50,0,50,0};
		int e[] = {0,80,50,50,0,50};
		int f[] = {50,50,0,0,0,50};
	}
	/*searchメソッドは使用するリンクの配列を返す*/

	/*最短経路パス*/
	public  int[] k1path(int s,int d){
		ArrayList<Integer> usenode = new ArrayList<Integer>(0);
		System.out.println("usenodesize:"+usenode.size());

		if(s==0){
			System.out.println("s=0");
			switch(d){
			case 1:
				usenode.add(6);
				break;

			case 2:
				usenode.add(6);
				usenode.add(1);
				break;

			case 3:
				usenode.add(6); //k2同距離あり
				usenode.add(1);
				usenode.add(2);
				break;
			case 4:
				usenode.add(5);
				usenode.add(4);
				break;
			case 5:
				usenode.add(5);
				break;
			}

		}else if(s==1){
			System.out.println("s=1");
			switch(d){
			case 0:
				usenode.add(6);
				break;
			case 2:
				usenode.add(1);
				break;
			case 3:
				usenode.add(1);
				usenode.add(2);
				break;

			case 4:
				usenode.add(7);
				break;

			case 5:
				usenode.add(8);
				break;
			}

		}else if(s==2){
			System.out.println("s=2");
			switch(d){
			case 0:
				usenode.add(1);
				usenode.add(6);
				break;
			case 1:
				usenode.add(1);
				break;
			case 3:
				usenode.add(2);
				break;
			case 4:
				usenode.add(9);
				break;
			case 5:
				usenode.add(1);//同距離あり
				usenode.add(8);
				break;
			}

		}else if(s==3){
			System.out.println("s=3");
			switch(d){
			case 0:
				usenode.add(2);//同距離あり
				usenode.add(1);
				usenode.add(6);
				break;
			case 1:
				usenode.add(2);
				usenode.add(1);
				break;

			case 2:
				usenode.add(2);
				break;
			case 4:
				usenode.add(3);
				break;
			case 5:
				usenode.add(3);
				usenode.add(4);
				break;
			}

		}else if(s==4){
			System.out.println("s=4");
			switch(d){
			case 0:
				usenode.add(4);
				usenode.add(5);
				break;
			case 1:
				usenode.add(7);
				break;
			case 2:
				usenode.add(9);
				break;
			case 3:
				usenode.add(3);
				break;
			case 5:
				usenode.add(4);
				break;
			}

		}else if(s==5){
			System.out.println("s=5");
			switch(d){
			case 0:
				usenode.add(5);
				break;

			case 1:
				usenode.add(8);
				break;
			case 2:
				usenode.add(8);
				usenode.add(1);
				break;
			case 3:
				usenode.add(4);
				usenode.add(3);
				break;

			case 4:
				usenode.add(4);
				break;
			}
		}

		int[] a = new int[usenode.size()];
		for (int i=0; i<usenode.size(); i++) {
			  a[i] = usenode.get(i); // Integer
			  System.out.println(a[i]);
		}
		return a;
	}


	/*2番目最短パス*/
	public  int[] k2path(int s,int d){
		ArrayList<Integer> usenode = new ArrayList<Integer>(0);
		if(s==0){
			switch(d){
			case 1:
				usenode.add(5);
				usenode.add(8);
				break;

			case 2:
				usenode.add(5);
				usenode.add(4);
				usenode.add(9);
				break;

			case 3:
				usenode.add(5);
				usenode.add(4);
				usenode.add(3);
				break;
			case 4:
				usenode.add(6);
				usenode.add(7);
				break;

			case 5:
				usenode.add(6);
				usenode.add(8);
				break;

			}

		}else if(s==1){
			switch(d){
			case 0:
				usenode.add(8);
				usenode.add(5);
				break;

			case 2:
				usenode.add(7);
				usenode.add(9);
				break;

			case 3:
				usenode.add(1);
				usenode.add(9);
				usenode.add(3);
				break;

			case 4:
				usenode.add(8);//k3に同値あり
				usenode.add(4);
				break;

			case 5:
				usenode.add(7);
				usenode.add(4);
				break;
			}

		}else if(s==2){
			switch(d){
			case 0:
				usenode.add(9);//k3に同値あり
				usenode.add(4);
				usenode.add(5);
				break;
			case 1:
				usenode.add(9);
				usenode.add(4);
				usenode.add(8);
				break;
			case 3:
				usenode.add(9);
				usenode.add(3);
				break;

			case 4:
				usenode.add(2);
				usenode.add(3);
				break;
			case 5:
				usenode.add(9);
				usenode.add(4);
				break;
			}

		}else if(s==3){
			switch(d){
			case 0:
				usenode.add(3);
				usenode.add(7);
				usenode.add(6);
				break;
			case 1:
				usenode.add(3);
				usenode.add(4);
				usenode.add(8);
				break;
			case 2:
				usenode.add(3);
				usenode.add(7);
				usenode.add(1);
				break;
			case 4:
				usenode.add(2);
				usenode.add(1);
				usenode.add(7);
				break;
			case 5:
				usenode.add(2);
				usenode.add(9);
				usenode.add(4);
				break;
			}

		}else if(s==4){
			switch(d){
			case 0:
				usenode.add(7);
				usenode.add(6);
				break;
			case 1:
				usenode.add(9);//k3に同値あり
				usenode.add(1);
				break;
			case 2:
				usenode.add(3);
				usenode.add(2);
				break;
			case 3:
				usenode.add(9);
				usenode.add(2);
				break;
			case 5:
				usenode.add(7);
				usenode.add(8);
				break;
			}

		}else if(s==5){
			switch(d){
			case 0:
				usenode.add(8);
				usenode.add(6);
				break;
			case 1:
				usenode.add(5);
				usenode.add(6);
				break;
			case 2:
				usenode.add(4);
				usenode.add(9);
				break;
			case 3:
				usenode.add(8);//k3同値あり812
				usenode.add(1);
				usenode.add(2);
				break;
			case 4:
				usenode.add(8);
				usenode.add(7);
				break;
			}
		}

		int[] a = new int[usenode.size()];
		for (int i=0; i<usenode.size(); i++) {
			  a[i] = usenode.get(i); // Integer
		}
		return a;
	}
    /*             */
	/*3番目最短パス*/
	/*			   */
	public  int[] k3path(int s,int d){
		ArrayList<Integer> usenode = new ArrayList<Integer>(0);

		if(s==0){
			switch(d){
			case 1:
				usenode.add(5);
				usenode.add(4);
				usenode.add(7);
				break;
			case 2:
				usenode.add(6);
				usenode.add(7);
				usenode.add(9);
				break;

			case 3:
				usenode.add(6);
				usenode.add(7);
				usenode.add(3);
				break;
			case 4:
				usenode.add(6);
				usenode.add(8);
				usenode.add(4);
				break;
			case 5:
				usenode.add(6);
				usenode.add(7);
				usenode.add(4);
				break;
			}

		}else if(s==1){
			switch(d){
			case 0:
				usenode.add(7);
				usenode.add(4);
				usenode.add(5);
				break;
			case 2:
				usenode.add(8);
				usenode.add(4);
				usenode.add(9);
				break;
			case 3:
				usenode.add(1);
				usenode.add(9);
				usenode.add(3);
				break;
			case 4:
				usenode.add(1);//k3に同値あり
				usenode.add(9);
				usenode.add(3);
				break;
			case 5:
				usenode.add(7);
				usenode.add(4);
				break;
			}

		}else if(s==2){
			switch(d){
			case 0:
				usenode.add(1);//k3に同値あり
				usenode.add(8);
				usenode.add(5);
				break;
			case 1:
				usenode.add(9);
				usenode.add(4);
				usenode.add(8);
				break;
			case 3:
				usenode.add(1);
				usenode.add(7);
				usenode.add(3);
				break;
			case 4:
				usenode.add(1);
				usenode.add(7);
				break;
			case 5:
				usenode.add(1);
				usenode.add(6);
				usenode.add(5);
				break;
			}

		}else if(s==3){
			switch(d){
			case 0:
				usenode.add(3);//k2同距離あり
				usenode.add(7);
				usenode.add(6);
				break;
			case 1:
				usenode.add(3);
				usenode.add(4);
				usenode.add(8);
				break;
			case 2:
				usenode.add(3);
				usenode.add(7);
				usenode.add(1);
				break;
			case 4:
				usenode.add(2);
				usenode.add(1);
				usenode.add(7);
				break;
			case 5:
				usenode.add(2);
				usenode.add(9);
				usenode.add(4);
				break;
			}

		}else if(s==4){
			switch(d){
			case 0:
				usenode.add(7);
				usenode.add(8);
				usenode.add(5);
				break;
			case 1:
				usenode.add(4);
				usenode.add(8);
				break;
			case 2:
				usenode.add(7);
				usenode.add(1);
				break;
			case 3:
				usenode.add(7);
				usenode.add(1);
				usenode.add(2);
				break;
			case 5:
				usenode.add(9);
				usenode.add(1);
				usenode.add(8);
				break;
			}

		}else if(s==5){
			switch(d){
			case 0:
				usenode.add(4);
				usenode.add(7);
				usenode.add(6);
				break;
			case 1:
				usenode.add(4);
				usenode.add(7);
				break;
			case 2:
				usenode.add(4);
				usenode.add(3);
				usenode.add(2);
				break;
			case 3:
				usenode.add(4);//k3同値あり812
				usenode.add(9);
				usenode.add(2);
				break;
			case 4:
				usenode.add(8);
				usenode.add(1);
				usenode.add(9);
				break;
			}
		}

		int[] a = new int[usenode.size()];
		for (int i=0; i<usenode.size(); i++) {
			  a[i] = usenode.get(i); // Integer
		}
		return a;
	}


}

