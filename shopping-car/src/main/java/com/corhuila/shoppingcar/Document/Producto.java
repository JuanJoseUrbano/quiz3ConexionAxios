package com.corhuila.shoppingcar.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "producto")
public class Producto {

    @Id
    private String id;

    @Field
    private String codigo;

    @Field
    private String nombre;

    @Field
    private BigDecimal precio;

    @Field
    private Integer stock;

    @Field
    private String marca;

    @Field
    private LocalDateTime deleteAt;

    @Field
    private Boolean status;

}
