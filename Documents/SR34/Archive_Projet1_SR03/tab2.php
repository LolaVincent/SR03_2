<?php
	include 'convert.php';
	include 'connect.php';

	$jours = ["LUNDI", "MARDI", "MERCREDI", "JEUDI", "VENDREDI", "SAMEDI"];
	$colors = ['tan', '#82CAFA', 'yellow', 'orange', 'aquamarine', 'pink', 'plum', 'salmon', 'lightgreen', 'aqua', 'yellowgreen', 'palevioletred', 'mediumturquoise', 'orangered', 'indianred'];
	$edt1 = array();
	$edt2 = array();
	$tab1 = array();
	$tab2 = array();
    $used = array();
    $k = 0;

	function tab_jour($edt) {
		$tab = array();
        global $used, $k, $colors, $jours;
	    foreach($jours as $jour){
	    	$i = 0;
	    	while($i < sizeof($edt)){
	    		$begin = convert($edt[$i]["begin"]);
	    		$end = convert($edt[$i]["end"]);
	    		if (!array_key_exists($edt[$i]["uv"], $used)){
	    			$edt[$i]["color"] = $colors[$k];
	    			$used[$edt[$i]["uv"]] = $colors[$k];
						$k  += 1;
	    		} else {
	    			$edt[$i]["color"] = $used[$edt[$i]["uv"]];
	    		}
	    		if($edt[$i]["day"] ==  $jour){
	    			if($edt[$i]["type"] == "Cours") {
	    				$edt[$i]["type"]  = "C";
	    			}
	    			if ($edt[$i]["group"]) {
	    				preg_match('#[0-9]#', $edt[$i]["group"], $matches);
						$edt[$i]["group"] = 'G'.$matches[0];
					}
		    		$j = $begin;
		    		while ($j != $end){
		    			$tab[$jour][$j] = $edt[$i];
		    			$j += 1;
		    		}
		    	}
		    	$i += 1;
	    	}
	    }
		return $tab;
	}



	if(isset($_POST['loginInput1'])) {
    $login1 = $_POST['loginInput1'];			
		$edt1 = connect($login1);
 	  $tab1 = tab_jour($edt1);
		$nb_login = 1;
	}

	if(isset($_POST['loginInput2'])) {
	    $login2 = $_POST['loginInput2'];
			$edt2 = connect($login2);
	    $tab2 = tab_jour($edt2);
			$nb_login = 2;
		}
?>



	<div class="row first" style="  padding-top: 3%;
                                    left: -4%;
                                    position: relative;
                                    border-style: none;">
		<div class='col-lg-1 col-md-1 col-xs-1 hour'>
			<div class='row hour'><br></div>
			<?php for($i = 8; $i < 20; $i +=1){ 
				for($j = 00; $j <= 45; $j +=15){
					if($j==0){?>
						<div class='row hour'><?php echo $i ?>:00</div>
			<?php } else if($j!= 15 && $j !=45){ ?>
				<div class='row hour'><?php echo $i ?>:<?php echo $j ?></div>
			<?php	} else { ?>
				<br>
			<?php }
				}	
			} ?>
		</div>
		<div class='col-lg-11 col-md-11 col-xs-11'>
			<?php foreach($jours as $jour) { ?>
				<div class="col-lg-2 col-md-2 col-xs-2 <?php echo htmlspecialchars($jour) ?>">
					<div class='row day'> <b> <?php echo $jour ?> </b> </div>
					<div class='row cours'>
					<?php 								
						$largeur= 12/$nb_login;
						$col = 'col-lg-'.$largeur.' col-md-'.$largeur.' col-xs-'.$largeur;
						for ($n=1; $n<$nb_login+1; $n++) {
							echo '<div class="' . htmlspecialchars($col).' tab'.$n. '" />'."\n";
							if ($n == 1) {
								$tab = $tab1;
							} else {
								$tab = $tab2;
							}
							for($i = 0; $i < 48; $i +=1){
								if(!$tab[$jour][$i] && $tab[$jour][$i+1]['uv'] && $tab[$jour][$i-1]['uv']) { ?>
									<div><br></div>
								<?php } else if (!$tab[$jour][$i] && ($i == 0 || $tab[$jour][$i - 1]['uv'])){ ?>
									<div class='row'><br>
								<?php } else if(!$tab[$jour][$i] && ($i == 47 || $tab[$jour][$i + 1]['uv'])){ ?>		
									<br></div>
								<?php } else if (!$tab[$jour][$i] && !$tab[$jour][$i + 1] && !$tab[$jour][$i - 1]) { ?>
									<br>
								<?php } else if(!$tab[$jour][$i - 1]['uv'] || $tab[$jour][$i - 1]['uv'] != $tab[$jour][$i]['uv'] || $tab[$jour][$i - 1]['type'] != $tab[$jour][$i]['type']){ ?>
									<div class='row' style='background-color: <?php echo htmlspecialchars($tab[$jour][$i]['color']); ?>'><b><?php echo $tab[$jour][$i]['type'] ?> <?php echo $tab[$jour][$i]['uv'] ?> <?php echo $tab[$jour][$i]['group'] ?></b><br><?php echo $tab[$jour][$i]['room'] ?><br><?php echo $tab[$jour][$i]['begin'] ?> - <?php echo $tab[$jour][$i]['end'] ?>
								<?php } else if(!$tab[$jour][$i + 1]['uv'] || $tab[$jour][$i + 1]['uv'] != $tab[$jour][$i]['uv'] || $tab[$jour][$i + 1]['type'] != $tab[$jour][$i]['type']){ ?>
									</div>
								<?php } else { ?>
										<br>
										<?php }
							} ?>
						</div>
						<?php } ?>
				</div>
			</div>
			<?php } ?>
		</div>
	</div>


