<html>
<head>
  <title>Liste des événements</title>
  <meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>
</head>
<body>
  <h2>Liste des événements</h2>
  <ol>
    <% evenements.each { %>
    <li><a href="edit.html?id=<%= it.id %>"><%= it.inspect() %></a></li>
    <% } %>
  </ol>
  <a href="new.html">Ajouter un nouvel événement</a>
</body>
</html>