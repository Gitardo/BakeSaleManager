# BakeSaleManager
Demo project for Spring Boot

Environment:
- Windows 10 64bits
- Java JDK 11.0.4+11
- Eclipse 2020-06-EE
- Apache Tomcat 9.0.37
- Oracle SQL Developer 20.20.175
- Oracle DataBase XE 18c

Spring Initializr:
https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.3.3.RELEASE&packaging=jar&jvmVersion=11&groupId=com.eestienergia&artifactId=BakeSaleManager&name=BakeSaleManager&description=Demo%20project%20for%20Eesti%20Energia&packageName=com.eestienergia.BakeSaleManager&dependencies=web,thymeleaf,data-jdbc

DB configuration:
  CREATE TABLE "SYSTEM"."BAKESALE" (
    "ID" NUMBER(*,0) NOT NULL ENABLE, 
    "PRODUCT" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
    "STOCK" NUMBER(*,0) NOT NULL ENABLE, 
    "PRICE" FLOAT(126) NOT NULL ENABLE, 
    "PROD" VARCHAR2(5 BYTE) NOT NULL ENABLE, 
    CONSTRAINT "BAKESALE_PK" PRIMARY KEY ("ID")
  )

  CREATE SEQUENCE "BAKESALE_SEQUENCE" MINVALUE 1 MAXVALUE 100000 INCREMENT BY 1 START WITH 1;

  CREATE TRIGGER "SYSTEM"."BAKESALE_PRIMARY_KEY_TRG"
     before insert on "SYSTEM"."BAKESALE"
     for each row
  begin 
     if inserting then
        if :NEW."ID" is null then
           select BAKESALE_SEQUENCE.nextval into :NEW."ID" from dual;
        end if;
     end if;
  end;

  INSERT INTO BAKESALE(id, product, stock, price, prod) VALUES (1, 'Brownie', 48, 0.65, 'B');
  INSERT INTO BAKESALE(id, product, stock, price, prod) VALUES (2, 'Muffin', 36, 1.00, 'M');
  INSERT INTO BAKESALE(id, product, stock, price, prod) VALUES (3, 'Cake pop', 24, 1.35, 'C');
  INSERT INTO BAKESALE(id, product, stock, price, prod) VALUES (4, 'Water', 30, 1.50, 'W');

---

In the pom.xml, enter the proper ojdbc8.jar systemPath
Eclipse > Project Properties > Project Facets > check Dynamic Web Module > Apply and Close
Eclipse > Window > Show View > Other > Server > Servers > New > Tomcat Server > choose Tomcat v9.0 Server > Next > add BakeSaleManager resource > Finish
(from the new Tomcat server > change Monitoring ports if other instances are running in the default port) Start the server
Run BakeSaleManagerApplication as Java Application
Open http://localhost:8080/
