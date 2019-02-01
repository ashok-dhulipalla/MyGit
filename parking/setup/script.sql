create table BusinessGroup(
	creation_date timestamptz default now(),
	created_by text default 'system',
	group_id int unique default nextval('businessgroup_uid'),
	group_name text unique,
	office_address text,
	contact_person_name text,
	contact_no text,
	primary key(group_id,group_name)
);
create sequence businessgroup_uid start with 1 increment by 1;

create table Business(
	creation_date timestamptz default now(),
	created_by text default 'system',
	group_id int,
	group_name text,
	business_id int default nextval('business_uid'),
	business_name text,
	address text,
	location text,
	start_time time,
	end_time time,
	contact_person_name text,
	contact_no text,
	tech_support_contact_no text,
	PRIMARY KEY (group_id, business_id)
);
create sequence business_uid start with 1 increment by 1;


create table LocalServer(
	creation_date timestamptz default now(),
	created_by text default 'system',
	group_id int,
	group_name text,
	business_id int,
	business_name text,
	server_mac_address text,
	server_name text,
	total_capacity int,
	capacity_for_2w int,
	capacity_for_4w int,
	client_mac_address_list text,
	token text
);


create table Capacity(
	creation_date timestamptz default now(),
	created_by text default 'system',
	group_id int,
	group_name text,
	business_id int,
	business_name text,
	server_mac_address text,
	server_name text,
	company_name text,
	capacity_2w int,
	capacity_4w int,
	primary key(group_id,business_id,server_mac_address,company_name)
);


create table VehiclePass(
	creation_date timestamptz default now(),
	created_by text default 'system',
	group_id int,
	group_name text,
	business_id int,
	business_name text,
	server_mac_address text,
	server_name text,
	full_licence_plate text,
	four_digit_licence_plate text,
	pass_id int default nextval('vehiclepass_uid'),
	expiry_date timestamptz,
	updation_date timestamptz,
	vehicle_type text,
	company_name text,
	primary key(group_id,business_id,server_mac_address,full_licence_plate)
);
create sequence vehiclepass_uid start with 1 increment by 1;

create table transactions(
	creation_date timestamptz default now(),
	created_by text default 'system',
	group_id int,
	group_name text,
	business_id int,
	business_name text,
	server_mac_address text,
	server_name text,
	transaction_id int default nextval('transactions_uid'),
	full_licence_plate text,
	four_digit_licence_plate text,
	vehicle_type text,
	entry_time timestamptz,
	exit_time timestamptz,
	record_type text,
	entry_image_path text,
	exit_image_path text
);
create sequence transactions_uid start with 1 increment by 1;


create table authtoken(
	creation_date timestamptz default now(),
	created_by text default 'system',
	user_name text,
	token text
);
insert into authtoken(user_name,token) values('ashok','5bc56e61b6434d9f897fc257e4fb9923');
insert into authtoken(user_name,token) values('user2','811b9d5265414c25b2c830924222a34a');