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
 * @version 8 juin 2014
 */
public class ListePrioriteImpl<T extends Priorite> implements ListePrioriteTda<T> {

	private List<T> liste;
	
	// Constructeur de la liste
	public ListePrioriteImpl() {
		liste = new ArrayList<T>();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#ajouter(T)
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

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#ajouter(List<T>)
	 */
	public void ajouter(List<T> liste) {
		if(liste!=null){
			for(T i: liste){
				this.ajouter(i);
			}
		}
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(T)
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

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(List<T>)
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

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(int)
	 */
	public List<T> supprimer(int priorite) {
		List<T> listRet = new ArrayList<T>();
		int counter=0;
		for(T i: liste){
			int prioList = i.obtenirPriorite();
			if(prioList==priorite){
				listRet.add(i);
				counter++;
			}
		}
		if(counter!=0){
			this.supprimer(listRet);
		}else{
			listRet=null;
		}
		return listRet;
	}


	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#supprimer(int, boolean)
	 */
	public List<T> supprimer(int priorite, boolean plusPetit) {
		List<T> listRet = new ArrayList<T>();
		List<T> listTmp = new ArrayList<T>();
		int counter=0;
		if(liste!=null){
			if(plusPetit && priorite!=1){ //Si priorite est 1 on a rien a effacer
				for(int i=priorite-1; i>0; i--){
					if(this.ObtenirNbElments(i)!=0){
						listTmp = this.supprimer(i);
						listRet.addAll(listTmp);
						counter++;
					}
				}
			}else if(!plusPetit){
				int prioMaxInd = 0; 
				int prioMinInd = 0;
				// On parcours la liste pour obtenir les indices max et min
				for(int i = 0; i < liste.size(); i++){
					int prioMax = liste.get(0).obtenirPriorite();
					if(liste.get(i).obtenirPriorite()<=prioMax){
						if(liste.get(i).obtenirPriorite()>priorite){
							prioMinInd = i;
						}
					}
				}
				
				if(prioMinInd!=0){ // On enregistre la liste de retour avec le max et min
					for(int i=prioMaxInd; i<=prioMinInd; i++){
						listRet.add(liste.get(i));
						counter++;
					}
				}
				this.supprimer(listRet);
			}
		}
		if(counter==0){
			listRet = null;
		}
		
		return listRet;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#remplacer(int, int)
	 */
	public boolean remplacer(int anciennePriorite, int nouvellePriorite) {
		boolean reponse = false;
		List<T> listTmp = new ArrayList<T>();
		if(nouvellePriorite>0){
			if(this.ObtenirNbElments(anciennePriorite)!=0){
				reponse = true;
				for(T i: liste){
					if(i.obtenirPriorite()==anciennePriorite){
						listTmp.add(i);
					}
				}
				this.supprimer(listTmp);
				for(int i=0; i<listTmp.size(); i++){
					listTmp.get(i).modifierPriorite(nouvellePriorite);
				}
				this.ajouter(listTmp);
			}
		}
		return reponse;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#ObtenirNbElments(int)
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

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#estVide()
	 */
	public boolean estVide() {
		return liste.isEmpty();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.adt.ListePrioriteTda#iterateur()
	 */
	public ListIterator<T> iterateur() {
		ListIterator<T> it = liste.listIterator();
		return it;
	}
	
	
	
}
