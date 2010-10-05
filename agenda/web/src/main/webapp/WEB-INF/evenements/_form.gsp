<form method="POST" action="<%= action %>" encoding="UTF-8">
  <input type="hidden" name="id" value="<%= evenement.id ?: '' %>">
  <label for="nom">Nom:</label>
  <input type="text" name="nom" value="<%= evenement.nom ?: '' %>">
  <br>
  <label for="du">Du:</label>
  <input type="text" name="du" value='<%= evenement.du?.format("yyyy-MM-dd'T'HH:mm") ?: '' %>'>
  <br>
  <label for="au">Au:</label>
  <input type="text" name="au" value='<%= evenement.au?.format("yyyy-MM-dd'T'HH:mm") ?: '' %>'>
  <br>
  <input type="submit" value="<%= submitName %>" />
</form>
