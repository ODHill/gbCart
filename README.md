Tarea Realizada para Garbarino <br />
Esta tarea se desarrollo en Java 8 con Spring Boot 2 y como BD se uso H2 en memoria. <br />
 <br />
Las URIs son las siguientes : <br />
-[POST] /carts <br />
-[POST] /carts/{id}/products <br />
-[DELETE] /carts/{cartId}/products/{productId} <br />
-[GET] /carts/{id}/ <br />
-[POST] /carts/{id}/checkout <br />
 <br />
Se creo un scheduler el cual se ejecuta cada minuto para procesar los carritos. <br />
Para configurar el mismo, ir al application.properties y modificar el atributo scheduler.cron <br />
