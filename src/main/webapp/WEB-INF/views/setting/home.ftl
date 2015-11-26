<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
<#import "/common/html.ftl" as html/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<@html.commonHead/>
		<title>Setting</title>
	</head>
	<body>
		<@html.topMenu/>
		
		<@html.content>
			<h1 class="page-header">
				Setting List
			</h1>
			<div class="container-fluid">
				<div>
					<div class="">
						<a class="btn btn-default" href="#" role="button">Create</a>
					</div>
					<table class="table table-striped">
					  <thead>
						<tr>
						  <th>Key</th>
						  <th>Prompt</th>
						  <th>Description</th>
						  <th>Action</th>
						</tr>
					  </thead>
					  <tbody>
					  	<#list settings as setting>
						<tr>
						  <td>${setting.key}</td>
						  <td>${setting.prompt}</td>
						  <td>${setting.desc}</td>
						  <td>
							<a class="glyphicon glyphicon-pencil" href="menu/to.do?key=M_SET_EDIT&settingKey=${setting.key}" role="button"></a>
						  </td>
						</tr>
						</#list>
					  </tbody>
					</table>
				</div>
			</div>
		</@html.content>
		
		<@html.footerJs/>
	</body>
</html>