/*
This code is created for static battle ships and for 2 players. There are a total of 17 hits required for the a player to win the game.
If a player hits,
	he/she can play again.
If a player a misses,
	it's the other player's turn.		
*/



// setting grid rows and columns and the size of each square
var numberOfRows = 10;
var numberOfCols = 10;
var squareSize = 45;

// get the container element for the board
var playerBoard1 = document.getElementById("playerBoard1");

// make the grid columns and rows
for (var i = 0; i < numberOfCols; i++) {
	for (var j = 0; j < numberOfRows; j++) {
		
		// creating a new div HTML element for each grid square and make it the right size
		var square1 = document.createElement("div");
		playerBoard1.appendChild(square1);

       // each div element gets a unique id based on its row and column, like "s00"
		square1.id = 's' + j + i;			
		
		// set each grid square's coordinates: multiples of the current row or column number
		var topPosition = j * squareSize;
		var leftPosition = i * squareSize;			
		
		//using CSS absolute positioning, place each grid square on the page
		square1.style.top = topPosition + 'px';
		square1.style.left = leftPosition + 'px';						
	}
}


// get the container element for the board
var playerBoard2 = document.getElementById("playerBoard2");

// make the grid columns and rows
for (var i = 0; i < numberOfCols; i++) {
	for (var j = 0; j < numberOfRows; j++) {
		
		// creating a new div HTML element for each grid square and make it the right size
		var square2 = document.createElement("div");
		playerBoard2.appendChild(square2);

       // each div element gets a unique id based on its row and column, like "s00"
		square2.id = 's' + j + i;			
		
		// set each grid square's coordinates: multiples of the current row or column number
		var topPosition = j * squareSize;
		var leftPosition = i * squareSize;			
		
		//using CSS absolute positioning, place each grid square on the page
		square2.style.top = topPosition + 'px';
		square2.style.left = leftPosition + 'px';						
	}
}



document.getElementById("player1Status").innerHTML="Status";
document.getElementById("player1Status").style.color = "black"
document.getElementById("player2Status").innerHTML="Status";
document.getElementById("player2Status").style.color = "black"


/////////////////////////////////////////////code for player 1//////////////////////////////////////////////////////


var hitCount1 = 0;

//position the ships through a list
var gameBoardForPlayer1 = [	
				[0,0,0,1,1,1,1,0,0,0],
				[0,0,0,0,0,0,0,0,0,0],
				[0,0,0,1,0,0,0,0,0,0],
				[0,0,0,1,0,0,0,0,0,0],
				[0,0,0,0,0,0,0,0,0,0],
				[1,0,0,0,0,0,1,1,1,1],
				[1,0,0,0,0,0,0,0,0,0],
				[1,0,0,1,0,0,0,0,0,0],
				[1,0,0,1,0,0,0,0,0,0],
				[1,0,0,0,0,0,0,0,0,0]
				]

// setting event listener for all elements in gameBoardForPlayer1, run attackPlayer1 function when square is clicked
playerBoard1.addEventListener("click", attackPlayer1, false);


function attackPlayer1(event) {

	if (event.target !== event.currentTarget) {
        // extracting row and column number
		var row = event.target.id.substring(1,2);
		var col = event.target.id.substring(2,3);
        //alert("Clicked on row number " + row + " and column number" + col);
				
		// if player clicks a square with no ship, change the color and change square's value
		if (gameBoardForPlayer1[row][col] == 0) {
			event.target.style.background = 'yellow';
			// setting this square's value to 3 to indicate that they fired and missed
			gameBoardForPlayer1[row][col] = 3;
			//alert("Miss!");
            document.getElementById("player2Status").innerHTML="Miss!";
            document.getElementById("player2Status").style.color = "black"

			
		// if player clicks a square with a ship, change the color and change square's value
		} else if (gameBoardForPlayer1[row][col] == 1) {
			event.target.style.background = 'red';
			// setting this square's value to 2 to indicate the ship has been hit
			gameBoardForPlayer1[row][col] = 2;
			//alert("Hit!");
            document.getElementById("player2Status").innerHTML="Hit!";
            document.getElementById("player2Status").style.color = "black"
			
			// increment hitCount1 each time a ship is hit
			hitCount1++;

			if (hitCount1 == 17) {
				alert("You win! Congratulations Player 2!");
                location.reload();
			}
			
		// if player clicks a square that's been previously hit
		} else if (gameBoardForPlayer1[row][col] > 1) {
			//alert("Already Taken!");
            document.getElementById("player2Status").innerHTML="Taken!";
            document.getElementById("player2Status").style.color = "black"

		}		
    }
    event.stopPropagation();
}



/////////////////////////////////////////////code for player 2//////////////////////////////////////////////////////


var hitCount2 = 0;

//position the ships through a list
var gameBoardForPlayer2 = [
				[0,0,0,0,0,0,0,0,0,0],
				[0,1,0,0,0,0,0,0,0,0],
				[0,1,0,0,0,1,1,1,1,1],
				[0,0,0,0,0,0,0,0,0,0],
				[0,0,0,0,0,0,0,0,0,0],
				[1,0,0,1,0,0,0,0,0,0],
				[1,0,0,1,0,0,0,0,0,0],
				[0,0,0,1,0,0,0,0,0,0],
				[0,0,0,1,0,0,0,0,0,0],
				[0,0,0,0,0,0,1,1,1,1]
				]

// setting event listener for all elements in gameBoardForPlayer2, run attackPlayer2 function when square is clicked
playerBoard2.addEventListener("click", attackPlayer2, false);


function attackPlayer2(event) {

	if (event.target !== event.currentTarget) {
        // extract row and column number
		var row = event.target.id.substring(1,2);
		var col = event.target.id.substring(2,3);
        //alert("Clicked on row number " + row + " and column number" + col);
				
		// if player clicks a square with no ship, change the color and change square's value
		if (gameBoardForPlayer2[row][col] == 0) {
			event.target.style.background = 'yellow';
			// set this square's value to 3 to indicate that they fired and missed
			gameBoardForPlayer2[row][col] = 3;
			//alert("Miss!");
            document.getElementById("player1Status").innerHTML="Miss!";
            document.getElementById("player1Status").style.color = "black"

			
		// if player clicks a square with a ship, change the color and change square's value
		} else if (gameBoardForPlayer2[row][col] == 1) {
			event.target.style.background = 'red';
			// setting this square's value to 2 to indicate the ship has been hit
			gameBoardForPlayer2[row][col] = 2;
			//alert("Hit!");
            document.getElementById("player1Status").innerHTML="Hit!";
            document.getElementById("player1Status").style.color = "black"

			
			// increment hitCount2 each time a ship is hit
			hitCount2++;

			if (hitCount2 == 17) {
				alert("You win! Congratulations Player 1!");
                location.reload();
			}
			
		} else if (gameBoardForPlayer2[row][col] > 1) {
			//alert("Already Taken!");
            document.getElementById("player1Status").innerHTML="Taken!";
            document.getElementById("player1Status").style.color = "black"

		}		
    }
    event.stopPropagation();
}




