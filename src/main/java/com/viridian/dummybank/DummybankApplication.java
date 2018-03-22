package com.viridian.dummybank;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.jooq.impl.DSL.*;

@SpringBootApplication
public class DummybankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummybankApplication.class, args);
		/*------------------------------------------*/
		// ejemplo sencillo hacer consulta sin generacion de codigo
		String user = "root";
		String pass = "password";
		String url = "jdbc:mysql://localhost:3306/viridianbank";
		try(Connection conn = DriverManager.getConnection(url, user, pass)){
			DSLContext db = DSL.using(conn, SQLDialect.MYSQL);
			//Field<String> NOMBRE = db.field("p.nombre");
			Result<Record> result = db.select().from("Persona").fetch();
			for (Record r: result) {
				System.out.println(r.getValue("nombre"));
				
			}

		}catch (SQLException e){

		}
		/*------------------------------------------*/
	}
}
