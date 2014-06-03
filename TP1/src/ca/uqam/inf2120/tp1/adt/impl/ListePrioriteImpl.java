package ca.uqam.inf2120.tp1.adt.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
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

	private List<T> liste1;
	
	// Constructeur
	public ListePrioriteImpl() {
		liste1 = new ArrayList<T>();
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
		if(elt!=null && !liste1.contains(elt) && !(elt.obtenirPriorite()<=0)){
			if(liste1.size()==0){
				liste1.add(elt);
				reponse=true;
			}else{
				while (iterateur().hasNext() && !fin) {
					if(iterateur().next().obtenirPriorite()==elt.obtenirPriorite() || iterateur().next().obtenirPriorite()>elt.obtenirPriorite()){
						fin=false;
						reponse=false;		
					}else if(iterateur().next().obtenirPriorite()<elt.obtenirPriorite()){
						liste1.add(iterateur().nextIndex(),elt);
						fin=true;
						reponse=true;
					}else{
						liste1.add(elt);
						fin=true;
						reponse=true;
					}
				}
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
		Iterator<T> it = liste.iterator();
		while(it.hasNext()){
			//liste1.ajouter(it.next());
		}
		
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(ca.uqam.inf2120.tp1.adt.Priorite)
	 */
	@Override
	public boolean supprimer(T elt) {
		// TODO Auto-generated method stub
		return false;
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

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#ObtenirNbElments(int)
	 */
	@Override
	public int ObtenirNbElments(int priorite) {
		// TODO Auto-generated method stub
		return 0;
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
