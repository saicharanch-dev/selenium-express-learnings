https://www.youtube.com/watch?v=a7u_8Apd6f4

### Chapter: Deep Dive into Spring Framework Transaction Management

#### Introduction
- [00:00:00 ~ 00:01:32]  
  This chapter explores the **transaction management** module of the **Spring Framework**, a critical concept for ensuring data integrity and consistency in enterprise applications. Transaction management controls how operations on data sources are grouped and executed as a single unit, either fully completing or fully rolling back in case of failures. Central to this is the **@Transactional** annotation, which, despite its simplicity in appearance, encapsulates complex behavior and multiple configurable properties such as **transaction manager**, **propagation**, **isolation**, and **rollback rules**. Understanding these elements is essential for developers to manage transactions effectively and reliably in Spring applications.

Key vocabulary and concepts introduced include:
- **Transaction Manager**: The component responsible for creating, committing, and rolling back transactions.
- **Propagation**: Defines how transactions behave when multiple transactional methods call each other.
- **Isolation Level**: Controls how transaction integrity is visibly affected by other concurrent transactions.
- **Rollback Rules**: Conditions under which transactions are rolled back or committed.

The chapter begins with setting up a Spring project from scratch, demonstrating the components and configurations required when not using Spring Boot’s automated setup, emphasizing manual control and deeper understanding.

---

#### Section 1: Project Setup and Dependencies
- [00:02:34 ~ 00:07:47]  
  The project is created as a Maven Java project named `spring-transactional-one` under the group `com.seleniumexpress.com.trans`. Essential dependencies are added to `pom.xml`:
- **spring-context** for core Spring functionalities,
- **spring-jdbc** to facilitate JDBC operations and transaction integration,
- **MySQL Connector/J** for database connectivity,
- **spring-aop** (added but not immediately used) for later exploring Aspect-Oriented Programming (AOP), which underpins transaction proxies.

Key points:
- JDBC Template is chosen for simplicity in database interactions.
- DataSource is configured manually, as Spring Boot auto-configuration is not used here.
- The project structure includes a package for repositories, DTOs, and configurations.

---

#### Section 2: Database and Repository Layer
- [00:07:06 ~ 00:14:54]  
  The MySQL schema `product_new` and table `product` are created with columns:
- `id` (Primary Key, Integer)
- `name` (String)

A repository class `ProductRepo` is created and annotated with `@Repository` to enable component scanning. It contains a `saveProduct` method that uses `JdbcTemplate` to insert product records.
- SQL Insert query is parameterized with placeholders for `id` and `name`.
- `JdbcTemplate#update` executes the query with arguments derived from a `Product` DTO.

The **Product DTO** is a simple POJO with `id` and `name` fields and standard getter/setters, matching the database columns.

Important fact:
- Since no Spring Boot is used, neither `JdbcTemplate` nor `DataSource` is auto-configured, requiring manual bean configuration.

---

#### Section 3: Manual Spring Configuration
- [00:14:55 ~ 00:20:59]  
  To enable JDBC operations and transactions, a `ProductConfig` class is created with:
- `@Configuration` annotation to declare it as a Spring configuration class.
- `@ComponentScan("com")` to scan all sub-packages under the root `com` for Spring beans.

Beans configured:
- **DataSource Bean**: Uses `DriverManagerDataSource` with URL, username (`root`), and password to connect to MySQL.
- **JdbcTemplate Bean**: Created by injecting the configured DataSource.
- **PlatformTransactionManager Bean**: A `DataSourceTransactionManager` is created to manage transactions over the DataSource.

This manual setup replicates aspects of Spring Boot’s auto-configuration and prepares the environment for transaction management.

---

#### Section 4: Service Layer and Transactional Behavior
- [00:20:21 ~ 00:29:39]  
  A `ProductService` class annotated with `@Service` is created to encapsulate business logic. It injects `ProductRepo` and exposes a method `saveProductInfo` which loops to create and insert 10 products.

Key observations:
- The service method is later annotated with **@Transactional** to manage the transaction boundary.
- Without `@Transactional`, partial inserts happen if an exception occurs mid-loop; for example, if an exception is thrown at the 7th iteration, the first six records remain inserted, violating atomicity.
- Atomicity is emphasized as part of the **ACID** properties: either all operations succeed, or none should persist.

---

#### Section 5: Demonstrating Transaction Management with @Transactional
- [00:29:39 ~ 00:38:50]  
  When the `@Transactional` annotation is added on the service method:
- The entire loop is wrapped in a single transaction.
- If a runtime exception occurs during insertion of the 7th product, all prior inserts are rolled back.
- However, this behavior only works if:
    - The **transaction manager** bean is correctly configured.
    - The configuration class is annotated with **@EnableTransactionManagement**, which enables Spring’s transaction support.

Without these, the rollback does not occur despite the annotation.

---

#### Section 6: Understanding Transaction Manager and Spring AOP Proxying
- [00:38:15 ~ 00:48:42]  
  The **PlatformTransactionManager** interface defines key methods:
- `getTransaction()`
- `commit()`
- `rollback()`

Spring uses **AOP proxies** around transactional methods:
- When a method annotated with `@Transactional` is called, Spring creates a proxy that intercepts the call.
- The proxy starts a transaction, calls the actual method, then commits or rolls back based on the method’s execution outcome.
- This separation keeps transaction logic out of business code, adhering to **aspect-oriented programming (AOP)** principles.
- The proxy ensures the connection is closed after transaction completion, avoiding connection leaks.

