<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAnnuaireProxyid" scope="session" class="DefaultNamespace.AnnuaireProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAnnuaireProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
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
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
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
%>
<%=getAnnuaire10mtemp %>
<%
}else{
        if(getAnnuaire10mtemp!= null){
        String tempreturnp11 = getAnnuaire10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
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
%>
<%=affichageAnnonceCategorie18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(affichageAnnonceCategorie18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(affichageAnnonceCategorie18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
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
%>
<%=affichageAnnonceAdresse23mtemp %>
<%
}else{
        String tempreturnp24 = null;
        if(affichageAnnonceAdresse23mtemp != null){
        java.util.List listreturnp24= java.util.Arrays.asList(affichageAnnonceAdresse23mtemp);
        tempreturnp24 = listreturnp24.toString();
        }
        %>
        <%=tempreturnp24%>
        <%
}
break;
case 28:
        gotMethod = true;
        beans.Annonce[] affichageAnnonce28mtemp = sampleAnnuaireProxyid.affichageAnnonce();
if(affichageAnnonce28mtemp == null){
%>
<%=affichageAnnonce28mtemp %>
<%
}else{
        String tempreturnp29 = null;
        if(affichageAnnonce28mtemp != null){
        java.util.List listreturnp29= java.util.Arrays.asList(affichageAnnonce28mtemp);
        tempreturnp29 = listreturnp29.toString();
        }
        %>
        <%=tempreturnp29%>
        <%
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
%>
<%=affichageAnnonceNom31mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">numero:</TD>
<TD>
<%
if(affichageAnnonceNom31mtemp != null){
java.lang.String typenumero34 = affichageAnnonceNom31mtemp.getNumero();
        String tempResultnumero34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenumero34));
        %>
        <%= tempResultnumero34 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nom:</TD>
<TD>
<%
if(affichageAnnonceNom31mtemp != null){
java.lang.String typenom36 = affichageAnnonceNom31mtemp.getNom();
        String tempResultnom36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenom36));
        %>
        <%= tempResultnom36 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">adresse:</TD>
<TD>
<%
if(affichageAnnonceNom31mtemp != null){
java.lang.String typeadresse38 = affichageAnnonceNom31mtemp.getAdresse();
        String tempResultadresse38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeadresse38));
        %>
        <%= tempResultadresse38 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">categorie:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">sujet:</TD>
<TD>
<%
if(affichageAnnonceNom31mtemp != null){
beans.Categorie tebece0=affichageAnnonceNom31mtemp.getCategorie();
if(tebece0 != null){
java.lang.String typesujet42 = tebece0.getSujet();
        String tempResultsujet42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesujet42));
        %>
        <%= tempResultsujet42 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">id:</TD>
<TD>
<%
if(affichageAnnonceNom31mtemp != null){
beans.Categorie tebece0=affichageAnnonceNom31mtemp.getCategorie();
if(tebece0 != null){
%>
<%=tebece0.getId()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(affichageAnnonceNom31mtemp != null){
%>
<%=affichageAnnonceNom31mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 50:
        gotMethod = true;
        beans.Categorie[] affichageCategorie50mtemp = sampleAnnuaireProxyid.affichageCategorie();
if(affichageCategorie50mtemp == null){
%>
<%=affichageCategorie50mtemp %>
<%
}else{
        String tempreturnp51 = null;
        if(affichageCategorie50mtemp != null){
        java.util.List listreturnp51= java.util.Arrays.asList(affichageCategorie50mtemp);
        tempreturnp51 = listreturnp51.toString();
        }
        %>
        <%=tempreturnp51%>
        <%
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
%>
<%=affichageCategorieNom94mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">sujet:</TD>
<TD>
<%
if(affichageCategorieNom94mtemp != null){
java.lang.String typesujet97 = affichageCategorieNom94mtemp.getSujet();
        String tempResultsujet97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesujet97));
        %>
        <%= tempResultsujet97 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(affichageCategorieNom94mtemp != null){
%>
<%=affichageCategorieNom94mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>