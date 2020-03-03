# Multitenancy Application

This is a Multitenant application stored at the same database with separate schemas.

### How the project works
In the public schema we have the tenant table. For each tenant the flyway migration create a whole new schema.
The service requests are intercepted, and by the header 'TENANT' of each requisition is setted which schema will be used.
