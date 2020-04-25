<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<!DOCTYPE html>
<html lang="en">
<head>
<access orgin="*"/>
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
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {
        height: 450px;
/*        background: ghostwhite;
        background-image: url(images/darkwood.jpg);*/
    }
    
    .wrapper{
        min-height: calc(100vh - 50px - 60px);
        background-image: url(images/dice1.png);
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
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
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
    
    textarea.form-control {
        height: 100px;
    }
    
    .btn-secondary{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
    .btn-secondary:hover{
       color: white;
       background-color: dimgrey;
       border-color: whitesmoke;
       box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
    }
    
    .btn-secondary:active{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
     .btn-secondary:active:focus{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
    .btn-secondary:focus{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
     .btn-secondary:visited{
        color: white;
        background-color: darkslategrey;
        border-color: white;
    }
    
    .radio-buttons{
        padding-bottom: 30px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
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
             <h1 class="home-header">Dice Roller</h1>
             <hr>
             <div class="dice-data">
                 <div class="num-sides-body">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-sides-text" id="inputGroup-sizing-default">Number of Dice:</span>
                    </div>
                    <input type="text" id="numD" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                </div>
            </div>
             <div class="dice-type">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Dice Type:</span>
                    <select class="browser-default custom-select" id="diceTypeValue">
                        <option selected>Select dice type:</option>
                        <option value="4">4-Sided Dice</option>
                        <option value="6">6-Sided Dice</option>
                        <option value="8">8-Sided Dice</option>
                        <option value="10">10-Sided Dice</option>
                        <option value="12">12-Sided Dice</option>
                        <option value="20">20-Sided Dice</option>
                    </select>
             </div>
<!--                 <div class="radio-buttons">
                     <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <label class="btn btn-secondary active">
                            <input type="radio" name="options" id="normalO" autocomplete="off" checked> Normal
                        </label>
                        <label class="btn btn-secondary">
                            <input type="radio" name="options" id="advantageO" autocomplete="off"> Advantage
                        </label>
                        <label class="btn btn-secondary">
                            <input type="radio" name="options" id="disadO" autocomplete="off"> Disadvantage
                        </label>
                    </div>
             </div>-->
                 <div class="dice-button">
                      <div class="dice-button">
                                <button type="submit" onclick="getRolls()" class="btn btn-primary btn-lg">Roll Dice</button>
                        </div>
                 </div>
                 <form>
                        <div class="form-group-result">
                            <label class="input-sides-text" for="exampleFormControlTextarea1">Result:</label>
                            <textarea class="form-control" id="diceResults" rows="3" readonly></textarea>
                        </div>
                 </form>
                 <hr>
             </div>
            </div>
            
        </div>
    </div>
</div>

<script>
      function getRolls()
      {
          var numDice = document.getElementById("numD").value;
          var dType = document.getElementById("diceTypeValue").value;
          
          var diceO = {"numDice":numDice, "diceType":dType};
          
          if (numDice > 100000)
          {
              numDice = 100000
          }
          
          $.ajax({
              type:"GET",
              url:"https://localhost:8443/ClientProject/diceClient?numDice=" + numDice + "&diceType=" + dType,
              success: function(result){
                  console.log(result)
                  document.getElementById("diceResults").textContent = "Rolled " + numDice + "d" + dType + ". Total: " + result.total
                          + "\nHigh roll: " + result.max + "\nLow roll: " + result.min
                          + "\n{ " + result.rolls + " }" 
                        
              },
              error: function(result){
                  document.getElementById("diceResults").textContent = result.toString() + " Failure";
              }
          })
      }
      
</script>

<footer class="container-fluid text-center">
  <p>SWENG 465 - Web Services Final</p>
</footer>

</body>
</html>
