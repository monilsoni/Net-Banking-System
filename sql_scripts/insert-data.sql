use `netbanking`;

insert into `user` (user_name,email,mobile_no,address)
values ( "Bhavik Mehta", "bhavikmehta98@gmail.com", 7990271687, "Aavkar soc;Karelibaug;Vadodara");

insert into `user` (user_name,email,mobile_no,address)
values ( "Monil Soni", "monilsoni99@gmail.com", 9925103799, "Shahibaug;Ahemdabad");

insert into `user` (user_name,email,mobile_no,address)
values ( "Swapnil Jethwa", "swapniljethwa@gmail.com", 9409156633, "Ellora park;Vadodara");

insert into `bank` (IFSC,bank_name,area,city,state)
values ( "HDFC0000147", "HDFC Bank", "Karelibaug", "Vadodara", "Gujarat");

insert into `bank` (IFSC,bank_name,area,city,state)
values ( "UTIB0002862", "Axis Bank", "Old Padra Road", "Vadodara", "Gujarat");

insert into `bank` (IFSC,bank_name,area,city,state)
values ( "HDFC0000461", "HDFC Bank", "Shahibaug", "Ahmedabad", "Gujarat");

insert into `account` (account_no,open_date,IFSC,`type`,balance,currency)
values ( "13583098154376", "2016-10-03", "HDFC0000147", "Current Account", 98000,"INR");

insert into `account` (account_no,open_date,IFSC,`type`,balance,currency)
values ( "13583098154377", "2016-10-03", "HDFC0000147", "Savings Account", 40000,"INR");

insert into `account` (account_no,open_date,IFSC,`type`,balance,currency)
values ( "49782341849271", "2015-12-05", "UTIB0002862", "Current Account", 110000,"INR");

insert into `account` (account_no,open_date,IFSC,`type`,balance,currency)
values ( "156849023784539", "2015-02-12", "HDFC0000461", "Savings Account", 100000,"INR");

update account set user_id = 1000 where IFSC = "HDFC0000147";

update account set user_id = 1001 where IFSC = "HDFC0000461";

update account set user_id = 1002 where IFSC = "UTIB0002862";

update user set password = "1234" where user_id > 0 ;

set foreign_key_checks = 0;
update user set user_id = 201601223 where user_id = 1000;
update account set user_id = 201601223 where user_id = 1000;

update user set user_id = 201601049 where user_id = 1001;
update account set user_id = 201601049 where user_id = 1001;

update user set user_id = 201601127 where user_id = 1002;
update account set user_id = 201601127 where user_id = 1002;

set foreign_key_checks = 1;