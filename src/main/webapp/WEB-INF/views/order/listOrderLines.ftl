<html>
	<head></head>
	<body>
		<h1>Sales Order Lines</h1>
		
		<table border=1>
			<thead>
				<tr>
					<th>Line Number</th>
					<th>Item Id</th>
					<th>Order Count</th>
					<th>Order Price</th>
				</tr>
			</thead>
			<tbody>
			<#list orderLines as line>
				<tr>
					<td>${line.lineNum}</td>
					<td>${line.itemId}</td>
					<td>${line.orderCount}</td>
					<td>${line.orderPrice}</td>
				</tr>
			</#list>
			</tbody>
	</body>
</html>