create table LocalVehiclePass(
	creation_date timestamptz default now(),
	created_by text default 'system',
	full_licence_plate text,
	four_digit_licence_plate text,
	pass_id int default nextval('vehiclepass_uid'),
	expiry_date timestamptz,
	updation_date timestamptz,
	vehicle_type text,
	company_name text,
	primary key(full_licence_plate)
);

create table LocalTransactions(
	creation_date timestamptz default now(),
	created_by text default 'system',
	transaction_id int default nextval('LocalTransactions_uid'),
	full_licence_plate text,
	four_digit_licence_plate text,
	vehicle_type text,
	entry_time timestamptz default now(),
	exit_time timestamptz,
	record_type text,
	company_name text,
	entry_image_path text,
	exit_image_path text,
	parking_duration_in_mins int
);
create sequence LocalTransactions_uid start with 1 increment by 1;

create table companyCapacity(
	creation_date timestamptz default now(),
	created_by text default 'system',
	company_name text unique,
	total_capacity_for_2w int,
	total_capacity_for_4w int,
	available_capacity_for_2w int,
	available_capacity_for_4w int
);

create table ServerDetails(
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