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
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
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
                        <span class="input-sides-text" id="inputGroup-sizing-default">Group CR:</span>
                    </div>
                    <input type="text" id="groupCR" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
             </div>
             <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-sides-text" id="inputGroup-sizing-default">Number of Enemies:</span>
                    </div>
                    <input type="text" id="numEnemies" class="side-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
             </div>
             <div class="loot-rarity-selection">
                 <span class="input-sides-text" id="inputGroup-sizing-default">Terrain Selection:</span>
                    <select class="browser-default custom-select">
                        <option selected>Select Terrain:</option>
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
                            <form action="#">
                                <button type="submit" class="btn btn-primary btn-lg">Generate Encounter</button>
                            </form>
                        </div>
                 </div>
             <div class="results">
                 <form>
                        <div class="form-group-result">
                            <label class="input-sides-text" for="exampleFormControlTextarea1">Results:</label>
                            <textarea class="form-control" id="contentResults" rows="3"></textarea>
                        </div>
                 </form>
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
