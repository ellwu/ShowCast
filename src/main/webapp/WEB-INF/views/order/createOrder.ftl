<html>
	<head></head>
	<body>
		<a href="/demo/orders/listOrders.do?ou=8">Orders</a>
		<form action="/demo/orders/createOrder.do" method="post">
			<label for="orderNum">Order Number</label><input type="text" name="orderNum" value=""/><br/>
			<label for="ou">Operation Unit</label><input type="text" name="ou" value="8"/><br/>
			<label for="customerId">Customer Id</label><input type="text" name="customerId" value=""/><br/>
			<input type="submit" name="submit" value="submit"/>
		</form>
		<script>
			var submitResult = ${result!false};
			
			if(submitResult){
				alert("Created successful!");
			}
		</script>
	</body>
</html>