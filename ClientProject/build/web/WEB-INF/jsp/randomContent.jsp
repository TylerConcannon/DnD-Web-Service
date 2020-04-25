<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>

<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
   <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .loot-catagory-selection{
        padding-bottom: 30px;
    }
    
    .loot-rarity-selection{
        padding-bottom: 35px;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {
        height: 450px;
/*        background: ghostwhite;
        background-image: url(images/darkwood.jpg);*/
    }
    
    .wrapper{
        min-height: calc(100vh - 50px - 60px);
        background-image: url(images/content.jpg);
        background-size: cover;
    }
    
    .home-buttons{
        display: flex;
    }
    
    .roll-button{
        margin: 20px;
    }
    
    .content-button{
        margin: 20px;
    }
    
    .encounter-button{
        margin: 20px;
    }
    
    .character-button{
        margin: 20px;
    }
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    .home-header{
        text-align: center;
    }
    
    .input-sides-text{
        color:white;
        font-size: large;
    }
    
    .dice-type{
        padding-bottom: 20px;
    }
    
    .dice-button{
        padding-bottom: 35px;
    }
    
    .num-sides-body{
        padding-bottom: 20px;
    }
    
    h1{
        color: white;
    }
    
     .btn-primary{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
    .btn-primary:hover{
       color: white;
       background-color: dimgrey;
       border-color: whitesmoke;
       box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    }
    
    .btn-primary:active{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
     .btn-primary:active:focus{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
    .btn-primary:focus{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
     .btn-primary:visited{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
    
    textarea.form-control {
    height: 175px;
    }
    
    .loot-name{
        padding-bottom: 30px;
    }
    
    .loot-rarity{
        padding-bottom: 30px;
    }
    
    .loot-catagory-creation{
        padding-bottom: 30px;
    }
    
    .loot-description{
        padding-bottom: 30px;
    }
    
    .loot-value{
        padding-bottom: 30px;
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="/ClientProject/">DnD Generator</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="/ClientProject/">Home</a></li>
        <li><a href="about.html">About</a></li>
        <li><a href="roll.html">Dice Roller</a></li>
        <li><a href="randomContent.html">Random Content Generator</a></li>
        <li><a href="randomEncounter.html">Random Encounter Generator</a></li>
        <li><a href="randomCharacter.html">Random Character Generator</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="wrapper">
      <div class="container-fluid text-center">    
        <div class="row content">
            <div class="col-sm-8 text-left"> 
             <h1 class="home-header">Random Content Generator</h1>
             <hr>
             <div class="dice-data">
             <div class="dice-type">
             <div class="loot-rarity-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Loot Rarity:</span>
                    <select id="rarity" class="browser-default custom-select">
                        <option selected>Select loot rarity:</option>
                        <option value="Mundane">Mundane</option>
                        <option value="Common">Common</option>
<!--                        <option value="Uncommon">Uncommon</option>-->
                        <option value="Rare">Rare</option>
                        <option value="Very Rare">Very Rare</option>
                        <option value="Legendary">Legendary</option>
                    </select>
             </div>
             <div class="loot-catagory-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Loot Category:</span>
                    <select id="type" class="browser-default custom-select">
                        <option selected>Select loot Category:</option>
                        <option value="Treasure">Treasure</option>
                        <option value="Weapon">Weapon</option>
                        <option value="Adventuring Gear">Adventuring Gear</option>
                        <option value="Book">Book</option>
                        <option value="Wondrous Item">Wondrous Item</option>
<!--                        <option value="Trap">Trap</option>-->
                        <option value="Armor">Armor</option>
<!--                        <option value="Shield">Shield</option>-->
                        <option value="Potion">Potion</option>
<!--                        <option value="Quest Hook">Quest Hook</option>-->
                        <option value="Ring">Ring</option>
<!--                        <option value="Rod">Rod</option>-->
                    </select>
             </div>
                 
                
                 <div class="dice-button">
                      <div class="dice-button">
                                <button onclick="getContent()" type="submit" class="btn btn-primary btn-lg">Generate Loot</button>
                        </div>
                 </div>
                 <form>
                        <div class="form-group-result">
                            <label class="input-sides-text" for="exampleFormControlTextarea1">Results:</label>
                            <textarea class="form-control" id="contentResults" rows="3" readonly></textarea>
                        </div>
                 </form>
                 <hr>
                  <div class="loot-creation">
                     <h1 class="home-header">Create Loot</h1>
                     <div class="loot-name">
                         <span class="input-sides-text" id="inputGroup-sizing-default">Loot Name:</span>
                         <input type="text" id="nameLoot" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                     </div>
                     <div class="loot-rarity">
                         <span class="input-sides-text" id="inputGroup-sizing-default">Loot Rarity:</span>
                        <select id="rarityCreation" class="browser-default custom-select">
                            <option selected>Select loot rarity:</option>
                            <option value="Mundane">Mundane</option>
                            <option value="Common">Common</option>
<!--                        <option value="Uncommon">Uncommon</option>-->
                            <option value="Rare">Rare</option>
                            <option value="Very Rare">Very Rare</option>
                            <option value="Legendary">Legendary</option>
                        </select>
                     </div>
                     <div class="loot-catagory-creation">
                         <span class="input-sides-text" id="inputGroup-sizing-default">Loot Category:</span>
                        <select id="createCatagory" class="browser-default custom-select">
                            <option selected>Select loot Category:</option>
                            <option value="Treasure">Treasure</option>
                            <option value="Weapon">Weapon</option>
                            <option value="Adventuring Gear">Adventuring Gear</option>
                            <option value="Book">Book</option>
                            <option value="Wondrous Item">Wondrous Item</option>
<!--                        <option value="Trap">Trap</option>-->
                            <option value="Armor">Armor</option>
<!--                        <option value="Shield">Shield</option>-->
                            <option value="Potion">Potion</option>
<!--                        <option value="Quest Hook">Quest Hook</option>-->
                            <option value="Ring">Ring</option>
<!--                        <option value="Rod">Rod</option>-->
                        </select>
                     </div>
                     <div class="loot-description">
                         <label class="input-sides-text" for="exampleFormControlTextarea1">Loot Description:</label>
                         <textarea class="form-control" id="description" rows="3"></textarea>
                     </div>
                     <div class="loot-value">
                         <span class="input-sides-text" id="inputGroup-sizing-default">Loot Value:</span>
                         <input type="text" id="valueLoot" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                     </div>
                     
                     <div class="dice-button">
                      <div class="dice-button">
                                <button onclick="createContent()" type="submit" class="btn btn-primary btn-lg">Create Loot</button>
                        </div>
                 </div>
                 </div>
             </div>
</div>
             
            </div>
        </div>
      </div>
</div>
    


<footer class="container-fluid text-center">
  <p>SWENG 465 - Web Services Final</p>
</footer>

</body>
</html>

<script>
      function getContent()
      {
          var rarity = document.getElementById("rarity").value;
          var type = document.getElementById("type").value;
          
          var urlRarity = rarity.replace(/\s/g, '');
          var urlType = type.replace(/\s/g, '');
          
          console.log(urlRarity);
          console.log(urlType)
          
          console.log(urlType)
          
          $.ajax({
              type:"GET",
              url:"https://localhost:8443/ClientProject/content?rarity=" + urlRarity + "&type=" + urlType,
              success: function(result){
                  
                  console.log(result)
                  var content
                  
                  if (result.name === undefined){
                      content = "We didn't find any entries for: " + rarity + " " + type + "\nBut you can help us out by adding your own!"
                  }
                  else {
                    content = "You found: " + result.name + "!\n";

                    if (result.description != ""){
                      content += "Description: " + result.description + "\n";
                    }
                    if (result.value != ""){
                        content += "Value: " + result.value
                    }
                  }

                  
                  document.getElementById("contentResults").textContent = content;
              },
              error: function(result){
                  document.getElementById("diceResults").textContent = result.toString() + " Failure";
              }
          })
      }
      
      function createContent()
      {
          var lootName = document.getElementById("nameLoot").value;
          var lootRarity = document.getElementById("rarityCreation").value;
          var lootCategory = document.getElementById("createCatagory").value;
          var lootDescription = document.getElementById("description").value;
          var lootValue = document.getElementById("valueLoot").value;
          
          var json = {
              "name": lootName,
              "description": lootDescription,
              "type": lootCategory,
              "rarity": lootRarity,
              "value": lootValue
          }
          
          
           $.ajax({
              type:"POST",
              url:"https://localhost:8443/ClientProject/content",
              contentType: "application/json; charset=utf-8",
              dataType: "json",
              data: JSON.stringify(json),
              success: function(result){
                  alert(result)
                  console.log(result);
              },
              error: function(result){
                  console.log(result);

              }
          })
      }
      
</script>