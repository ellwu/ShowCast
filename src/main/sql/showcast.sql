use demo;

drop table if exists t_users;

create table t_users(
	user_id char(32) not null,
	user_username varchar(100) not null,
	user_password varchar(100) not null,
	user_desc varchar(200),
	primary key(user_id)
);

insert into t_users(user_id, user_username, user_password, user_desc)
	values('5a94912886cf4b8dabb900939f651c98', 'admin', 'admin', 'administrator');

drop table if exists t_roles;
	
create table t_roles(
	role_id char(32) not null,
	role_name varchar(100) not null,
	role_desc varchar(200),
	primary key(role_id)
);

drop table if exists t_role_users;

create table t_role_users(
	ru_user_id char(32) not null,
	ru_role_id char(32) not null,
	primary key(ru_user_id)
);

drop table if exists t_role_menus;

create table t_role_menus(
	rm_role_id char(32) not null,
	rm_menu_id char(32) not null,
	primary key(rm_role_id)
);


drop table if exists t_settings;

create table t_settings(
	setting_id char(32) not null,
	setting_key char(30) not null,
	setting_value varchar(200) not null,
	setting_prompt varchar(100),
	setting_desc varchar(200),
	primary key(setting_id)
);

insert into t_settings(setting_id, setting_key, setting_value, setting_prompt, setting_desc)
	values('77b63b65e0db475e9acba7a083ba8bc4', 'S_ADMIN_PWD', 'admin', 'Admin Password', 'Admin Password');

drop table if exists t_funcs;

create table t_funcs(
	func_id char(32) not null,
	func_key char(30) not null,
	func_prompt varchar(100),
	func_url varchar(200),
	func_desc varchar(200),
	primary key (func_id)
);

insert into t_funcs(func_id, func_key, func_prompt, func_url, func_desc)
	values('2ed7cda9cd1643f58531eb0ddcca55fd', 'F_LOGIN', 'Login', '/login.do', 'Login Function');
insert into t_funcs(func_id, func_key, func_prompt, func_url, func_desc)
	values('9daf13a7e54a4eb1a8aab43258700deb', 'F_LOGOUT', 'Logout', '/logout.do', 'Logout Function');
insert into t_funcs(func_id, func_key, func_prompt, func_url, func_desc)
	values('e7e5b2e9d1ee4723958857114a37cc95', 'F_SET', 'Logout', '/setting/home.do', 'Setting Function');
insert into t_funcs(func_id, func_key, func_prompt, func_url, func_desc)
	values('63478326db9e4d2caeb6d4061c4e1983', 'F_SET_EDIT', 'Edit', '/setting/edit.do', 'Setting Edit Function');

drop table if exists t_views;

create table t_views(
	view_id char(32) not null,
	view_key char(30) not null,
	view_prompt varchar(100),
	view_path varchar(200),
	view_desc varchar(200),
	primary key (view_id)
);

insert into t_views(view_id, view_key, view_prompt, view_path, view_desc)
	values('9a60568ef0bd4c27b145efdb432439e1', 'V_LOGIN', 'Login Page', '/login', 'Login Page');
insert into t_views(view_id, view_key, view_prompt, view_path, view_desc)
	values('6f1bad742b0e4d5fa0d55b41073fbb1e', 'V_HOME', 'Home Page', '/index', 'Home Page');

drop table if exists t_menus;
	
create table t_menus(
	menu_id char(32) not null,
	menu_key char(30) not null,
	menu_prompt varchar(100) not null,
	menu_parent_id varchar(32),
	menu_desc varchar(200),
	menu_sequence int,
	func_id char(32),
	primary key(menu_id)
);


insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('85073057e9304fa382bb1cd386915819', 'M_HOME', 'Home', null, 'Home Menu', 10, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('4822269108db4fb6bc9c22817f85007f', 'M_SET', 'Setting', null, 'Home Menu', 110, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('a37ba2b255184dac8cdc2c329145a5f6', 'M_SET_EDIT', 'Edit', '4822269108db4fb6bc9c22817f85007f', 'Setting Edit Menu', 1110, '63478326db9e4d2caeb6d4061c4e1983');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('77da20112e4e467d8c00f1f008657af0', 'M_LOGOUT', 'Logout', null, 'Home Menu', 120, '9daf13a7e54a4eb1a8aab43258700deb');
	
	
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('3b73f858c63e4b18af02f3f3c6d7ee22', 'M_POND', 'Pond', null, 'Pond Menu', 20, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('5facc2ddc37e4b40887739bac0d2c8a7', 'M_P_HOME', 'Overview', '3b73f858c63e4b18af02f3f3c6d7ee22', 'Pond Home Menu', 210, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('910d18b54df1400fb41271ab91eaa78c', 'M_P_LOTUS', 'Lotus', '3b73f858c63e4b18af02f3f3c6d7ee22', 'Lotus Menu', 220, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('055a892b4f29491cbd338a3b838e2350', 'M_P_FROG', 'Frog', '3b73f858c63e4b18af02f3f3c6d7ee22', 'Frog Menu', 230, 'e7e5b2e9d1ee4723958857114a37cc95');
	
	
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('a89dca5c3d4a4e1ba5c4a602bc07fe6e', 'M_CAST', 'Cast', null, 'Cast Menu', 30, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('2f11754613564ee19b0cec9c768d4083', 'M_C_HOME', 'Overview', 'a89dca5c3d4a4e1ba5c4a602bc07fe6e', 'Cast Home Menu', 310, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('6184f01175b54023b9180f690a85c27b', 'M_C_SCHEDULE', 'Schedule', 'a89dca5c3d4a4e1ba5c4a602bc07fe6e', 'Schedule Menu', 320, 'e7e5b2e9d1ee4723958857114a37cc95');
	
	
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('114d4207f80846bda0f25e251632569e', 'M_REPO', 'Repository', null, 'Repository Menu', 40, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('b53622691b2f4f8487ac8e6536048a9f', 'M_R_HOME', 'Overview', '114d4207f80846bda0f25e251632569e', 'Repository Home Menu', 410, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('98aed5f4f8814a3bb37b1986a75593cb', 'M_R_SHOW', 'Show', '114d4207f80846bda0f25e251632569e', 'Show Menu', 420, 'e7e5b2e9d1ee4723958857114a37cc95');
insert into t_menus(menu_id, menu_key, menu_prompt, menu_parent_id, menu_desc, menu_sequence, func_id)
	values('07d8de58eff040d4b8364eca151a62f9', 'M_R_KEEPER', 'Keeper', '114d4207f80846bda0f25e251632569e', 'Keeper Menu', 430, 'e7e5b2e9d1ee4723958857114a37cc95');
	
	
	
	
/*













a6e95de94c004b099bef061039bf2b68
*/
