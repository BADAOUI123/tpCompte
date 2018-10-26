/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Compte;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc asus
 */
public class CompteService extends AbstractFacade<Compte> {

    public CompteService() {
        super(Compte.class);
    }

    public Compte ouvrirCompte(String rib, double soldeInitial) {
        Compte c1 = new Compte();
        c1.setRib(rib);
        c1.setSolde(soldeInitial);
        c1.setOuvert(true);
        if (soldeInitial > 0 && soldeInitial < 200) {
            c1.setClasse('D');
        } else if (soldeInitial >= 200 && soldeInitial < 1000) {
            c1.setClasse('C');
        } else if (soldeInitial >= 1000 && soldeInitial < 6000) {
            c1.setClasse('B');
        } else {
            c1.setClasse('A');
        }
        create(c1);
        return c1;

    }

    public int fermerCompte(String rib) {
        Compte c1 = find(rib);
        if (c1 == null) {
            return -2;
        } else if (c1.isOuvert() == false) {
            return -1;
        } else if (c1.getSolde() > 0) {
            return -2;
        } else {
            c1.setOuvert(false);
            edit(c1);
            return 1;
        }
    }

    public int crediter(String rib, double montantCredit) {
        Compte c1 = find(rib);
        if (c1 == null) {
            return -2;
        } else if (c1.isOuvert() == false) {
            return -1;
        } else {
            c1.setSolde(montantCredit + c1.getSolde());
            edit(c1);
            return 1;
        }
    }

    public int debiter(String rib, double montantDebit) {
        Compte c1 = find(rib);
        if (c1 == null) {
            return -5;
        } else if (c1.isOuvert() == false) {
            return -1;
        } else if (montantDebit > c1.getSolde()) {
            return -2;
        } else if ((c1.getSolde() - montantDebit) < 100) {
            return -3;
        } else if (montantDebit > 6000) {
            return -4;
        } else {
            c1.setSolde(c1.getSolde() - montantDebit);
            edit(c1);
            return 1;
        }
    }

    public int transferer(String rib, String rib2, double montant) {
        Compte c1, c2 = new Compte();
        c1 = find(rib);
        c2 = find(rib2);
        if (c1 == null || c2 == null) {
            return -3;
        } else {
            if (c1.isOuvert() == false || c2.isOuvert() == false) {
                return -1;
            } else if (montant > c1.getSolde()) {
                return -2;
            } else {
                c1.setSolde(c1.getSolde() - montant);
                c2.setSolde(c2.getSolde() + montant);
                edit(c1);
                edit(c2);
                return 1;
            }
        }

    }

    public List<Compte> searchByCreteria(String rib, Double soldeMin, Double soldeMax) {
        String query = constuctQuery(rib, soldeMin, soldeMax);
        return getEntityManager().createQuery(query).getResultList();
    }

    private String constuctQuery(String rib, Double soldeMin, Double soldeMax) {
        String query = "SELECT c FROM Compte c where 1=1";
        if (rib != null && !rib.equals("")) {
            query += " AND c.rib='" + rib + "'";
            return query;
        }
        if (soldeMin != null && !soldeMin.equals("")) {
            query += " AND c.solde >='" + soldeMin + "'";
        }
        if (soldeMax != null && !soldeMax.equals("")) {
            query += " AND c.solde <='" + soldeMax + "'";
        }
        System.out.println("the query is ==>" + query);
        return query;
    }

    public int delete(String rib) {
        Compte compte = find(rib);
        if (compte == null) {
            return -1;
        } else if (compte.getSolde() != 0) {
            return -2;
        } else {
            remove(compte);
            return 1;
        }
    }

}
