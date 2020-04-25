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
        background-image: url(images/gandalf.jpg);
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
        color: white;
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
       border-color: white;
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
/*    
    hr{
        border-top: 1px solid black;
    }*/
    
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
        height: -webkit-fill-available;
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
             <h1 class="home-header">Random Character Generator</h1>
             <hr>
             
             <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-sides-text" id="inputGroup-sizing-default">Name:</span>
                    </div>
                    <input type="text" id="name" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
             </div>
             
             <div class="loot-rarity-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Class:</span>
                    <select id="classType" class="browser-default custom-select">
                        <option selected>Select Class:</option>
                        <option value="Barbarian">Barbarian</option>
                        <option value="Bard">Bard</option>
                        <option value="Druid">Druid</option>
                        <option value="Monk">Monk</option>
                        <option value="Paladin">Paladin</option>
                        <option value="Ranger">Ranger</option>
                        <option value="Sorcerer">Sorcerer</option>
                        <option value="Warlock">Warlock</option>
                        <option value="Cleric">Cleric</option>
                        <option value="Fighter">Fighter</option>
                        <option value="Rogue">Rogue</option>
                        <option value="Wizard">Wizard</option>
                    </select>
             </div>
             
             <div class="loot-rarity-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Race:</span>
                    <select id="raceType" class="browser-default custom-select">
                        <option selected>Select Race:</option>
                        <option value="Dwarf">Dwarf</option>
                        <option value="Elf">Elf</option>
                        <option value="Halfling">Halfling</option>
                        <option value="Human">Human</option>

                    </select>
             </div>
             
             <div class="loot-rarity-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Level:</span>
                    <select id="level" class="browser-default custom-select">
                        <option selected>Select Level:</option>
                        <option value="1">Level 1</option>
                        <option value="2">Level 2</option>
                        <option value="3">Level 3</option>
                        <option value="4">Level 4</option>
                        <option value="5">Level 5</option>
                        <option value="6">Level 6</option>
                        <option value="7">Level 7</option>
                        <option value="8">Level 8</option>
                        <option value="9">Level 9</option>
                        <option value="10">Level 10</option>
                        <option value="11">Level 11</option>
                        <option value="12">Level 12</option>
                        <option value="13">Level 13</option>
                        <option value="14">Level 14</option>
                        <option value="15">Level 15</option>
                        <option value="16">Level 16</option>
                        <option value="17">Level 17</option>
                        <option value="18">Level 18</option>
                        <option value="19">Level 19</option>
                        <option value="20">Level 20</option>

                    </select>
             </div>
             
             <div class="dice-button">
                      <div class="dice-button">
                                <button type="submit" class="btn btn-primary btn-lg" onclick="createCharacter()">Generate Character</button>
                        </div>
                 </div>
             <div class="results">
                 <form>
                        <div class="form-group-result">
                            <label class="input-sides-text" for="exampleFormControlTextarea1">Results:</label>
                            <textarea class="form-control" id="contentResults" rows="3" readonly></textarea>
                        </div>
                 </form>
             </div>
             <hr>
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
    function getCharacter()
      {
          var name = document.getElementById("name").value;
          var classType = document.getElementById("classType").value;
          var raceType = document.getElementById("raceType").value;
          var level = document.getElementById("level").value;
          
          $.ajax({
              type:"GET",
              url:"https://localhost:8443/ClientProject/character?name=" + name + "&classType=" + classType + "&raceType=" + raceType + "&level=" + level,
              success: function(result){
                  
                  console.log(result.character)
                  
              },
              error: function(result){
                  document.getElementById("diceResults").textContent = result.toString() + " Failure";
              }
          })
      }
      
    function createCharacter()
      {
          var name = document.getElementById("name").value;
          var playerClass = document.getElementById("classType").value;
          var race = document.getElementById("raceType").value;
          var level = document.getElementById("level").value;
          
          var json = {
              "name": name,
              "playerClass": playerClass,
              "race": race,
              "playerLevel": level
          }
          
          console.log(json)
          
           $.ajax({
              type:"POST",
              url:"https://localhost:8443/ClientProject/character",
              contentType: "application/json; charset=utf-8",
              dataType: "json",
              data: JSON.stringify(json),
              success: function(result){
                  console.log(result);
                  var content
                  var i
                  
                  content = "";
                  
                  content += "Character Information \n";
                  content += "--------------------- \n";
                  content += "Name: " + result.character.name + "\n";
                  content += "Level: " + result.character.level  + "\n";
//                  content += "Level: " + document.getElementById("level").value  + "\n";
                  
                  content += "--------------------- \n";
                  content += "Class: " + result.character.playerClass.name + "\n";
                  content += "Hit Dice: " + result.character.playerClass.hitDie + "\n";
                  content += "Proficiencies: " + result.character.playerClass.proficiencies + "\n";
                  content += "Saving Throws: " + result.character.playerClass.savingThrows + "\n";
                  content += "Skills: " + result.character.playerClass.skills + "\n";
                  
                  content += "--------------------- \n";
                  content += "Strength: " + result.character.abilityScores[0] + "\n";
                  content += "Dexterity: " + result.character.abilityScores[1] + "\n";
                  content += "Constitution: " + result.character.abilityScores[2] + "\n";
                  content += "Intelligence: " + result.character.abilityScores[3] + "\n";
                  content += "Wisdom: " + result.character.abilityScores[4] + "\n";
                  content += "Charisma: " + result.character.abilityScores[5] + "\n";
                  
                  content += "--------------------- \n";
                  content += "Race: " + result.character.playerRace.name  + "\n";
                  content += "Age: " + result.character.playerRace.age  + "\n";
                  content += "Size: " + result.character.playerRace.size  + "\n";
                  content += "Speed: " + result.character.playerRace.speed  + "\n";
                  content += "Languages: " + result.character.playerRace.languages  + "\n";
                  content += "Traits: " + result.character.playerRace.traits  + "\n";
                  content += "Strength Bonus: +" + result.character.playerRace.str  + "\n";
                  content += "Dexterity Bonus: +" + result.character.playerRace.dex  + "\n";
                  content += "Constitution Bonus: +" + result.character.playerRace.con  + "\n";
                  content += "Intelligence Bonus: +" + result.character.playerRace.inte  + "\n";
                  content += "Wisdom Bonus: +" + result.character.playerRace.wis  + "\n";
                  content += "Charisma Bonus: +" + result.character.playerRace.cha  + "\n";
                  
                  document.getElementById("contentResults").textContent = content;
              },
              error: function(result){
                  console.log(result);

              }
          })
      }
</script>