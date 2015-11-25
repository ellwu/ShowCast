<html>
	<head></head>
	<body>
		<h1>Sales Orders</h1>
		
		<form action="/demo/orders/listOrders.do" method="post">
			<label for="ou">Operation Unit</label><input type="text" name="ou" value=""/><br/>
			<input type="submit" name="search" value="Search"/>
		</form>
		
		<a href="/demo/orders/toCreateOrder.do">Create Order</a>
		
		<table border=1>
			<thead>
				<tr>
					<th>Order Number</th>
					<th>Order Date</th>
					<th>Customer Id</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			<#list orders as o>
				<tr>
					<td>${o.orderNum}</td>
					<td>${o.orderDate}</td>
					<td>${o.customerId}</td>
					<td><a href="/demo/orders/listOrderLines.do?ou=${o.ou}&orderId=${o.orderId}">Details</a></td>
				</tr>
			</#list>
			</tbody>
	</body>
</html>