/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.33
 * Generated at: 2016-05-27 07:40:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminCreationQuestion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Creation Question</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<form  method=\"post\" action=\"CreationQuestion\">\n");
      out.write("\t\t<input type=\"hidden\" name =\"titre\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${titre}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></input>\n");
      out.write("\t\t<label for=\"question\"><br>Question: </label>\n");
      out.write("\t\t<input type=\"text\" name=\"question\" id=\"question\"></input>\n");
      out.write("\t\t\t<label for=\"reponse1\"><br> &nbsp; Réponse 1 :</label>\n");
      out.write("\t\t\t<input type=\"text\" name=\"reponse1\" id=\"reponse1\"></input>\n");
      out.write("\t\t\t<input type=\"number\" name=\"reponse1number\"></input>\n");
      out.write("\t\t\t<label for=\"reponse2\"><br> &nbsp; Réponse 2 :</label>\n");
      out.write("\t\t\t<input type=\"text\" name=\"reponse2\" id=\"reponse2\"></input>\n");
      out.write("\t\t\t<input type=\"number\" name=\"reponse2number\"></input>\n");
      out.write("\t\t\t<label for=\"reponse3\"><br> &nbsp; Réponse 3 :</label>\n");
      out.write("\t\t\t<input type=\"text\" name=\"reponse3\" id=\"reponse3\"></input>\n");
      out.write("\t\t\t<input type=\"number\" name=\"reponse3number\"></input>\n");
      out.write("\t\t\t<label for=\"reponse4\"><br> &nbsp; Réponse 4 :</label>\n");
      out.write("\t\t\t<input type=\"text\" name=\"reponse4\" id=\"reponse4\"></input>\n");
      out.write("\t\t\t<input type=\"number\" name=\"reponse4number\"></input>\n");
      out.write("\t\t\t<label for=\"bonneReponse\"><br> &nbsp; Veuillez sélectionner la bonne réponse :</label>\n");
      out.write("\t\t\t<select name=\"bonneReponse\" id=\"bonneReponse\">\n");
      out.write("\t\t\t\t<option value=\"reponse1\">Réponse 1</option>\n");
      out.write("\t\t\t\t<option value=\"reponse2\">Réponse 2</option>\n");
      out.write("\t\t\t\t<option value=\"reponse3\">Réponse 3</option>\n");
      out.write("\t\t\t\t<option value=\"reponse4\">Réponse 4</option>\n");
      out.write("\t\t\t</select>\n");
      out.write("\t\t\t<input type=\"submit\" value=\"Question Suivante\"></input>\n");
      out.write("\t</form>\n");
      out.write("\t<form action=\"admin\" method=\"get\">\n");
      out.write("    \t<input type=\"submit\" value=\"Fin\"/>\n");
      out.write("\t</form>\n");
      out.write("</body>\n");
      out.write("</html>");
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
