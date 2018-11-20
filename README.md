Tarea Realizada para Garbarino
Esta tarea se desarrollo en Java 8 con Spring Boot 2 y como BD se uso H2 en memoria.

Las URIs son las siguientes :
-[POST] /carts
-[POST] /carts/{id}/products
-[DELETE] /carts/{cartId}/products/{productId}
-[GET] /carts/{id}/
-[POST] /carts/{id}/checkout

Se creo un scheduler el cual se ejecuta cada minuto para procesar los carritos.
Para configurar el mismo, ir al application.properties y modificar el atributo scheduler.cron
