import java.util.Scanner;

public class Polja {
	String p;
	String mat[][];
	
	public Polja() {
		this.p=" ";
		this.mat=new String[6][7];
		for (int i=0;i<6;i++) {
			for (int j=0;j<7;j++) {
				mat[i][j]=" ";
			}
		}
	}
	
	public void ispisi() {
		for (int i=0;i<6;i++) {
			for (int j=0;j<7;j++) {
				System.out.print("| " + mat[i][j] + " ");
			}
			System.out.print("|");
			System.out.println("\n-----------------------------");
		}
		System.out.println(" [0] [1] [2] [3] [4] [5] [6]");
		System.out.println();
	}
	
	public void azurirajX() {
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite poziciju za X");
		int a = s.nextInt();
		if (a > 6 || a < 0) {
			System.out.println("Uneli ste nekorektnu poziciju");
			azurirajX();
		}
		if (popunjenaKolona(a)) {
			System.out.println("Nema slobodnog mesta u koloni");
			azurirajX();
		} else {
			for (int i = 5; i >= 0; i--) {
				if (mat[i][a] == " ") {
					mat[i][a] = "X";
					ispisi();
					if (!pobednik()) {
						if (!nereseno()) {
							azurirajO();
						} else {
							System.out.println("*****Rezultat je neresen*****");
						}
					} else {
						System.out.println("*****POBEDNIK je igrac X*****");
					}
					break;
				}
			}
		}
	}
	
	
	public boolean popunjenaKolona(int a) {
		boolean b=true;
		for(int i=0;i<6;i++) {
			if (mat[i][a]==" ") {
				b=false;
			}	
		}
		return b;
	}

	public void azurirajO() {
		Scanner s = new Scanner(System.in);
		System.out.println("Unesite poziciju za O");
		int a = s.nextInt();
		if (a > 6 || a < 0) {
			System.out.println("Uneli ste nekorektnu poziciju");
			azurirajO();
		}
		if (popunjenaKolona(a)) {
			System.out.println("Nema slobodnog mesta u koloni");
			azurirajO();
		} else {
			for (int i = 5; i >= 0; i--) {
				if (mat[i][a] == " ") {
					mat[i][a] = "O";
					ispisi();
					if (!pobednik()) {
						if (!nereseno()) {
							azurirajX();
						} else {
							System.out.println("*****Rezultat je neresen*****");
						}
					} else {
						System.out.println("*****POBEDNIK je igrac O*****");
					}
					break;
				}
			}
		}
	}
	
	public boolean nereseno() {
		boolean b=true;
		for (int i=0;i<6;i++) {
			for (int j=0;j<7;j++) {
				if (mat[i][j]==" ") {
					b=false;
				}
			}
		}
		return b;
	}

	public boolean pobednik() {
		if (pobednikHorizontalno()||pobednikVertikalno()||pobednikDijagonalno1()||pobednikDijagonalno2()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean pobednikHorizontalno() {
		boolean b=false;
		for (int i=0;i<6;i++) {
			for (int j=0;j<4;j++) {
				if (mat[i][j]==mat[i][j+1] && mat[i][j]==mat[i][j+2] && mat[i][j]==mat[i][j+3] && mat[i][j]!=" ") {
					b=true;
				}
			}
		}
		return b;
	}
	
	public boolean pobednikVertikalno() {
		boolean b=false;
		for (int j=0;j<7;j++) {
			for (int i=0;i<3;i++) {
				if (mat[i][j]==mat[i+1][j] && mat[i][j]==mat[i+2][j] && mat[i][j]==mat[i+3][j] && mat[i][j]!=" ") {
					b=true;
				}
			}
		}
		return b;
	}
	
	public boolean pobednikDijagonalno1() {
		boolean b=false;
		for (int j=0;j<4;j++) {
			for (int i=0;i<3;i++) {
				if (mat[i][j]==mat[i+1][j+1] && mat[i][j]==mat[i+2][j+2] && mat[i][j]==mat[i+3][j+3] && mat[i][j]!=" ") {
					b=true;
				}
			}
		}
		return b;
	}
	
	public boolean pobednikDijagonalno2() {
		boolean b=false;
		for (int j=6;j>2;j--) {
			for (int i=0;i<3;i++) {
				if (mat[i][j]==mat[i+1][j-1] && mat[i][j]==mat[i+2][j-2] && mat[i][j]==mat[i+3][j-3] && mat[i][j]!=" ") {
					b=true;
				}
			}
		}
		return b;
	}
					

}
