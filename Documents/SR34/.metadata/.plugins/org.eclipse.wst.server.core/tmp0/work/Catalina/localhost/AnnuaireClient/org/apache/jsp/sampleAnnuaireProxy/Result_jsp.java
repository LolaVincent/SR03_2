/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2016-06-08 19:42:46 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.sampleAnnuaireProxy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Result_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
 request.setCharacterEncoding("UTF-8"); 
      out.write("\n");
      out.write("<HTML>\n");
      out.write("<HEAD>\n");
      out.write("<TITLE>Result</TITLE>\n");
      out.write("</HEAD>\n");
      out.write("<BODY>\n");
      out.write("<H1>Result</H1>\n");
      out.write("\n");
      DefaultNamespace.AnnuaireProxy sampleAnnuaireProxyid = null;
      synchronized (session) {
        sampleAnnuaireProxyid = (DefaultNamespace.AnnuaireProxy) _jspx_page_context.getAttribute("sampleAnnuaireProxyid", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (sampleAnnuaireProxyid == null){
          sampleAnnuaireProxyid = new DefaultNamespace.AnnuaireProxy();
          _jspx_page_context.setAttribute("sampleAnnuaireProxyid", sampleAnnuaireProxyid, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\n');

if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAnnuaireProxyid.setEndpoint(request.getParameter("endpoint"));

      out.write('\n');
      out.write('\n');

String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAnnuaireProxyid.getEndpoint();
if(getEndpoint2mtemp == null){

      out.write('\n');
      out.print(getEndpoint2mtemp );
      out.write('\n');

}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultreturnp3 );
      out.write("\n");
      out.write("        ");

}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAnnuaireProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        DefaultNamespace.Annuaire getAnnuaire10mtemp = sampleAnnuaireProxyid.getAnnuaire();
if(getAnnuaire10mtemp == null){

      out.write('\n');
      out.print(getAnnuaire10mtemp );
      out.write('\n');

}else{
        if(getAnnuaire10mtemp!= null){
        String tempreturnp11 = getAnnuaire10mtemp.toString();
        
      out.write("\n");
      out.write("        ");
      out.print(tempreturnp11);
      out.write("\n");
      out.write("        ");

        }}
break;
case 13:
        gotMethod = true;
        String annonce_id_1id=  request.getParameter("annonce_id16");
        int annonce_id_1idTemp  = Integer.parseInt(annonce_id_1id);
        sampleAnnuaireProxyid.suppressionAnnonce(annonce_id_1idTemp);
break;
case 18:
        gotMethod = true;
        String sujet_2id=  request.getParameter("sujet21");
            java.lang.String sujet_2idTemp = null;
        if(!sujet_2id.equals("")){
         sujet_2idTemp  = sujet_2id;
        }
        beans.Annonce[] affichageAnnonceCategorie18mtemp = sampleAnnuaireProxyid.affichageAnnonceCategorie(sujet_2idTemp);
if(affichageAnnonceCategorie18mtemp == null){

      out.write('\n');
      out.print(affichageAnnonceCategorie18mtemp );
      out.write('\n');

}else{
        String tempreturnp19 = null;
        if(affichageAnnonceCategorie18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(affichageAnnonceCategorie18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        
      out.write("\n");
      out.write("        ");
      out.print(tempreturnp19);
      out.write("\n");
      out.write("        ");

}
break;
case 23:
        gotMethod = true;
        String adresse_3id=  request.getParameter("adresse26");
            java.lang.String adresse_3idTemp = null;
        if(!adresse_3id.equals("")){
         adresse_3idTemp  = adresse_3id;
        }
        beans.Annonce[] affichageAnnonceAdresse23mtemp = sampleAnnuaireProxyid.affichageAnnonceAdresse(adresse_3idTemp);
if(affichageAnnonceAdresse23mtemp == null){

      out.write('\n');
      out.print(affichageAnnonceAdresse23mtemp );
      out.write('\n');

}else{
        String tempreturnp24 = null;
        if(affichageAnnonceAdresse23mtemp != null){
        java.util.List listreturnp24= java.util.Arrays.asList(affichageAnnonceAdresse23mtemp);
        tempreturnp24 = listreturnp24.toString();
        }
        
      out.write("\n");
      out.write("        ");
      out.print(tempreturnp24);
      out.write("\n");
      out.write("        ");

}
break;
case 28:
        gotMethod = true;
        beans.Annonce[] affichageAnnonce28mtemp = sampleAnnuaireProxyid.affichageAnnonce();
if(affichageAnnonce28mtemp == null){

      out.write('\n');
      out.print(affichageAnnonce28mtemp );
      out.write('\n');

}else{
        String tempreturnp29 = null;
        if(affichageAnnonce28mtemp != null){
        java.util.List listreturnp29= java.util.Arrays.asList(affichageAnnonce28mtemp);
        tempreturnp29 = listreturnp29.toString();
        }
        
      out.write("\n");
      out.write("        ");
      out.print(tempreturnp29);
      out.write("\n");
      out.write("        ");

}
break;
case 31:
        gotMethod = true;
        String nom_4id=  request.getParameter("nom48");
            java.lang.String nom_4idTemp = null;
        if(!nom_4id.equals("")){
         nom_4idTemp  = nom_4id;
        }
        beans.Annonce affichageAnnonceNom31mtemp = sampleAnnuaireProxyid.affichageAnnonceNom(nom_4idTemp);
if(affichageAnnonceNom31mtemp == null){

      out.write('\n');
      out.print(affichageAnnonceNom31mtemp );
      out.write('\n');

}else{

      out.write("\n");
      out.write("<TABLE>\n");
      out.write("<TR>\n");
      out.write("<TD COLSPAN=\"3\" ALIGN=\"LEFT\">returnp:</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">numero:</TD>\n");
      out.write("<TD>\n");

if(affichageAnnonceNom31mtemp != null){
java.lang.String typenumero34 = affichageAnnonceNom31mtemp.getNumero();
        String tempResultnumero34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenumero34));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultnumero34 );
      out.write("\n");
      out.write("        ");

}
      out.write("\n");
      out.write("</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">nom:</TD>\n");
      out.write("<TD>\n");

if(affichageAnnonceNom31mtemp != null){
java.lang.String typenom36 = affichageAnnonceNom31mtemp.getNom();
        String tempResultnom36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenom36));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultnom36 );
      out.write("\n");
      out.write("        ");

}
      out.write("\n");
      out.write("</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">adresse:</TD>\n");
      out.write("<TD>\n");

if(affichageAnnonceNom31mtemp != null){
java.lang.String typeadresse38 = affichageAnnonceNom31mtemp.getAdresse();
        String tempResultadresse38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeadresse38));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultadresse38 );
      out.write("\n");
      out.write("        ");

}
      out.write("\n");
      out.write("</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">categorie:</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"1\" ALIGN=\"LEFT\">sujet:</TD>\n");
      out.write("<TD>\n");

