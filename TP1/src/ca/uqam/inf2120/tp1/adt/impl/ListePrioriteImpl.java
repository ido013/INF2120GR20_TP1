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

	private List<T> liste = new ArrayList<T>();
	
	// Constructeur
	public ListePrioriteImpl() {
		liste = new ArrayList<T>();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#ajouter(ca.uqam.inf2120.tp1.adt.Priorite)
	 */
	@Override
	public boolean ajouter(T elt) {
		boolean reponse=false;
		boolean fin=false;
		if(elt!=null && !liste.contains(elt) && !(elt.obtenirPriorite()<=0)){
			ListIterator<T> it = liste.listIterator();
			while (it.hasNext() && !fin) {
				if(it.next().obtenirPriorite()==elt.obtenirPriorite()){
					liste.add(it.nextIndex()+1,elt);
					fin=true;
				}else if(it.next().obtenirPriorite()<elt.obtenirPriorite()){
					it.next();
				}else if(it.next().obtenirPriorite()>elt.obtenirPriorite()){
					liste.add(it.nextIndex(),elt);
				}
			}
		}
		
		return reponse;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#ajouter(java.util.List)
	 */
	@Override
	public void ajouter(List<T> liste) {
		// TODO Auto-generated method stub
		
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
	public boolean supprimer(int priorite, boolean plusPetit) {
		// TODO Auto-generated method stub
		return false;
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
	@Override
	public boolean estVide() {
		return liste.isEmpty();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#iterateur()
	 */
	@Override
	public ListIterator<T> iterateur() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
