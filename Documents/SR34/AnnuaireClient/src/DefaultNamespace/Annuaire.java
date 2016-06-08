/**
 * Annuaire.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface Annuaire extends java.rmi.Remote {
    public beans.Categorie affichageCategorieNom(java.lang.String sujet) throws java.rmi.RemoteException;
    public void suppressionAnnonce(int annonce_id) throws java.rmi.RemoteException;
    public beans.Annonce[] affichageAnnonceCategorie(java.lang.String sujet) throws java.rmi.RemoteException;
    public beans.Annonce[] affichageAnnonceAdresse(java.lang.String adresse) throws java.rmi.RemoteException;
    public beans.Annonce[] affichageAnnonce() throws java.rmi.RemoteException;
    public beans.Annonce affichageAnnonceNom(java.lang.String nom) throws java.rmi.RemoteException;
    public beans.Categorie[] affichageCategorie() throws java.rmi.RemoteException;
    public void creationAnnonce(java.lang.String sujet, java.lang.String nom, java.lang.String adresse, java.lang.String numero) throws java.rmi.RemoteException;
    public void creationCategorie(java.lang.String categorie) throws java.rmi.RemoteException;
    public void modificationCategorie(java.lang.String sujet, int categorie_id) throws java.rmi.RemoteException;
    public void modificationAnnonce(int categorie_id, java.lang.String nom, java.lang.String adresse, java.lang.String numero, int annonce_id) throws java.rmi.RemoteException;
    public void suppressionCategorie(int categorie_id) throws java.rmi.RemoteException;
}