if(affichageAnnonceNom31mtemp != null){
beans.Categorie tebece0=affichageAnnonceNom31mtemp.getCategorie();
if(tebece0 != null){
java.lang.String typesujet42 = tebece0.getSujet();
        String tempResultsujet42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesujet42));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultsujet42 );
      out.write("\n");
      out.write("        ");

}}
      out.write("\n");
      out.write("</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"1\" ALIGN=\"LEFT\">id:</TD>\n");
      out.write("<TD>\n");

if(affichageAnnonceNom31mtemp != null){
beans.Categorie tebece0=affichageAnnonceNom31mtemp.getCategorie();
if(tebece0 != null){

      out.write('\n');
      out.print(tebece0.getId()
);
}}
      out.write("\n");
      out.write("</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">id:</TD>\n");
      out.write("<TD>\n");

if(affichageAnnonceNom31mtemp != null){

      out.write('\n');
      out.print(affichageAnnonceNom31mtemp.getId()
);
}
      out.write("\n");
      out.write("</TD>\n");
      out.write("</TABLE>\n");

}
break;
case 50:
        gotMethod = true;
        beans.Categorie[] affichageCategorie50mtemp = sampleAnnuaireProxyid.affichageCategorie();
if(affichageCategorie50mtemp == null){

      out.write('\n');
      out.print(affichageCategorie50mtemp );
      out.write('\n');

}else{
        String tempreturnp51 = null;
        if(affichageCategorie50mtemp != null){
        java.util.List listreturnp51= java.util.Arrays.asList(affichageCategorie50mtemp);
        tempreturnp51 = listreturnp51.toString();
        }
        
      out.write("\n");
      out.write("        ");
      out.print(tempreturnp51);
      out.write("\n");
      out.write("        ");

}
break;
case 53:
        gotMethod = true;
        String categorie_5id=  request.getParameter("categorie56");
            java.lang.String categorie_5idTemp = null;
        if(!categorie_5id.equals("")){
         categorie_5idTemp  = categorie_5id;
        }
        sampleAnnuaireProxyid.creationCategorie(categorie_5idTemp);
break;
case 58:
        gotMethod = true;
        String sujet_6id=  request.getParameter("sujet61");
            java.lang.String sujet_6idTemp = null;
        if(!sujet_6id.equals("")){
         sujet_6idTemp  = sujet_6id;
        }
        String categorie_id_7id=  request.getParameter("categorie_id63");
        int categorie_id_7idTemp  = Integer.parseInt(categorie_id_7id);
        sampleAnnuaireProxyid.modificationCategorie(sujet_6idTemp,categorie_id_7idTemp);
