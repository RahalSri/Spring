This example demonstrate how we can implement Spring transactions and JDBC templates.
Here we try to insert record to Person and PersonAddress which is expected to run as transactions.
If one of the insertion fails other insertion should be rollbacked.
In this example first add one record to Person table and next try to add a record to PersonAddress
table which would give Sql exception.(By entering value which exceed max characters to "street" column in "PersonAddress")

Steps to setup
===============
1. Create below two tables in any database server
    CREATE TABLE Person(
		id int NOT NULL,
		name varchar(50) NULL,
		age int NULL
	)
	
	CREATE TABLE PersonAddress(
		id int NOT NULL,
		street varchar(15) NULL,
		city varchar(50) NULL,
		country varchar(50) NULL,	
	)
	
2. Import your JDBC driver and configure following lines in configure.xml. (In this example I use mssql)
   
    <property name="driverClassName" value="com.microsoft.sqlserver.jdbc.SQLServerDriver" />
	<property name="url" value="jdbc:sqlserver://localhost:1433;DatabaseName=home;responseBuffering=adaptive" />
	<property name="username" value="sa" />
	<property name="password" value="mypw" />
	
    For mysql configuratio would be follows
	
	<property name="driverClassName" value="com.mysql.jdbc.Driver" />
	<property name="url" value="jdbc:mysql://localhost:3306/home" />
	<property name="username" value="root" />
	<property name="password" value="root" />
	
Steps to demonstrate
====================
1. First uncomment the codes between "//Start: Not transaction" and "//End: Not transaction" comments in TransactionTest.java.
   Then run and query tables how they look like if we don't use transactions.
   
2. Then uncomment the codes between "//Start: transaction." and "//End: transaction." comments in TransactionTest.java.
   Then run and query tables. Notice the debug console how transactions are rollbacked.
   
Note : you can import Spring/lib directory to run this project which is uploaded to git.
	
