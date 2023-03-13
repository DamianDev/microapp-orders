# microapp-orders

### Run postgres

`docker run -d --name postgres -e POSTGRES_PASSWORD=docker -e POSTGRES_DB=ordersdb -p 5432:5432 postgres`

### Run application

`docker run -d --name microapp-orders -e DB_HOST=<<postgres image IPAddress>> -p <<your port>>:8080 damiandev13/microapp-orders`

### Endpoint

(GET) /api/orders/all

(GET) /api/orders/{id}

(GET) /api/orders/customer/{customerId}

(POST) /api/orders/add

(DELETE) /api/delete?ids={id},{id},...

(DELETE) /api/orders/delete/{id}
