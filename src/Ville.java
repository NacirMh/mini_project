import java.util.ArrayList;
import java.util.List;

public class Ville {
  private String nomVille;
  private int max;
  private List <Personne> habitants=new ArrayList <Personne> ();
  
  
  public Ville(int max,String nomVille) {
	  this.nomVille=nomVille;
	  this.max=max;
  }
  
  public void addHabitant(Personne p) {
	  if(habitants.size()<=max) {
	     habitants.add(p);
      }else {
    	  System.out.println("la ville est pleine");
      }  
  }
  public void ListHabitant() {
	  for(Personne h : habitants) {
		  System.out.println(h.toString());
	  }
  }
  public int getNbHabitants(){
	  return habitants.size();
  }
  
  public int existe(Personne p){
	  int size=getNbHabitants();
	  for(int i=0;i<size;i++) {
		  if(habitants.get(i).equals(p)) {
			  return i;
		  }
	  }
	  return -1;
  }

public List<Personne> getHabitants() {
	return habitants;
}
  
  
  
  
}
