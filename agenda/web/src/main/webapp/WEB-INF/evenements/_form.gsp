<form method="POST" action="<%= action %>">
  <label for="nom">Nom:</label>
  <input type="text" name="nom" value="<%= evenement.nom ?: '' %>">
  <br>
  <label for="du">Du:</label>
  <input type="text" name="du" value="<%= evenement.du ?: '' %>">
  <br>
  <label for="au">Au:</label>
  <input type="text" name="au" value="<%= evenement.au ?: '' %>">
  <br>
  <input type="submit" value="<%= submitName %>" />
</form>
