package com.corhuila.shoppingcar.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "proveedores")
public class Proveedor {

    @Id
    private String id;
    @Field
    private String nombre;
    @Field
    private String direccion;
}