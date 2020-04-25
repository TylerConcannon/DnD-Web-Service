<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
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
        background-image: url(images/encounters.jpg);
        background-size: cover;
    }
    
    .home-buttons{
        display: flex;
    }
    
    .mb-3{
        padding-bottom: 30px;
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
        height: 515px;
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
             <h1 class="home-header">Random Encounter Generator</h1>
             <hr>
             
             <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-sides-text" id="inputGroup-sizing-default">Player Level:</span>
                    </div>
                    <input type="text" id="playerLevel" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
             </div>
             <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-sides-text" id="inputGroup-sizing-default">Number of Players:</span>
                    </div>
                    <input type="text" id="numPlayers" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
             </div>
             
            <div class="monster-number-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Max number of Monsters:</span>
                    <select id="numMonsters" class="browser-default custom-select">
                        <option selected>Select max number of Monsters</option>
                        <option value="0">Any</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
             </div>
             <br>
             <div class="loot-rarity-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Terrain Selection:</span>
                    <select id="terrain" class="browser-default custom-select">
                        <option selected>Select Terrain:</option>
                        <option value="Any">Any</option>
                        <option value="Forest">Forest</option>
                        <option value="Hill">Hill</option>
                        <option value="Jungle">Jungle</option>
                        <option value="Mountains">Mountains</option>
                        <option value="Plains">Plains</option>
                        <option value="Snowy">Snowy</option>
                        <option value="Swamp">Swamp</option>
                    </select>
             </div>
             
            <div class="dice-button">
                <div class="dice-button">
                      <button type="submit" class="btn btn-primary btn-lg" onclick="getEncounters()">Generate Encounter</button>
                </div>
           </div>

            <div class="dice-button">
                  <div class="dice-button">
                        <button type="submit" class="btn btn-primary btn-lg" onclick="getMonsters()">Get All Monsters in Terrain</button>
                    </div>
             </div>
             
             <div class="results">
                 <form>
                        <div class="form-group-result">
                            <label class="input-sides-text" for="exampleFormControlTextarea1">Results:</label>
                            <textarea class="form-control" id="contentResults" rows="3" readonly></textarea>
                        </div>
                 </form>
                 <hr>
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
    function getEncounters()
      {
          var terrain = document.getElementById("terrain").value;
          var numPlayers = document.getElementById("numPlayers").value;
          var playerLevel = document.getElementById("playerLevel").value;
          var numMonsters = document.getElementById("numMonsters").value;
          
          var json = {
              "terrain": terrain,
              "numPlayers": numPlayers,
              "groupLevel": playerLevel,
              "numMonsters": numMonsters
          }
          
          console.log(json)
          
           $.ajax({
              type:"POST",
              url:"https://localhost:8443/ClientProject/encounter",
              contentType: "application/json; charset=utf-8",
              dataType: "json",
              data: JSON.stringify(json),
              success: function(result){
                  console.log(result.encounters)
                  var content
                  var i

                  content = "";

                      for(i = 0; i < 4; i++)
                      {
                          if(result.encounters[i].difficulty == "Easy")
                          {
                              content += "Difficulty: " + result.encounters[i].difficulty + "\n";
                              content += "You encounter: " + result.encounters[i].monster.name + "\n";
                              content += "Alignment: " + result.encounters[i].monster.alignment + "\n";
                              content += "Size: " + result.encounters[i].monster.size + "\n";
                              content += "Type: " + result.encounters[i].monster.type + "\n";
                              content += "XP: " + result.encounters[i].monster.xp + "\n";
                              content += "Number of Monsters: " + result.encounters[i].numMonsters + "\n";
                              content += "Terrain: " + result.encounters[i].terrain + "\n";
                              content += "Total XP: " + result.encounters[i].totalXp + "\n";
                          }
                          else if(result.encounters[i].difficulty == "Medium")
                          {
                              content += "Difficulty: " + result.encounters[i].difficulty + "\n";
                              content += "You encounter: " + result.encounters[i].monster.name + "\n";
                              content += "Alignment: " + result.encounters[i].monster.alignment + "\n";
                              content += "Size: " + result.encounters[i].monster.size + "\n";
                              content += "Type: " + result.encounters[i].monster.type + "\n";
                              content += "XP: " + result.encounters[i].monster.xp + "\n";
                              content += "Number of Monsters: " + result.encounters[i].numMonsters + "\n";
                              content += "Terrain: " + result.encounters[i].terrain + "\n";
                              content += "Total XP: " + result.encounters[i].totalXp + "\n";
                          }
                          else if(result.encounters[i].difficulty == "Hard")
                          {
                              content += "Difficulty: " + result.encounters[i].difficulty + "\n";
                              content += "You encounter: " + result.encounters[i].monster.name + "\n";
                              content += "Alignment: " + result.encounters[i].monster.alignment + "\n";
                              content += "Size: " + result.encounters[i].monster.size + "\n";
                              content += "Type: " + result.encounters[i].monster.type + "\n";
                              content += "XP: " + result.encounters[i].monster.xp + "\n";
                              content += "Number of Monsters: " + result.encounters[i].numMonsters + "\n";
                              content += "Terrain: " + result.encounters[i].terrain + "\n";
                              content += "Total XP: " + result.encounters[i].totalXp + "\n";
                          }
                          else
                          {
                              content += "Difficulty: " + result.encounters[i].difficulty + "\n";
                              content += "You encounter: " + result.encounters[i].monster.name + "\n";
                              content += "Alignment: " + result.encounters[i].monster.alignment + "\n";
                              content += "Size: " + result.encounters[i].monster.size + "\n";
                              content += "Type: " + result.encounters[i].monster.type + "\n";
                              content += "XP: " + result.encounters[i].monster.xp + "\n";
                              content += "Number of Monsters: " + result.encounters[i].numMonsters + "\n";
                              content += "Terrain: " + result.encounters[i].terrain + "\n";
                              content += "Total XP: " + result.encounters[i].totalXp + "\n";
                          }
                          content += "\n";
                      }

//                    if (result.description != ""){
//                      content += "Description: " + result.description + "\n";
//                    }
                  

                  
                  document.getElementById("contentResults").textContent = content;
              },
              error: function(result){
                  console.log(result);

              }
          })
      }
      
    function getMonsters()
      {
          var terrain = document.getElementById("terrain").value;
                    
           $.ajax({
              type:"GET",
              url:"https://localhost:8443/ClientProject/encounter?terrain=" + terrain,
              success: function(result){
                  console.log(result.monsters)
//                  var content1
//                  var content2
//                  var content3
//                  var content4
//                  var content5
//                  var content6
//                  var content7
                  var content
                  var i
                  
                  content = "";
                  
                  content += "Monster List for " + terrain + "\n";
                  content += "--------------------------------------\n";
                  
                  for(i = 0; i < result.monsters.length; i++)
                  {
                      content += "Name: " + result.monsters[i].name + "\n";
                      content += "Size: " + result.monsters[i].size  + "\n";
                      content += "Type: " + result.monsters[i].type  + "\n";
                      content += "Alignment: " + result.monsters[i].alignment  + "\n";
                      content += "XP: " + result.monsters[i].xp  + "\n";
                      content += "\n";
                  }
                   document.getElementById("contentResults").textContent = content;
              },
              error: function(result){
                  console.log(result);

              }
          })
      }
</script>