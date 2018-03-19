package com.viridian.dummybank.jooq.service;

import com.viridian.dummybank.gensrc.jooq.tables.Persona;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static com.viridian.dummybank.gensrc.jooq.tables.Persona.PERSONA;

/**
 * Created by marcelo on 16-03-18
 */
@Service
public class PersonaJooqService {

    String user = "root";
    String pass = "password";
    String url = "jdbc:mysql://localhost:3306/library";

    DSLContext dslContext;

    public PersonaJooqService() {
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        /*
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // ...
            dslContext = DSL.using(conn, SQLDialect.MYSQL);
        }

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }*/
        //System.out.println("HOLA");
    }

    public List<com.viridian.dummybank.model.persona.Persona> getAllPersonas(){
        List<com.viridian.dummybank.model.persona.Persona> personas = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, user, pass)){
            dslContext = DSL.using(conn, SQLDialect.MYSQL);

            Result<Record> result = dslContext.select().from(PERSONA).fetch();

            for(Record r: result){
                com.viridian.dummybank.model.persona.Persona persona = new com.viridian.dummybank.model.persona.Persona();
                persona.setId(r.getValue(PERSONA.ID_PERSONA));
                persona.setNombres(r.getValue(PERSONA.NOMBRE));
                persona.setApellidoPaterno(r.getValue(PERSONA.APELLIDO_PATERNO));
                persona.setApellidoMaterno(r.getValue(PERSONA.APELLIDO_MATERNO));

                personas.add(persona);

                Long id = r.getValue(PERSONA.ID_PERSONA);
                        //.getValue(PERSONA.ID_PERSONA);
                String firstName = r.getValue(PERSONA.NOMBRE);
                String lastName = r.getValue(PERSONA.APELLIDO_PATERNO) + " " + r.getValue(PERSONA.APELLIDO_MATERNO);

                System.out.println("ID: "+ id);
                System.out.println("First Name: "+ firstName);
                System.out.println("Last Name: "+ lastName);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return personas;
    }
}
