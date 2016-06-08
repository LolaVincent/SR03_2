<?php
	include 'convert.php';

		if(isset($_POST['loginInput1'])) {
	    $login1 = $_POST['loginInput1'];
	    $json = json_decode(file_get_contents('https://webapplis.utc.fr/Edt_ent_rest/myedt/result?login='.$login1), true);
	    $tab = array();
			$edt = array();
	    $used = array();
	    $jours = ["LUNDI", "MARDI", "MERCREDI", "JEUDI", "VENDREDI", "SAMEDI"];
	    $colors = ['blue', 'red', 'yellow', 'orange', 'green', 'pink', 'plum', 'salmon'];
	    $k = 0;

			$i = 0;
			while (sizeof($json) != $i) {
				$edt[$json[$i]['day']][] = $json[$i];
				$i += 1;
			}

			foreach ($jours as $jour) {
				$j = 0;
				var_dump(sizeof($edt[$jour]));
				while (sizeof($edt[$jour]) != $j) {
					$fin = convert($edt[$jour][$j]['end']);
					$debut = convert($edt[$jour][$j]['begin']);
					/*if (!array_key_exists($tab[$jour][$j]["uv"], $used)){
							$tab[$jour][$j]["color"] = $colors[$k];
							$used[$tab[$jour][$j]["uv"]] = $colors[$k];
						} else {
							$tab[$jour][$j]["color"] = $used[$tab[$jour][$j]["uv"]];
					}*/
					while ($debut !=  $fin){	
						$tab[$jour][$debut] = $edt[$jour][$j];
						$debut +=1;
					}
					$j+=1;
				}
			}
	var_dump($tab['LUNDI'][4]);
		}
?>
		<div class='container'>
			<div class='row first'>
				<!--<div class='col-lg-1 col-md-1 col-xs-1'>
					<div class='row'><br></div>
					<?php for($i = 8; $i < 20; $i +=1){ 
								for($j = 00; $j <= 45; $j +=15){?>
									<div class='row'><?php echo $i ?>:<?php echo $j ?></div>
								<?php }
							} ?>
					</div>-->
				<?php foreach($jours as $jour) { ?>
					<div class='col-lg-2 col-md-2 col-xs-2'>
						<div class='row day'> <?php echo $jour ?> </div>
						<?php for($i = 0; $i < 48; $i +=1){ 
							if($i == 0 && !$tab[$jour][$i] || $tab[$jour][$i - 1] && !$tab[$jour][$i]) {?>
								<div class='row'><br>
							<?php } else if($i == 47 || $tab[$jour][$i + 1] && !$tab[$jour][$i]){ ?>
							<br></div>
							<?php } else if(!$tab[$jour][$i]){ ?>
							<br>
							<?php } else if(!$tab[$jour][$i - 1]['uv'] || $tab[$jour][$i - 1]['uv'] != $tab[$jour][$i]['uv'] || $tab[$jour][$i - 1]['type'] != $tab[$jour][$i]['type']){ ?>
								<div class='row' style='background-color: <?php echo $tab[$jour][$i]['color'] ?>'><?php echo $tab[$jour][$i]['uv'] ?> - <?php echo $tab[$jour][$i]['type'] ?> - (<?php echo $tab[$jour][$i]['room'] ?>)<br><?php echo $tab[$jour][$i]['group'] ?><br><?php echo $tab[$jour][$i]['begin'] ?>-<?php echo $tab[$jour][$i]['end'] ?>
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

