<html>
<head>
  <title>Liste des événements</title>
</head>
<body>
  <h2>Liste des événements</h2>
  <ol>
    <% evenements.each { %>
    <li><%= it.inspect() %></li>
    <% } %>
  </ol>
</body>
</html>