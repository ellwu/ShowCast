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
				Edit Setting
			</h1>
			<div class="container-fluid">
				<form class="form-horizontal">
				  <div class="form-group">
					<label for="pondName" class="col-sm-1 control-label">Key</label>
					<div class="col-sm-10">
					  <p class="form-control-static">${setting.key}</p>
					</div>
				  </div>
				  <div class="form-group">
					<label for="lotusCount" class="col-sm-1 control-label">Show Count</label>
					<div class="col-sm-10">
					  <p class="form-control-static">10</p>
					</div>
				  </div>
				  <div class="form-group">
					<label for="frogCount" class="col-sm-1 control-label">Keeper Count</label>
					<div class="col-sm-10">
					  <p class="form-control-static">3</p>
					</div>
				  </div>
				</form>
			</div>
		</@html.content>
		
		<@html.footerJs/>
	</body>
</html>