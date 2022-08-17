INSERT INTO department (id, code, name) VALUES
(1, "ACC-DLI","Accounts - DLI"),
(2, "HR-DLI","Human Resources - DLI"),
(3, "PROD-DLI","Production - DLI"),
(4, "TST-DLI","Testing - DLI"),
(5, "DOPS-DLI","DevOps - DLI");

INSERT INTO employee(id, address_line1, address_line2, city, country, state, zip_code, email, hire_date, name, phone, department_id) VALUES
(1,"xyz colony","xyz landmark", "SMI","IN","BR","123456","tonystark@gmail.com","2021-12-10","Tony Stark", "1234567890","3"),
(2,"xyz colony","xyz landmark", "DLI","IN","DLI","123456","jarvis@gmail.com","2021-12-10","Jarvis", "1234567890","2"),
(3,"xyz colony","xyz landmark", "ASN","IN","WB","123456","timothy@gmail.com","2021-12-10","Timothy", "1234567890","1"),
(4,"xyz colony","xyz landmark", "SMI","IN","BR","123456","johndoe@gmail.com","2021-12-10","John DOe", "1234567890","4"),
(5,"xyz colony","xyz landmark", "DLI","IN","BR","123456","groot@gmail.com","2021-12-10","Groot", "1234567890","5"),
(6,"xyz colony","xyz landmark", "SMI","IN","BR","123456","rocket@gmail.com","2021-12-10","Rocket", "1234567890","1"),
(7,"xyz colony","xyz landmark", "DLI","IN","BR","123456","thor@gmail.com","2021-12-10","Thor", "1234567890","2"),
(8,"xyz colony","xyz landmark", "SMI","IN","BR","123456","hulk@gmail.com","2021-12-10","Hulk", "1234567890","3"),
(9,"xyz colony","xyz landmark", "DLI","IN","BR","123456","cap@gmail.com","2021-12-10","Capitan America", "1234567890","3"),
(10,"xyz colony","xyz landmark", "SMI","IN","BR","123456","blackPanther@gmail.com","2021-12-10","Black Panther", "1234567890","5")
;