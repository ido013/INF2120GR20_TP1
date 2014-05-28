package ca.uqam.inf2120.tp1.adt.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.tp1.adt.ListePrioriteTda;
import ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl;

/**
 * UQAM - Été 2014 - INF2120 - Groupe 20 - TP1
 * 
 * ListePrioriteImplTest : Classe de test de ListePrioriteImpl.
 * 
 * @author Bernatchez, Jonathan et BERJ23118609
 * @version 27 mai 2014
 */
public class ListePrioriteImplTest {
	
	ListePrioriteTda<ElementT> listePriorite;
	ElementT elt1, elt2, elt3, elt4, elt5, elt6, elt7, elt8;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		listePriorite = new ListePrioriteImpl<ElementT>();
		elt1 = new ElementT("elt1",1);
		elt2 = new ElementT("elt2",2);
		elt3 = new ElementT("elt3",3);
		elt4 = new ElementT("elt4",4);
		elt5 = new ElementT("elt5",5);
		elt6 = new ElementT("elt6",6);
		elt7 = new ElementT("elt7",1);
		elt8 = new ElementT("elt8",2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		listePriorite = null;
		elt1 = null;
		elt2 = null;
		elt3 = null;
		elt4 = null;
		elt5 = null;
		elt6 = null;
		elt7 = null;
		elt8 = null;
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#ListePrioriteImpl()}.
	 */
	//@Test
	//public void testListePrioriteImpl() {
	//	fail("Not yet implemented");
	//}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#ajouter(ca.uqam.inf2120.tp1.adt.Priorite)}.
	 */
	@Test
	public void testAjouterT() {
		listePriorite.ajouter(elt1);
		assertFalse(listePriorite.estVide());
		
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#ajouter(java.util.List)}.
	 */
	@Test
	public void testAjouterListOfT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#supprimer(ca.uqam.inf2120.tp1.adt.Priorite)}.
	 */
	@Test
	public void testSupprimerT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#supprimer(java.util.List)}.
	 */
	@Test
	public void testSupprimerListOfT() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#supprimer(int)}.
	 */
	@Test
	public void testSupprimerInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#supprimer(int, boolean)}.
	 */
	@Test
	public void testSupprimerIntBoolean() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#remplacer(int, int)}.
	 */
	@Test
	public void testRemplacer() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#ObtenirNbElments(int)}.
	 */
	@Test
	public void testObtenirNbElments() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#estVide()}.
	 */
	@Test
	public void testEstVide() {
		assertTrue(listePriorite.estVide());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.tp1.adt.impl.ListePrioriteImpl#iterateur()}.
	 */
	@Test
	public void testIterateur() {
		fail("Not yet implemented");
	}

}
