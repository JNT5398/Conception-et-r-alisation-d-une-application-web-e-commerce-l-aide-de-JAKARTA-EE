 <main id="rightCol" style="overflow: auto">
<div class="rechC">
   <div><h2>Recherche de client:</h2></div>
   <div>
    <form action="chercherC.do" method="get">
      <label>Mot cle:</label>
      <input type= "text" name = "motCle" value="${model.motCle}"/>
      <button type = "submit">Chercher</button>
    </form>
    <table border="1">
     <tr>
         <th>ID</th>
         <th>Nom</th>
         <th>Prenom</th>
         <th>Adresse</th>
         <th>Email</th>
         <th>Numero de Tele</th>
         <th>Password</th>
     </tr>
         <c:forEach items= "${model.client}" var="c">
           <tr> 
             <td>${c.getId()}</td>
             <td>${c.getNom()}</td>
             <td>${c.getPrenom()}</td>
             <td>${c.getAdresse()}</td>
             <td>${c.getEmail()}</td>
             <td>${c.getTele()}</td>
             <td>${c.getPassword()}</td>
             <td><a onclick="return confirm('Etes vous sure?')" href= "Supprimer.do?id=${c.getId()}">SUPPRIMER</a></td>
             <td><a href= "Edit.do?id=${c.getId()}">MODIFIER</a></td> 
             </tr>
         </c:forEach>
    </table>
   </div>
 </div>
 </main>