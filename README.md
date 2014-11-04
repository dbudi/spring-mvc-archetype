spring-mvc-archetype
====================

Archetype untuk membuat template project dengan framework Spring MVC

Project structure:
parent
  |- web
  |- core
  |- ejb
  
cara menjalankan:
1.  Clone dulu repo ini ke local
2.  Buka command prompt dan masuk ke dalam folder tempat clone
3.  Install archetype ke local : mvn clean install
4.  Pindah ke folder tempat project baru akan dibuat
5.  Jalankan archetype untuk membuat project baru dengan command berikut
        mvn archetype:generate -DarchetypeCatalog=local
6.  Pindah ke folder project yang baru dibuat, compile dengan menjalankan: mvn clean install
7.  setup database mysql, dengan user: root, password: password. Jika user/password berbeda, edit pom.xml di root project
8.  Pindah ke folder core, test dengan menjalankan: mvn -DskipTests=false test
9.  Pindah ke folder web, jalankan dengan perintah: mvn jetty:run
10.  buka browser: localhost:8080.
