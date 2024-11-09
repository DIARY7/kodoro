<%@ page import="java.util.List" %>
<%@ page import="com.kodoro.kodoro.model.Usuel" %>
<%@ page import="com.kodoro.kodoro.model.Bloc" %>

<% List<Usuel> usuels = (List<Usuel>) request.getAttribute("usuel");   %>
<% List<Bloc> blocs = (List<Bloc>) request.getAttribute("blocDispo"); %>

<div class="containForm">
<h1> Insertion transformation </h1>
<form action="/transform/insert" method="post">
    <div>
        <label for="idBloc" class="form-label"> BLOC:  </label>
        <select class="form-select" name="idBloc" id="idBloc" >
            <% for(int i=0;i < blocs.size();i++){ %>
                <option value="<%= blocs.get(i).getId() %>"> N<sup>0</sup> <%= blocs.get(i).getId() %></option>
            <% } %>
        </select>
    </div>
    <div>
        <% for(int i=0;i < usuels.size();i++ ){ %>
            <label for="usuel<%= usuels.get(i).getId() %>" class="form-label"> <%= usuels.get(i).getDesignation() %> </label>
            <input type="number" name="usuel<%= usuels.get(i).getId() %>" id="usuel<%= usuels.get(i).getId() %>" value="0" class="form-control" >
        <% } %>
    </div>
    <div>
        <label for="reste" class="form-label"> Reste </label>
        <div class="form-floating">
            <input type="text" class="form-control" id="longueur" name="longueur" >
            <label for="longueur">Longueur</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="largeur" name="largeur" >
            <label for="largeur">Largeur</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="hauteur" name="hauteur" >
            <label for="hauteur">Hauteur</label>
        </div>
    </div>
    
    <div>
        <label for="daty" class="form-label"> Daty </label>
        <input type="date" name="daty" id="daty" class="form-control" >
        
    </div>

    <div class="div_btn_sub" >
        <input type="submit" class=" form-control btn btn-danger"  value="Valider" >
    </div>
</form>
</div>
