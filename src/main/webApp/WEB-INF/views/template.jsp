<%@page language = "java" pageEncoding="utf-8" %>
<%  String nomPage = (String) request.getAttribute("page") + ".jsp"; %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/style.css">
    <title>Document</title>
    <style>
        #sideBar{
            height: 100vh;
            position: fixed;
        }
        .droite{
            margin-left: 280px ;
            padding-top: 25px;
        }
    </style>

</head>
<body>
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px; overflow: auto; " id="sideBar"  >
        <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
          <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-4"> KODORO</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
          <li>
            <a href="/bloc/new" class="nav-link text-white <% if(nomPage.compareToIgnoreCase("pages/insert-bloc.jsp")==0) { out.print("active"); } %> "  >
              <svg class="bi me-2" width="16" height="16"><use xlink:href="#speedometer2"/></svg>
              BLOC
            </a>
          </li>

          <li>
            <a href="/transformation/new" class="nav-link text-white <% if(nomPage.compareToIgnoreCase("pages/transformation.jsp")==0) { out.print("active"); } %>">
              <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
              TRANSFORMATION
            </a>
          </li>
          <li>
            <a href="/result-trans" class="nav-link text-white <% if(nomPage.compareToIgnoreCase("pages/resultat-trans.jsp")==0) { out.print("active"); } %> "  >
              <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
              RESULTAT Trans
            </a>
          </li>
          <li>
            <a href="/bloc/new_update" class="nav-link text-white <% if(nomPage.compareToIgnoreCase("pages/update_prix_revient.jsp")==0) { out.print("active"); } %> " >
              <svg class="bi me-2" width="16" height="16"><use xlink:href="#table"/></svg>
              Update Revient
            </a>
          </li>

      </div>
      <div class="droite">
        <div class="container">
          <jsp:include page="<%= nomPage  %>" />
        </div>
    </div>
    <% if(request.getAttribute("message")!=null){ %>
      <script> 
        console.log("passeerrrrrrr");
        alert('<%= (String) request.getAttribute("message") %>'); 
      </script>
    <% } %>
    <script src="assets/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="asssets/bootstrap/js/bootstrap.js"></script>
</body>
</html>