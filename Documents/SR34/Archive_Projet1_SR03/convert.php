<?php

	function convert($date){
		$date = explode(":", $date);
		$indice = ($date[0]-8)*4;
		switch($date[1]){
			case "OO":
				break;
			case "15":
				$indice +=1;
				break;
			case "30":
				$indice +=2;
				break;
			case "45":
				$indice +=3;
				break;
		}
		return $indice;
	}



?>
