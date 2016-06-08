<?php

	function connect($login) {
		$edt = array();
		$opts = array(
  		'http'=>array(
    	'method'=>"GET",
    	'header'=>"Accept-language: en"
  		)
		);
		$context = stream_context_create($opts);
		$url = "https://webapplis.utc.fr/Edt_ent_rest/myedt/result?login=";
		$fp = fopen($url.$login, 'r', false, $context);
		$header = stream_get_meta_data($fp);
		$content = stream_get_contents($fp);
		preg_match('/[0-9]{3}/', $header["wrapper_data"][0], $status);
		if ($status[0] != 200){
			header('Location: index.php');
			exit();
		}
		$edt = json_decode($content, true);
		return $edt;
	}
?>
