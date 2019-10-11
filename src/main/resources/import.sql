INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (1, 'emusk@email.com', 'Elon', 'Musk');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (2, 'kutya@gmail.com', 'Kutya', 'Jacob');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (3, 'nmandela@email.com', 'Nelson', 'Madnella');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (4, 'Jackma@gmail.com', 'Jack', 'Ma');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (5, 'jstatham@email.com', 'Jason', 'Statham');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (6, 'msheeran@gmail.com', 'Michael', 'Sheeran');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (7, 'jslovacek@email.com', 'Jason', 'Slovacek');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (8, 'mpoggy@gmail.com', 'Michael', 'Poggy');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (9, 'arysbek@email.com', 'Akyl', 'Rysbek');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (10, 'nmamat@gmail.com', 'Nurdin', 'Mamatzhan');
INSERT INTO `money-transfer-app`.users (id, email, first_name, last_name) VALUES (11, 'bpitt@email.com', 'Brad', 'Pitt');

insert INTO transactions (id, transaction_id, user_id, currency_id) VALUES(1,'TRANSACTION-ONE',1,1);
insert INTO transactions (id, transaction_id, user_id, currency_id) VALUES(2,'TRANSACTION-ONE',1,3);
insert INTO transactions (id, transaction_id, user_id, currency_id) VALUES(3,'TRANSACTION-TWO',2,2);
insert INTO transactions (id, transaction_id, user_id, currency_id) VALUES(4,'TRANSACTION-TWO',2,1);



insert INTO currencies (id, `name`) VALUES (1, 'USD');
insert INTO currencies (id, `name`) VALUES (2, 'EUR');
insert INTO currencies (id, `name`) VALUES (3, 'CAD');
insert INTO currencies (id, `name`) VALUES (4, 'SOM');