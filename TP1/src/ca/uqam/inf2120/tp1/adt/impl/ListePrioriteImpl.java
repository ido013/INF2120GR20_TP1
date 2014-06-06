package ca.uqam.inf2120.tp1.adt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ca.uqam.inf2120.tp1.adt.ListePrioriteTda;
import ca.uqam.inf2120.tp1.adt.Priorite;

/**
 * UQAM - �t� 2014 - INF2120 - Groupe 20 - TP1
 * 
 * ListePrioriteImpl : Impl�mentation de l'interface ListePrioriteTda.
 * 
 * @author Bernatchez, Jonathan et BERJ23118609
 * @version 27 mai 2014
 */
public class ListePrioriteImpl<T extends Priorite> implements ListePrioriteTda<T> {

	private List<T> liste;
	
	// Constructeur
	public ListePrioriteImpl() {
		liste = new ArrayList<T>();
	}

	/**
	 * Ajoute l'�l�ment "elt" dans la liste selon sa priorit�. Les �l�ments de la
	 * plus grande priorit� sont ajout�s au d�but de la liste. L'�l�ment ne doit 
	 * pas �tre ajout� si une des conditions suivantes est vraie :
	 *   - L'�l�ment est null.
	 *   - L'�l�ment existe d�j� dans la liste (�l�ments identiques sans tenir compte 
	 *     de leur priorit�).
	 *   - La priorit� de l'�l�ment est inf�rieure ou �gale � 0.
	 *   
	 * Si l'�l�ment "elt" � ajouter a la m�me priorit� qu'un �l�ment qui existe dans 
	 * la liste, il doit �tre ajout� apr�s ce dernier.
	 *
	 * @param elt L'�l�ment � ajouter
	 * @return true si "elt" est ajout�, sinon false
	 */
	public boolean ajouter(T elt) {
		boolean reponse=false;
		boolean fin=false;
		if(elt!=null && !liste.contains(elt) && !(elt.obtenirPriorite()<=0)){
			if(liste.size()==0){
				liste.add(elt);
				reponse=true;
			}else{
				ListIterator<T> it = this.iterateur();
				while (it.hasNext() && !fin) {
					int priorite = it.next().obtenirPriorite();
					int indPrio = it.nextIndex();
					if(elt.obtenirPriorite()!=priorite){	
						if(elt.obtenirPriorite()>priorite){
							liste.add(indPrio-1,elt);
							fin=true;
							reponse=true;
						}
					}
				}
			}
			if(!reponse){
				liste.add(elt);
				reponse=true;
			}
		}
		return reponse;
	}

	/**
	 * Ajoute tous les �l�ments de la liste pass�e en param�tre dans la
	 * liste existante. Tous les �l�ments sont ajout�s dans la liste selon leur
	 * priorit�. Les �l�ments de la plus grande priorit� sont ajout�s au d�but de 
	 * la liste. Aucun ajout si une des conditions suivantes est vraie :
	 *   - La liste est nulle.
	 *   - L'�l�ment � ajouter est null.
	 *   - L'�l�ment existe d�j� dans la liste (�l�ments identiques sans tenir compte
	 *     de leur priorit�).
	 *   - La priorit� de l'�l�ment est inf�rieure ou �gale � 0.
	 * 
	 * Si l'�l�ment � ajouter a la m�me priorit� qu'un �l�ment qui existe dans la liste,
	 * il doit �tre ajout� apr�s ce dernier.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les �l�ments doivent �tre ajout�s
	 */
	public void ajouter(List<T> liste) {
		if(liste!=null){
			for(T i: liste){
				this.ajouter(i);
			}
		}
	}

	/**
	 * Supprime "elt" dans la liste existante. Aucune suppression si "elt" est
	 * nul ou s'il n'existe pas dans la liste. L'�l�ment � supprimer doit �tre
	 * �gal � celui pass� en param�tre ("elt") avec la m�me priorit�.
	 * 
	 * @param elt L'�l�ment � supprimer
	 * @return Vrai si l'�l�ment est supprim�
	 */
	public boolean supprimer(T elt) {
		boolean reponse=false;
		boolean fin=false;
		if(elt!=null && liste.contains(elt)){
			ListIterator<T> it = this.iterateur();
			while(it.hasNext()&&!fin){
				int priorite = it.next().obtenirPriorite();
				if(priorite==elt.obtenirPriorite()){
					reponse = liste.remove(elt);
					fin=true;
				}
			}
			reponse=true;
		}
		return reponse;
	}

	/**
	 * Supprime tous les �l�ments de la liste pass�e en param�tre dans la liste
	 * existante. Tous les �l�ments non supprim�s de la liste pass�e en param�tre
	 * sont retourn�s dans un tableau liste (ArrayList). L'�l�ment � supprimer doit
	 * �tre �gal � "elt" avec la m�me priorit�.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les �l�ments doivent �tre supprim�s
	 * @return Le tableau liste (ArrayList) des �l�ments non supprim�s, nul si tous les �l�ments
	 *         sont supprim�s.
	 */
	public List<T> supprimer(List<T> liste) {
		List<T> listeRet = new ArrayList<T>();
		if(liste!=null){
			for(T i: liste){
				if(!this.supprimer(i)){
					listeRet.add(i);
				}
			}
		}
		return listeRet;
	}

	/**
	 * Supprime tous les �l�ments dont la priorit� est �gale � celle pass�e en
	 * param�tre. Les �l�ments supprim�s sont retourn�s dans un tableau liste.
	 * Une valeur nulle est retourn�e si aucun �l�ment n'est supprim�.
	 * 
	 * @param priorite La priorit� des �l�ments � supprimer
	 * @return Le tableau liste des �l�ments supprim�s
	 */
	public List<T> supprimer(int priorite) {
		List<T> listRet = new ArrayList<T>();
		int counter=0;
		ListIterator<T> it = this.iterateur();
		while(it.hasNext()){
			T item = it.next();
			int prioList = item.obtenirPriorite();
			if(prioList==priorite){
				listRet.add(item);
				this.supprimer(item);
				counter++;
			}
		}
		if(counter==0){
			listRet=null;
		}
		return listRet;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(int, boolean)
	 */
	@Override
	public List<T> supprimer(int priorite, boolean plusPetit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#remplacer(int, int)
	 */
	@Override
	public boolean remplacer(int anciennePriorite, int nouvellePriorite) {
		// TODO Auto-generated method stub
		return false;
	}

	  /**
	   * Retourne le nombre d'�l�ments dont la priorit� est �gale � celle pass�e en param�tre.
	   * 
	   * @param priorite La priorit� 
	   * @return Le nombre d'�l�ments dont la priorit� = "priorite" 
	   */
	public int ObtenirNbElments(int priorite) {
		int nbPrio=0;
		ListIterator<T> it = this.iterateur();
		while(it.hasNext()){
			if(it.next().obtenirPriorite() == priorite){
				nbPrio++;
			}
		}
		return nbPrio;
	}

	/**
	 * V�rifie si la liste existante est vide.
	 * 
	 * @return Vrai si la liste est vide, sinon faux
	 */
	public boolean estVide() {
		return liste.isEmpty();
	}

	/**
	 * Retourne un it�rateur sur la liste courante.
	 * 
	 * @return It�rateur sur la liste courante.
	 */
	public ListIterator<T> iterateur() {
		ListIterator<T> it = liste.listIterator();
		return it;
	}
	
	
	
}
