public class TestPersonne {

	public static void main(String[] args) {
         Personne p1=new Personne("khélifa","Afifa",35,'F');
         Personne p2=new Personne("khélifa","Bechir",60,'H');
         Personne p3=new Personne("Helaoui","Fatma",55,'F');
         p1.setmere(p3);
         p1.setpere(p2);
         Personne p4=new Personne("Zgeuirni","Helmi",8,'H');
         p4.setmere(p1);
         Personne p5=new Personne("khélifa","Afifa",35,'F');
         p5.setmere(p3);
         p5.setpere(p2);
         p1.afficheArbre(1);
         p2.afficheArbre(1);
         p3.afficheArbre(1);
         p4.afficheArbre(1);
         if(Personne.equals(p5,p3)) {
        	 System.out.println("Les 2 Personnes sont les meme");
         }else {
        	 System.out.println("Les 2 ne sont pas les meme");
         }
         Personne p6=new Personne("Khélifa","Hanene",37,'F');
         p6.setmere(p3);
         p6.setpere(p2);
         if(Personne.sontFrere(p6,p1)) {
        	 System.out.println(p1+" et "+p6 +" sont fréres!");
         }else {
        	 System.out.println(p1+" et "+p6 +" ne sont pas fréres!");
         }
         
         if(Personne.estUnProche(p4,p6)) {
        	 System.out.println(p4+" et "+p6 +" sont des proches!");
         }else {
        	 System.out.println(p4+" et "+p6 +" ne sont pas proches!");
         }
         Ville v= new Ville(100,"Mahdia");
         v.addHabitant(p1);
         v.addHabitant(p2);
         v.addHabitant(p3);
         v.addHabitant(p4);
         v.addHabitant(p5);
         v.addHabitant(p6);
         Personne p7=new Personne("Nahla","Mejri",38,'F');
         p1.Inviter(v);
         String relation;
         relation= Personne.QuelleRelation(p1,p2);
             System.out.println(p1+" et "+p2+" : "+relation);
             relation= Personne.QuelleRelation(p1,p3);

             System.out.println(p1 +" et "+p3+" : "+relation);
        	 relation= Personne.QuelleRelation (p2,p1);
        	 System.out.println (p2 +" et " + p1 +" : "+ relation);
        	 relation=Personne.QuelleRelation (p3,p1);
        	 System.out.println (p3 + " et " + p1 + ": " + relation); 
        	 relation =Personne.QuelleRelation (p1,p4);
        	 System.out.println (p1+" et " + p4 + " : "+relation);
        	 relation =Personne.QuelleRelation (p1, p6);
        	 System.out.println (p1+" et " + p6+": "+relation);
        	 relation= Personne. QuelleRelation (p1,p7);
        	 System.out.println (p1 + " et " + p7+" : "+relation);
        	 relation= Personne.QuelleRelation (p2,p7);
        	 System.out.println(p2+" et " + p7 + " : " + relation);
        	 relation= Personne.QuelleRelation (p1,p5);
        	 System.out.println (p1+" et " + p5+" : "+relation);
        	 relation= Personne. QuelleRelation (p3,p4);
        	 System.out.println (p3+ " et " + p4 +" : " + relation);
        	 relation =Personne.QuelleRelation (p4,p3);
        	 System.out.println(p4+" et " + p3 + " : " + relation);
        	 
        Personne p8 = new Personne();
        p8.afficheArbre(1);
        
         
         
         
	}

}
