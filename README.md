spring-mvc-archetype
====================

Archetype untuk membuat template project dengan framework Spring MVC

* Project structure
parent
	|-- web
	|-- core
	|-- ejb
	
cara menjalankan
1. clone repo di local
2. buka command prompt, masuk ke folder hasil clone, jalankan: mvn install
3. pindah ke folder tempat project baru akan dibuat, jalankan: mvn archetype:generate -DarchetypeCatalog=local
4. pindah ke folder project yang baru dibuat, compile dengan menjalankan: mvn clean install
5. setup database mysql, dengan user: root, password: password. Jika user/password berbeda, edit pom.xml di root project
6. pindah ke folder core, test dengan menjalankan: mvn -DskipTests=false test. Akan digenerate sample data di database
7. pindah ke folder web, jalankan dengan perintah: mvn jetty:run -Djetty.port=8989
8. buka browser, masuk ke alamat berikut: localhost:8989