The stack traces during exceptions reveal this proxying behavior, showing calls passing through Spring’s transaction interceptor.

---

#### Section 7: Exception Handling and Rollback Behavior
- [00:48:12 ~ 00:55:55]  
  Important nuances about rollback behavior:
- **Unchecked exceptions (RuntimeException and subclasses)** trigger rollback by default.
- If an exception is **caught and handled** inside the method (e.g., via try-catch), the transaction will **not roll back** because the exception does not propagate.
- **Checked exceptions** (exceptions that must be declared or caught) **do not trigger rollback by default**.

Spring’s `@Transactional` supports properties to customize rollback behavior:
- `rollbackFor`: Specifies exception classes that should cause rollback. For example, adding `rollbackFor = Exception.class` enables rollback for checked exceptions.
- `noRollbackFor`: Specifies exceptions to exclude from rollback.

Demonstrations show:
- Throwing a runtime exception rolls back unless caught.
- Throwing a checked exception does not roll back unless specified explicitly.

---

#### Section 8: Transaction Propagation and Its Impact
- [00:55:52 ~ 01:02:42]  
  The **propagation** attribute controls how transactions behave when one transactional method calls another. The default is `Propagation.REQUIRED`, meaning:
- If a transaction exists, join it.
- If not, create a new one.

Example flow:
- Service method starts a transaction.
- Calls repository method also annotated with `@Transactional`.
- Repository method joins the existing transaction instead of creating a new one.
- Commit or rollback happens once at the outer transaction boundary (service method).

Alternative propagation types like `REQUIRES_NEW` create a new transaction regardless of the existing one; this will be explored in further lessons.

---

#### Section 9: Summary and Key Takeaways
- [00:55:18 ~ 01:03:38]
- To enable transaction management, annotate configuration class with `@EnableTransactionManagement` and define a `PlatformTransactionManager` bean.
- Use `@Transactional` on service layer methods to demarcate transaction boundaries.
- Spring manages transactions via AOP proxies, which start, commit, or rollback transactions automatically.
- Default rollback occurs only for unchecked exceptions; checked exceptions require explicit configuration.
- Exception handling inside transactional methods can prevent rollback if exceptions are swallowed.
- Propagation behavior defaults to `REQUIRED`, ensuring a single transaction context per call chain unless overridden.

The chapter closes by promising deeper dives into propagation, isolation, transaction lifecycle, and AOP mechanisms in upcoming lessons.

---

### Bullet-Point Notes Summary

**Introduction & Significance**
- Transaction management is critical for data consistency in Spring applications.
- `@Transactional` seems simple but involves complex behavior (transaction manager, propagation, isolation, rollback).
- Manual configuration is necessary without Spring Boot, offering deeper understanding.

**Project Setup & Dependencies**
- Maven Java project with Spring Context, Spring JDBC, MySQL Connector, Spring AOP dependencies.
- JDBC Template used for database operations.
- Manual bean configuration for DataSource and JdbcTemplate.

**Database & Repository Layer**
- MySQL schema `product_new` and `product` table (id, name).
- Repository class with `saveProduct` method using JdbcTemplate for insert.
- Product DTO matches database columns.

**Manual Spring Configuration**
- `ProductConfig` class with `@Configuration` and `@ComponentScan`.
- Beans for DataSource (DriverManagerDataSource), JdbcTemplate, and TransactionManager (DataSourceTransactionManager).

**Service Layer & Transactional Behavior**
- `ProductService` class with method creating and saving 10 products in a loop.
- Without `@Transactional`, partial inserts occur if exceptions thrown mid-loop.
- Atomicity (ACID) violated without transaction management.

**@Transactional Annotation & Transaction Manager**
- Adding `@Transactional` wraps method in transaction.
- Requires `@EnableTransactionManagement` and transaction manager bean configured.
- Without these, rollback does not occur despite annotation.

**Spring AOP & Proxy Mechanism**
- Spring creates proxy objects for transactional methods.
- Proxy starts transaction, calls method, commits or rolls back, closes connection.
- Separates transaction logic from business logic via AOP.

**Exception Handling & Rollback Rules**
- Rollback by default on runtime exceptions only.
- Handling exceptions inside methods prevents rollback.
- Checked exceptions do not trigger rollback unless specified with `rollbackFor`.
- `rollbackFor` and `noRollbackFor` provide fine-grained control on rollback behavior.

**Transaction Propagation**
- Default propagation is `REQUIRED`: join existing transaction or create new if none exists.
- Service method starts transaction; repo method joins same transaction.
- Alternative propagations like `REQUIRES_NEW` create new transactions (to be explored).
- Proper transaction demarcation avoids multiple overlapping transactions.

**Conclusion & Future Directions**
- Manual setup and configuration critical for understanding transaction management internals.
- Transaction management ensures atomicity, consistency, isolation, and durability (ACID).
- Proxy-based AOP enables transparent transaction control.
- Exception handling impacts rollback behavior significantly.
- Propagation controls transaction boundaries across layers.
- Upcoming lessons will cover propagation types, AOP internals, transaction lifecycle, and isolation levels for comprehensive mastery.

---

This chapter equips readers with a foundational and practical understanding of Spring’s transaction management, preparing them for advanced topics and real-world applications that require robust data integrity and error handling.