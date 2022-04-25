CREATE TABLE `supplier` (
  `id` int(10) NOT NULL,
  `name` varchar(45) NOT NULL,
  `account_number` varchar(45) NOT NULL,
  `units` varchar(100) NOT NULL,
  `unit_price` varchar(45) NOT NULL,
  `date` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `supplier` (`id`, `name`, `account_number`, `units`, `unit_price`, `date`) VALUES
(1, 'supplier1', '1234567', '12', '10', '2022/04/22'),
(2, 'supplier2', '12345672', '122', '120', '2022/02/22');

ALTER TABLE `supplier`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `supplier`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;


  
 