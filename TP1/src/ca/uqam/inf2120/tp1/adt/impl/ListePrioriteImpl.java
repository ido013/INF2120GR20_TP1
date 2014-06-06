package ca.uqam.inf2120.tp1.adt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import ca.uqam.inf2120.tp1.adt.ListePrioriteTda;
import ca.uqam.inf2120.tp1.adt.Priorite;

/**
 * UQAM - Été 2014 - INF2120 - Groupe 20 - TP1
 * 
 * ListePrioriteImpl : Implémentation de l'interface ListePrioriteTda.
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
	 * Ajoute l'élément "elt" dans la liste selon sa priorité. Les éléments de la
	 * plus grande priorité sont ajoutés au début de la liste. L'élément ne doit 
	 * pas être ajouté si une des conditions suivantes est vraie :
	 *   - L'élément est null.
	 *   - L'élément existe déjà dans la liste (éléments identiques sans tenir compte 
	 *     de leur priorité).
	 *   - La priorité de l'élément est inférieure ou égale à 0.
	 *   
	 * Si l'élément "elt" à ajouter a la même priorité qu'un élément qui existe dans 
	 * la liste, il doit être ajouté après ce dernier.
	 *
	 * @param elt L'élément à ajouter
	 * @return true si "elt" est ajouté, sinon false
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
	 * Ajoute tous les éléments de la liste passée en paramètre dans la
	 * liste existante. Tous les éléments sont ajoutés dans la liste selon leur
	 * priorité. Les éléments de la plus grande priorité sont ajoutés au début de 
	 * la liste. Aucun ajout si une des conditions suivantes est vraie :
	 *   - La liste est nulle.
	 *   - L'élément à ajouter est null.
	 *   - L'élément existe déjà dans la liste (éléments identiques sans tenir compte
	 *     de leur priorité).
	 *   - La priorité de l'élément est inférieure ou égale à 0.
	 * 
	 * Si l'élément à ajouter a la même priorité qu'un élément qui existe dans la liste,
	 * il doit être ajouté après ce dernier.
	 * 
	 * @param liste Le tableau liste (ArrayList) dont les éléments doivent être ajoutés
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
	 * nul ou s'il n'existe pas dans la liste. L'élément à supprimer doit être
	 * égal à celui passé en paramètre ("elt") avec la même priorité.
	 * 
	 * @param elt L'élément à supprimer
	 * @return Vrai si l'élément est supprimé
	 */
	public boolean supprimer(T elt) {
		boolean reponse=false;
		boolean fin=false;
		if(elt!=null && liste.contains(elt)){
			ListIterator<T> it = this.iterateur();
			while (it.hasNext() && !fin) {
				int priorite = it.next().obtenirPriorite();
				if(priorite==elt.obtenirPriorite()&&it.equals(elt)){
					liste.remove(elt);
					fin=true;
					reponse=true;
				}
			}
		}
		return reponse;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(java.util.List)
	 */
	@Override
	public List<T> supprimer(List<T> liste) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(int)
	 */
	@Override
	public List<T> supprimer(int priorite) {
		// TODO Auto-generated method stub
		return null;
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
	   * Retourne le nombre d'éléments dont la priorité est égale à celle passée en paramètre.
	   * 
	   * @param priorite La priorité 
	   * @return Le nombre d'éléments dont la priorité = "priorite" 
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
	 * Vérifie si la liste existante est vide.
	 * 
	 * @return Vrai si la liste est vide, sinon faux
	 */
	public boolean estVide() {
		return liste.isEmpty();
	}

	/**
	 * Retourne un itérateur sur la liste courante.
	 * 
	 * @return Itérateur sur la liste courante.
	 */
	public ListIterator<T> iterateur() {
		ListIterator<T> it = liste.listIterator();
		return it;
	}
	
	
	
}
