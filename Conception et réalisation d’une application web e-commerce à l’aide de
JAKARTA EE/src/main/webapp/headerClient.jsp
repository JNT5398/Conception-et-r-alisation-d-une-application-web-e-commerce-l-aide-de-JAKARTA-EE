<div>
<div align="center">
 <table>
<tr>
  <th><a href="votreCompte.do">Votre Compte</a></th>
  <th><a href="Deconnection.do">Deconnection</a></th>
  
 </tr>
 </table>
 </div>
</div>
<c:if test="${ !empty sessionScope.Nom}">
         <h6 style="margin: 5px">Bienvenue: ${sessionScope.Nom } ${sessionScope.Prenom } </h6>
    </c:if>