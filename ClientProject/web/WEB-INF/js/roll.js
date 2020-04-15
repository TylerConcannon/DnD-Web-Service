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
        url:"http://localhost:8084/ClientProject/diceClient?numDice=" + numDice + "&diceType=" + dType,
        success: function(result){
            console.log(result)
            document.getElementById("diceResults").textContent = "Rolled " + numDice + "d" + dType + ". Total: " + result.total + "\n{ " + result.rolls + " }" 
                  + "\nHigh roll: " + result.max + "\nLow roll: " + result.min;
        },
        error: function(result){
            document.getElementById("diceResults").textContent = result.toString() + " Failure";
        }
    })
}
