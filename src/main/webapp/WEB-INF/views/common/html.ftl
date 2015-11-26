<#macro commonHead>
	<#assign base=request.contextPath/>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		
	<base id="base" href="${base}/"/>
	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/showcast.css" rel="stylesheet">
</#macro>

<#macro topMenu>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">ShowCast</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<#list Session["topMenus"] as menu>
					<li <#if Session["currentTopMenuKey"] == menu.key >class="active"</#if> >
						<a href="menu/to.do?key=${menu.key}">${menu.prompt}</a>
					</li>
					</#list>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li>
						<a href="menu/to.do?key=M_SET">Settings</a>
					</li>
					<li>
						<a href="menu/to.do?key=M_LOGOUT">Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
</#macro>

<#macro content>
	<div id="content" class="container-fluid">
			
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<#list Session["sideMenus"] as menu>
						<li <#if Session["currentSideMenuKey"] == menu.key >class="active"</#if> >
							<a href="menu/to.do?key=${menu.key}">${menu.prompt}</a>
						</li>
					</#list>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <#list Session["menuCrumbs"] as menu>
				  	<li><a href="menu/to.do?key=${menu.key}">${menu.prompt}</a></li>
				  </#list>
				</ol>
				<#nested/>
			</div>
		</div>
	</div>
</#macro>

<#macro footerJs>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="js/jquery.min.js"/>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"/>
</#macro>