break;
case 65:
        gotMethod = true;
        String categorie_id_8id=  request.getParameter("categorie_id68");
        int categorie_id_8idTemp  = Integer.parseInt(categorie_id_8id);
        String nom_9id=  request.getParameter("nom70");
            java.lang.String nom_9idTemp = null;
        if(!nom_9id.equals("")){
         nom_9idTemp  = nom_9id;
        }
        String adresse_10id=  request.getParameter("adresse72");
            java.lang.String adresse_10idTemp = null;
        if(!adresse_10id.equals("")){
         adresse_10idTemp  = adresse_10id;
        }
        String numero_11id=  request.getParameter("numero74");
            java.lang.String numero_11idTemp = null;
        if(!numero_11id.equals("")){
         numero_11idTemp  = numero_11id;
        }
        String annonce_id_12id=  request.getParameter("annonce_id76");
        int annonce_id_12idTemp  = Integer.parseInt(annonce_id_12id);
        sampleAnnuaireProxyid.modificationAnnonce(categorie_id_8idTemp,nom_9idTemp,adresse_10idTemp,numero_11idTemp,annonce_id_12idTemp);
break;
case 78:
        gotMethod = true;
        String categorie_id_13id=  request.getParameter("categorie_id81");
        int categorie_id_13idTemp  = Integer.parseInt(categorie_id_13id);
        sampleAnnuaireProxyid.suppressionCategorie(categorie_id_13idTemp);
break;
case 83:
        gotMethod = true;
        String sujet_14id=  request.getParameter("sujet86");
            java.lang.String sujet_14idTemp = null;
        if(!sujet_14id.equals("")){
         sujet_14idTemp  = sujet_14id;
        }
        String nom_15id=  request.getParameter("nom88");
            java.lang.String nom_15idTemp = null;
        if(!nom_15id.equals("")){
         nom_15idTemp  = nom_15id;
        }
        String adresse_16id=  request.getParameter("adresse90");
            java.lang.String adresse_16idTemp = null;
        if(!adresse_16id.equals("")){
         adresse_16idTemp  = adresse_16id;
        }
        String numero_17id=  request.getParameter("numero92");
            java.lang.String numero_17idTemp = null;
        if(!numero_17id.equals("")){
         numero_17idTemp  = numero_17id;
        }
        sampleAnnuaireProxyid.creationAnnonce(sujet_14idTemp,nom_15idTemp,adresse_16idTemp,numero_17idTemp);
break;
case 94:
        gotMethod = true;
        String sujet_18id=  request.getParameter("sujet101");
            java.lang.String sujet_18idTemp = null;
        if(!sujet_18id.equals("")){
         sujet_18idTemp  = sujet_18id;
        }
        beans.Categorie affichageCategorieNom94mtemp = sampleAnnuaireProxyid.affichageCategorieNom(sujet_18idTemp);
if(affichageCategorieNom94mtemp == null){

      out.write('\n');
      out.print(affichageCategorieNom94mtemp );
      out.write('\n');

}else{

      out.write("\n");
      out.write("<TABLE>\n");
      out.write("<TR>\n");
      out.write("<TD COLSPAN=\"3\" ALIGN=\"LEFT\">returnp:</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">sujet:</TD>\n");
      out.write("<TD>\n");

if(affichageCategorieNom94mtemp != null){
java.lang.String typesujet97 = affichageCategorieNom94mtemp.getSujet();
        String tempResultsujet97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesujet97));
        
      out.write("\n");
      out.write("        ");
      out.print( tempResultsujet97 );
      out.write("\n");
      out.write("        ");

}
      out.write("\n");
      out.write("</TD>\n");
      out.write("<TR>\n");
      out.write("<TD WIDTH=\"5%\"></TD>\n");
      out.write("<TD COLSPAN=\"2\" ALIGN=\"LEFT\">id:</TD>\n");
      out.write("<TD>\n");

if(affichageCategorieNom94mtemp != null){

      out.write('\n');
      out.print(affichageCategorieNom94mtemp.getId()
);
}
      out.write("\n");
      out.write("</TD>\n");
      out.write("</TABLE>\n");

}
break;
}
} catch (Exception e) { 

      out.write("\n");
      out.write("Exception: ");
      out.print( org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) );
      out.write("\n");
      out.write("Message: ");
      out.print( org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) );
      out.write('\n');

return;
}
if(!gotMethod){

      out.write("\n");
      out.write("result: N/A\n");

}

      out.write("\n");
      out.write("</BODY>\n");
      out.write("</HTML>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
