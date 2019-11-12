use `netbanking_test`;
    
INSERT INTO `user` (`username`, `password`, `name`, `email`, `mobile_no`, `address`)
VALUES 
( "201601223", "{noop}201601223", "Bhavik Mehta", "bhavikmehta98@gmail.com", 7990271687, "Aavkar soc;Karelibaug;Vadodara"),
( "201601049", "{noop}201601049", "Monil Soni", "monilsoni99@gmail.com", 9925103799, "Shahibaug;Ahemdabad"),
( "201601127", "{noop}201601127", "Swapnil Jethwa", "swapniljethwa@gmail.com", 9409156633, "Ellora park;Vadodara");

INSERT INTO `user_roles` (`user_id`, `role`)
VALUES
(1, "ROLE_USER"),
(2, "ROLE_USER"),
(3, "ROLE_USER");

INSERT INTO `bank` (`IFSC`, `bank_name`, `area`, `city`, `state`)
VALUES 
( "HDFC0000147", "HDFC Bank", "Karelibaug", "Vadodara", "Gujarat"),
( "UTIB0002862", "Axis Bank", "Old Padra Road", "Vadodara", "Gujarat"),
( "HDFC0000461", "HDFC Bank", "Shahibaug", "Ahmedabad", "Gujarat");

INSERT INTO `account` (`account_no`, `user_id`, `open_date`, `IFSC`,`type`, `balance`, `currency`)
VALUES 
( "13583098154376", 1, "2016-10-03", "HDFC0000147", "Current Account", 98000,"INR"),
( "13583098154377", 2, "2016-10-03", "HDFC0000147", "Current Account", 40000,"INR"),
( "156849023784539", 2, "2015-02-12", "HDFC0000461", "Savings Account", 100000,"INR"),
( "49782341849271", 3, "2015-12-05", "UTIB0002862", "Current Account", 110000,"INR");


