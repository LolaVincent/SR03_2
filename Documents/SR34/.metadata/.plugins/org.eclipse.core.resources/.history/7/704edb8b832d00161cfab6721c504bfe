package DefaultNamespace;

public class AnnuaireProxy implements DefaultNamespace.Annuaire {
  private String _endpoint = null;
  private DefaultNamespace.Annuaire annuaire = null;
  
  public AnnuaireProxy() {
    _initAnnuaireProxy();
  }
  
  public AnnuaireProxy(String endpoint) {
    _endpoint = endpoint;
    _initAnnuaireProxy();
  }
  
  private void _initAnnuaireProxy() {
    try {
      annuaire = (new DefaultNamespace.AnnuaireServiceLocator()).getAnnuaire();
      if (annuaire != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)annuaire)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)annuaire)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (annuaire != null)
      ((javax.xml.rpc.Stub)annuaire)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.Annuaire getAnnuaire() {
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire;
  }
  
  public void modificationCategorie(java.lang.String sujet, int categorie_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.modificationCategorie(sujet, categorie_id);
  }
  
  public void modificationAnnonce(int categorie_id, java.lang.String nom, java.lang.String adresse, java.lang.String numero, int annonce_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.modificationAnnonce(categorie_id, nom, adresse, numero, annonce_id);
  }
  
  public void creationAnnonce(int categorie_id, java.lang.String nom, java.lang.String adresse, java.lang.String numero) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.creationAnnonce(categorie_id, nom, adresse, numero);
  }
  
  public void creationCategorie(java.lang.String categorie) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.creationCategorie(categorie);
  }
  
  public beans.Annonce[] affichageAnnonceAdresse(java.lang.String adresse) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.affichageAnnonceAdresse(adresse);
  }
  
  public beans.Annonce[] affichageAnnonce() throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.affichageAnnonce();
  }
  
  public beans.Annonce affichageAnnonceNom(java.lang.String nom) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.affichageAnnonceNom(nom);
  }
  
  public void suppressionCategorie(int categorie_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.suppressionCategorie(categorie_id);
  }
  
  public void suppressionAnnonce(int annonce_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    annuaire.suppressionAnnonce(annonce_id);
  }
  
  public beans.Annonce[] affichageAnnonceCategorie(int categorie_id) throws java.rmi.RemoteException{
    if (annuaire == null)
      _initAnnuaireProxy();
    return annuaire.affichageAnnonceCategorie(categorie_id);
  }
  
  
}