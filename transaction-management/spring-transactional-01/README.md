Transaction Management Demonstration

Running service method inserts 10 products successfully without transaction management.
Introducing a runtime exception at the 7th iteration:
Without @Transactional and transaction manager, 7 records are inserted, and the rest fail, violating atomicity.
Adding @Transactional on service method does not work until transaction manager is configured and @EnableTransactionManagement is added.
After proper setup, all inserts roll back on exception, ensuring atomicity (no partial data inserted).
Explanation of proxy-based AOP mechanism:
Spring creates a proxy around transactional methods.
The proxy starts a transaction, invokes the target method, then commits or rolls back based on execution.
Important notes on exception handling:
Transaction rollback occurs only when exceptions propagate out of the method.
Handling exceptions inside the method (try-catch) prevents rollback.
By default, Spring rolls back only on unchecked exceptions (RuntimeException).
Rollback for checked exceptions can be configured explicitly using rollbackFor property of @Transactional.
Transaction Propagation Concept (Intro)

Default propagation is REQUIRED: uses existing transaction if present or creates a new one.
Example discussed where service method calling repository method:
Both having @Transactional with default propagation will share the same transaction.
Mentioned other propagation behaviors like REQUIRES_NEW, NESTED, MANDATORY to be covered in next sessions.

Exception handling affects rollback behavior:
Only unchecked exceptions trigger rollback by default.
Checked exceptions require explicit rollbackFor configuration.
Catching exceptions inside the method disables rollback.