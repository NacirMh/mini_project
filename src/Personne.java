import java.util.Scanner;

public class Personne {
	
private String nom;
private String prenom;
private int age;
private char gendre;
private Personne pere;
private Personne mere;

public Personne(String nom, String prenom, int age, char gendre) {
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.gendre = gendre;
}

public Personne() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("nom : ");
	this.nom=scanner.nextLine();
	System.out.println("prenom : ");
	this.prenom=scanner.nextLine();
	System.out.println("Femme?(0/1):  ");
	if(Integer.parseInt(scanner.nextLine())==1) {
		this.gendre='F';
	}else{
		this.gendre='M';
	};
	System.out.println("age: ");
	this.age=Integer.parseInt(scanner.nextLine());
	System.out.println("Avez-vous des informations sur la mére de "+toString()+"?");
	if(scanner.nextInt()==0) {
		this.mere=null;
	}else {
		mere= new Personne();
	}
	System.out.println("Avez-vous des informations sur la pere de "+toString()+"?");
	if(scanner.nextInt()==0) {
		this.pere=null;
	}else {
		pere= new Personne();
	}
	scanner.close();
}


public Personne(String nom, String prenom, int age, char gendre, Personne pere, Personne mere) {
	this(nom,prenom,age,gendre);
	this.pere = pere;
	this.mere = mere;
}

public void setmere(Personne mere) {
	this.mere=mere;
}

public void setpere(Personne pere) {
	this.pere=pere;
}

public boolean equals(Personne p) {
	
	return (this.nom == p.nom  && this.prenom == p.prenom && this.pere == p.pere && this.mere==p.mere);
}

public static boolean equals(Personne p ,Personne p1) {
	return (p1.nom.equals(p.nom) && p1.prenom.equals(p.prenom) && p1.pere == p.pere && p1.mere==p.mere);
}


public boolean memepere(Personne p) {
	if(this.pere== null || p.pere== null) {
		return false;
	}
	return(this.pere.equals(p.pere));
}

public boolean mememere(Personne m) {
	if(this.mere== null || m.mere== null) {
		return false;
	}
	return(this.mere.equals(m.mere));
}

public String toString() {
	return nom +" "+ prenom;
}
public void afficheArbre(int nbg) {
       System.out.println(toString()+" " + this.age +" ans");
       if(this.mere != null) {
    	 for(int i = 0;i<nbg;i++){
    		 System.out.print("\t");
    	 }
         System.out.print("Mére:");
         mere.afficheArbre(nbg+1);
         }
       if(this.pere != null) {
    	 for(int i = 0;i<nbg;i++){
      		 System.out.print("\t");
      	 }
         System.out.print("Pére:"); 
         pere.afficheArbre(nbg+1);
       }
}

public static boolean estUnFils(Personne p1,Personne p2) {
	boolean result=false;
	if(p1.pere != null && p1.mere!=null) {
		result= p1.pere.equals(p2) || p1.mere.equals(p2);
	}
	if(p1.pere == null && p1.mere!=null) {
		result= p1.mere.equals(p2);
	}
	if(p1.pere != null && p1.mere==null) {
		result= p1.pere.equals(p2);
	}
	return result ;
}

public static boolean sontFrere(Personne p1,Personne p2) {
	return p1.mememere(p2) || p1.memepere(p2);
}

public static boolean estUnAscendant(Personne p1,Personne p2) {
	if (p1 == null || p2 == null) {
        return false;
    }
	if (p1.equals(p2)) {
        return true;
    }
	if (p2.pere != null && estUnAscendant(p1,p2.pere)){
        return true;
    }
	if (p2.mere != null && estUnAscendant(p1,p2.mere)) {
        return true;
    }
	return false;
}
public static boolean estDescendant(Personne p1,Personne p2) {
	if (p1 == null || p2 == null) {
        return false;
    }
	if (p1.equals(p2)) {
        return true;
    }
	if (p1.mere != null && estDescendant(p1.mere,p2)){
        return true;
    }
	if (p1.pere != null && estDescendant(p1.pere,p2)) {
        return true;
    }
	return false;
}
public static Personne premierAscendant(Personne p1) {
    if (p1 == null) {
        return null;
    }

    if (p1.pere != null) {
        return premierAscendant(p1.pere);
    }

    if (p1.mere != null) {
        return premierAscendant(p1.mere);
    }

    return p1; 
}


public static boolean estUnProche(Personne p1,Personne p2) {
	if(Personne.premierAscendant(p1).equals(Personne.premierAscendant(p2)) || Personne.estUnAscendant(p1, p2) || Personne.estDescendant(p1, p2) ) {
	   return true;	
	}
	return false;	
}

public static String QuelleRelation(Personne p1,Personne p2) {
	if(p1.equals(p2)) {
		return "Meme";
	}
	if(Personne.sontFrere(p1,p2)) {
		return "frére";
	}
	if(Personne.estUnFils(p1, p2)) {
		return "Fils";
	}
	if(Personne.estUnFils(p2, p1)) {
		return "Parent";
	}
	if(Personne.estUnAscendant(p1, p2)) {
		return "Ascendant";
	}
	if(Personne.estDescendant(p1, p2)) {
		return "Descendant";
	}
	if(Personne.estUnProche(p1, p2)) {
		return "Proche";
	}
	return "Aucune";
}

public void Inviter(Ville v) {
	System.out.println("Les proches "+this.toString()+ " sont:");
	for(Personne p : v.getHabitants()) {
		if(estUnProche(this, p) && !p.equals(this)){
			System.out.println("\t"+p);
		}
	}
}
}

