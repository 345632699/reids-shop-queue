<?php 
header("content-type:text/html;charset=utf-8");  
$redis = new redis();
$result = $redis->connect('127.0.0.1', 6379);  
$mywatchkey = $redis->get('mywatchkey');
$rob_total = 100;
if ($mywatchkey < $rob_total) {
	# code...
	$redis->watch('mywatchkey');
	//redis 事务开始
	$redis->multi();
	sleep(5);
	//开始业务
	$user_id = "user_id_".mt_rand(1,9999);
	$redis->hSet("mywatchlist",$user_id,date('H-m-d H:i:s'));
	$redis->set('mywatchkey',$mywatchkey+1);
	$rob_result = $redis->exec();
	if ($rob_result) {
		# code...
		$mywatchlist = $redis->hGetAll('mywatchlist');
		echo $user_id."抢购成功";
	 	echo "剩余数量：".($rob_total-$mywatchkey-1)."<br/>";  
        echo "用户列表：<pre>"; 
        var_dump($mywatchlist); 
	}else{
		echo "手气不好，再抢购";exit();
	}

}