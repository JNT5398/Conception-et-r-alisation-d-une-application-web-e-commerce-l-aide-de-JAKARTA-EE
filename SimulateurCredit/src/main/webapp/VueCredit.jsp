<%@page import="web.CreditModel"%>
<%
 CreditModel mod =(CreditModel)request.getAttribute("mod");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simulateur Credit</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
 <form action="controleur.do" method="post">
    <table>
     <tr>
      <td>Montant:</td>
      <td><input type="text" name="montant" value="<%=mod.getMontant()%>"/></td>
      <td>DH</td>
     </tr>
     <tr>
      <td>Duree:</td>
      <td><input type="text" name="duree" value="<%=mod.getDuree()%>"/></td>
      <td>mois</td>
     </tr>
     <tr>
      <td>Taux:</td>
      <td><input type="text" name="taux" value="<%=mod.getTaux()%>"/></td>
      <td>%</td>
     </tr>
     <tr>
      <td><input type="submit" value="Calculer"/></td>
     </tr>
    </table>
 </form>
 <div>
   <table>
     <tr>
      <td>Mesualite:</td>
      <td><%=mod.getMensualite()%></td>
      <td>DH</td>
     </tr>
   </table>
 </div>
</body>
</html>