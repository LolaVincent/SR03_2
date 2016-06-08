<!DOCTYPE html>
<html>
	<head>
		<link href="bootstrap.css" rel="stylesheet">
	</head>
<body>

<?php
$login = $_GET['login'];
$url = "https://webapplis.utc.fr/Edt_ent_rest/myedt/result?login=".$login;

$opts = array(
  'http'=>array(
    'method'=>"GET",
    'header'=>"Accept-language: en"
  )
);

$context = stream_context_create($opts);

/* Envoi une requête HTTP vers www.example.com
   avec les en-têtes additionnels ci-dessus */
$fp = fopen("https://webapplis.utc.fr/Edt_ent_rest/myedt/result?login=".$login, 'r', false, $context);
$header = stream_get_meta_data($fp);
$content = stream_get_contents($fp);
//var_dump($header["wrapper_data"][0]);

//
preg_match('/[0-9]{3}/', $header["wrapper_data"][0], $status);
if ($status[0] != 200){
	header('Location: index.html');
	exit();
}

$json = json_decode($content, true);
$i = 0;
while (sizeof($json) != $i) {
	$tab[$json[$i]['day']][] = $json[$i];
	// var_dump($json[$i]);
	echo '<br>';
	$i += 1;
}

function convert($date){
	$date = explode(":", $date);
	$indice = ($date[0]-8)*4;
	switch ($date[1]) {
		case "00":
			break;
		case "15":
			$indice += 1;
			break;
		case "30":
			$indice += 2;
			break;
		case "45":
			$indice += 3;
			break;
	}
	return $indice;
}


$jours = array('LUNDI', 'MARDI', 'MERCREDI', 'JEUDI', 'VENDREDI');
$edt = array();
foreach ($jours as $jour) {
	$j = 0;
	while (sizeof($tab[$jour]) != $j) {
		$fin = convert($tab[$jour][$j]['end']);
		$debut = convert($tab[$jour][$j]['begin']);
		while ($debut !=  $fin){	
			$edt[$jour][$debut] = $tab[$jour][$j];
			$debut +=1;
		}
		$j+=1;
				
	}
} 

// var_dump($edt['LUNDI']);

$j = 0;
while (sizeof($tab['MERCREDI']) != $j) {
	//echo $tab['MERCREDI'][$j]['uv'];
	//echo convert("16:45");
	//echo gettype($debut);
	//echo '<br>';
	$j+=1;
}



fclose($fp); 
?>





<!-- <table BORDER="1"> 
	<caption> Emploi du temps de <?php echo $login; ?> </caption> 
	<tr>
		<th> Jour </th> 
	<?php
		for ($h=8; $h<20; $h++){?>
 
 		<th> <?php echo $h; ?>h-<?php echo $h+1; ?>h</th> 
		<?php } ?>
  	</tr> 
  	<?php foreach ($jours as $jour) {?>	
		<tr> 	
			<th> <?php echo $jour; ?> </th>
			<?php
				$j = 0;
				while (sizeof($tab[$jour]) != $j) {
			?>
					<td><?php echo $tab[$jour][$j]['uv'];?></td>
					<?php $j+=1;
				}?>
		</tr>
	<?php } ?>
</table> -->

 <div class="container">
	<div class="row">
		<?php foreach ($jours as $jour) {?>
			<div class="col-lg-2">
				<div class="row">
					<?php echo $jour; ?>
				</div>
				<?php for ($i=0; $i<48; $i++){ ?>
					<div class="row">
					<?php if ($edt[$jour][$i]){
						echo $edt[$jour][$i]['uv'];}
					else {
						echo"<br>";
					}
					?>
					</div>
				<?php } ?>
			</div>
		<?php } ?>
	</div>
</div>
	


</body>
</html>

