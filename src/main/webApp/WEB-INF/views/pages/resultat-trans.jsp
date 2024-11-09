<%@ page import="java.util.List" %>
<%@ page import="com.kodoro.kodoro.dto.ResultTabUsuel" %>

<% List<ResultTabUsuel> listeTabUsuels = (List<ResultTabUsuel>) request.getAttribute("tabUsuel"); 
  ResultTabUsuel tabBenef = (ResultTabUsuel) request.getAttribute("tabMaxBenef");
  ResultTabUsuel tabMinPerte = (ResultTabUsuel) request.getAttribute("tabMinPerte"); 
%> 
<h1> RESULTAT TRANSFORMATION </h1>
<table class="table">
    <thead>
      <tr class="table-dark">
        <th scope="col">Usuels</th>
        <th scope="col">Quantite</th>
        <th scope="col">Prix de Revient</th>
        <th scope="col">Prix de Vente</th>
      </tr>
    </thead>
    <tbody>
      <% for(int i=0;i < listeTabUsuels.size();i++){ %>
        <tr>
          <td><%= listeTabUsuels.get(i).getDesignation() %></td>
          <td><%= listeTabUsuels.get(i).getQuantite() %></td>
          <td><%= listeTabUsuels.get(i).getPrixRevient() %></td>
          <td><%= listeTabUsuels.get(i).getPrixVente() %></td>
        </tr>
      <% } %>
      <tr scope="row">
        <td colspan="2" >SOMME</td>
        <td><%= ResultTabUsuel.getSommeRevient(listeTabUsuels) %></td>
        <td><%= ResultTabUsuel.getSommeVente(listeTabUsuels) %></td>
      </tr>
    </tbody>
</table>
<table class="table" >
  <tr>
    <td scope="col" >Reste</td>
    <td scope="col" ><%= (double) request.getAttribute("volReste")  %></td>
  </tr>
</table>

<h3> Maximum de Benefice </h3>
<table class="table">
  <thead>
    <tr class="table-dark">
      <th scope="col">Usuel</th>
      <th scope="col">Quantite</th>
      <th scope="col">Prix de Revient</th>
      <th scope="col">Prix de Vente</th>
      <th scope="col" > Volume Reste </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= tabBenef.getDesignation() %></td>
      <td><%= tabBenef.getQuantite() %></td>
      <td><%= tabBenef.getPrixRevient()  %></td>
      <td><%= tabBenef.getPrixVente() %></td>
      <td><%= tabBenef.getReste() %></td>
    </tr>
  </tbody>
</table>

<h3> Minimum de Perte </h3>
<table class="table">
  <thead>
    <tr class="table-dark">
      <th scope="col">Usuel</th>
      <th scope="col">Quantite</th>
      <th scope="col">Prix de Revient</th>
      <th scope="col">Prix de Vente</th>
      <th scope="col" > Volume Reste </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= tabMinPerte.getDesignation() %></td>
      <td><%= tabMinPerte.getQuantite() %></td>
      <td><%= tabMinPerte.getPrixRevient()  %></td>
      <td><%= tabMinPerte.getPrixVente() %></td>
      <td><%= tabMinPerte.getReste() %></td>
    </tr>
  </tbody>
</table>



